package binarysearch;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;


/*Given an array arr of positive integers sorted in a strictly increasing order, and an integer k. 
Find the kth positive integer that is missing from this array.*/

/*Input: int[] input, int k
Output: int output
constraints: time complexity should be O(logn)


TestData set: Positive
			  Negative
			  Edge
Approaches Known: brute force and binary search
*/
public class FindKthPositiveInt {

	@Test //positive
	public void test1() {
		int input[] = {2,3,4,7,11};
		int k = 5;
		Assert.assertEquals(9, usingBinarySearch(input, k));
	}
	
	//negative
	@Test (expected = RuntimeException.class)
	public void test2() {
		int input[] = {1,2,3,4};
		int k = 0;
		Assert.assertEquals(6, usingBinarySearch(input, k));
	}

	@Test //edge
	public void test3() {
		int input[] = {2,4,5,6,8,9};  //1,3,7,10,11
		int k = 5;
		Assert.assertEquals(11, usingBinarySearch(input, k));
	}

	
	/*
	 * declare no of missing element integer missingEleCount
	 * declare low , high
	 * iterate loop till low<high
	 * find the mid of low and high
	 * find the number of elements missing before the mid value = midvalue-mid+1 assign to missingEleCount
	 * if missingEleCount<k, move right low = mid+1
	 * if missingEleCount>=k, move high = mid-1
	 * 
	 * return low+k

	
	*/
	
	
	private int usingBinarySearch(int[] input, int k) {
		
		if(k==0) throw new RuntimeException("Invalid Target");
		
		int missingEleCount = -1;
		int low = 0, high = input.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			missingEleCount = input[mid]-(mid+1);
			if(missingEleCount<k) low = mid+1;
			if(missingEleCount>=k) high = mid-1;
		}
		
		return low+k;
	}
}
