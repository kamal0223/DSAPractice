package onspot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

/*
 * given a array of unsorted elements, move all odd to right
 * 
 * Did you understand the question? yes
 * the inputs are int[] input
 * expected output is int[] output
 * any constranits - No constraints
 * confirm your understand and if yes, proceed
 * Test data to be covered
 * 
 * 

*/
public class MoveOddToRight {
	
	
	@Test
	public void test1() {
		int[] input = {4,7,3,2,1,13};
		Assert.assertTrue(Arrays.equals(new int[] {4,2,7,3,1,13}, usingTwoPointer(input)));
	}
	
	
	@Test
	public void test2() {
		int[] input = {2,4,6,8};
		Assert.assertTrue(Arrays.equals(new int[] {2,4,6,8}, usingTwoPointer(input)));
	}
	
	@Test
	public void test3() {
		int[] input = {4,3,7};
		Assert.assertTrue(Arrays.equals(new int[] {4,3,7}, usingTwoPointer(input)));
	}

	/*brute force 
	create two arraylist
	traverse through the array
	if element is even then add it to an list say evenList
	if element is odd then add it to list say oddList
	add all the oddList to end to evenList
	convert the arraylist to int array by traversing the evenlist
	
	time coplexity - O(n) two pass
	space complexity - 0(n)+O(n) = O(n)
	*/	
	
	
	private int[] bruteForce(int[] input) {
		
		List<Integer> evenList = new ArrayList<Integer>();
		List<Integer> oddList = new ArrayList<Integer>();
		int[] output = new int[input.length];
		for(int i = 0;i<input.length;i++) {
			if(input[i]%2 == 0)  evenList.add(input[i]);
			if(input[i]%2 != 0)  oddList.add(input[i]);
		}
		
		evenList.addAll(oddList);
		//System.out.println(evenList);
		for(int i = 0;i<evenList.size();i++) {
			output[i] = evenList.get(i);
		}
		System.out.println(Arrays.toString(output));
		return output;
	}
	
	/*using2pointer
	 * 9,2,6,5,4,2
	initialize pointers left and right on start and end of array
	traverse through the array till left<right
	check if left is odd and right is even if yes -> then swap left ele to right ele, increment both pointers
	if left is even then move left++ 
	if right is odd then move right--
	return input

	time complexity O(n/2)
	space complexity O(1)
	*/	
	
	private int[] usingTwoPointer(int[] input) {
		int left = 0, right = input.length-1;
		
		while(left<right) {
			
			if(input[left]%2 != 0 && input[right]%2 == 0) {
				int temp = input[left];
				input[left] = input[right];
				input[right] = temp;
				left++;
				right--;
			}
			else if(input[left]%2 == 0) left++;
			else if(input[right]%2 != 0) right--;
			
		}
		
		
		
		return input;
		
	}

}
