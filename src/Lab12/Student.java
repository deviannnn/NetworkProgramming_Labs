package Lab12;

public class Student extends Person {

    public double score;

    public Student(int number, String name, String code, String birthday, double score) {
        super(number, name, code, birthday);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

}
