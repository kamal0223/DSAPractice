package week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class IntersectionOfTwoArrays {

	@Test
	public void test1() {
		int[] input1 = {1,3,5,2,4,3};
		int[] input2 = {3,7,5,8};
		Assert.assertTrue(Arrays.equals(new int[] {3,5}, usingTwoPointer(input1, input2)));
	}
	
	@Test
	public void test2() {
		int[] input1 = {1,3,5,2,4};
		int[] input2 = {0,9};
		Assert.assertTrue(Arrays.equals(new int[] {}, usingTwoPointer(input1, input2)));
	}
	
	@Test
	public void test3() {
		int[] input1 = {5,5,5};
		int[] input2 = {5,5,5};
		Assert.assertTrue(Arrays.equals(new int[] {5,5,5}, usingTwoPointer(input1, input2)));
	}
	@Test
	public void test4() {
		int[] input1 = {3,7,5,8};
		int[] input2 = {1,3,5,2,4,3};
		Assert.assertTrue(Arrays.equals(new int[] {3,5}, usingTwoPointer(input1, input2)));
	}
	
	private int[] usingBruteForce(int[] input1, int[] input2) {
		/*
		 * declare an int index
		 * declare an arraylist
		   iterate the input1 and get element
		   	for each element in input1, iterate input2
		   	check if the j index is not contained in list
		   	find the values matching in input1 and input2
				if match found, add the i value to to input1 at index
				add the index j in a list
				break inner loop
		 * After all iterations, copy the array input1 from 0 to index
		 * return the copied array
		 * time complexity - O(n^2) space complexity - O(n)
		 */
		
		int index = 0;
		List<Integer> matchedIndex = new ArrayList<Integer>();
		for (int i = 0; i < input1.length; i++) {
			for (int j = 0; j < input2.length; j++) {
				if(!matchedIndex.contains(j)) {
					if(input1[i] == input2[j]) {
						input1[index++] = input1[i];
						matchedIndex.add(j);
						break;
					}
				}
				
			}
		}
		System.out.println(Arrays.toString(Arrays.copyOf(input1, index)));
		return Arrays.copyOf(input1, index);
	}
	
	private int[] usingTwoPointer(int[] input1, int[] input2) {
		/*
		 * declare left and right pointers to 0
		 * declare index to 0 to rebase any one input with the output
		 * sort both the arrays in ascending
		 * iterate till both input arrays are within length
		 * check if value at left and right are same, 
		 * 		then add the value at left to input1 at index position
		 * 		move left and right
		 * if value at left is less than right
		 * 		then move left pointer
		 * if value at right is less than left
		 * 		then move right pointer
		 * After all iterations, copy the array input1 from 0 to index
		 * return the copied array
		 * time complexity - O(nlogn) space complexity - O(n)
		 */
		
		int left = 0, right = 0;
		int index = 0; 
		List<Integer> output = new ArrayList<Integer>();
		Arrays.sort(input1);
		Arrays.sort(input2);
		while(left<input1.length && right<input2.length) {
			//!(output.contains(input1[left]))
			if(input1[left] == input2[right]){ 
				//add the value at left to the input1 index
				output.add(input1[left]);
				left++;
				right++;
			}else if(input1[left]<input2[right]) left++;
			else right++;
		}
		
		System.out.println(output.toString());
		for(int each:output) {
			input1[index++] = each;
		}
		return Arrays.copyOf(input1, index);
	}
}
