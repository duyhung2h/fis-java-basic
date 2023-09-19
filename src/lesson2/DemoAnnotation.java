package lesson2;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.Arrays;

public class DemoAnnotation {

    @MyAnnotation("field")
    @IgnorePrint(check = true)
    private String field;
    private String code;
    private String name;
    private String value;
    private String type;

    @MyAnnotation("method")
    public void method(@MyAnnotation("params") String params) {

    }

    public void method(@MyAnnotation("params") String params, String b) {

    }

    public static void main(String[] args) {
        new DemoAnnotation().testAnno();
    }

    public void testAnno() {
//        Field field = lesson2.DemoAnnotation.class.getDeclaredField("field");
        Field[] fieldList = DemoAnnotation.class.getDeclaredFields();
    }

//    Arrays.stream(fieldList).

//    forEach(System.out::println);
//
//    Method method = lesson2.DemoAnnotation.class.getDeclaredMethod("");

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Field[] fieldList = this.getClass().getDeclaredFields();
        Arrays.stream(fieldList).filter(item -> {
            boolean check = true;
            if (item.isAnnotationPresent(IgnorePrint.class)) {
                IgnorePrint a = item.getAnnotation(IgnorePrint.class);
                check = !a.check();
            }
            return check;
        })
        .forEach(item -> {
            try {
                str.append(item + "=" + item.get(this) + ",");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
        return str.toString();
    }

}

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String value();
}

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface IgnorePrint {
    boolean check();
}