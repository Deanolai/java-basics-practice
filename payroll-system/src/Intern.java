public class Intern extends Employee {
    public Intern(int employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }

    @Override
    public String getRole() {
        return "Intern";
    }
}
