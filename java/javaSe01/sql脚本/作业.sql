-- 1)查询所有的员工信息！
SELECT * FROM employee;

-- 2)查询员工编号、员工薪资、薪资发放时间以及薪资是否发放！
SELECT * FROM salary;

-- 3)查询工资大于5000元的工资信息。
SELECT * FROM salary
WHERE salMoney > 5000;

-- 4)查询‘2021-03-01’之前入职的员工信息。
SELECT * from employee
WHERE empJoinTime < '2021-03-01';

-- 5)查询部门编号为：1，并且在职的员工信息。
SELECT * FROM employee
WHERE empState = 0 and depId = 1;

-- 6)查询员工姓名中以“张”字开头的员工信息。
SELECT * FROM employee
WHERE empName LIKE '张%';

-- 查询年龄大于25岁，并且工龄大于3年的员工姓名！
SELECT * FROM employee
WHERE empAge > 25 and empWorkYear > 3;

-- 8)根据工龄将员工信息进行排序。按照降序。
SELECT * FROM employee
ORDER BY empWorkYear desc;

-- 9)统计每个部门的人数。
SELECT COUNT(e.empId) '人数',d.depName '部门'
FROM employee e
LEFT JOIN department d ON e.depId = d.depId
GROUP BY depName
ORDER BY COUNT(e.empId);

-- 10)按照入职时间进行降序，然后查询第3条到第5条的记录！
SELECT * FROM employee
ORDER BY empJoinTime DESC
LIMIT 2,3;

-- 11)查询每个部门中，工龄最高的工龄值！
SELECT d.depName '部门',max(e.empWorkYear) '最高工龄'
FROM employee e
LEFT JOIN department d
ON e.depId = d.depId
GROUP BY d.depName;

-- 12)统计所有员工的平均工资！
SELECT avg(s.salMoney) '平均工资',e.empName '员工姓名'
FROM salary s
LEFT JOIN employee e
ON s.empId = e.empId
GROUP BY e.empName;

-- 1)查询所有的员工姓名、员工工龄、薪资、薪资发放时间！
SELECT e.empName '员工姓名',e.empWorkYear '工龄',s.salMoney '薪资',s.payTime '薪资发放时间'
FROM employee e
LEFT JOIN salary s
ON e.empId = s.empId;

-- 2)查询所有的员工姓名、所属部门、工龄、薪资、薪资发放时间。
SELECT e.empName '员工姓名',d.depName '部门',e.empWorkYear '工龄',s.salMoney '薪资',s.payTime '薪资发放时间'
FROM (employee e
LEFT JOIN salary s
ON e.empId = s.empId)
LEFT JOIN department d
ON e.depId = d.depId;

-- 3)查询所有薪资大于5000元的员工姓名和所属部门。
SELECT e.empName '员工姓名',d.depName '部门',s.salMoney '薪资'
FROM (employee e
LEFT JOIN salary s
ON e.empId = s.empId)
LEFT JOIN department d
ON e.depId = d.depId
WHERE s.salMoney > 5000;

-- 4)查询还没有招聘任何员工的部门信息。
SELECT d.depName '部门',e.empName '无员工'
FROM department d
LEFT JOIN employee e
ON d.depId = e.depId
WHERE e.empName is null; 

-- 5)查询工资最高的员工信息。
SELECT * FROM employee
WHERE empId in (SELECT empId FROM salary WHERE salMoney = (SELECT max(salMoney) FROM salary));


-- 1.创建student和score表
CREATE TABLE student (
id INT(10) PRIMARY KEY,#学生1D
stuName VARCHAR(20) NOT NULL,#学生姓名
sex VARCHAR(4),#学生性别！
birth YEAR,#学生出生年份
department VARCHAR(20),#所在院系
address VARCHAR(50) #家庭地址
);

CREATE TABLE score (
id INT PRIMARY KEY AUTO_INCREMENT,#自增 1Dl
stuId INT(10) NOT NULL,#学生1D，外键创建可有可无！
className VARCHAR(20),#学科名称业
grade INT(10),#分数
FOREIGN KEY(stuId) REFERENCES student(id)
);

