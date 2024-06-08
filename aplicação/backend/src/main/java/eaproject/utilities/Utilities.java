package eaproject.utilities;

import org.orm.PersistentException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Utilities {

    @FunctionalInterface
    public interface ThrowingFunction<T, R> {
        R apply(T t) throws PersistentException;
    }

    /**
     * Fetches an entity from the database based on lazy loading.
     *
     * @param <I> the type of the input object
     * @param <T> the type of the entity object
     * @param input the input object which determines if lazy loading should be performed
     * @param id the ID of the entity to be fetched
     * @param lazyLoadFunction the function to fetch the entity with lazy loading
     * @param nonLazyLoadFunction the function to fetch the entity without lazy loading
     * @param isLazyLoad a boolean indicating whether lazy loading should be performed
     * @return the fetched entity object
     * @throws PersistentException if an error occurs during fetching the entity
     */
    public static <I, T> T fetchEntity(I input, Integer id, ThrowingFunction<Integer, T> lazyLoadFunction, ThrowingFunction<Integer, T> nonLazyLoadFunction, boolean isLazyLoad) throws PersistentException {
        if (isLazyLoad) {
            return lazyLoadFunction.apply(id);
        } else {
            return nonLazyLoadFunction.apply(id);
        }
    }

    /**
     * Processes an input object and assigns data to an output object based on lazy loading.
     *
     * @param <I> the type of the input object
     * @param <T> the type of the entity object
     * @param <O> the type of the output object
     * @param input the input object which determines if lazy loading should be performed
     * @param type the entity object from which data is retrieved
     * @param outputClass the class of the output object
     * @param isLazyLoad a boolean indicating whether lazy loading should be performed
     * @return an instance of the output object populated with data from the entity object
     */
    public static <I, T, O> O processLazyLoad(I input, T type, Class<O> outputClass, boolean isLazyLoad) {
        O output;
        try {
            if (isLazyLoad) {
                output = outputClass.getDeclaredConstructor().newInstance();
                copyProperties(type, output, "getId", "setId");
                copyProperties(type, output, "getName", "setName");
            } else {
                output = convertToDTO(type, outputClass);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error processing lazy load", e);
        }
        return output;
    }

    /**
     * Copies properties from the source object to the destination object using reflection.
     *
     * @param source the source object
     * @param destination the destination object
     * @param getterName the name of the getter method in the source object
     * @param setterName the name of the setter method in the destination object
     */
    private static <T, O> void copyProperties(T source, O destination, String getterName, String setterName) {
        try {
            Method getter = source.getClass().getMethod(getterName);
            Method setter = null;
            for (Method method : destination.getClass().getMethods()) {
                if (method.getName().equals(setterName) && method.getParameterCount() == 1) {
                    setter = method;
                    break;
                }
            }
            if (getter != null && setter != null) {
                Object value = getter.invoke(source);
                setter.invoke(destination, value);
            }
        } catch (NoSuchMethodException e) {
            // Getter or setter not found, silently skip
        } catch (Exception e) {
            throw new RuntimeException("Error copying properties", e);
        }
    }

    /**
     * Updates the fields of the target object with the non-null and non-empty fields from the source object.
     *
     * @param source The source object containing the new values.
     * @param target The target object to be updated.
     * @throws IllegalAccessException if the field is not accessible.
     */
    public static void updateNonNullFields(Object source, Object target) throws IllegalAccessException {
        if (source == null || target == null) return;
        Field[] fields = source.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); // Make private fields accessible
            Object value = field.get(source); // Get value from source
            if (value != null) { // Only update if the value is not null
                if (value instanceof String) {
                    // Check if the string is not empty
                    if (!((String) value).isEmpty()) {
                        field.set(target, value); // Set value to target
                    }
                } else {
                    field.set(target, value); // Set value to target
                }
            }
        }
    }

    /**
     * Converts an entity to its corresponding DTO.
     *
     * @param <T>      the type of the entity
     * @param <U>      the type of the DTO
     * @param entity   the entity to convert
     * @param dtoClass the class of the DTO
     * @return the converted DTO, or null if an error occurred
     */
    public static <T, U> U convertToDTO(T entity, Class<U> dtoClass) {
        try {
            // Create a new instance of the DTO class
            U dto = dtoClass.getDeclaredConstructor().newInstance();

            // Get all fields from the entity (DAO) class
            Field[] entityFields = entity.getClass().getDeclaredFields();

            // Get all fields from the DTO class
            Field[] dtoFields = dtoClass.getDeclaredFields();

            for (Field entityField : entityFields) {
                entityField.setAccessible(true); // Make private fields accessible
                Object value = entityField.get(entity); // Get the value from the entity

                for (Field dtoField : dtoFields) {
                    if (compareFieldTypes(dtoField, entityField)) {
                        dtoField.setAccessible(true); // Make private fields accessible
                        dtoField.set(dto, value); // Set the value in the DTO
                        break;
                    }
                }
            }
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Converts an array of entities to a list of their corresponding DTOs.
     *
     * @param <T>      the type of the entities
     * @param <U>      the type of the DTOs
     * @param entities the array of entities to convert
     * @param dtoClass the class of the DTOs
     * @return a list of converted DTOs
     */
    public static <T, U> ArrayList<U> convertToDTOArray(T[] entities, Class<U> dtoClass) {
        ArrayList<U> dtoList = new ArrayList<>();
        for (T entity : entities) {
            U dto = convertToDTO(entity, dtoClass);
            if (dto != null) {
                dtoList.add(dto);
            }
        }
        return dtoList;
    }

    /**
     * Converts a DTO to its corresponding DAO.
     *
     * @param <T>      the type of the DTO
     * @param <U>      the type of the DAO
     * @param dto      the DTO to convert
     * @param daoClass the class of the DAO
     * @return the converted DAO, or null if an error occurred
     */
    public static <T, U> U convertToDAO(T dto, Class<U> daoClass) {
        try {
            U dao = daoClass.getDeclaredConstructor().newInstance();

            Field[] dtoFields = dto.getClass().getDeclaredFields();
            Field[] daoFields = daoClass.getDeclaredFields();

            for (Field dtoField : dtoFields) {
                for (Field daoField : daoFields) {
                    if (compareFieldTypes(dtoField, daoField)) {
                        dtoField.setAccessible(true);
                        Object value = dtoField.get(dto);
                        if (value != null) {
                            daoField.setAccessible(true);
                            daoField.set(dao, value);
                        }
                        break;
                    }
                }
            }

            return dao;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Normalize a type name by removing non-alphabetic characters and converting to lowercase.
     *
     * @param typeName The type name to normalize.
     * @return The normalized type name.
     */
    public static String normalizeTypeName(String typeName) {
        return typeName.replaceAll("[^A-Za-z]", "").toLowerCase();
    }

    /**
     * Compare two field types, ignoring camel case differences.
     *
     * @param dtoField The first field to compare.
     * @param daoField The second field to compare.
     * @return true if the normalized type names are equal, false otherwise.
     */
    public static boolean compareFieldTypes(Field dtoField, Field daoField) {
        String dtoFieldType = dtoField.getName();
        String daoFieldType = daoField.getName();
        return normalizeTypeName(dtoFieldType).equals(normalizeTypeName(daoFieldType));
    }
}
