public class Developer extends Employee implements Payable {
    private double projectBonus;

    public Developer(int employeeId, String name, double baseSalary, double projectBonus) {
        super(employeeId, name, baseSalary);
        this.projectBonus = projectBonus;
    }

    @Override
    public String getRole() {
        return "Developer";
    }

    @Override
    public double calculateSalary(){
        return projectBonus + baseSalary;
    }
}
