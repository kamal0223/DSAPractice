package week5;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/*Given a list of salaries of different employees. Find out
what is the average salary in that company.
skip the max and min salary while calculating avg

example: {2000,10000,9000,3000,8000}
output: 20000/3 = 6666.66*/

public class AvgSalary {
	
	@Test
	public void test1() {
		int[]  sal = {4000,3000,1000,2000};
		Assert.assertEquals(2500.00000, usingBruteForce(sal),0);
	}
 
	@Test (expected = RuntimeException.class)
	public void test2() {
		int[]  sal = {4000,3000};
		usingBruteForce(sal);
	}
	
	@Test
	public void test3() {
		int[]  sal = {8000,9000,2000,3000,6000,1000};
		Assert.assertEquals(4750.00000, usingBruteForce(sal),0);
	}
	
	@Test
	public void test4() {
		int[]  sal = {4000,3000,1000,2000};
		Assert.assertEquals(2500.00000, usingBruteForce(sal),0);
	}
	
	//declare a sum of double
    //iterate the array and compare current with next element 
    //get the min and max from the array
    //iterate the array again
    //filter the min and max and sum rest of the elements
    //divide sum/array size-2 and return

	private double usingBruteForce(int[] sal) {
		if(sal.length == 2) throw new RuntimeException("Number of sals to be more than 2");
		double sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		//iterate the array and find max and min
		for (int i = 0; i < sal.length; i++) {
			max = Math.max(max, sal[i]);
			min = Math.min(min, sal[i]);
		}
		//iterate the array and filter max and min and find sum of rest
		for (int i = 0; i < sal.length; i++) {
			if(sal[i] != max && sal[i] != min) {
				sum += sal[i];
			}
		}
		//divide sum/array size-2
		return sum/(sal.length-2);
	}
	
	private double usingOptimised(int[] salary) {
		
		int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int x : salary) {
            sum += x;
            if (x < min) min = x;
            if (x > max) max = x;
        }
        System.out.println((double) (sum - min - max) /  (salary.length - 2));
        return (double) (sum - min - max) /  (salary.length - 2);
	}
}
