package Lab12;

public class Teacher extends Person {

    public double salary;

    public Teacher(int number, String name, String code, String birthday, double salary) {
        super(number, name, code, birthday);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
