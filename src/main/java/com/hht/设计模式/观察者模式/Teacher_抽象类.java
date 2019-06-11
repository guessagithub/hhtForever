package com.hht.设计模式.观察者模式;

public interface Teacher_抽象类 {

	public void add(Student_抽象类 student);
	
	public void remove(Student_抽象类 student);
	
	public void notifyStudent();
	
}
