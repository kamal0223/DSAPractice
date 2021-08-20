package onspot;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

//https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
	
	@Test
	public void test1() {
		int[] height = {4,2,0,3,2,5};
		Assert.assertEquals(9, trapRainUsingStack(height));
	}
	
	@Test
	public void test2() {
		int[] height = {6,4,2,0,7,2,4};
		Assert.assertEquals(17, trapRainUsingStack(height));
	}

	@Test
	public void test3() {
		int[] height = {0,5};
		Assert.assertEquals(0, trapRainUsingStack(height));
	}
	
	@Test
	public void test4() {
		int[] height = {1,2,3,0,0};
		Assert.assertEquals(0, trapRainUsingStack(height));
	}

	/*
	 *declare 2 pointers left and right at 0
	  declare a int of sum
	  iterate till left!=length of array-1
	  tempMin = leftvalue
	  1.loop till tempMin>=rightValue && right!=length-1
	  move right++, 
	  tempMin = find minium of tempMin,right

	  2.check if right+1>right && right!=length-2 move right++,
	  3.get the minValue by finding min of leftValue and rightvalue
	  4. left++,
	  5.iterate till left<right
	  int temp = minValue - leftValue
	  if(temp>0)add it to the sum, move left++

	  6.return sum when loop is done
	 */
	private int trapRainTwoPointer(int[] height) {
		int left = 0, right = 0;
		int sum = 0;
		while(left != height.length-1) {
			int tempMin = height[left];
			while(tempMin>=height[right] && right!=height.length-1) {
				right++;
				tempMin = Math.min(tempMin, height[right]);
			}
			if(right!=height.length-1) {
				if(height[right+1]>height[right]) right++;
			}
			
			int minValue = Math.min(height[left], height[right]);
			left++;
			while(left<right) {
				int temp = minValue-height[left++];
				if (temp>0) sum += temp;
			}
		}
		return sum;
	}
	
	/*
	 * peak is peak when it is greater than i-1 
	 * AND 
	 * it is greater than i+1
	 * i is greater than previousPeak
	 * OR
	 * it is greater than nextMax
	 */
	
	private int trapRainUsingStack(int[] height) {
		int sum = 0;
		Stack<Integer> stack = new Stack<Integer>();
		//iterate the height
		int prevMax = 0;
		if (height[0]>height[1]) {
			stack.push(height[0]);
			prevMax = height[0];
		}
		for (int i = 1; i < height.length-1; i++) {
			if(height[i]>height[i+1] && height[i]>height[i-1]) {
				int nextMax = 0;
				//get the nextMax by iterating till a greaterValue or lenght of height
				for (int j = i+1; j < height.length; j++) {
					if(height[j]>height[i]) {
						nextMax = height[j];
						break;
					}
					}
				if(height[i]>prevMax || height[i]>nextMax){ //if no next max for 
					stack.push(height[i]);
					prevMax = height[i];
				}
				
			}
		}
		//for last height
		if (height[height.length-1]>height[height.length-2]) {
			stack.push(height.length-1);
			prevMax = height.length-1;
		}
		
		//iterate the stack
		while(!stack.isEmpty()) {
			//pop the stack 
			Integer lastEle = stack.pop();
			int minVal = Math.min(lastEle, stack.peek());
			for(int i = stack.peek()+1;i<lastEle;i++) {
				sum += minVal-height[i];
			}
		}
		return sum;
		
	}
}
