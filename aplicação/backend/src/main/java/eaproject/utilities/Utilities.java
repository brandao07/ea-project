package eaproject.utilities;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Utilities {
    public static <T, U> U convertToDTO(T entity, Class<U> dtoClass) {
        try {
            Constructor<U> constructor = dtoClass.getDeclaredConstructor(entity.getClass());
            return constructor.newInstance(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

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

    public static <T, U> U convertToDAO(T dto, Class<U> daoClass) {
        try {
            U dao = daoClass.getDeclaredConstructor().newInstance();

            Field[] dtoFields = dto.getClass().getDeclaredFields();
            Field[] daoFields = daoClass.getDeclaredFields();

            for (Field dtoField : dtoFields) {
                for (Field daoField : daoFields) {
                    if (dtoField.getName().equals(daoField.getName())) {
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
}
