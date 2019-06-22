package com.yuan.cardview.clazz;

public class ClassTest {
    public static void main(String[] args){
        System.out.println("++++++");
        try {
            Class<?> aClass = Class.forName("");
            ClassLoader classLoader = aClass.getClassLoader();
            Class<?> aClass1 = classLoader.loadClass("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
