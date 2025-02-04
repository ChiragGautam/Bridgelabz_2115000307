public class Employee {
    private static String companyName="xyz";
    private static int totalCount=0;
    private final String id;
    private String employeeName;
    private String employeeDesignation;

    public Employee(String employeeName, String id, String employeeDesignation){
        this.id =id;
        this.employeeName=employeeName;
        this.employeeDesignation=employeeDesignation;
        totalCount++;
    }
    static int getTotalCount(){
        return totalCount;
    }
    public void displayDetails(){
        if(this instanceof Employee){
            System.out.println("Employee Name - "+employeeName);
            System.out.println("Employee id  - "+ id);
            System.out.println("Employee Designation - "+employeeDesignation);
        }
    }

    public static void main(String args[]){
        Employee a1=new Employee("Chirag","1","Developer");
        Employee a2=new Employee("Jayant","2","Senior ANalyst");
        Employee a3=new Employee("Aman","3","Analyst");
        a1.displayDetails();
        a2.displayDetails();
        a3.displayDetails();

        System.out.println("Total count = "+Employee.getTotalCount());
    }
}
