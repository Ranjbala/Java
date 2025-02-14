import java.util.Scanner;

public class employeeManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of employees to add: ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine(); 

        EmployeeManager manager = new EmployeeManager(numEmployees);
        for (int i = 0; i < numEmployees; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));

            System.out.print("Enter Employee ID: ");
            int empId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Department: ");
            String department = scanner.nextLine();

            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();


            Employee emp = new Employee(empId, name, department, salary);
            manager.addEmployee(emp);
        }

        // Displaying all employees
        manager.displayAllEmployees();

        scanner.close();
    }
    }

class Employee {
    // Encapsulation
    private int employeeId;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int employeeId, String name, String department, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) { 
            this.salary = salary;
        } else {
            System.out.println("Invalid Salary! Must be greater than 0.");
        }
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
        System.out.println("-----------------------------");
    }
}

class EmployeeManager {
    private Employee[] employees;
    private int employeeCount;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        employeeCount = 0;
    }
    public void addEmployee(Employee employee) {
        if (employeeCount < employees.length) {
            employees[employeeCount++] = employee;
            System.out.println("Employee added successfully!");
        } else {
            System.out.println("Cannot add more employees. Capacity full!");
        }
    }

    public void displayAllEmployees() {
        System.out.println("----- Employee List -----");
        for (int i = 0; i < employeeCount; i++) {
            employees[i].displayEmployeeDetails();
        }
    }
}
