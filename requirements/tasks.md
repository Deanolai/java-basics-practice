# Java 基础实战练习 — 任务清单

## 项目背景

本项目涵盖三个业务场景的 15 道开发任务，循序渐进地从单一知识点到综合项目实战。

### 场景一：图书借阅管理系统（Tasks 01-06）
模拟一家小型图书馆的日常业务：图书信息管理、借阅流程、逾期罚款计算等。

### 场景二：员工薪资管理系统（Tasks 07-11）
模拟企业薪资核算业务：员工信息管理、不同岗位的薪资计算、部门统计等。

### 场景三：校园卡管理系统（Tasks 12-15）
模拟校园一卡通的业务：开卡、充值消费、挂失解挂、消费记录查询等。

---

## 题目列表

### Part 1：图书借阅管理系统

---

#### 🟢 Task01 — 计算图书逾期罚款

**知识点**：变量、运算符、if/else

**需求描述**：

图书馆规定每本书的借阅期限为 30 天。读者输入实际借阅天数和应还天数（用于判断是否逾期），根据逾期天数按以下规则计算罚款：
- 逾期 1-7 天：每天 0.5 元
- 逾期 8-30 天：每天 1 元
- 逾期 30 天以上：每天 2 元

输出是否逾期及罚款金额。如果未逾期，输出提示信息"按时归还，无需罚款"。

---

#### 🟢 Task02 — 图书分类统计

**知识点**：循环结构（for/while）、条件判断（if/else）

**需求描述**：

图书馆有多个图书分类（如：文学、科学、历史、艺术、技术）。运行程序后，循环输入一批图书的分类名称（先输入图书总数，再依次输入每本的分类），程序统计每个分类下各有多少本图书，并输出统计结果。

---

#### 🟢 Task03 — 图书信息格式校验

**知识点**：String 类常用方法（equals、length、substring、trim、isEmpty）

**需求描述**：

录入图书时需要对 ISBN 和书名做格式校验。输入 ISBN 号和书名，程序检查：
1. ISBN 长度是否为 13 位
2. ISBN 是否以 "978" 或 "979" 开头
3. 书名是否为空或全为空格

校验结果分别输出"通过"或具体的错误原因。

---

#### 🟡 Task04 — Book 类的设计与封装

**知识点**：类与对象、封装、private、构造方法、getter/setter

**需求描述**：

设计一个 Book 类，包含以下私有属性：
- `isbn`（String 类型）
- `title`（String 类型）
- `author`（String 类型）
- `category`（String 类型）
- `isBorrowed`（boolean 类型，表示是否已借出）

要求提供：
- 一个全参构造方法
- 一个空参构造方法
- 所有属性的 getter 和 setter 方法

编写一个测试类（在 main 方法中），创建两个 Book 对象并用构造方法赋值，然后调用 getter 打印信息。

---

#### 🟡 Task05 — 图书清单管理

**知识点**：ArrayList、泛型、for-each 遍历

**需求描述**：

使用 `ArrayList<Book>` 管理图书清单，实现以下功能（在 main 方法中演示）：
1. 添加三本图书到清单中
2. 按 ISBN 编号删除一本图书
3. 按分类名称搜索，遍历并打印所有匹配的图书信息
4. 列出所有未借出的图书（isBorrowed == false）
5. 遍历整个清单，打印每本书的详细信息和借出状态

---

#### 🔴 Task06 — 图书借阅系统综合

**知识点**：类 + 封装 + ArrayList + 异常处理 + String 方法

**需求描述**：

模拟一个简化的图书借阅流程。系统维护一个 `ArrayList<Book>` 作为图书库存。借书时：

1. 用户输入借书证号和 ISBN
2. 校验借书证号格式（8 位数字字符），格式错误则抛出 IllegalArgumentException 并捕获处理
3. 在库存中查找该 ISBN 的书
4. 如果书不存在或已借出，输出相应的错误提示
5. 如果书存在且未借出，将 isBorrowed 设为 true，输出借阅成功信息

还书时：
1. 输入 ISBN
2. 将对应图书的 isBorrowed 设为 false
3. 计算是否逾期，若逾期则计算罚款金额

用 try-catch-finally 处理输入格式异常，方法签名使用 throws 声明异常。

---

### Part 2：员工薪资管理系统

---

#### 🟢 Task07 — 员工工资统计

**知识点**：数组、for 循环

**需求描述**：

定义一个 double 类型数组，存储 10 名员工的工资信息（数据在代码中直接初始化）。遍历数组，计算并输出：
- 工资总额
- 平均工资
- 最高工资及对应的员工编号（数组下标+1）
- 最低工资及对应的员工编号

---

#### 🟡 Task08 — 员工继承体系

**知识点**：继承、super、访问权限控制（public / protected / private）

**需求描述**：

定义以下类：

- `Employee`（基类）：属性 id（private）、name（private）、baseSalary（protected）。提供全参构造器和公有的 getter 方法。
- `Manager`（子类）：额外属性 `positionAllowance`（岗位津贴），重写一个显示信息的方法，用 super 调用父类构造器。
- `Developer`（子类）：额外属性 `projectBonus`（项目奖金），同样重写信息显示方法。

编写测试类演示：创建 Manager 和 Developer 对象，调用它们的方法并输出所有薪资构成信息。

---

#### 🟡 Task09 — 薪资计算接口

**知识点**：interface、implements

**需求描述**：

定义 `Payable` 接口，包含方法：
- `double calculateSalary()` — 计算薪资

三个实现类：
- `Manager`：薪资 = 基础工资 + 岗位津贴
- `Developer`：薪资 = 基础工资 + 项目奖金
- `Intern`：薪资 = 基础工资 × 0.8

