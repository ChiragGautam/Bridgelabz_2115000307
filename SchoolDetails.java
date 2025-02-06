import java.util.*;
class Course {
    String courseName;
    ArrayList<Student> students;
    public Course(String courseName) {
        this.courseName = courseName;
        students = new ArrayList<>();
    }
    public void enrollStudent(Student student) {
        students.add(student);
    }
    public void showStudents() {
        System.out.println("Course: " + courseName);
        for (Student student : students) {
            System.out.println("  Student: " + student.studentName);
        }
    }
}
class Student {
    String studentName;
    ArrayList<Course> courses;
    public Student(String studentName) {
        this.studentName = studentName;
        courses = new ArrayList<>();
    }
    public void enrollInCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this);
    }
    public void showCourses() {
        System.out.println("Student: " + studentName);
        for (Course course : courses) {
            System.out.println("  Enrolled in: " + course.courseName);
        }
    }
}
class School {
    String schoolName;
    ArrayList<Student> students;
    public School(String schoolName) {
        this.schoolName = schoolName;
        students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void showStudents() {
        System.out.println("School: " + schoolName);
        for (Student student : students) {
            student.showCourses();
        }
    }
}
public class SchoolDetails {
    public static void main(String[] args) {
        School school = new School("Greenwood High");
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        Course course1 = new Course("Math");
        Course course2 = new Course("Science");
        school.addStudent(student1);
        school.addStudent(student2);
        student1.enrollInCourse(course1);
        student1.enrollInCourse(course2);
        student2.enrollInCourse(course1);
        school.showStudents();
        course1.showStudents();
        course2.showStudents();
    }
}
