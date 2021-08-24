package hacker.rank.test;

import org.junit.Assert;
import org.junit.Test;

public class ConferenceSchedule {

	@Test
	public void test1() {
		int[] startTime = {1,1,2,3};
		int[] endTime = {2,3,3,4};
		Assert.assertEquals(3, numberOfConference(startTime, endTime));
	}
	
	@Test
	public void test2() {
		int[] startTime = {1,2,8,6};
		int[] endTime =   {9,3,10,9};
		Assert.assertEquals(2, numberOfConference(startTime, endTime));
	}
	
	@Test
	public void test3() {
		int[] startTime = {2,8,1,7};
		int[] endTime =   {7,9,8,9};
		Assert.assertEquals(3, numberOfConference(startTime, endTime));
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
	private Object numberOfConference(int[] startTime, int[] endTime) {
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
