package binarysearch;
import org.junit.Test;

import junit.framework.Assert;

/*You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
Follow up: Your solution should run in O(log n) time and O(1) space.*/

/*Input: int[] input
Output: int output
constraints: 


TestData set: Positive
			  Negative
			  Edge
Approaches Known: Binary search
*/
public class SingleElementFinder {

	@Test
	public void test1() {
		int[] input = {1,1,2,3,3,4,4,8,8};
		Assert.assertEquals(2, usingBinarySearch(input));
	}


	@Test
	public void test2() {
		int[] input = {1,1,2,2,3,3,4,8,8};
		Assert.assertEquals(2, usingBinarySearch(input));
	}

	@Test
	public void test3() {
		int[] input = {1,1,2,2,3,4,4,8,8};
		Assert.assertEquals(2, usingBinarySearch(input));
	}




	/*
	 * delcare low as zero and high as length-1
	 * iterate till low crossed high
	 * delcare mid as low+high/2
	 * check the mid-1 is not equal to mid value or mid+1 is not equal to mid value then return mid value
	 * if value at mid-1 is equal to mid then high = mid-2
	 * if value at mid+1 is equal to mid then low = mid+2

	 */
	private int usingBinarySearch(int[] input) {

		int low = 0, high = input.length-1;
		while(low<high) {
			int mid = (low+high)/2;
			if(input[mid-1]!=input[mid] && input[mid+1]!= input[mid]) return input[mid];
			if(input[mid-1]==input[mid]) high = mid-2;
			if(input[mid+1]==input[mid]) low = mid+2;
		}

		return -1;
	}

}




