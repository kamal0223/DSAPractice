package slidingwindow;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/*Given an array of integers and an integer k, find out whether there are two
distinct indices i and j in the array such that nums[i] = nums[j]
and the absolute difference between i and j is at most k.
*/

public class findIfPresentInRange {
	
	    @Test
	    public void test1() {
	        int[] input = {1,2,3,1};
	        int k = 3;
	        Assert.assertTrue(findIfPresent(input,k));
	    }

	    @Test
	    public void test2() {
	        int[] input = {1,0,1,1};
	        int k = 1;
	        Assert.assertTrue(findIfPresent(input,k));
	    }

	    @Test
	    public void test3() {
	        int[] input = {1,2,3,1,2,3};
	        int k = 2;
	        Assert.assertFalse(findIfPresent(input,k));
	    }

	    @Test
	    public void test4() {
	        int[] input = {1,2,3,2};
	        int k = 2;
	        Assert.assertTrue(findIfPresent(input,k));
	    }

	    @Test
	    public void test5() {
	        int[] input = {1,2,1,2};
	        int k = 1;
	        Assert.assertFalse(findIfPresent(input,k));
	    }
	    
	    /*
	     * traverse through the loop till the target length
	     * For each element find if duplicate is present in the subarray
	     * add each element to set and while adding if it returns false if element is already in set
	     * if duplicate of a element is found then return true as it is in the target range
	     * For sliding through next subarray, traverse from index 1 to the input length-target
	     * Remove the one element from set before to the window 
	     * Add one element next to the window to the set
	     * if the added element is duplicate then return true
	     * if no element has duplicates in the target range return false
	     * 
	     * 
	    * Time Complexity -> O(n+m)
	    * Space complexity -> O(n)
	    
		*/	    
	    private boolean findIfPresent(int[] input, int k) {
	        Set<Integer> set = new HashSet<>();

	        for(int i=0; i<=k; i++) {
	            if(!set.add(input[i])) return true;//to check duplicates within first window size
	        }

	        for(int i=1; i<input.length-k; i++) {
	            set.remove(input[i-1]); // Deleting previous window element at the index(i-1)
	            if(!set.add(input[i+k])) return true;
	            set.removeIf(null)
	        }
	        return false;
	    }

}
