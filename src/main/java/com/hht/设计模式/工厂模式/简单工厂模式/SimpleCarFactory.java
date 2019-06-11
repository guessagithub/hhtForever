package com.hht.设计模式.工厂模式.简单工厂模式;

import com.hht.设计模式.工厂模式.Aodi;
import com.hht.设计模式.工厂模式.Baoma;
import com.hht.设计模式.工厂模式.Benchi;
import com.hht.设计模式.工厂模式.ICar;

public class SimpleCarFactory {
	
	public static final String TYPE_BAOMA = "baoma";
	public static final String TYPE_AODI = "aodi";
	public static final String TYPE_BENCHI = "benchi";
	
	public static ICar createCar(String type) {
		ICar car = null;
		if(TYPE_BAOMA.equals(type)) {
			car = new Baoma();
		}
		if(TYPE_AODI.equals(type)) {
			car = new Aodi();
		}
		if(TYPE_BENCHI.equals(type)) {
			car = new Benchi();
		}
		
		return car;
	}

}
