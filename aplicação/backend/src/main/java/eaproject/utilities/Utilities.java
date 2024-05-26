package eaproject.utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Utilities {

    /**
     * Converts an entity to its corresponding DTO.
     *
     * @param <T> the type of the entity
     * @param <U> the type of the DTO
     * @param entity the entity to convert
     * @param dtoClass the class of the DTO
     * @return the converted DTO, or null if an error occurred
     */
    public static <T, U> U convertToDTO(T entity, Class<U> dtoClass) {
        try {
            Constructor<U> constructor = dtoClass.getDeclaredConstructor(entity.getClass());
            return constructor.newInstance(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Converts a list of entities to a list of their corresponding DTOs.
     *
     * @param <T> the type of the entities
     * @param <U> the type of the DTOs
     * @param entities the list of entities to convert
     * @param dtoClass the class of the DTOs
     * @return a list of converted DTOs
     */
    public static <T, U> List<U> convertToDTOList(List<T> entities, Class<U> dtoClass) {
        List<U> dtoList = new ArrayList<>();
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
     * @param <T> the type of the DTO
     * @param <U> the type of the DAO
     * @param dto the DTO to convert
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
                        daoField.setAccessible(true);
                        daoField.set(dao, value);
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
     * @param typeName The type name to normalize.
     * @return The normalized type name.
     */
    public static String normalizeTypeName(String typeName) {
        return typeName.replaceAll("[^A-Za-z]", "").toLowerCase();
    }

    /**
     * Compare two field types, ignoring camel case differences.
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