-- 2.添加记录
-- 向student
INSERT INTO student VALUES(901,'张老大','男',1985,'计算机系','北京市海淀区');
INSERT INTO student VALUES(902,'张老二','男',1986,'中文系','北京市昌平区');
INSERT INTO student VALUES(903,'张三','女',1990,'中文系','湖南省永州市');
INSERT INTO student VALUES(904,'李四','男',1990,'英语系','辽宁省阜新市');
INSERT INTO student VALUES(905,'王五','女',1991,'英语系','福建省厦门市');
INSERT INTO student VALUES(906,'王六','男',1988,'计算机系','湖南省衡阳市');
-- 向 score 表
INSERT INTO score VALUES(NULL,901,'计算机',98);
INSERT INTO score VALUES(NULL,901,'英语',80);
INSERT INTO score VALUES(NULL,902,'计算机',65);
INSERT INTO score VALUES(NULL,902,'中文',88);
INSERT INTO score VALUES(NULL,903,'中文',95);
INSERT INTO score VALUES(NULL,904,'计算机',70);
INSERT INTO score VALUES(NULL,904,'英语',92);
INSERT INTO score VALUES(NULL,905,'英语',94);
INSERT INTO score VALUES(NULL,906,'计算机',90);
INSERT INTO score VALUES(NULL,906,'英语',85);

-- 3.查询student表的所有记录
SELECT * FROM student;

-- 4.查询student表的第2条到4条记录
SELECT * FROM student
LIMIT 1,3;

-- 5.从student表查询所有学生的学号（id）、姓名（name）和院系（department）的信息
SELECT id '学号',stuName '姓名',department '院系' FROM student;

-- 6.从student表中查询计算机系和英语系的学生的信息
SELECT * FROM student
WHERE department in('计算机系','英语系');

-- 7.从student表中查询年龄1985~1990年份的学生信息
SELECT * FROM student
WHERE birth BETWEEN 1985 AND 1990;

-- 8.从student表中查询每个院系有多少人
SELECT count(id) '人数',department '院系'
FROM student
GROUP BY department;

-- 9.从score表中查询每个科目的最高分
SELECT MAX(grade) '最高分',className '科目'
FROM score
GROUP BY className;

-- 10.查询李四的考试科目（c_name）和考试成绩（grade）
SELECT className '科目',grade '成绩'
FROM score
WHERE stuId = (SELECT id FROM student WHERE stuName = '李四');

-- 11.用连接的方式查询所有学生的信息和考试信息
SELECT * FROM score s
LEFT JOIN student t
on s.stuId = t.id;

-- 12.计算每个学生的总成绩
SELECT t.stuName,SUM(s.grade) '总成绩' FROM score s
LEFT JOIN student t
ON s.stuId = t.id
GROUP BY t.stuName;

-- 13.计算每个考试科目的平均成绩
SELECT AVG(grade) '平均成绩',className '科目'
FROM score
GROUP BY className;

-- 14.查询计算机成绩低于95的学生信息
SELECT t.*,s.className,s.grade FROM score s
LEFT JOIN student t
ON s.stuId = t.id
WHERE s.className = '计算机' AND s.grade < 95;

-- 15.将计算机考试成绩按从高到低进行排序
SELECT t.*,s.className,s.grade FROM score s
LEFT JOIN student t
ON s.stuId = t.id
WHERE s.className = '计算机'
ORDER BY s.grade desc;

-- 16.查询姓张或者姓王的同学的姓名、院系和考试科目及成绩
SELECT t.stuName,t.department,s.className,s.grade FROM score s
LEFT JOIN student t
ON s.stuId = t.id
WHERE t.stuName LIKE '张%' OR t.stuName LIKE '王%';

-- 17.查询都是北京的学生的姓名、年龄、院系和考试科目及成绩
SELECT t.stuName,(2022-t.birth),t.department,s.className,s.grade,t.address FROM score s
LEFT JOIN student t
ON s.stuId = t.id
WHERE t.address LIKE '北京%';