package codesample.java_se_api.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Simple example of what you can do with exception. You should also checkout {@link codesample.java_se_api.annotations.GettingRuntimeAnnotations}
 * class for examples with reflection and annotations
 */
class ShowAnyClassFieldsMethodsConstructors {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("java.lang.String");
            Constructor[] constructors = clazz.getConstructors();
            Method[] methods = clazz.getMethods();
            Field[] fields = clazz.getFields();

            System.out.println("Constrictors:");
            Arrays.stream(constructors).forEach(System.out::println);
            System.out.println();

            System.out.println("Methods:");
            Arrays.stream(methods).forEach(System.out::println);
            System.out.println();

            System.out.println("Fields:");
            Arrays.stream(fields).forEach(System.out::println);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
