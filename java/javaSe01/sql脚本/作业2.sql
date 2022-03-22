
#
# Structure for table "dept"
#

DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` int(11) DEFAULT NULL,
  `dname` varchar(14) DEFAULT NULL,
  `loc` varchar(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "dept"
#

INSERT INTO `dept` VALUES (10,'教研部','北京'),(20,'学工部','上海'),(30,'销售部','广州'),(40,'财务部','深圳');

#
# Structure for table "emp"
#

DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `empno` int(11) DEFAULT NULL,
  `ename` varchar(50) DEFAULT NULL,
  `job` varchar(50) DEFAULT NULL,
  `mgr` int(11) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` decimal(7,2) DEFAULT NULL,
  `comm` decimal(7,2) DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "emp"
#

INSERT INTO `emp` VALUES (1001,'甘宁','文员',1013,'2000-12-17',8000.00,NULL,20),(1002,'黛绮丝','销售员',1006,'2001-02-20',16000.00,3000.00,30),(1003,'殷天正','销售员',1006,'2001-02-22',12500.00,5000.00,30),(1004,'刘备','经理',1009,'2001-04-02',29750.00,NULL,20),(1005,'谢逊','销售员',1006,'2001-09-28',12500.00,14000.00,30),(1006,'关羽','经理',1009,'2001-05-01',28500.00,NULL,30),(1007,'张飞','经理',1009,'2001-09-01',24500.00,NULL,10),(1008,'诸葛亮','分析师',1004,'2007-04-19',30000.00,NULL,20),(1009,'曾阿牛','董事长',NULL,'2001-11-17',50000.00,NULL,10),(1010,'韦一笑','销售员',1006,'2011-09-08',15000.00,0.00,30),(1011,'周泰','文员',1008,'2007-05-23',11000.00,NULL,20),(1012,'程普','文员',1006,'2001-12-03',9500.00,NULL,30),(1013,'庞统','分析师',1004,'2001-12-03',30000.00,NULL,20),(1014,'黄盖','文员',1007,'2002-01-23',13000.00,NULL,10),(1015,'张三','保洁员',1001,'2013-05-01',80000.00,50000.00,50);

#
# Structure for table "profit"
#

