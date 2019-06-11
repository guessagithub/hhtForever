package com.hht.设计模式.工厂模式.工厂方法模式;

import com.hht.设计模式.工厂模式.Baoma;
import com.hht.设计模式.工厂模式.ICar;

public class BaomaFactory implements IFactory {

	public ICar getCar() {
		return new Baoma();
	}

}
