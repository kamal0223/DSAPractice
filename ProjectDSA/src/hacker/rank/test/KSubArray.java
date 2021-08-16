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
