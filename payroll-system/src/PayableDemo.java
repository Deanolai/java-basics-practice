public class PayableDemo {
    public static void main(String[] args) {
        // 三种不同的员工，都实现了 Payable 接口
        Payable[] employees = {
            new Manager(1, "张三", 10000, 2000),
            new Developer(2, "李四", 8000, 1500),
            new Intern(3, "王五", 5000)
        };

        // 多态：同一个方法调用，三种不同的结果
        for (Payable p : employees) {
            Employee e = (Employee) p;   // 转型：Payable 只会算钱，名字/角色得问 Employee
            System.out.println(e.getName() + "（" + e.getRole() + "）：" + p.calculateSalary());
        }
    }
}
