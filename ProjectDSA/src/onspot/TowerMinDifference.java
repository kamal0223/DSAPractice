package onspot;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

/*
Given heights of n towers and a value k. We have to either increase or decrease height of every tower by k (only once) where k > 0. The task is to minimise the difference between the heights of the longest and the shortest tower after modifications, and output this difference.
Examples:
Input : arr[] = {1, 15, 10}, k = 6
Output : Maximum difference is 5.
Explanation : We change 1 to 7, 15 to
9 and 10 to 4. Maximum difference is 5
(between 4 and 9). We can't get a lower
difference.
 */
public class TowerMinDifference {
	
	@Test
	public void test1() {
		int[] arr = {1,15,10};   //7,4|16,9   mindiff = 2
		int k = 6;
		Assert.assertEquals(5, findMinimunDifference(arr,k));
	}
	
	@Test
	public void test2() {
		int[] arr = {1, 5, 15, 10};   //4, 8|2, 13|7, 12  diff = 8   //4,8,7,12
		//{1, 2, 3};   //3, 4|0 1   
		int k = 3;
		Assert.assertEquals(8, findMinimunDifference(arr,k));
	}
	
	@Test
	public void test3() {
		int[] arr = {4, 6};   //14, 16      14 | -6, 16|-4
		int k = 10;
		Assert.assertEquals(2, findMinimunDifference(arr,k));
	}
	
	@Test
	public void test4() {
		int[] arr = {6, 10};  //9, 7    //9, 13|7
		int k = 3;
		Assert.assertEquals(2, findMinimunDifference(arr,k));
	}
	
	@Test
	public void test5() {
		int[] arr = {1, 10, 14, 14, 14, 15};
		int k = 6;
		Assert.assertEquals(5, findMinimunDifference(arr,k));
	}
	
	@Test
	public void test6() {
		int[] arr = {1, 2, 3};   //3, 0, 1   
		int k = 2;
		Assert.assertEquals(2, findMinimunDifference(arr,k));
	}

	/*
	 * sort the array
	 * Get the first element and add k to it and update it at arr
	 * Get the last element and subtract k to it and update it in arr
	 * set the first element as min 
	 * set the last elemetn as max
	 * iterate the array from 1 to length
	   declare a variable growTower
       delcare a varialbe destructTower
       add k to the i_value and assigne to growTower
       subtract k with i_value and assigne to destrct

       check grow is greater than max, assign des
    	   yes-> get diff between min and grow
	  	   get the diff between 

	 * 
	 * 
	 * 

	 */
	
	private int findMinimunDifference(int[] arr, int k) {
		// TODO Auto-generated method stub
		int max=0,min=Integer.MAX_VALUE,mindiff,newdiff = 0;
		Arrays.sort(arr);
		max = arr[arr.length-1];
		min = arr[0];
		mindiff = max-min;
		// Handle corner elements
        int small = arr[0] + k;
        int big = arr[arr.length-1] - k;
        int temp = 0;   
        if (small > big)
        {
            temp = small;
            small = big;
            big = temp;
        }
		for (int i = 1; i < arr.length-1; i++) {
			 int subtract = arr[i] - k;
	         int add = arr[i] + k;
	      // If both subtraction and addition
          // do not change diff
          if (subtract >= small || add <= big)
              continue;

          if (big - subtract <= add - small)
              small = subtract;
          else
              big = add;
      }

		System.out.println(Math.min(mindiff, big - small));
      return Math.min(mindiff, big - small);

		}

}
