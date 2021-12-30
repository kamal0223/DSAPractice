package fullweek.onsite;

import java.util.List;

import org.junit.Test;

/*
Given an array of distinct integers candidates and a target integer target, 
return a list of all unique combinations of candidates where the chosen numbers sum to target. 
You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. 
Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 
combinations for the given input.

input - int array, target int
output - list of list
 */

public class CombinationOfAllElementsSum {

	@Test
	public void test1() {
		int[] input = {2,3,6,7};
		int target = 7;
	}

	@Test
	public void test2() {
		int[] input = {2,3,5};
		int target = 8;
	}

	@Test
	public void test3() {
		int[] input = {2};
		int target = 1;
	}
	@Test
	public void test4() {
		int[] input = {1};
		int target = 1;
	}

	@Test
	public void test5() {
		int[] input = {1};
		int target = 2;
	}

	/*
	 * 
	 */

	private List<List<Integer>> combinationOfAllElementsSum(input, target){

		return 
	}


}
