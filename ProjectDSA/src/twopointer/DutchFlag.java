package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/*
 Given an array nums with n objects colored red, white, or blue, 
sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.


Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]

Example 3:

Input: nums = [0]
Output: [0]


 */

/* Problem Solving Techniques :
 * 1. Do you understand the question? - Yes
 * 		Yes - Go to next step
 * 		No - Ask the person to provide more detail with example(s).
 * 
 *  ->what is the input(s)? --> int input[]
 * 	->what is the expected output? --> int output[]
 *  ->Do i have constraints to solve the problem? --> using 2 pointer
 *  ->Do i have all informations to go to next step? -> If all the above mentioned steps (i.e., for Yes) we can proceed
 *  ->How big is your test data will be?
 *  
 *  2. Test Data Set
 *  -> Minimum of 3 data set !! "Positive" , "Edge" and "Negative" 
 *  -> Validate with the interviewer if the data set is fine -> its depends on the interviewer
 *  
 *  3. Do i know how to solve it?
 *  
 *  Yes - Great, is there an alternate? -> Yes
 *  No - Can i break down the problem into sub problems? 
 *  then -> 
 * 
 * 4. Ask for hint (if you do not know how to solve it?) 
 *  		-> Ask one time and thank the interviewer
 *  		-> Worst Case! even after got the hint, we don't know how to solve, then convince them and prove with your confidence 
 *  		   level to get the next question 
 *  
 * 5. Do I know alternate solutions as well? - yes
 * 	
 * 	Yes - What are those?
 *     way of Approach to solve with the following
 *    -> Brute Force (Simple Technique) -->  
 *    -> inbuilt approach --> List
 *  No - Can i break down the problems into sub problems?
 * 
 * 6. If you know alternate solutions-> find out the O notations (performance)
 *  Then explain the both or the best (depends on the time)
 *  
 *  Approach 1-> Start with the worst -> Improve to optimize -> End up with the beset
 *  Approach 2-> Write down the options and benefits and code the best
 *  
 * 7. Start with the Pseudo code
 * 
 * 8. Implement them in the code (editor)
 * 
 * 9. Test against the different data set
 * 
 * 10. If it fails, debug them to solve it
 */


public class DutchFlag {

	//positive
	@Test
	public void test1() {
		int[] input = {2,0,2,1,1,0};
		int[] output = {0,0,1,1,2,2};
		System.out.println(Arrays.toString(usingTwoPointer(input)));

		//System.out.println("intersetion input1 "+Arrays.toString(usingSet(input1, input2)));
		//Assert.assertEquals(Arrays.toString(intersection), Arrays.toString(bruteForce(input1, input2)));
	}
	
	/*
	 * create 3 pointers low, mid, hight
	 * Place pointer low and mid at position 0 and high last index of array
	 * Loop till the when mid<=high
	 * if the value of at low pointer
	 * 		is 0 then call swap function with low and mid values, low++ and mid++
	 * 		is 1 then no swap and just mid++
	 * 		is 2 then call swap function with mid and high, high--
	 * return input
	
	*/
	private int[] usingTwoPointer(int[] input) {
		
		
		int low = 0, mid = 0, high = input.length-1;
		while(mid<=high) {
			if(input[mid] == 0) {
				int temp = 0;
				temp = input[low];
				input[low] = input[mid];
				input[mid] = temp;
				low++;
				mid++;
			}else if(input[mid] == 1) mid++;
			else {
				//swap(input[mid], input[high]);
				int temp = 0;
				temp = input[mid];
				input[mid] = input[high];
				input[high] = temp;
				high--;
				
			}
			
		}
		
		return input;
	}
	
	 public void sortColors(int[] nums) {
	        //using dutch flag
	        //declare 3 pointers left at 0 mid at 0 and high at end
	        String s = "";
	        String[] strs = {"ad","dae"};
	        Map<Character,Integer> baseMap = new HashMap<Character,Integer>();
	        Map<Character,Integer> eachMap = new HashMap<Character,Integer>();
	        Collection<Integer> values = baseMap.values();
	        List<Integer> li = new ArrayList<Integer>(values);
	        baseMap.equals(eachMap);
            for(Character c:strs[0].toCharArray()){
                baseMap.put(c, baseMap.getOrDefault(c,0)+1);
            }
            List<String> innerList = new ArrayList<String>();
            innerList.add("");
            Set<Integer> set = new HashSet<Integer>();
            set.add(1);
	        int low = 0, mid = 0, high = nums.length-1;
	        while(mid<=high){
	            //if mid is 0
	            if(nums[mid] == 0) {
	                //swap low and mid and increment low and mid
	                int temp = nums[mid];
	                nums[mid++] = nums[low];
	                nums[low++] = temp;
	            }else if(nums[mid] == 1){
	                //just increment mid
	                mid++;
	            }else {
	                //swap mid and high and decrement high
	                int temp = nums[mid];
	                nums[mid] = nums[high];
	                nums[high--] = temp;
	            }
	        }
	    }

}
