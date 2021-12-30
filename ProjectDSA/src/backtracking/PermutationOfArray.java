package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/permutations/
public class PermutationOfArray {

	@Test
	public void test1() {
		int[] nums = {1,2,3};
		System.out.println(permuationOfArray(nums));
	}

	private List<List<Integer>> permuationOfArray(int[] nums) {
		//create a decision tree elements as list
		//create a res list of list of integers
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> decTree = new ArrayList<>();
		for(int num : nums) {
			decTree.add(num);
		}
		dfs(new ArrayList<Integer>(), decTree);
		return res;
	}
	
	public void dfs(List<Integer> permutation, List<Integer> dt) {
		//
	}
}
