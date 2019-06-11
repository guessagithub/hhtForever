package com.hht.设计模式.工厂模式.简单工厂模式;

import com.hht.设计模式.工厂模式.ICar;

public class Test {

	public static void main(String[] args) {
		
		ICar car = SimpleCarFactory.createCar(SimpleCarFactory.TYPE_BAOMA);
		car.createCar();

	}

}
