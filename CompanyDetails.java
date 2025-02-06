import java.util.*;
class Company {
    String name;
    ArrayList<Department> departments;
    public Company(String name) {
        this.name = name;
        departments = new ArrayList<>();
    }
    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }
    public void showDetails() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            dept.showDetails();
        }
    }
    public void deleteCompany() {
        departments.clear();
        System.out.println("Company and all associated departments and employees deleted.");
    }
}
class Department {
    String deptName;
    ArrayList<Employee> employees;
    public Department(String deptName) {
        this.deptName = deptName;
        employees = new ArrayList<>();
    }
    public void addEmployee(String empName) {
        employees.add(new Employee(empName));
    }
    public void showDetails() {
        System.out.println("  Department: " + deptName);
        for (Employee emp : employees) {
            emp.showDetails();
        }
    }
}
class Employee {
    String empName;
    public Employee(String empName) {
        this.empName = empName;
    }
    public void showDetails() {
        System.out.println("    Employee: " + empName);
    }
}
public class CompanyDetails {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");
        company.addDepartment("Engineering");
        company.addDepartment("HR");
        company.departments.get(0).addEmployee("Alice");
        company.departments.get(0).addEmployee("Bob");
        company.departments.get(1).addEmployee("Charlie");
        company.showDetails();
        company.deleteCompany();
        company.showDetails();
    }
}
