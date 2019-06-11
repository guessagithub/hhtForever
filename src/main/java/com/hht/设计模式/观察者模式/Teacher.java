package com.hht.设计模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

public class Teacher implements Teacher_抽象类 {

	private String msg;
	
	private List<Student_抽象类> list = new ArrayList<Student_抽象类>();
	
	public void add(Student_抽象类 student) {
		list.add(student);
	}

	public void remove(Student_抽象类 student) {
		list.remove(student);
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
		System.out.println("老师发布消息： " + msg);
		notifyStudent();
	}

	public void notifyStudent() {
		for(Student_抽象类 student : list) {
			student.update(msg);
		}
	}

}
