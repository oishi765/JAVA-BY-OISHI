package smarthomemanagementsystem;

//custom exception
class InvalidPerformanceRatingException extends Exception {
    public InvalidPerformanceRatingException(String message) {
        super(message);
    }
}
//custom excepton
class InvalidContactNumberException extends Exception {
    public InvalidContactNumberException(String message) {
        super(message);
    }
}
//Base class
abstract class Employee {
    private int employeeId;
    private String name;
    private String contactNumber;
    private int performanceRating;
 //constructor
    public Employee(int employeeId, String name, String contactNumber, int performanceRating) {
            this.employeeId=employeeId;
            this.name=name;
            this.contactNumber=contactNumber;
            this.performanceRating=performanceRating;
    }
       
    //Getter and setter
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getPerformanceRating() {
        return performanceRating;
    }

    public void setPerformanceRating(int performanceRating) {
        this.performanceRating = performanceRating;
    }
//Details showing method
    void detailsInfo() {
        System.out.println("Id: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Contact number: " + contactNumber);
        System.out.println("Performance rating: " + performanceRating);
    }
//given abstract method from question
    abstract void calculateSalary();
}

//derived class
class FullTimeEmployee extends Employee {
    //another extra attribute
    private double workingHours;

    public FullTimeEmployee(int employeeId, String name, String contactNumber, int performanceRating, double workingHours) 
            throws InvalidPerformanceRatingException, InvalidContactNumberException {
        super(employeeId, name, contactNumber, performanceRating);
        this.workingHours = workingHours;
    }
//getter setter

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }
    
    @Override
    void detailsInfo() {
        super.detailsInfo();
        System.out.println("Working hours: " + workingHours);
    }

    @Override
    void calculateSalary() {
        if (workingHours > 30 && workingHours < 50) {
            System.out.println("Salary will be 50000$");
        } else {
            System.out.println("Salary will be 25000$");
        }
    }
}
 //same as fulltimeemployee
class PartTimeEmployee extends Employee {
    private double workingPeriod;

    public PartTimeEmployee(int employeeId, String name, String contactNumber, int performanceRating, double workingPeriod) 
            throws InvalidPerformanceRatingException, InvalidContactNumberException {
        super(employeeId, name, contactNumber, performanceRating);
        this.workingPeriod = workingPeriod;
    }

    public double getWorkingPeriod() {
        return workingPeriod;
    }

    public void setWorkingPeriod(double workingPeriod) {
        this.workingPeriod = workingPeriod;
    }

    @Override
    void detailsInfo() {
        super.detailsInfo();
        System.out.println("Working period: " + workingPeriod);
    }

    @Override
    void calculateSalary() {
        if (workingPeriod > 15 && workingPeriod < 20) {
            System.out.println("Salary will be 10000$");
        } else {
            System.out.println("Salary will be 7000$");
        }
    }
}

public class SmartHomeManagementSystem {
    public static void main(String[] args) {
        //exception handle by using try and catch
        try {
            System.out.println("Full time employee details :");
            FullTimeEmployee f = new FullTimeEmployee(26, "Salam", "019750813451", 6, 35);
            f.detailsInfo();
            f.calculateSalary();
        } catch (InvalidPerformanceRatingException | InvalidContactNumberException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        try {
                        System.out.println("Part time employee details :");

            PartTimeEmployee p = new PartTimeEmployee(19, "Lalon", "019178291011", 8, 18);
            p.detailsInfo();
            p.calculateSalary();
        } catch (InvalidPerformanceRatingException | InvalidContactNumberException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }
    }
}
