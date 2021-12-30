package vmware;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class Sort0And1 {
	
	@Test
	public void test1() {
		int[] num = {1, 0, 1, 1, 0, 1, 0, 0};
		Assert.assertTrue(Arrays.equals(new int[] {0, 0, 0, 0, 1, 1, 1, 1}, sortArray2(num)));
	}
	@Test
	public void test2() {
		int[] num = {1};
		Assert.assertTrue(Arrays.equals(new int[] {1}, sortArray2(num)));
	}
	@Test (expected = RuntimeException.class)
	public void test3() {
		int[] num = {};
		Assert.assertTrue(Arrays.equals(new int[] {}, sortArray2(num)));
	}

	/**
	 * @author kamalakannan.s
	 * @param num the array to be sorted
	 * @throws RunTimeException if the num length is 0
	 */
	//time complexity - O(2n) and space is O(1)
	private int[] sortArray(int[] num) {
		if(num.length == 0) throw new RuntimeException("the input array is empty");
		if(num.length == 1) return num;
		int zeroCount = 0;
		for(int i = 0 ;i<num.length;i++) {
			if(num[i] == 0) zeroCount++;
		}
		Arrays.fill(num, 0, zeroCount, 0);
		Arrays.fill(num, zeroCount, num.length,1);
		return num;
	}
	
	/*
	 * declare 2 pointers left as 0 and right at length-1
	 * traverse the array till the left and right meet
	 * check if the left value is 0 then increment left
	 * else check the value at right is 0 then swap
	 * check if the right value is 1 then increment right
	 * 
	 * left 0 and right 0 then increment left only
	 * left 0 and right 1 then increment left and decrement right
	 * left 1 and right 0 then swap both and move both
	 * left 1 and right 1 then decrement right only
	 * 
	 * time complexity best case - O(n/2) and avg case - less than O(n) and worst o(n) space - o(1)
	 */
	private int[] sortArray2(int[] num) {
		Set<Integer> set  = new HashSet<Integer>();
		set.add(1);
		set.add(5);
		set.add(2);
		Collections.sort
		if(num.length == 0) throw new RuntimeException();
		int left  = 0 , right = num.length-1;
		while(left<right) {
			if(num[left] == 0 && num[right] == 0) left++;
			else if(num[right] == 0) {  // left 1 and right 0
				//int temp = num[left];
				num[left++] = 0;
				num[right--] = 1;
			}else if(num[left] == 0) { // left 0 and right 1
				left++;
				right--;
			}else right--;
		}
		return num;
	}
}
