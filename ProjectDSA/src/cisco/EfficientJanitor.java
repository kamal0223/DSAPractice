package cisco;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class EfficientJanitor {
	
	@Test
	public void test1() {
		int n = 5;
		float[] weight = {1.01f, 1.99f, 2.5f, 1.5f, 1.01f};
		Assert.assertEquals(3, minimumTrip(n, weight));
	}
	
	@Test
	public void test2() {
		int n = 3;
		float[] weight = {2.51f, 1.01f, 2.5f, 1.99f, 1.5f, 1.5f};
		//1.01f, 1.5f, 1.5f, 1.99f, 2.5f, 2.51f
		Assert.assertEquals(4, minimumTrip(n, weight));
	}
	
	@Test
	public void test3() {
		int n = 2;
		float[] weight = {1.01f, 1.01f};
		Assert.assertEquals(1, minimumTrip(n, weight));
	}
	
	@Test
	public void test4() {
		int n = 1;
		float[] weight = {1.01F};
		Assert.assertEquals(1, minimumTrip(n, weight));
	}
	
	/*if a bag is more than 1.99 then it cannot be paired with any other
	 * janitor can carry minimum one and max 2 bags (as min weith of one bag is 1.01)
	 * sort the arrays using utils.Arrays or collection.sort if list
	 * declare left at 0 and right at last index
	 * iterate till the left and right are not matching 
	 * if the right bag weights more than 1.99 then increment 1 and move right pointer alone
	 * else move left and right and increment counter
	 * return count
	 * 
	 */
	private int minimumTrip(int n, float[] weight) {
		
		if(weight.length == 1) return 1;
		if(weight.length == 0) return 0;
		Arrays.sort(weight);
		int minimumTrip = 0, left = 0, right = weight.length-1;
		while(left<right) {
			if(weight[right]> 1.99f) {
				minimumTrip++;
				right--;
			}else {
				minimumTrip++;
				left++;
				right--;
			}
		}
		return minimumTrip;
	}

}
