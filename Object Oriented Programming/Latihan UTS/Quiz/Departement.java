package Quiz;

import java.util.ArrayList;

public class Departement {
    private ArrayList<Employee> employees;

    public Departement(){
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }

    public ArrayList<Employee> getEmployees(){
        return employees;
    }
}
