package 异常多线程06LambdaCase1;

import java.util.Arrays;
import java.util.Comparator;

public class Main110702 {

    public static void main(String[] args) {

        Person[] pArray = {new Person("伊利丹",1200),new Person("泰兰德",1210),
                new Person("吉安娜",35),new Person("安度因",25)};

        Arrays.sort(pArray, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() -o2.getAge();
            }
        });

        System.out.println("___________________");

        Arrays.sort(pArray, (Person o1, Person o2)->{
            return o1.getAge() -o2.getAge();
        });


        for (Person person : pArray) {
            System.out.println(person);
        }}
}
