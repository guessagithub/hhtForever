package com.hht.Java基础.JDK代理;

import com.hht.Java基础.JDK代理.动态代理.DynamicTimeProxy;
import com.hht.Java基础.JDK代理.静态代理.KtvServerTimeProxy_static;

public class Test {

	public static void main(String[] args) {
		
		/**
		 * 静态代理
		 * 
		 * 在不改变KtvA的sing()代码的前提下，对sing耗时进行了统计，即对sing方法进行了前后置增强
		 * 
		 * 缺点：不容易扩展。 
		 * 
		 * 代理类和被代理类实现了相同的接口，导致代码的重复，如果接口增加一个方法，
		 * 那么除了被代理类需要实现这个方法外，代理类也要实现这个方法，增加了代码维护的难度
		 * 
		 * 代理对象只服务于一种类型的对象，如果要服务多类型的对象。
		 * 势必要为每一种对象都进行代理，静态代理在程序规模稍大时就无法胜任了。
		 * 
		 */
		System.out.println("============= 静态代理 =============================================");
		KtvServer ktvA = new KtvA();
		KtvServerTimeProxy_static ktvProxy_static = new KtvServerTimeProxy_static(ktvA);
		
		ktvProxy_static.sing();
		
		
		/**
		 * 动态代理
		 */
		System.out.println("============= 动态代理 =============================================");
		KtvServer ktvProxy = new DynamicTimeProxy(new KtvA()).getProxy();
		ktvProxy.sing();
		
		SpaServer spaProxy = new DynamicTimeProxy(new SpaA()).getProxy();
		spaProxy.massage();
		
		
	}

}
