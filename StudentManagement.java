package studentmanagementsystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private String department;
    private double marks;

    public Student(int id, String name, String department, double marks) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.marks = marks;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getMarks() { return marks; }

    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    public void setMarks(double marks) { this.marks = marks; }

    @Override
    public String toString() {
        return "Student ID: " + id + 
               ", Name: " + name + 
               ", Department: " + department + 
               ", Marks: " + marks;
    }
}
public class StudentManagementSystem {
	
	    private static final List<Student> students = new ArrayList<>();

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("\n===== Student Management System =====");
	            System.out.println("1. Add Student");
	            System.out.println("2. View All Students");
	            System.out.println("3. Search Student by ID");
	            System.out.println("4. Update Student");
	            System.out.println("5. Delete Student");
	            System.out.println("6. Exit");
	            System.out.print("Enter choice: ");
	            choice = sc.nextInt();

	            switch (choice) {
	                case 1 -> addStudent(sc);
	                case 2 -> viewStudents();
	                case 3 -> searchStudent(sc);
	                case 4 -> updateStudent(sc);
	                case 5 -> deleteStudent(sc);
	                case 6 -> System.out.println("Exiting System...");
	                default -> System.out.println("Invalid choice! Try again.");
	            }

	        } while (choice != 6);
	        sc.close();
	    }

	    // Add Student
	    private static void addStudent(Scanner sc) {
	        System.out.print("Enter ID: ");
	        int id = sc.nextInt();
	        sc.nextLine();

	        System.out.print("Enter Name: ");
	        String name = sc.nextLine();

	        System.out.print("Enter Department: ");
	        String department = sc.nextLine();

	        System.out.print("Enter Marks: ");
	        double marks = sc.nextDouble();

	        students.add(new Student(id, name, department, marks));
	        System.out.println("✔ Student Added Successfully!");
	    }

	    // View All Students
	    private static void viewStudents() {
	        if (students.isEmpty()) {
	            System.out.println("No student records found!");
	            return;
	        }
	        System.out.println("\n--- Student List ---");
	        students.forEach(System.out::println);
	    }

	    // Search Student
	    private static void searchStudent(Scanner sc) {
	        System.out.print("Enter Student ID to Search: ");
	        int id = sc.nextInt();

	        for (Student s : students) {
	            if (s.getId() == id) {
	                System.out.println("Record Found: " + s);
	                return;
	            }
	        }
	        System.out.println("❌ Student Not Found!");
	    }

	    // Update Student
	    private static void updateStudent(Scanner sc) {
	        System.out.print("Enter Student ID to Update: ");
	        int id = sc.nextInt();

	        for (Student s : students) {
	            if (s.getId() == id) {
	                sc.nextLine();
	                System.out.print("Enter New Name: ");
	                s.setName(sc.nextLine());

	                System.out.print("Enter New Department: ");
	                s.setDepartment(sc.nextLine());

	                System.out.print("Enter New Marks: ");
	                s.setMarks(sc.nextDouble());

	                System.out.println("✔ Student Updated Successfully!");
	                return;
	            }
	        }
	        System.out.println("❌ Student Not Found!");
	    }

	    // Delete Student
	    private static void deleteStudent(Scanner sc) {
	        System.out.print("Enter Student ID to Delete: ");
	        int id = sc.nextInt();

	        students.removeIf(s -> s.getId() == id);
	        System.out.println("✔ Student Deleted Successfully (if exists)");
	    }
	}