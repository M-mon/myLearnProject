例子：ISP.java
学生成绩管理程序。

分析：学生成绩管理程序一般包含插入成绩、删除成绩、修改成绩、计算总分、计算均分、打印成绩信息、査询成绩信息等功能。
如果将这些功能全部放到一个接口中显然不太合理，正确的做法是将它们分别放在输入模块、统计模块和打印模块等 3 个模块中。


即，以一定的规律，打散功能放置。
可以是根据操作类型进行划分，如输入模块，是对数据进行增删改，是直接操作数据的类型。
也可以是根据面向用户进行划分，如打印模块，对师生进行开放，可以放置在同一页面的功能。
