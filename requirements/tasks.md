# Java 基础实战练习 — 任务清单

## 项目概览

本项目由三个独立的业务子系统组成，覆盖 Java SE 核心知识点。每个子系统都是一个可独立开发、编译、运行的小型项目。

> **开发建议**：三个项目按顺序开发，每个项目内部按 🟢 → 🟡 → 🔴 的难度顺序渐进完成。

---

## Project 1：Library Management System（图书借阅管理系统）

### 项目介绍

一个面向图书馆日常业务的系统，支持图书信息录入与管理、借阅与归还流程、逾期罚款计算等核心功能。这是你进入 OOP 的第一个项目，重点练习封装思想、集合框架和异常处理。

### 涉及知识点

封装 · 构造方法 · ArrayList · 异常处理 · String 方法 · 循环与条件 · 运算符

### 功能清单

#### 🟢 功能一：图书格式校验

**实现类**：`BookValidator.java`

**需求**：
图书录入时需要校验信息合法性：
1. ISBN 长度是否为 13 位
2. ISBN 是否以 "978" 或 "979" 开头
3. 书名是否为空或全为空格

要求对每一种校验失败情况返回清晰的错误信息，而不是直接打印。这样上层调用者可以决定如何处理。

> 💡 **设计意图**：String 方法练习 + 职责分离——校验逻辑从录入流程中独立出来，后续可以被其他类复用。

---

#### 🟢 功能二：图书分类统计器

**实现类**：`BookCategoryCounter.java`

**需求**：
图书馆的图书按分类管理（文学、科学、历史、艺术、技术等）。

实现一个独立的工具类，提供静态方法 `countByCategory(String[] categories)`，接收一个分类名称数组，返回一个分类到数量的映射关系。

> 💡 **设计意图**：数组与循环的综合练习，同时体验"工具类"的概念。

---

#### 🟢 功能三：逾期罚款计算器

**实现类**：`OverdueFineCalculator.java`

**需求**：
图书馆借阅期限为 30 天。提供一个方法 `calculateFine(int overdueDays)`，根据逾期天数返回罚款金额：
- 逾期 1-7 天：每天 0.5 元
- 逾期 8-30 天：每天 1 元
- 逾期 30 天以上：每天 2 元

如果未逾期返回 0。后续这个计算器会被借阅流程调用。

> 💡 **设计意图**：变量、运算符、if/else 的基础练习，封装为一个独立的方法。

---

#### 🟡 功能四：Book 实体类

**实现类**：`Book.java`

**需求**：
Book 是系统的核心领域模型。包含以下属性：

| 属性 | 类型 | 说明 |
|------|------|------|
| isbn | String | 图书 ISBN，唯一标识 |
| title | String | 书名 |
| author | String | 作者 |
| category | String | 分类 |
| isBorrowed | boolean | 是否已借出 |

要求：
- 所有属性私有化，提供 getter / setter
- 提供全参构造器和空参构造器
- 提供 `toString()` 方法，方便直接打印图书信息
- 提供 `borrow()` 和 `returnBook()` 两个行为方法，修改借出状态

> 💡 **设计意图**：封装的核心练习。把"借出"和"归还"作为对象的行为，而不是由外部代码直接修改属性——这是 OOP 的起点。

---

#### 🟡 功能五：图书清单管理器

**实现类**：`BookService.java`

**需求**：
使用 `ArrayList<Book>` 管理图书馆的全部藏书，提供以下服务方法：

```java
void addBook(Book book)              // 添加图书
boolean removeByIsbn(String isbn)    // 按 ISBN 删除
Book findByIsbn(String isbn)         // 按 ISBN 查找
List<Book> findByCategory(String cat) // 按分类查找
List<Book> findAvailableBooks()      // 列出所有未借出的书
void printAll()                      // 打印全部图书信息
```

> 💡 **设计意图**：ArrayList 的增删改查遍历练习。将集合操作封装到 Service 类中，与实体类职责分离。

---

#### 🔴 功能六：借阅流程服务

**实现类**：`BorrowingService.java`

**依赖**：Book、BookService、OverdueFineCalculator、BookValidator

**需求**：
实现完整的图书借阅与归还流程：

