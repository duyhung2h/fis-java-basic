package lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//btvn: lam stack queue dựa theo generic type
//chuẩn bị db
public class Main {

    private List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

    public static void main(String[] args) throws ValidateException, AppException {
        new Main().test();
        Stack stack = new Stack();

    }

    public void test() throws ValidateException, AppException {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 3) {
                System.out.println("list");
                System.out.println(list);
                list.remove(i);
                i--;
            }
        }
        List<Integer> l2 = list.stream().filter(item -> item != 3).collect(Collectors.toList());

//        List<Integer> list3 = list.stream().filter(new lesson2.CustomPre.test.collect(Collectors.toList()));

                //
//        list3 = list.stream()
//                .filter(integer -> integer != 3)
//                .collect(Collectors.toList());

        for (int i = 0; i < l2.size(); i++) {
            System.out.println(l2.get(i));
        }
        list.forEach(System.out::println);
        System.out.println(l2.size());

//        type generic thì ko phát hiện đc lỗi
        List<Integer> lst = new ArrayList<>();
        lst.add(123);
        lst.add(12);
//        lst.add("12");
//        int x = (Integer) lst.get(0) + (Integer) lst.get(2);
        testGenerics(new ArrayList<Person>());
        testGenerics(new ArrayList<Student>());
        testGenerics(new ArrayList<Teacher>());

        testGenerics2(new ArrayList<Person>());
        testGenerics2(new ArrayList<Student>());
        testGenerics2(new ArrayList<Teacher>());
    }

    public void testGenerics(List <? extends Person> lst) throws ValidateException, AppException {
//        ngoài cùng controller mới catch
        try{
            Integer.parseInt("123");
            throw new ValidateException();
        }catch (ValidateException e1){
            e1.printStackTrace();
        }
        try{
            throw new AppException();
        }
        catch (AppException e2){
            e2.printStackTrace();
        }
        catch (Exception e1){
//            e.printStackTrace();
        }
    }

    public void testGenerics2(List <? extends Person> lst){

    }


}

class CustomPre implements Predicate<Integer>{
    @Override
    public boolean test(Integer item) {
        return item != 3;
    }
}
class Person {

}
class Student extends Person {

}
class Teacher extends Person {

}