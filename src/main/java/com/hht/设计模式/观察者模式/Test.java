package com.hht.设计模式.观察者模式;

public class Test {

	
	/**
	 * 	学生观察老师，执行老师的命令
	 * 
	 */
	public static void main(String[] args) {
		
		Teacher teacher = new Teacher();
		
		// 创建观察者
		Student_抽象类 s1 = new Student("张三");
		Student_抽象类 s2 = new Student("李四");
		Student_抽象类 s3 = new Student("王五");
		
		// 注册观察者
		teacher.add(s1);
		teacher.add(s2);
		teacher.add(s3);
		
		// 老师发布消息
		teacher.setMsg("上课了！");
		
		System.out.println("________________________________________________________________________________");
		
		// 移除观察者，再发布一条消息
		teacher.remove(s1);
		teacher.remove(s2);
		teacher.setMsg("下课了！");
		
		
		
		
	}

}
