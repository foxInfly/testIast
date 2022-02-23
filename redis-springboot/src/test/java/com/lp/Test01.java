package com.lp;

import io.lettuce.core.RedisClient;
import io.lettuce.core.codec.RedisCodec;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class Test01 {
    public static void main(String[] args) throws Exception {
        test02();
    }

    private static void test02() throws NoSuchMethodException {
        Method[] declaredMethods = RedisClient.class.getDeclaredMethods();
        Field[] declaredFields = RedisClient.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        System.out.println("========================");
//        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if(declaredMethod.getName().startsWith("connectSt")) {
                System.out.println(declaredMethod.getName());
                System.out.println(declaredMethod.getDeclaringClass());
                System.out.println(declaredMethod.getClass());
                System.out.println("---------------------");
                TypeVariable<Method>[] typeParameters = declaredMethod.getTypeParameters();
                for (TypeVariable<Method> typeParameter : typeParameters) {
                    System.out.println(typeParameter.getName());
                }
            }
        }

    }

    private static void test01() {
        System.out.println("&lt");
    }

}

