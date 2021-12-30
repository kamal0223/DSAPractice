package vmware;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class StockSpanner {
	
	@Test
	public void test1() {
		int[] stockPrice = {100,80,60,70,60,75,85};
		Assert.assertTrue(Arrays.equals(new int[] {1,1,1,2,1,4,6}, stockSpanner(stockPrice)));
	}
	
	@Test
	public void test2() {
		int[] stockPrice = {70,80,90,100};
		Assert.assertTrue(Arrays.equals(new int[] {1,1,1,1}, stockSpanner(stockPrice)));
	}

	//get the current element and count the number of elements on the left of current (prev element) that are less than current
	//if no element is less then make it as 1
	/*
	 * using stack
	 * declare an result array of int
	 * make the first element in result as 1
	 * iterate the stock price from end
	 * if the stack is empty, peek the stack and check current element < st.peek
	 * yes-> push the index of price to stack
	 * if stack is not empty and current element >= st.peek. check this iteratively 
	 * yes-> st.peek - current element in the result[st.peek]
	 * 
	 */
	private int[] stockSpanner(int[] stockPrice) {
		Stack<Integer> st = new Stack<Integer>();
		int[] result = new int[stockPrice.length];
		result[0] = 1;
		st.push(0);
		for (int i = 1; i < stockPrice.length; i++) {
			//check if the previous day is less 
			while(!st.isEmpty() && stockPrice[st.peek()] <= stockPrice[i]) {
				st.pop();
			}
			if(st.isEmpty()) result[i] = i+1;
			else result[i] = i - st.peek(); 
			st.push(i);
		}
		System.out.println(Arrays.toString(result));
		return result;
	}

}