**借书流程**：
1. 用户提供借书证号和 ISBN
2. 校验借书证号格式（8 位数字字符）— 格式错误抛出 `IllegalArgumentException`
3. 用 BookValidator 校验 ISBN 格式
4. 通过 BookService 查找该书
5. 如果书不存在，抛出 `BookNotFoundException`（自定义异常）
6. 如果书已借出，抛出 `BookNotAvailableException`（自定义异常）
7. 正常则调用 `book.borrow()` 标记借出

**还书流程**：
1. 用户提供 ISBN
2. 查找图书，调用 `book.returnBook()`
3. 调用 OverdueFineCalculator 计算是否逾期罚款
4. 如果有罚款，输出罚款金额

**异常处理要求**：
- 自定义两个异常类：`BookNotFoundException`、`BookNotAvailableException`
- 方法签名使用 `throws` 声明
- 调用方用 `try-catch-finally` 捕获处理

> 💡 **设计意图**：多个类协作的综合练习。实体类做自己的行为，Service 类统筹流程，验证器做格式检查——各司其职。

---

## Project 2：Payroll System（员工薪资管理系统）

### 项目介绍

一家企业的薪资核算系统，支持多种岗位类型的薪资计算、员工数据管理、月度核算与历史记录查询。这个项目的重点是继承体系、接口与多态的综合运用。

### 涉及知识点

继承 · 接口 · 多态 · 数组 · HashMap · 异常处理 · 访问权限控制

### 功能清单

#### 🟢 功能一：薪资统计工具

**实现类**：`SalaryStatistics.java`

**需求**：
提供一个工具类，接收一个 `double[]` 工资数组，统计并返回以下信息：
- 工资总额
- 平均工资
- 最高工资（及其对应的员工编号）
- 最低工资（及其对应的员工编号）

将结果封装在一个 `SalaryReport` 内部类或普通类中返回，而不是逐条打印。

> 💡 **设计意图**：数组遍历 + 数据封装的初步练习。

---

#### 🟡 功能二：员工继承体系

**实现类**：`Employee.java`、`Manager.java`、`Developer.java`、`Intern.java`

**需求**：
设计员工的类层次结构：

**Employee（基类）**
- 属性：`employeeId`（private）、`name`（private）、`baseSalary`（protected）
- 提供全参构造器和 getter 方法
- 提供一个方法 `getRole()` 返回岗位名称（字符串）

**Manager extends Employee**
- 新增属性 `positionAllowance`（岗位津贴，private）
- 重写 `getRole()` 返回 "Manager"
- 通过 `super` 调用父类构造器

**Developer extends Employee**
- 新增属性 `projectBonus`（项目奖金，private）
- 重写 `getRole()` 返回 "Developer"
- 通过 `super` 调用父类构造器

**Intern extends Employee**
- 无额外属性，但薪资有不同计算规则
- 重写 `getRole()` 返回 "Intern"

> 💡 **设计意图**：继承 + super + 访问权限控制的综合练习。protected 的妙用（子类可访问但外部不可访问）。

---

#### 🟡 功能三：薪资计算接口

**实现类**：`Payable.java`（接口）

**需求**：
定义 `Payable` 接口，包含方法：
```java
double calculateSalary();
```

让 Manager、Developer、Intern 分别实现该接口：

| 岗位 | 薪资规则 |
|------|---------|
| Manager | baseSalary + positionAllowance |
| Developer | baseSalary + projectBonus |
| Intern | baseSalary × 0.8 |

在某个演示类中，创建一个 `Payable[]` 数组，存放不同类型的员工，循环调用 `calculateSalary()` 输出——验证多态效果。

> 💡 **设计意图**：接口定义 + 多态的经典练习。同一个方法调用，不同对象行为不同。

---

#### 🟡 功能四：员工薪资数据管理器

**实现类**：`PayrollDataManager.java`

**需求**：
用 `HashMap<Integer, Employee>` 管理全部员工数据（key 为员工编号），提供以下服务：

```java
void addEmployee(Employee emp)
Employee findById(int id)          // 不存在返回 null（不抛异常）
Employee removeById(int id)
Map<String, Integer> countByRole() // 按岗位类型统计人数
void printAll()                    // ID：姓名 - 角色 - 薪资
```

