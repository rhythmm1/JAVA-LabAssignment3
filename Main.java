import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

class Student {
    private Integer rollNo;
    private String name;
    private String email;
    private String course;
    private Double marks;
    private String grade;

    public Student(Integer rollNo, String name, String email, String course, Double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    private String calculateGrade(Double marks) {
        if (marks >= 90) return "A";
        if (marks >= 75) return "B";
        if (marks >= 60) return "C";
        return "D";
    }

    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
    }

    public Integer getRollNo() { return rollNo; }
}

interface RecordActions {
    void addStudent(Student s);
    Student searchStudent(Integer rollNo) throws StudentNotFoundException;
}

class StudentManager implements RecordActions {
    private Map<Integer, Student> studentMap = new HashMap<>();

    @Override
    public void addStudent(Student s) {
        studentMap.put(s.getRollNo(), s);
        System.out.println("Student added successfully!\n");
    }

    @Override
    public Student searchStudent(Integer rollNo) throws StudentNotFoundException {
        if (!studentMap.containsKey(rollNo)) {
            throw new StudentNotFoundException("Student with roll no " + rollNo + " not found!");
        }
        return studentMap.get(rollNo);
    }
}

class Loader implements Runnable {
    @Override
    public void run() {
        try {
            System.out.print("Loading");
            for (int i = 0; i < 5; i++) {
                Thread.sleep(500);
                System.out.print(".");
            }
            System.out.println();
        } catch (InterruptedException e) {
            System.out.println("Loading interrupted!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        try {
            System.out.print("Enter Roll No (Integer): ");
            Integer roll = Integer.valueOf(sc.nextLine());

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Marks (Double): ");
            Double marks = Double.valueOf(sc.nextLine());

            if (name.isEmpty() || course.isEmpty()) {
                throw new IllegalArgumentException("Name or course cannot be empty.");
            }

            if (marks < 0 || marks > 100) {
                throw new IllegalArgumentException("Invalid input: Marks must be 0–100.");
            }

            Thread t = new Thread(new Loader());
            t.start();
            t.join();

            Student s = new Student(roll, name, email, course, marks);
            manager.addStudent(s);

            s.display();

        } catch (NumberFormatException e) {
            System.out.println("Input Error: Please enter valid numbers!");
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted!");
        } finally {
            System.out.println("\nProgram execution completed.");
            sc.close();
        }
    }
}
