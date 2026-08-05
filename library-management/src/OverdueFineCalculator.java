public class OverdueFineCalculator {
    public static double calculateFine(int overdueDays){
        if(overdueDays >=1 && overdueDays <=7){
            return overdueDays * 0.5;
        }else if(overdueDays >=8 && overdueDays <=30){
            return overdueDays * 1.0;
        }else if(overdueDays >= 31){
            return overdueDays * 2.0;
        }
        return 0.0;
    }
}
