package onspot;

import java.util.ArrayList;

import org.junit.Test;

/*Swiggy SDE online round

froggie wants to leap across an integer sequence with some rules:
1. can start his journey from any element of the sequence
2. he can only jump in the forward direction
3. He can only jump to an integer that is strictly smaller than the int he is currently at

Froggie wants to know what is the maximum amount of jumps that he can make.

input: array of integers
output: integer - max number of leaps that frog can make with conditions
 */

public class FrogLeapBinarySearch {
	@Test
	public void example1() {
		int[] nums = {6,13,10,8,11,7,3,5,2};
		System.out.println(maxFrogJumps(nums));
	}
	
	@Test
	public void example2() {
		int[] nums = {6,4,5,4,3,2,1};
		System.out.println(maxFrogJumps(nums));
	}
	
	@Test
	public void example3() {
		int[] nums = {5,7,11,9,10,7,6,3,5,2,1};
		System.out.println(maxFrogJumps(nums));
	}
	
	@Test
	public void example4() {
		int[] nums = {5,7,16,9,10,15,14,13,12,7,6,3,5,2,1};
		System.out.println(maxFrogJumps(nums));
	}
	
	public static int maxFrogJumps(int[] nums){
		ArrayList<Integer> sub = new ArrayList<>();
		sub.add(nums[0]);

		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			if (num < sub.get(sub.size() - 1)) {
				sub.add(num);
			} else {
				// Find the first element in sub that is greater than or equal to num
				int j = binarySearch(sub, num);
				if(j == sub.size()-1)
					sub.set(j, num);
			}
		}

		return sub.size()-1;
	}

	private static int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        int mid = (left + right) / 2;
        
        while (left < right) {
            mid = (left + right) / 2;
            if (sub.get(mid) == num) {
                return mid;
            }
            
            if (sub.get(mid) > num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
