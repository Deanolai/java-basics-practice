import java.util.Map;

public class SalaryStatistics {
    public record SalaryReport(double total, double average, double maxSalary, int maxId, double minSalary, int minId) { }

    public SalaryReport calculate(Map<Integer,Double> salaries) {
        if (salaries.isEmpty()) {
            throw new IllegalArgumentException("Salary statistics cannot be empty");
        }
        boolean isFirst = true;
        double maxSalary = 0.0;
        double minSalary = 0.0;

        int maxId = 0;
        int minId = 0;

        double total = 0.0;
        double average = 0.0;

        for(Map.Entry<Integer, Double> entry : salaries.entrySet()){
            int id = entry.getKey();
            double value = entry.getValue();

            if(isFirst){
                isFirst = false;
                maxSalary = minSalary = value;
                minId = maxId = id;
            }else{
                if(value > maxSalary){
                    maxSalary = value;
                    maxId = id;
                }
                if(value < minSalary){
                    minSalary = value;
                    minId = id;
                }
            }

            total += value;
        }

        average = total / salaries.size();
        return new SalaryReport(total, average, maxSalary, maxId, minSalary, minId);
    }
}
