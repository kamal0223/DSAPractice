package week4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

/*Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.*/

/*Input: int[] input
Output: int output
constraints: O(n)


TestData set: Positive
			  Negative
			  Edge
Approaches Known: brute force
*/

public class LongestConsecutiveSequence {
	
	@Test
	public void test1(){
		int[] input = {100,4,200,1,3,2};
		Assert.assertEquals(4, usingBruteForce(input));
	}
	
	@Test
	public void test2(){
		int[] input = {0,3,7,2,5,8,4,6,0,1};
		Assert.assertEquals(9, usingBruteForce(input));
	}
	
	@Test
	public void test3(){
		int[] input = {1,1,1,1};
		Assert.assertEquals(1, usingBruteForce(input));
	}
	
	@Test
	public void test4(){
		int[] input = {9,1,4,7,3,-1,0,5,8,-1,6};
		Assert.assertEquals(7, usingBruteForce(input));
	}

	/*
	 * remove the duplicate in array by adding to hashset
		iterate the array till lenght
		add the i value to a  temp
		iterate pointer untill pointer reaches end
		check if value at i == pointer-1 increment counter
		i++
		get max of maxCounter, counter
	
	*/
	private int usingBruteForce(int[] input) {
		
		int max = 0;
		Set<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < input.length; i++) {
			hs.add(input[i]);
		}
		
		//iterate the input array
		//loop if the elements increment is present in array
		//if present increment counter and remove the element
		for(int i = 0;i<input.length;i++) {
			int count = 1;
			int num = input[i];
			//to right of the number
			while(hs.remove(++num)) count++;  //logn -uses maps remove which removes by hashkey and index
			num = input[i];
			while(hs.remove(--num)) count++;
			hs.remove(input[i]);
			max = Math.max(max, count);
		}
		
		return max;		
	}

}
