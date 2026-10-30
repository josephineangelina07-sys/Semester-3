package Quiz;

public class TujuhB {
    public static void main(String[] args){
        Departement dept = new Departement();
        Employee emp = new Employee("Rina", "5000000");
        dept.addEmployee(emp);
        System.out.println(dept.Employees().get(0).getName);
    }
}
