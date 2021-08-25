package hacker.rank.test;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class ConferenceSchedule {

	@Test
	public void test1() {
		int[] startTime = {1,1,2,3};
		int[] endTime = {2,3,3,4};
		Assert.assertEquals(3, maxPresentation(startTime, endTime));
	}

	@Test
	public void test2() {
		int[] startTime = {1,2,9,6};
		int[] endTime =   {9,3,10,9};
		Assert.assertEquals(3, maxPresentation(startTime, endTime));
	}

	@Test
	public void test3() {
		int[] startTime = {2,8,1,7};
		int[] endTime =   {7,9,8,9};
		Assert.assertEquals(2, maxPresentation(startTime, endTime));
	}

	/*
	 declare a maxPresentation
	 Make a 2 dimensional array pairing the start and endtimes
	 sort the 2-D array by end time and if endtime matches by starttime
  	 Set the startPointer as 1 and endPointer as 0
     Traverse through the size of 2D array
	 check if endtime at endPointer <=startTime at startPointer maxPresentation++ and increment end
	 increment start always
	 return maxPresentation
	 */
	private int maxPresentation(int[] startTime, int[] endTime) {
		int maxPresentation = 1;
		int[][] presentations = new int[startTime.length][2];
		for (int i = 0; i < presentations.length; i++) {
			presentations[i][0] = startTime[i];
			presentations[i][1] = endTime[i];
		}
		//sort the array based on endtime and startime
		Arrays.sort(presentations, (a,b)->{
			if(a[1]!=b[1]) return a[1]-b[1];
			else return a[0]-b[0];
		});
		int start = 1, end=0;
		while(start<presentations.length) {
			if(presentations[end][1]<=presentations[start][0]) {
				maxPresentation++;
				end = start;
			}
			start++;
		}
		
		return maxPresentation;
	}

	/*
	 * brute force
	 * declare a maxCounter to 0
	 * declare two pointer i to zero and j to one
	 * iterate till pointer i less than size
	 * 	declare a temp pointer same as i
	 * 	declare a counter to 1
	 * 	iterate j pointer till the last element
	 * 		check startTime of j > = endTime of temp OR endTime of j< = temp StartTime
	 * 		if yes increment counter and change the pointer temp to j
	 * 		if not then increment j
	 * 	after the inner loop check count>maxCount
	 * 		if yes , update the maxCount to count
	 * return maxCount
	 * 
	 */
	private Object maxPresentationBruteForce(int[] startTime, int[] endTime) {
		int maxCount = 0;
		for (int i = 0; i < endTime.length; i++) {
			int count = 1;
			int temp = i;
			for (int j = i+1; j < endTime.length; j++) {
				if(startTime[j]>=endTime[temp] || endTime[j]<=startTime[temp]) {
					count++;
					temp = j;
				}
			}
			if(count>maxCount) maxCount = count;
		}
		return maxCount;
	}	
}