DROP TABLE IF EXISTS `profit`;
CREATE TABLE `profit` (
  `year` year(4) DEFAULT NULL,
  `zz` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "profit"
#

INSERT INTO `profit` VALUES (2010,100),(2011,150),(2012,250),(2013,800),(2014,1000);

#
# Structure for table "salgrade"
#

DROP TABLE IF EXISTS `salgrade`;
CREATE TABLE `salgrade` (
  `GRADE` int(11) NOT NULL DEFAULT '0' COMMENT '工资的等级',
  `LOwSAL` decimal(7,2) DEFAULT NULL COMMENT '此等级的最低工资',
  `HISAL` decimal(7,2) DEFAULT NULL COMMENT '此等级的最高工资'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工资等级表';

#
# Data for table "salgrade"
#

INSERT INTO `salgrade` VALUES (1,7000.00,12000.00),(2,12010.00,14000.00),(3,14010.00,20000.00),(4,20010.00,30000.00),(5,30010.00,99990.00);

-- 1.查询出姓张的，并且有提成的员工信息！
SELECT * 
FROM emp
WHERE ename LIKE '张%' and comm is not null;

-- 2.查询出“财务部”的员工信息！【使用联表和子查询两种方式实现】
SELECT * FROM emp
WHERE deptno = (SELECT deptno FROM dept WHERE dname = '财务部');
-- 联表
SELECT e.*,d.dname
FROM emp e
LEFT JOIN dept d
ON e.deptno = d.deptno
WHERE d.dname = '财务部';

-- 3.按照工资进行降序，查询前5的员工信息。【包含部门名称】！
SELECT e.*,d.dname
FROM emp e
LEFT JOIN dept d
ON e.deptno = d.deptno
ORDER BY e.sal DESC
LIMIT 5;

-- 4.统计出每个部门的人数、以及最高工资和最低工资！
SELECT count(e.empno) '人数',MAX(e.sal) '最高工资',MIN(e.sal) '最低工资',d.dname
FROM emp e
LEFT JOIN dept d
ON e.deptno = d.deptno
GROUP BY e.deptno;

-- 5.查询出工资在4级别的员工信息。
SELECT e.* FROM emp e
LEFT JOIN salgrade s
ON e.sal BETWEEN s.lowsal AND s.hisal
WHERE s.grade = 4;

-- 6.查询出没有上级的员工信息！
SELECT * FROM emp
WHERE mgr is null;

-- 7.查询出支出最高的部门信息！
SELECT * FROM dept
WHERE deptno = (SELECT e.deptno 
FROM emp e
GROUP BY e.deptno 
ORDER BY SUM(e.sal+IFNULL(e.comm,0)) desc
LIMIT 1);

-- 8.查询出每个部门最高工资的员工信息！
SELECT MAX(sal) m,deptno FROM emp
GROUP BY deptno;

SELECT e.* FROM emp e,(SELECT MAX(sal) m,deptno FROM emp GROUP BY deptno) d
WHERE e.sal = d.m and e.deptno = d.deptno;

-- 9.查出至少有一个员工的部门。显示部门编号、部门名称、部门位置、部门人数。
SELECT d.* ,COUNT(e.empno) '人数'
FROM dept d
LEFT JOIN emp e
ON d.deptno = e.deptno
GROUP BY e.deptno
HAVING COUNT(e.empno)>0;

-- 10.列出所有员工的姓名及其直接上级的姓名。
SELECT e1.ename '员工',e2.ename '上级'
FROM emp e1,emp e2
WHERE e1.mgr = e2.empno;

-- 11.列出受雇日期早于直接上级的所有员工的编号、姓名、部门名称。
SELECT e1.empno,e1.ename,d.dname
FROM emp e1
LEFT JOIN emp e2
on e1.mgr = e2.empno
LEFT JOIN dept d
on e1.deptno = d.deptno
WHERE e1.hiredate < e2.hiredate;

-- 12.列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门。
SELECT d.dname,e.*
FROM dept d
LEFT JOIN emp e
ON d.deptno = e.deptno;

-- 13.列出最低薪金大于15000的各种工作及从事此工作的员工人数。
SELECT job,COUNT(empno) '人数'
FROM emp
GROUP BY job
HAVING MIN(sal)>15000;

-- 14.列出在销售部工作的员工的姓名，假定不知道销售部的部门编号。
SELECT deptno FROM dept WHERE dname = '销售部';
SELECT ename FROM emp WHERE deptno = (SELECT deptno FROM dept WHERE dname = '销售部');

-- 15.列出薪金高于公司平均薪金的所有员工信息，所在部门名称，上级领导，工资等级。
SELECT avg(sal) FROM emp;
SELECT e1.*,e2.ename '领导姓名',s.grade
FROM emp e1
LEFT JOIN emp e2
ON e1.mgr = e2.empno
LEFT JOIN salgrade s
ON e1.sal BETWEEN s.lowsal and s.hisal
WHERE e1.sal>(SELECT avg(sal) FROM emp);

-- 16.列出与庞统从事相同工作的所有员工及部门名称。
SELECT job FROM emp WHERE ename = '庞统';
SELECT e.*,d.dname
FROM emp e
LEFT JOIN dept d
ON e.deptno = d.deptno
WHERE e.job = (SELECT job FROM emp WHERE ename = '庞统');

-- 17.列出薪金高于在部门30工作的所有员工的薪金的员工姓名和薪金、部门名称。
SELECT SUM(sal) FROM emp where deptno = 30;
SELECT e.ename,(e.sal + IFNULL(e.sal,0)) '总工资',d.dname
FROM emp e
LEFT JOIN dept d
ON e.deptno = d.deptno
WHERE e.sal + IFNULL(e.sal,0) > (SELECT SUM(sal) FROM emp where deptno = 30);

-- 18.查出年份、利润、年度增长比。 
