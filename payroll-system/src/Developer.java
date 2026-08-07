public class Developer extends Employee {
    private double projectBonus;

    public Developer(int employeeId, String name, double baseSalary, double projectBonus) {
        super(employeeId, name, baseSalary);
        this.projectBonus = projectBonus;
    }

    public double getProjectBonus() {
        return projectBonus;
    }

    @Override
    public String getRole() {
        return "Developer";
    }
}
