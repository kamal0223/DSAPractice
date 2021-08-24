package onspot;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;

import junit.framework.Assert;

//Swap any two digits to get the biggest number

public class SwapTwoDigitsToMax {

	@Test
	public void test1() {
		int num = 2736;
		Assert.assertEquals(7236, getMaxDigit(num));
	}
	
	@Test
	public void test2() {
		int num = 1997;
		Assert.assertEquals(9917, getMaxDigit(num));
	}

	/*
	 * iterate and get the last occurence of max if multiple max are present and its index
	   find the first occurence of element less than max iterating from 0 to maxIndex
	   get the min and minIndex
	   swap that minIndex and maxIndex
	 */
	private int getMaxDigit(int num) {
		
		int maxIndex = 0;
		int minIndex = 0;
		//convert the int to int array
		String temp = String.valueOf(num);
		int[] nums = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++) {
			nums[i] = temp.charAt(i)-'0';
		}
		int max = nums[0] ;
		for (int i = 1; i < nums.length-1; i++) {
			if (max<=nums[i]) {
				max = nums[i];
				maxIndex = i;
			}
		}
		//2178
		int min = 0;
		for (int i = 0; i <= maxIndex; i++) {
			if (max<nums[i]) {
				min = nums[i];
				minIndex = i;
			}
		}
		
		int swapper = nums[minIndex];
		nums[minIndex] = nums[maxIndex];
		nums[maxIndex] = swapper;
		System.out.println(Arrays.toString(nums));
		return 1;
	}
}