编写测试类，创建一个 `Payable` 类型的数组，存放三种不同的员工对象，循环调用 `calculateSalary()` 输出各自薪资，体验多态。

---

#### 🟡 Task10 — 员工薪资映射管理

**知识点**：HashMap、泛型、增删改查遍历

**需求描述**：

使用 `HashMap<Integer, Employee>` 管理员工信息（整数为员工编号），实现以下功能并在 main 中演示：
1. 添加 3-5 名员工
2. 根据员工 ID 查询并输出该员工信息（若不存在则提示"未找到"）
3. 根据 ID 删除一名员工
4. 遍历整个 HashMap，按格式"ID：姓名 - 薪资"输出所有员工
5. 按岗位类型（Manager / Developer / Intern）统计各岗位的人数

---

#### 🔴 Task11 — 薪资核算系统综合

**知识点**：接口 + 多态 + HashMap + 异常处理

**需求描述**：

在 Task08-10 的基础上，实现一个薪资核算系统。用户输入员工 ID 和核算月份（格式"2026-07"），系统：

1. 校验员工 ID 是否存在，不存在则抛出并捕获自定义异常 EmployeeNotFoundException
2. 校验月份格式（7 位字符，第 5 位为 '-'），格式错误则提示重新输入
3. 利用多态调用该员工的 `calculateSalary()` 方法计算薪资
4. 将核算记录存入 `HashMap<String, Double>`（key 格式 "员工ID_月份"），如果当月已核算则拒绝重复核算（抛出异常）
5. 遍历输出所有历史核算记录

自行定义 EmployeeNotFoundException 异常类和 DuplicatePayrollException 异常类。

---

### Part 3：校园卡管理系统

---

#### 🟢 Task12 — 工具类与常量管理

**知识点**：static、package、import

**需求描述**：

创建包结构 `com.campuscard.util`，在包中定义以下类：

- `CampusCardConstants`：存放静态常量，包括学生折扣率（0.9）、教师折扣率（0.8）、月消费上限（2000.0）等
- `IdGenerator`：包含一个静态方法 `generateCardId()`，每次调用返回一个递增的唯一卡号（如 "C00001"、"C00002"）

在另一个包（如 `com.campuscard.test`）的测试类中 import 上述类，演示使用静态常量和方法。

---

#### 🟡 Task13 — 校园卡抽象类

**知识点**：abstract、继承

**需求描述**：

定义抽象类 `CampusCard`：
- 属性：cardId（String）、holderName（String）、balance（double）
- 构造器初始化卡号和持卡人姓名
- 抽象方法：`double calculateDiscountRate()` 返回该卡类型的折扣率
- 具体方法：`void recharge(double amount)` 充值并更新余额

两个子类：
- `StudentCard`：折扣率 0.9，每次消费额外积 1 分
- `TeacherCard`：折扣率 0.8，每次消费额外积 2 分

编写测试类，创建学生卡和教师卡对象，演示充值、消费（消费金额 × 折扣率）、查询余额。

---

#### 🔴 Task14 — 自定义异常处理

**知识点**：try-catch-finally、throw、throws、自定义异常

**需求描述**：

定义三个自定义异常类：
- `InsufficientBalanceException`（余额不足）
- `InvalidCardException`（无效卡号）
- `CardExpiredException`（卡片过期）

模拟以下场景：
1. 从控制台输入卡号和消费金额
2. 校验卡号是否存在（检出一个假定数据源），不存在则抛出 InvalidCardException
3. 校验余额是否充足，不足则抛出 InsufficientBalanceException
4. 假定部分卡片已过期，过期卡片消费时抛出 CardExpiredException
5. 在调用层用 try-catch 分别捕获并处理三种异常
6. finally 块中输出"本次操作结束"

---

#### 🔴 Task15 — 校园卡综合管理系统

**知识点**：abstract + 接口 + ArrayList + HashMap + 异常处理 + String

**需求描述**：

综合运用前面三部分的内容，实现一个小型校园卡管理系统。系统启动后在控制台提供菜单选项：

1. **开卡** — 输入持卡人姓名和卡类型（学生/教师），利用 IdGenerator 生成卡号，存入 `HashMap<String, CampusCard>` 管理
2. **充值** — 输入卡号和金额，调用 recharge 方法
3. **消费** — 输入卡号和金额，计算折扣后扣款。处理三种自定义异常（余额不足、无效卡号、卡片过期）
4. **挂失 / 解挂** — 输入卡号切换卡片状态（boolean 属性 isLost）
5. **查询消费记录** — 输入卡号，列出该卡的所有历史消费（用 `ArrayList<String>` 记录，格式："时间_金额_商户名"）
6. **退出** — 程序结束

所有用户输入用 String 方法做格式校验（卡号格式 "C" + 5 位数字）。异常用 try-catch 统一处理。

---

## 进度记录

- [ ] Task01 — 计算图书逾期罚款 🟢
- [ ] Task02 — 图书分类统计 🟢
- [ ] Task03 — 图书信息格式校验 🟢
- [ ] Task04 — Book 类的设计与封装 🟡
- [ ] Task05 — 图书清单管理 🟡
- [ ] Task06 — 图书借阅系统综合 🔴
- [ ] Task07 — 员工工资统计 🟢
- [ ] Task08 — 员工继承体系 🟡
- [ ] Task09 — 薪资计算接口 🟡
- [ ] Task10 — 员工薪资映射管理 🟡
- [ ] Task11 — 薪资核算系统综合 🔴
- [ ] Task12 — 工具类与常量管理 🟢
- [ ] Task13 — 校园卡抽象类 🟡
- [ ] Task14 — 自定义异常处理 🔴
- [ ] Task15 — 校园卡综合管理系统 🔴
