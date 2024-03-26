package Lab12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class ManagePerson {

    private static final int MIN_SCORE = 0;
    private static final int MAX_SCORE = 10;
    private static final int MIN_SALARY = 100;
    private static final int MAX_SALARY = 10000;
    private static final int MAX_YEAR = 50;
    private static final String DATE_FORMAT = "dd-MM-yyyy";
    public static ArrayList<Person> listPerson = new ArrayList<>();

    public static int getNextNumber() {
        int nextNum = 0;
        if (!listPerson.isEmpty()) {
            nextNum = listPerson.get(listPerson.size() - 1).getNumber() + 1;
        }
        return nextNum;
    }

    public static ArrayList<Person> getListPerson() {
        return listPerson;
    }

    public static void appendStudent(Student student) {
        ManagePerson.listPerson.add(student);
    }

    public static void appendTeacher(Teacher teacher) {
        ManagePerson.listPerson.add(teacher);
    }

    public static Person findByCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            return null;
        }

        for (Person p : listPerson) {
            if (p.getCode().equals(code)) {
                return p;
            }
        }
        return null;
    }

    public static boolean codeValidator(String input) {
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid Code! Please do not leave it blank.", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (findByCode(input) != null) {
            JOptionPane.showMessageDialog(null, "Ooops! The code already exists. Please try another one.", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean nameValidator(String input) {
        if (input == null || input.trim().isEmpty() || !input.matches("^[a-zA-Z\\s]+$")) {
            JOptionPane.showMessageDialog(null, "Invalid Name! Please enter that includes only letters and spaces.", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean birthdayValidator(String input) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

        dateFormat.setLenient(false);

        try {
            Calendar currentDate = Calendar.getInstance();

            Calendar birthday = Calendar.getInstance();
            birthday.setTime(dateFormat.parse(input));

            if (birthday.before(currentDate) && birthday.after(get100YearsAgo())) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Birthday! Please enter a valid date within the last " + MAX_YEAR + " years.", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Invalid Birthday! Please enter as dd-mm-yyyy format.", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    public static boolean scoreValidator(String input) {
        try {
            double score = Double.parseDouble(input);
            if (score >= MIN_SCORE && score <= MAX_SCORE) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Score! Please enter a number between " + MIN_SCORE + " and " + MAX_SCORE + ".", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Score! Please enter as a real number.", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    public static boolean salaryValidator(String input) {
        try {
            double salary = Double.parseDouble(input);
            if (salary >= MIN_SALARY && salary <= MAX_SALARY) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Salary! Please enter a number between " + MIN_SALARY + " and " + MAX_SALARY + ".", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Salary! Please enter as a real number.", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private static Calendar get100YearsAgo() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1 * MAX_YEAR);
        return calendar;
    }
}
