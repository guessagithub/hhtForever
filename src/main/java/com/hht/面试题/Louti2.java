package com.hht.面试题;

public class Louti2 {

	/**
	 * 	1个台阶1种走法，2个台阶2种走法， 3个台阶4种走法
	 * 	台阶大于3后，走法是前3个走法的总和： (n-1) + (n-2) + (n-3)
	 * 
	 */
	public static int exe(int num) {
		if(num ==1) {
			return 1;
		}else if(num == 2) {
			return 2;
		}else if(num == 3) {
			return 4;
		}else {
			return exe(num-1)+exe(num-2)+exe(num-3);
		}
	}
	
}
