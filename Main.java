import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private int id;
    private String name;
    private String fatherName;
    private String motherName;
    private int age;
    private String bloodGroup;
    private float basicSalary;
    private String emailAddress;

    public Employee(int id, String name, String fatherName, String motherName, int age, String bloodGroup,
            float basicSalary, String emailAddress) {
        this.id = id;
        this.name = name;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.basicSalary = basicSalary;
        this.emailAddress = emailAddress;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public int getAge() {
        return age;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public float getBasicSalary() {
        return basicSalary;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setBasicSalary(float basicSalary) {
        this.basicSalary = basicSalary;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}

class EmployeeManagementSystem {
    private final List<Employee> employees;
    private final Scanner scanner;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("1. Add Record");
            System.out.println("2. List Records");
            System.out.println("3. Modify Records");
            System.out.println("4. Delete Records");
            System.out.println("5. Exit");
            System.out.print("Your Choice: ");
            char choice = scanner.next().charAt(0);
            scanner.nextLine();

            switch (choice) {
                case '1' -> addRecord();
                case '2' -> listRecords();
                case '3' -> modifyRecords();
                case '4' -> deleteRecords();
                case '5' -> {
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void addRecord() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Father's Name: ");
        String fatherName = scanner.nextLine();

        System.out.print("Enter Mother's Name: ");
        String motherName = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Blood Group: ");
        String bloodGroup = scanner.nextLine();

        System.out.print("Enter Basic Salary: ");
        float basicSalary = scanner.nextFloat();
        scanner.nextLine();

        System.out.print("Enter Email Address: ");
        String emailAddress = scanner.nextLine();

        Employee employee = new Employee(id, name, fatherName, motherName,
                age, bloodGroup, basicSalary, emailAddress);
        employees.add(employee);

        System.out.println("Record added successfully!");
    }

    private void listRecords() {
        for (Employee employee : employees) {
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Father's Name: " + employee.getFatherName());
            System.out.println("Mother's Name: " + employee.getMotherName());
            System.out.println("Age: " + employee.getAge());
            System.out.println("Blood Group: " + employee.getBloodGroup());
            System.out.println("Salary: " + employee.getBasicSalary());
            System.out.println("Mail Address: " + employee.getEmailAddress());
            System.out.println();
        }
    }

    private void modifyRecords() {
        System.out.print("Enter the employee name to modify: ");
        String empName = scanner.nextLine();

        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(empName)) {
                System.out.print("Enter Employee ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter name: ");
                String name = scanner.nextLine();

                System.out.print("Enter Father's Name: ");
                String fatherName = scanner.nextLine();

                System.out.print("Enter Mother's Name: ");
                String motherName = scanner.nextLine();

                System.out.print("Enter Age: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter Blood Group: ");
                String bloodGroup = scanner.nextLine();

                System.out.print("Enter Basic Salary: ");
                float basicSalary = scanner.nextFloat();
                scanner.nextLine();

                System.out.print("Enter Email Address: ");
                String emailAddress = scanner.nextLine();

                employee.setId(id);
                employee.setName(name);
                employee.setFatherName(fatherName);
                employee.setMotherName(motherName);
                employee.setAge(age);
                employee.setBloodGroup(bloodGroup);
                employee.setBasicSalary(basicSalary);
                employee.setEmailAddress(emailAddress);

                System.out.println("Record modified successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    private void deleteRecords() {
        System.out.print("Enter name of employee to delete: ");
        String empName = scanner.nextLine();

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getName().equalsIgnoreCase(empName)) {
                iterator.remove();
                System.out.println("Record deleted successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }
}

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        system.start();
    }
}
