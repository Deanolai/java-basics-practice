public class Intern extends Employee implements Payable{
    public Intern(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    @Override
    public String getRole() {
        return "Intern";
    }

    @Override
    public double calculateSalary(){
        return baseSalary * 0.8;
    }
}
