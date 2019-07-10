package com.hht.Java基础.JDK代理.静态代理;

import com.hht.Java基础.JDK代理.KtvServer;

/**
 * 统计各个方法耗时的代理
 * 
 * 
 * @author guessa
 *
 */
public class KtvServerTimeProxy_static implements KtvServer{

	private KtvServer ketServer;
	
	public KtvServerTimeProxy_static(KtvServer ketServer){
		this.ketServer = ketServer;
	}
	
	public void sing() {
		long begin = System.currentTimeMillis();
		ketServer.sing();
		long count = System.currentTimeMillis() - begin;
		System.out.println("KTV sing() 服务耗时：" + count);
		
	}

}
