package com.hht.面试题;

public class Louti {
	
	private int count = 0;	// 几种走法
	
	public int exe(int num) {
		count = 0;
		nextStep(num);
		return count;
	}
	
	private void nextStep(int remain) {
		if(remain == 0) {
			count++;
		}else {
			if(remain >= 1) {
				nextStep(remain-1);
			}
			if(remain >= 2) {
				nextStep(remain-2);
			}
			if(remain >= 3) {
				nextStep(remain-3);
			}
		}
	}
	
	
	

}
