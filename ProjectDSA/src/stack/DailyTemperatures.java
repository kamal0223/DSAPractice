package stack;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/daily-temperatures/
/*
 * Given an array of integers temperatures represents the daily temperatures, 
 * return an array answer such that answer[i] is the number of days you have to 
 * wait after the ith day to get a warmer temperature. 
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */

/* Problem Solving Techniques :
 * 1. Do you understand the question? - Yes

 *  ->what is the input(s)? --> int[] input
 * 	->what is the expected output? --> int answer
 *  ->Do i have constraints to solve the problem? --> no
 
 *  2. Test Data Set
 *  -> Minimum of 3 data set !! "Positive" , "Edge" and "Negative" 
 *  
 *  3. Do i know how to solve it?  
 *  Yes - Great, is there an alternate? -> Yes
  
 *  4. If you know alternate solutions-> find out the O notations (performance)
 *  Then explain the both or the best (depends on the time)
 *    
 *  5. Start with the Pseudo code

 *  6. Implement them in the code (editor)
 
 */
public class DailyTemperatures {
	
	@Test
	public void test1() {
		int[] input = {73,74,75,71,69,72,76,73};
		Assert.assertTrue(Arrays.equals(new int[] {1,1,4,2,1,1,0,0}, usingStack(input)));
	}
	
	@Test
	public void test2() {
		int[] input = {30,30,30,30};
		Assert.assertTrue(Arrays.equals(new int[] {0,0,0,0}, usingStack(input)));
	}
	
	@Test
	public void test3() {
		int[] input = {40,38,40,38,38};
		Assert.assertTrue(Arrays.equals(new int[] {0,1,0,0,0}, usingStack(input)));
	}
	
	@Test
	public void test4() {
		int[] input = {60};
		Assert.assertTrue(Arrays.equals(new int[] {0}, usingStack(input)));
	}

	private int[] bruteForce(int[] temperatures) {
		//declare an output array answer
        //loop and get the first value
        //loop through the next values
        //check if current value < next value, then get distance j-i and break inner loop
        //update the distance in output array at i
        //set the last index at answer as 0
        //time complexity - O(n^2) and space - O(n)
        
        int[] answer = new int[temperatures.length];
        for(int i = 0;i<temperatures.length-1;i++){
            for(int j = i+1 ;j<temperatures.length;j++){
                if(temperatures[i]<temperatures[j]){
                    answer[i] = j-i;
                    break;
                }
            }
            
        }
        answer[temperatures.length-1] = 0;
        return answer;
	}
	
	private int[] twoPointers(int[] temperatures) {
		//declare an output array answer of input size
		//create two pointers left and right at zero and one
		//traverse till the left pointer reaches end -1
		//if the temperature at left > = right then increment right pointer
		//else business logic found, add the distance right-left to array answer of left and move left++ and right = left+1
		//return answer
		/*
		int loopCounter = 0;
		int[] answer = new int[temperatures.length];
		int left = 0, right=1;
		while(left<temperatures.length-1) {
			if(temperatures[left]>=temperatures[right]) right++;
			else if(temperatures[left]<temperatures[right]){
				answer[left] = right-left;
                left++;
                right = left+1;
			}
			if(right == temperatures.length) {
				left++;
                right = left+1;
			}
			loopCounter++;
		}
		
		System.out.println("number of loops "+loopCounter);
		return answer;
		*/
		
		 int[] output = new int[temperatures.length];
	        for(int i = 0;i<temperatures.length-1;i++){
	            int j = i+1;
	            while(j<=temperatures.length-1 && temperatures[j]<=temperatures[i]){
	                j++;
	            }
	            if(j>temperatures.length-1) output[i] = 0;
	            else output[i] = j-i;
	        }
	        return output;
		
	}
	
	/*
declare a stack of integers
declare an output array of int
iterate the array from left to right
if the array is empty
   push the element index 
if array not empty
   check curr element > indexStack peek value at input
     Yes-> while loop till curr ele > peek_value
 	   pop the stack, curr element is larger than value at stackindex
	   find the difference between current index-popped Indexand 
	   add to output array at index of pop value
	   check if stack is empty, if yes then break loop
     No-> do nothing
   push the index to stack
   
return output array
	 */
	
	private int[] usingStack(int[] temperatures) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] output = new int[temperatures.length];
		for(int i = 0;i<temperatures.length;i++){
			while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
				int poppedValue = stack.pop();
				output[poppedValue] = i - poppedValue;
				if(stack.isEmpty()) break;
			}

			stack.push(i);
		}
		return output;
		
	}

}
