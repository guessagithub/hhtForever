package com.hht.Java基础.JDK代理.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK的动态代理主要有2个类：
 * 
 * @author guessa
 *
 */


public class DynamicTimeProxy implements InvocationHandler{

	private Object target;
	
	public DynamicTimeProxy(Object target){
		this.target = target;
	}
	
	public <T> T getProxy() {
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long begin = System.currentTimeMillis();
		Object result = method.invoke(target, args);
		long count = System.currentTimeMillis() - begin;
		System.out.println(target.getClass().getName() + " - " + method.getName() + " 服务耗时：" + count);
		return result;
	}
	
	
}
