package hacker.rank.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

/*
Your company is designing a dam to be built across a stream to create a small lake. To reduce materials cost, it will be made of one or more concrete walls with mud packed in between them. Determine the maximum height of the mud segments in the dam with the following restrictions:
 
One unit width of the gap between walls will contain one segment of packed mud
The height of mud in a segment cannot exceed 1 unit more than an adjacent wall or mud segment.
 
Given the placement of a number of walls and their heights, determine the maximum height of a mud segment that can be built. If no mud segment can be built, return 0.
 
Example
wallPositions = [1, 2, 4, 7] 
wallHeights = [4, 6, 8, 11]
 */
public class DamDesign {
	
	@Test
	public void test1() {
		List<Integer> wallPositions = new ArrayList<Integer>(Arrays.asList(new Integer[] {1,2,4,7}));
		List<Integer> wallHeights = new ArrayList<Integer>(Arrays.asList(new Integer[] {4, 6, 8, 11}));
		Assert.assertEquals(10, maxHeighOfMudBlock(wallPositions, wallHeights));
	}
	
	@Test
	public void test2() {
		List<Integer> wallPositions = new ArrayList<Integer>(Arrays.asList(new Integer[] {1,3,7}));
		List<Integer> wallHeights = new ArrayList<Integer>(Arrays.asList(new Integer[] {4,3,3}));
		Assert.assertEquals(5, maxHeighOfMudBlock(wallPositions, wallHeights));
	}
	
	/*
	 * declare a maxHeight integer
	 * declare a arraylist called fromLeftMudHeight of int
	 * declare a arraylist called mudHeights of int
	 * iterate from 0 to last wallPosition
	 * 	check if i is present in wallPositions list
	 * 		if yes, then add 0 to fromLeftMudHeight
	 * 		if no, then add to array the previous height+1 
	 * iterate from last wall position to 0
	 * 	check if i is present in wallPositions list
	 * 		if yes, then add 0 to mudHeights
	 * 		if no, compare the index of fromLeft with nextHeight+1 and add the min to mudHeights
	 * return mad of mudHeights
	 */

	private int maxHeighOfMudBlock(List<Integer> wallPositions, List<Integer> wallHeights) {
		
		int wallLength = wallPositions.get(wallPositions.size()-1);
		int[] damHeights = new int[wallLength+1];
		//1,2,4,7
		//4,6,8,11
		//0,4,6,7,8,9,10,11
		//0,1,2,3,4,5,06,07
		int j = 0;
		for (int i = 1; i <damHeights.length; i++) {
			if(!wallPositions.contains(i)) damHeights[i] = damHeights[i-1]+1;
			else damHeights[i] = wallHeights.get(j++);
			
		}
		int max = Integer.MIN_VALUE;
		for (int i = damHeights.length-1; i >=1; i--) {
			if(!wallPositions.contains(i)) {
				int temp = damHeights[i+1]+1;
				//get min of damHeights[i] and temp
				int minMudHeight = Math.min(temp, damHeights[i]);
				//write the minMudeHeight to array
				damHeights[i] = minMudHeight;
				//get the max of this above min with previosuMin
				if(minMudHeight>max) max = minMudHeight;
			}
		}
		return max;
	}

}
