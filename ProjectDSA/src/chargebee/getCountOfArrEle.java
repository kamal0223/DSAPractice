package chargebee;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;

public class getCountOfArrEle {

	@Test
	public void test1() {
		int[]  arr = {1,2,3,4,1};
		            //0,0,-1,-1,-2
		int n = 5;
		findCountOfEle(arr,n);

	}

	/*
	 * iterate the array from 1 to n
	   subtract i - arr[i]
	   if subtract is negative then -1, then make sub = len+sub
	   if subtract is 0 then make output[i]++
	   output[sub]++
	 */
	private void findCountOfEle(int[] arr,int n) {
		int[] count = new int[arr.length];
		for (int i = 1; i <= n; i++) {
			int sub = i-arr[i-1];
			count[i-1-sub]++;
		}
		System.out.println(Arrays.toString(count));
	}
	
	private void findCountOfEle1(int[] arr,int n) {
		int[] asciiCount = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			asciiCount[arr[i]-1]++;
		}
		System.out.println(Arrays.toString(asciiCount));
	}



}
