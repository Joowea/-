package 异常多线程06LambdaCase1;

public class Person /*implements Comparable<Person>*/ {

    private String name;

    private int age;

//    @Override
//    public int compareTo(Person o) {
//        return this.getAge() - o.getAge();
//    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
