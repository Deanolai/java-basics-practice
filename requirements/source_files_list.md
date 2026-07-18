# Java 源文件清单（参考示例）

> ⚠️ 以下结构为参考示例，具体类名、包结构、文件拆分可根据个人设计调整。
> 核心是职责分离——一个类只做一件事，就够了。

---

## Project 1：library-management

```
library-management/
└── src/
    ├── Book.java                     // 图书实体类（封装）
    ├── BookValidator.java            // ISBN/书名格式校验
    ├── BookCategoryCounter.java      // 图书分类统计工具
    ├── OverdueFineCalculator.java    // 逾期罚款计算器
    ├── BookService.java              // 图书清单管理服务
    ├── BookNotFoundException.java    // 自定义异常
    ├── BookNotAvailableException.java// 自定义异常
    └── BorrowingService.java         // 借阅流程服务
```

---

## Project 2：payroll-system

```
payroll-system/
└── src/
    ├── Payable.java                  // 薪资计算接口
    ├── Employee.java                 // 员工基类
    ├── Manager.java                  // 经理子类
    ├── Developer.java                // 开发人员子类
    ├── Intern.java                   // 实习生子类
    ├── SalaryStatistics.java         // 薪资统计工具
    ├── SalaryReport.java             // 统计结果封装
    ├── PayrollDataManager.java       // 员工数据管理（HashMap）
    ├── PayrollSystem.java            // 薪资核算主流程
    ├── EmployeeNotFoundException.java// 自定义异常
    └── DuplicatePayrollException.java// 自定义异常
```

---

## Project 3：campus-card-system

```
campus-card-system/
└── src/
    ├── com/campuscard/
    │   ├── util/
    │   │   ├── CampusCardConstants.java
    │   │   └── IdGenerator.java
    │   ├── domain/
    │   │   ├── CampusCard.java        // 抽象类
    │   │   ├── StudentCard.java
    │   │   └── TeacherCard.java
    │   ├── exception/
    │   │   ├── InsufficientBalanceException.java
    │   │   ├── InvalidCardException.java
    │   │   └── CardExpiredException.java
    │   └── system/
    │       └── CampusCardSystem.java  // 综合主流程
    └── com/campuscard/test/
        └── UtilDemoTest.java          // 工具类演示测试
```

---

## 总项目结构

```
java-basics-practice/
├── README.md
├── requirements/
│   ├── tasks.md
│   └── source_files_list.md
├── library-management/
│   └── src/ ...
├── payroll-system/
│   └── src/ ...
└── campus-card-system/
    └── src/ ...
```
