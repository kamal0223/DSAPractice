package flash.twopointer;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

//https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/

public class MinSwapsForBalanceBrackets {

	@Test
	public void test1() {
		String s = "][][";
		Assert.assertEquals(1, minSwapOptimized(s));
	}

	@Test
	public void test2() {
		String s = "]]][[[";
		Assert.assertEquals(2, minSwapOptimized(s));
	}

	@Test
	public void test3() {
		String s = "[]";
		Assert.assertEquals(0, minSwapOptimized(s));
	}

	private int minSwaps(String s) {
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0;i<s.length();i++){
			if(!stack.isEmpty() && s.charAt(i) == ']' && stack.peek() == '['){
				stack.pop();   
			}
			else stack.push(s.charAt(i));
		}
		int size = stack.size();
		return ((size/2)+1)/2;
	}

	public int minSwapOptimized(String s) {

		//the count of [ and ] bracets are are equal
		//at a given point of time the string is unbalanced when ] count becomes more than [
		//When an [ is encountered increment balance and on ] decrement balance
		//when the balance becomes -1 then swap it with the opening first [ bracket from the last and make balance 1
		//continue this process till all character in string
		int balance = 0;
		int swap = 0;
		char[] charArr = s.toCharArray();
		for(int i = 0;i<s.length();i++){
			if(charArr[i] == '[') balance++;
			else balance--;
			if(balance == -1){
				int lastIndex = s.lastIndexOf('[');
				char temp = charArr[lastIndex];
				charArr[lastIndex] = charArr[i];
				charArr[i] = temp;
				balance = 1;
				swap++;
			}          
		}
		return swap;
	}

}
