package onspot;

import org.junit.Test;

import junit.framework.Assert;

//Given first N natural numbers in unsorted order. Find 2 subset of arrays such that 
//the sum of difference of this arrays is minimum
public class MinDiff {
	
	@Test
	public void test1() {
		int n = 4;
		int[] arr = {3,4,2,1};
		Assert.assertTrue(canPartition(n, arr));
	}

	@Test
	public void test2() {
		int n = 5;
		int[] arr = {5,3,4,2,1};
		Assert.assertFalse(canPartition(n, arr));
	}
	public boolean canPartition(int n, int[] nums) {
        if (nums.length == 0)
            return false;
        int totalSum = 0;
        // find sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) return false;
        int subSetSum = totalSum / 2;
        boolean dp[] = new boolean[subSetSum + 1];
        dp[0] = true;
        for (int curr : nums) {
            for (int j = subSetSum; j >= curr; j--) {
                dp[j] |= dp[j - curr];
            }
        }
        return dp[subSetSum];
    }
}
