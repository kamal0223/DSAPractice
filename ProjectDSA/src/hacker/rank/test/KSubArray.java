package hacker.rank.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class KSubArray {
	
	@Test
	public void test1() {
		int k = 5;
		int[] array = {5,10,11,9,5};
		//5,   5 10,   5 10 11,   5 10 11 9,   5 10 11 9 5,
		//10,   10 11,   10 11 9,   10 11 9,   10 11 9 5,
		//11,   11 9,   11 9 5, 
		//9,   9 5
		usingSlidingWindow(array,k);
	}

	private long usingBruteForce(int[] array, int k) {
	
		List<Integer> ali  = new ArrayList<Integer>();
		ali.add(5);
		ali.add(10);
		ali.add(11);
		ali.add(9);
		ali.add(5);
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
	private long usingSlidingWindow(int[] arr, int k) {
		
		// create auxiliary hash array to
        // count frequency of remainders
        int mod[] = new int[k];
        int  n = arr.length;
        Arrays.fill(mod, 0);
        // Traverse original array and compute cumulative
        // sum take remainder of this current cumulative
        // sum and increase count by 1 for this remainder
        // in mod[] array
        int cumSum = 0;
        for (int i = 0; i < n; i++) {
            cumSum += arr[i];
 
            // as the sum can be negative, taking modulo twice
            mod[((cumSum % k) + k) % k]++;
        }
 
        // Initialize result
        int result = 0;
 
        // Traverse mod[]
        for (int i = 0; i < k; i++) {
 
            // If there are more than one prefix subarrays
            // with a particular mod value.
            if (mod[i] > 1) result += (mod[i] * (mod[i] - 1)) / 2;
        }
        // add the elements which are divisible by k itself
        // i.e., the elements whose sum = 0
        result += mod[0];
        System.out.println(result);
 
        return result;
		
		
		
	}

}