> 💡 **设计意图**：HashMap 的增删改查遍历练习。注意这里存的是 Employee 父类引用，子类对象通过多态表现出不同的行为。

---

#### 🔴 功能五：薪资核算主流程

**实现类**：`PayrollSystem.java`

**依赖**：Employee 体系、Payable 接口、PayrollDataManager

**需求**：
实现月度薪资核算流程。用户输入员工 ID 和月份（格式 "2026-07"）：

1. **校验**员工 ID 是否存在 → 不存在抛出 `EmployeeNotFoundException`
2. **校验**月份格式（7 位字符，第 5 位为 '-'）→ 格式错误提示重输，不抛异常
3. **核算**：利用多态调用 `calculateSalary()` 计算该员工当月薪资
4. **防重复**：采用 `HashMap<String, Double>` 记录核算历史，key 为 "员工ID_月份"，如果当月已核算则抛出 `DuplicatePayrollException`
5. **查询**：提供方法按员工 ID 查询所有月份的核算记录

**自定义异常**：
- `EmployeeNotFoundException`
- `DuplicatePayrollException`

> 💡 **设计意图**：继承 + 接口 + 多态 + HashMap + 异常的完整综合。注意业务上的"防重复核算"是一个很真实的场景。

---

## Project 3：Campus Card System（校园卡管理系统）

### 项目介绍

一个校园一卡通管理平台，支持开卡、充值消费、挂失解挂、消费记录查询等功能。这个项目侧重抽象类、包管理、静态成员和异常体系的设计能力。

### 涉及知识点

abstract · package/import · static · 自定义异常 · try-catch-finally · HashMap · ArrayList · String 方法

### 功能清单

#### 🟢 功能一：工具类与常量管理

**实现类**：`CampusCardConstants.java`、`IdGenerator.java`

**包结构**：`com.campuscard.util`

**需求**：

**CampusCardConstants**：存放系统的静态常量
- `STUDENT_DISCOUNT` = 0.9
- `TEACHER_DISCOUNT` = 0.8
- `MONTHLY_LIMIT` = 2000.0
- `CARD_ID_PREFIX` = "C"

**IdGenerator**：卡号生成器
- 维护一个静态 int 计数器
- `generateCardId()` 返回格式 "C00001"、"C00002"……（前缀 + 5 位数字，不足补零）

在另一个包（比如 `com.campuscard.test`）的测试类中 import 这两个类，演示使用。

> 💡 **设计意图**：static 成员 + package/import 的练习。注意 IdGenerator 不需要实例化，用静态方法即可。

---

#### 🟡 功能二：校园卡抽象体系

**实现类**：`CampusCard.java`、`StudentCard.java`、`TeacherCard.java`

**包结构**：`com.campuscard.domain`

**需求**：

**CampusCard（抽象类）**
- 属性：`cardId`（String）、`holderName`（String）、`balance`（double）
- 构造器初始化卡号和持卡人姓名
- 抽象方法：`double getDiscountRate()`
- 具体方法：
  - `void recharge(double amount)` — 充值并更新余额
  - `boolean deduct(double amount)` — 消费扣款（amount × 折扣率），余额不足则返回 false
  - `void display()` — 打印卡片基本信息
- `toString()` 返回卡片信息字符串

**StudentCard extends CampusCard**
- `getDiscountRate()` 返回 0.9
- 额外属性 `points`（积分），每次消费加 1 分

**TeacherCard extends CampusCard**
- `getDiscountRate()` 返回 0.8
- 额外属性 `points`，每次消费加 2 分

> 💡 **设计意图**：abstract 的典型练习。公共行为在父类实现，差异行为交给子类。

---

#### 🔴 功能三：自定义异常体系

**实现类**：
- `InsufficientBalanceException.java`
- `InvalidCardException.java`
- `CardExpiredException.java`

**包结构**：`com.campuscard.exception`

**需求**：
模拟以下场景来测试三个自定义异常：

