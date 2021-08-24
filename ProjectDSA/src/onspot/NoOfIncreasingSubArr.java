package onspot;

import org.junit.Assert;
import org.junit.Test;

/*
 * Count the number of strictly increasing subarray of a 
 * specified size k in an array of size N .
 */
public class NoOfIncreasingSubArr {
	
	@Test
	public void test1() {
		int[] nums = {5,3,7,6,8};
		int k = 3;
		//pairs 3,5 and 5,7 and 7,8
		//3,5,7 and 5,7,8 are two strictly increasing subarray
		Assert.assertEquals(0, numberOfIncreasingSubArr(nums, k));
	}
	
	@Test
	public void test2() {
		int[] nums = {5,6,8,9,7,9,10};
		int k = 2;
		//if k=3 then output = 3
		//2+2-3+2 = 2+1 = 3
		Assert.assertEquals(5, numberOfIncreasingSubArr(nums, k));
	}
	
	@Test
	public void test4() {
		int[] nums = {5,3,5,7,8};
		int k = 6;
		Assert.assertEquals(0, numberOfIncreasingSubArr(nums, k));
	}


	private int numberOfIncreasingSubArr(int[] nums, int k) {
		//declare an int count to 0
		//iterate the input array
		//compare i value is less than i+1 value then increment the counter
		//we got the pairs that are increasing
		//if the k >2 then return count-k+1
		//or if k ==2 return count-k+2
	
		int count = 0;
		if(k==1) return nums.length;
		if(k>nums.length) return 0;
		int result = 0;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i-1]<nums[i]) {
				//check if the index are adjacent, if yes add to continuouCount
				count++;
				}else if(count>=k) {
					result += count-k+2;
					//reset counter and increment
					count = 0;
				}
			}
		if(count>=k) result += count-k+2;
		return result;
		}
		
	
	private int findCounts(int[] intarr, int k) {

		int count=0;
		int windowstart=0;
		for (int windowend = 1; windowend < intarr.length; windowend++) {
			if(intarr[windowstart]>intarr[windowend]) {
				windowstart=windowend;
			}
			while(intarr[windowstart]<intarr[windowend] && ((windowend-windowstart)+1==k)) {
				count++;
				windowstart++;
			}

		}

		System.out.println(count);
		return count;
	}

}
