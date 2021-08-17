package hacker.rank.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class KSubArray {

	@Test
	public void test1() {
		int k = 5;
		Arrays.asList(new int[] {5,10,11,9,5});
		List<Integer> ali  = new ArrayList<Integer>();
		ali.add(5);
		ali.add(10);
		ali.add(11);
		ali.add(9);
		ali.add(5);
		//5,   5 10,   5 10 11,   5 10 11 9,   5 10 11 9 5,
		//10,   10 11,   10 11 9,  10 11 9 5,
		//11,   11 9,   11 9 5, 
		//9,   9 5
		//5
		Assert.assertEquals(10, kSub(ali, k));
	}

	private long usingBruteForce(List<Integer> ali, int k) {

		//iterate the list
		long count = 0;
		for(int i = 0;i<ali.size();i++) {
			int sum = 0;
			for(int j = i;j<ali.size();j++) {
				sum = sum+ali.get(j);
				if(sum%k == 0) count++;
			}
		}
		System.out.println(count);
		return count;
	}
	public long kSub(List<Integer> nums, int k) {

		/*
		 * declare sum = 0
		 * declare long output to 0
		 * declare a hashmap<integer, integer> to hold the remainder and its occurence
		 * traverse the input list from 1 to last element
		 * 	find the remainder using sum, initially it is 0. so adding to remainder 0 count
		 * 	check if the remainder as key is present in map, if yes increment by 1
		 * 	else if the remainder is not present then make a new entry count as 1
		 * 	update sum by adding with the previous element starting from 0
		 * 	update the remainder using this above sum
		 * 	if the map contains the remainder then add 1 to output
		
		*/
		// Cumulative Sum of each number in the list
		int sum = 0;

		// Return output 
		long output = 0;

		// Find the frequency of remainder occurrence
		Map<Integer, Integer> freqMap = new HashMap<>();

		// Traverse 
		for(int i=1;i<=nums.size();++i) {

			// Calculate remainder and add K to it if it is negative
			int rem = sum%k < 0? sum%k + k : sum%k;

			//  If the remainder exist, update else add
			freqMap.put(rem, freqMap.getOrDefault(rem, 0)+1);

			// add the previous number to cumulative sum
			sum +=nums.get(i-1);

			// Calculate remainder and add K to it if it is negative
			rem = sum%k < 0? sum%k + k : sum%k;

			// If found, add to the output
			if(freqMap.containsKey(rem)) {
				output+=freqMap.get(rem);
			}
		}
		System.out.println(output);
		return output;

	}

}
