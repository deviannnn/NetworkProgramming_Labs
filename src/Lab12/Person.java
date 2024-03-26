package Lab12;

public class Person {

    public int number;
    public String name;
    public String code;
    public String birthday;

    public Person(int number, String name, String code, String birthday) {
        this.number = number;
        this.name = name;
        this.code = code;
        this.birthday = birthday;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
