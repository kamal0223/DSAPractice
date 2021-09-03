package binarysearch;

import java.util.HashMap;
import java.util.TreeMap;

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
		int input[] = {2,3,4,7,11};  //1,5,6,8,9,10,12
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
	
	    //declare two int variables low to 0 and high to length-1
        //iterate when condition satisfy low<=high
        //declare int mid which is low+high by 2
        //check if midvalue - mid is less than k, yes then move low to mid+1
        //check if midValue - mid is greater than k, yes then move high to mid-1
        //return K+high
	
	private int usingBinarySearch(int[] arr, int k) {
		if(k == 0) throw new RuntimeException("k cannot be 0");
        int low = 1, high = arr.length;
        while(low<=high){
            int mid = (low+high)/2;
            if((arr[mid-1]-mid) < k) low = mid+1;
            else high = mid-1;
        }
        return k+high;
	}
}
