package dynamicprogramming;

import org.junit.Test;

import junit.framework.Assert;

public class ClimbStairs {

	@Test
	public void test1() {
		int n = 2;
		Assert.assertEquals(2, numberOfStepsDp(n));
	}

	@Test
	public void test2() {
		int n = 5;
		Assert.assertEquals(8, numberOfStepsDp(n));
	}

	@Test
	public void test3() {
		int n = 1;
		Assert.assertEquals(1, numberOfStepsDp(n));
	}

	/*
	 * //recursion (top down approach)
       //base condition when n is 1 or 0 return 1
       //call the function with -1 of n + function with -2 of n
	 */
	private int numberOfSteps(int n) {
		if(n<2) return 1;
		int steps = numberOfSteps(n-1)+numberOfSteps(n-2);
		return steps;
	}

	/*dynamic programming bottom up approach
	 *  //create a dp array of size n+1
        //bottom up approach
        //create a dp array of size n+1
        //when there is 0 steps then value of it is 0
        //when n is 1 then number of ways is 1
        //when n is 2 then number of ways is 2
	 */
	private int numberOfStepsDp(int n) {
		int[] dp = new int[n+1];
		if(n == 1 || n == 2) return n;
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3;i<=n;i++){
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
}
