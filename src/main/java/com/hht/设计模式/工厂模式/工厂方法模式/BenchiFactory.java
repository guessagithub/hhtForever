package com.hht.设计模式.工厂模式.工厂方法模式;

import com.hht.设计模式.工厂模式.Benchi;
import com.hht.设计模式.工厂模式.ICar;

public class BenchiFactory implements IFactory {

	public ICar getCar() {
		return new Benchi();
	}

}
