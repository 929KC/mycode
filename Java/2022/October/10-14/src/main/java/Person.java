public class Person {
    private String name = "Person";
    int age = 0;
    private void test(){
        System.out.println("Hello World");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
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
class Child extends Person{
    public String grade;

    public void main(String[] args) {
        Person p = new Child();
        System.out.println(super.age);
        System.out.println(getName());
    }
}
