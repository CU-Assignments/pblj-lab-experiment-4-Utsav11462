Experiment 4.1: Employee Management System

The Employee Management System is a simple Java-based application that uses ArrayList to manage employee records. The system allows users to perform the following operations:

Add Employee → Store Employee ID, Name, and Salary.

Update Employee → Modify employee details based on their ID.

Remove Employee → Delete an employee using their ID.

Search Employee → Find employees by ID or Name.

Display All Employees → Show a complete list of employees.

code: 
import java.util.ArrayList;
import java.util.Scanner;
class Employee {
    int id;
    String name;
    double salary;
    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}
public class Main{
    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee by ID");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Remove Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    searchEmployeeById();
                    break;
                case 3:
                    updateEmployeeSalary();
                    break;
                case 4:
                    removeEmployee();
                    break;
                case 5:
                    displayAllEmployees();
                    break;
                case 6:
                    System.out.println("Exiting Employee Management System.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); 
        employees.add(new Employee(id, name, salary));
        System.out.println("Employee Added: ID=" + id + ", Name=" + name + ", Salary=" + salary);
    }
    static void updateEmployeeSalary() {
        System.out.print("Enter Employee ID to update salary: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        for (Employee employee : employees) {
            if (employee.id == id) {
                System.out.print("Enter new salary: ");
                double newSalary = scanner.nextDouble();
                scanner.nextLine(); 
                employee.salary = newSalary;
                System.out.println("Employee ID " + id + " updated successfully.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }
    static void removeEmployee() {
        System.out.print("Enter Employee ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        for (Employee employee : employees) {
            if (employee.id == id) {
                employees.remove(employee);
                System.out.println("Employee ID " + id + " removed successfully.");
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }
    static void searchEmployeeById() {
        System.out.print("Enter Employee ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        for (Employee employee : employees) {
            if (employee.id == id) {
                System.out.println("Employee Found: " + employee);
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }
    static void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }
}

Test Cases

Test Case 1: Adding Employees (No Employees Initially)
Display Employees
Expected Output:
No employees found.
  
Test Case 2: Add Employees
Input:
Add Employee (ID=101, Name="Anish", Salary=50000)
Add Employee (ID=102, Name="Bobby", Salary=60000)
Expected Output:
Employee Added: ID=101, Name=Anish, Salary=50000
Employee Added: ID=102, Name=Bobby, Salary=60000

Test Case 3: Update Employee Salary
Input:
Update Employee (ID=101, New Salary=55000)
Expected Output:
Employee ID 101 updated successfully.

Test Case 4: Search Employee by ID
Input:
Search Employee by ID=102
Expected Output:
Employee Found: ID=102, Name=Bobby, Salary=60000

Test Case 5: Remove Employee
Input:
Remove Employee (ID=101)
Expected Output:
Employee ID 101 removed successfully.

Test Case 6: Display All Employees
Input:
Display Employees
Expected Output:
ID: 102, Name: Bobby, Salary: 60000

Test Case 7: Adding Duplicate Employee ID
Input:
Add Employee (ID=101, Name="Charlie", Salary=70000)
Expected Output:
Error: Employee with ID 101 already exists.




