package com.hht.算法.排序;

import com.hht.common.UtilsPrint;

public class 冒泡排序 {

	public static void main(String[] args) {
		
		int[] nums = {2,8,3,6,9,0,5,7};
		maopao(nums);
		
	}

	private static void maopao(int[] nums) {
		int temp;
		int size = nums.length;
		for(int i=0;i<size-1;i++) {
			for(int j=i+1;j<size;j++) {
				if(nums[i]>nums[j]) {
					temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		
		UtilsPrint.printArray(nums);
	}
	
	
	
	
	
}
