package Quiz;

public class Employee extends Person {
    private int salary;

    public Employee(String name, int salary){
        super(name);
        this.salary = salary;
    }

    public int getSalary(){
        return salary;
    }
}