1. 创建一个"数据库"（简单的 `HashMap<String, CampusCard>` 模拟）
2. 用户输入卡号和消费金额
3. 校验卡号格式（"C" + 5 位数字），格式错误抛出 `InvalidCardException`
4. 在数据源中查找卡号，不存在也抛出 `InvalidCardException`
5. 检查卡片是否挂失（isLost 属性），挂失则抛出 `CardExpiredException`（代表不能使用）
6. 检查余额是否足够，不足则抛出 `InsufficientBalanceException`
7. 在调用层用 `try-catch-finally` 分别捕获三种异常，输出不同的提示信息
8. `finally` 块输出"本次操作结束"

> 💡 **设计意图**：自定义异常的完整练习。注意异常类的继承选择——可以让它们都继承 `Exception` 或自定义一个 `CardException` 基类。

---

#### 🔴 功能四：校园卡综合管理系统

**实现类**：`CampusCardSystem.java`

**包结构**：`com.campuscard.system`

**依赖**：前面三个功能的全部类

**需求**：
实现一个完整的控制台菜单式校园卡管理系统，提供以下功能：

| 菜单项 | 功能 | 涉及类 |
|--------|------|--------|
| 1. 开卡 | 输入持卡人姓名和卡类型（1-学生 / 2-教师），IdGenerator 生成卡号，存入 HashMap | CampusCardConstants, IdGenerator, StudentCard, TeacherCard |
| 2. 充值 | 输入卡号和金额，调用 recharge | CampusCard.recharge() |
| 3. 消费 | 输入卡号和金额，计算折扣后扣款，处理三种异常 | CampusCard.deduct(), 三个异常类 |
| 4. 挂失/解挂 | 输入卡号切换 isLost 状态 | 卡片自身属性 |
| 5. 消费记录 | 输入卡号，列出该卡所有历史消费（用 ArrayList<String> 记录，格式：时间_金额_商户名） | ArrayList，String 拼接 |
| 6. 退出 | 结束程序 | — |

**非功能性要求**：
- 所有输入用 String 方法做格式校验（卡号格式 "C" + 5 位数字）
- 异常用 try-catch 统一处理，不在菜单循环中中断程序
- 消费记录存储在 CampusCard 内部（用 `ArrayList<String>` 属性）

> 💡 **设计意图**：全项目的收官之作。抽象类 + 接口 + 集合 + 异常 + String 的全部综合。注意"消费记录存哪里"这个设计选择——存在卡片对象内部是最自然的。

---

## 难度总览

| 项目 | 🟢 简单 | 🟡 中等 | 🔴 较难 | 合计 |
|------|---------|---------|---------|------|
| library-management | ISBN 校验 / 分类统计 / 逾期计算 | Book 实体类 / 图书清单服务 | 借阅流程服务 | 6 |
| payroll-system | 薪资统计 | 继承体系 / Payable 接口 / 数据管理器 | 薪资核算主流程 | 5 |
| campus-card-system | 工具类与常量 | 校园卡抽象体系 | 自定义异常 / 综合管理系统 | 4 |
| **合计** | **5** | **6** | **4** | **15** |

---

## 进度记录

### 📚 Project 1：Library Management System

- [ ] 🟢 BookValidator（图书格式校验）
- [ ] 🟢 BookCategoryCounter（图书分类统计）
- [ ] 🟢 OverdueFineCalculator（逾期罚款计算）
- [ ] 🟡 Book 实体类（封装与行为）
- [ ] 🟡 BookService（图书清单管理）
- [ ] 🔴 BorrowingService（借阅流程 + 自定义异常）

### 💰 Project 2：Payroll System

- [ ] 🟢 SalaryStatistics（薪资统计工具）
- [ ] 🟡 Employee 继承体系（Employee / Manager / Developer / Intern）
- [ ] 🟡 Payable 接口与多态
- [ ] 🟡 PayrollDataManager（HashMap 数据管理）
- [ ] 🔴 PayrollSystem（薪资核算主流程）

### 🪪 Project 3：Campus Card System

- [ ] 🟢 工具类（CampusCardConstants / IdGenerator）
- [ ] 🟡 校园卡抽象体系（CampusCard / StudentCard / TeacherCard）
- [ ] 🔴 自定义异常体系（InsufficientBalance / InvalidCard / CardExpired）
- [ ] 🔴 CampusCardSystem（综合管理界面）
