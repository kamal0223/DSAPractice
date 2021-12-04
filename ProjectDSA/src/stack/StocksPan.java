package stack;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class StocksPan {
	
	@Test
	public void test1() {
		int[] input = {10,15,20,23};
		Assert.assertArrayEquals(new int[] {1,2,3,4}, stocksPan(input));
		//0 , 1, 
	}
	
	@Test
	public void test2() {
		int[] input = {15,15,14,18};
		Assert.assertArrayEquals(new int[] {1,2,1,4}, stocksPan(input));
		//
	}

	@Test
	public void test3() {
		int[] input = {40,30,25,20};
		Assert.assertArrayEquals(new int[] {1,1,1,1}, stocksPan(input));
		//0,1,
	}
	
	@Test
	public void test4() {
		int[] input =  {100, 80, 60, 70, 60, 75, 85};
		Assert.assertArrayEquals(new int[] {1, 1, 1, 2, 1, 4, 6} , stocksPan(input));
		//0,1,
	}
	
	/*
	 * declare two stacks 
	 * declare a span array
	 * one for index and other for span count
	 * maintain the stack as strictly decreasing to get the greater price
	 * add arr[0] to span output
	 * push arr[0] to indexStack
	 * iterate the input array
	 * check if the stack is not empty and stack.peek is less than to current ele
	 * yes=> pop the stack
	 * no=> do nothing
	 * if stack is not empty
	 * yes=>span array[i]  = current index - peekIndex
	 * no=> span array[i] = current index+1 
	 * push the element index to stack
	 */
	private int[] stocksPan(int[] input) {
		
		Stack<Integer> stIndex = new Stack<Integer>();
		int[] output = new int[input.length];
		output[0] = 1;
		stIndex.push(0);
		for(int i = 1;i<input.length;i++) {
			while(!stIndex.isEmpty() && input[stIndex.peek()] <= input[i]) {
				stIndex.pop();
			}
			if(stIndex.isEmpty()) output[i] = i+1;
			else output[i] = i-stIndex.peek();
			stIndex.push(i);
		}
		return output;
	}

}
