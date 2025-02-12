
class Node{
    int rollNo;
    int age;
    String name;
    String grade;
    Node next;
 public Node( int age,int rollNo, String name, String grade){
     this.age=age;
     this.rollNo=rollNo;
     this.name=name;
     this.grade=grade;
     this.next=null;
 }
 }
 
 public class StudentList{
    private Node head;
    public StudentList() {
        head = null;
    }
 
    public void addStudentAtBeginning(int age, int rollNo, String name, String grade){
        Node newStudent=new Node(age,rollNo,name ,grade);
        newStudent.next=head;
        head=newStudent;
    }
 
    public void addStudentAtEnd(int age, int rollNo, String name, String grade){
        Node newStudent=new Node(age,rollNo,name,grade);
        if(head==null){
            head=newStudent;
            return;
        }
        Node last=head;
        while(last.next!=null){
            last=last.next;
        }
        last.next=newStudent;
    }
    public void addStudentAtPosition(int position, int age, int rollNo, String name, String grade){
        Node newStudent=new Node(age,rollNo,name,grade);
        if(position==1){
            newStudent.next=head;
            head=newStudent;
            return;
        }
        Node current=head;
        for(int i=1;current!=null && i<position-1;i++){
            current=current.next;
        }
        if(current==null){
            System.out.println("position out of bound");
        }
        newStudent.next=current.next;
        current.next=newStudent;
    }
 
    public void deleteByRollNo(int rollNo){
        if(head==null){
            System.out.println("the list is empty");
            return;
        }
        if(head.rollNo==rollNo){
            head=head.next;
            return;
        }
        Node current=head;
        while(current.next!=null && current.next.rollNo!=rollNo){
            current=current.next;
        }
        if(current.next==null){
            System.out.println("Not found");
        }
        else{
            current.next=current.next.next;
        }
    }
 
    public void searchStudentByRollNo(int rollNo){
        Node current=head;
        while(current!=null){
            if(current.rollNo==rollNo){
                System.out.println("Student Found: Roll Number: " + current.rollNo + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
                return;
            }
            current=current.next;
        }
        System.out.println("student not found");
    }
 
    public void displayAllStudents(){
        if(head==null){
            System.out.println("List is Empty");
            return;
        }
        Node current=head;
        while(current!=null){
            System.out.println("Roll Number: " + current.rollNo + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
            current=current.next;
        }
    }
 
    public void updateGradeByRollNo(int rollNo, String newGrade){
        Node current=head;
        if(current==null){
            System.out.println("list is Empty");
            return;
        }
        while(current!=null){
            if(current.rollNo==rollNo){
                current.grade=newGrade;
                System.out.println("Grade updated for rollNo :  "+rollNo);
                return;
            }
            current=current.next;
        }
        System.out.println("Student Not Found");
    }
    public static void main(String args[]){
        StudentList obj=new StudentList();
        // Adding some students using hardcoded data
        obj.addStudentAtBeginning(20, 101, "Alice", "A");
        obj.addStudentAtEnd(21, 102, "Bob", "B");
        obj.addStudentAtEnd(22, 103, "Charlie", "C");
        obj.addStudentAtPosition(2, 19, 104, "David", "B+");
 
        // Display all students
        System.out.println("Displaying all students:");
        obj.displayAllStudents();
 
        // Search for a student by roll number
        System.out.println("\nSearching for student with Roll Number 102:");
        obj.searchStudentByRollNo(102);
 
        // Update the grade of a student
        System.out.println("\nUpdating grade for Roll Number 103:");
        obj.updateGradeByRollNo(103, "A+");
 
        // Display all students after the grade update
        System.out.println("\nDisplaying all students after grade update:");
        obj.displayAllStudents();
 
        // Delete a student by roll number
        System.out.println("\nDeleting student with Roll Number 101:");
        obj.deleteByRollNo(101);
 
        // Display all students after deletion
        System.out.println("\nDisplaying all students after deletion:");
        obj.displayAllStudents();
    }
 }
 
 