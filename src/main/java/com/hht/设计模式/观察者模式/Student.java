package com.hht.设计模式.观察者模式;

public class Student implements Student_抽象类 {

	private String name = "";
	
	public Student (String name){
		this.name = name;
	}
	
	public void update(String msg) {
		System.out.println(String.format("我是“%s”， 我收到消息：%s 。 ", name, msg));
	}

}
