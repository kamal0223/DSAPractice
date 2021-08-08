package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/*Two given character in a string
find the lenght of the longest valid parenthesis string*/

public class LongestValidParenthesis {
	
	@Test
	public void test1() {
		String input = "}{{}}{";
		Assert.assertEquals(4, optimisedStack(input));
	}
	
	@Test
	public void test2() {
		String input = "{}{}{";
		Assert.assertEquals(4, optimisedStack(input));
	}
	
	@Test
	public void test3() {
		String input = "";
		Assert.assertEquals(0, optimisedStack(input));
	}
	
	@Test
	public void test4() {
		String input = "{}}{}{}{}";
		Assert.assertEquals(6, optimisedStack(input));
	}
	
	@Test
	public void test5() {
		String input = "}";
		Assert.assertEquals(0, optimisedStack(input));
	}

	@Test
	public void test6() {
		String input = "{}{}{{}}";
		Assert.assertEquals(8, optimisedStack(input));
	}
	/*
	 * declare a stack of characters
	   declare a maxLen as 0
	   declare an ArrayList to hold the position of parenthesis
	   Iterate the string till the length
	   check if the eachCharacter is '}' and stack is not empty
	   		peek the stack and if it is '{' then pop it while poping delete the last element in arrayList
	   		else push it to stack while pushing  add the index of current char to arraylist
	   else character is not '}' then push to stack while pushing  add the index of current char to arraylist
	   
	   now the arraylist holds the invalidators positions. so element between this invalidators are valid parent
	   
	   iterate the arraylist
	   declare int currentIndex = 0
	   find the diff between i value - currentIndex -1 and find max with previous diff
	   find max of maxLen and difference
	   if the current element is last ele then 
	   	find differenc between the length of string - currentIndex +1
	   find max of maxLen and difference
	   	
	   	return maxLen
	   	
	   	time - O(2n) = O(n) and space - O(n+m)
	 */
	
	private int longestValidParenthesis(String input) {
		
		if(input.length() == 0 || input.length() == 1)  return 0; 
		
		Stack<Character> stack = new Stack<Character>();
		int maxLen = 0;
		List<Integer> invalidatorsIdex = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '}' && !stack.isEmpty()) {
				if(stack.peek() == '{') {
					stack.pop();
					invalidatorsIdex.remove(invalidatorsIdex.size()-1);
				} else {
					stack.push(input.charAt(i));
					invalidatorsIdex.add(i);
				}
			}else {
				stack.push(input.charAt(i));
				invalidatorsIdex.add(i);
			}
		}
		//if the invalidatorIndex is empty then whole input string is valid
		if(invalidatorsIdex.size() == 0) return input.length();
		
		//for first element in arraylist
		int currentValid = invalidatorsIdex.get(0)-0;
		maxLen = Math.max(currentValid, maxLen);
		for (int i = 1; i < invalidatorsIdex.size(); i++) {
			currentValid = invalidatorsIdex.get(i)-invalidatorsIdex.get(i-1)-1;
			maxLen = Math.max(currentValid, maxLen);
		}
		//after the last element
		currentValid = input.length()-invalidatorsIdex.get(invalidatorsIdex.size()-1)-1;
		maxLen = Math.max(currentValid, maxLen);
		return maxLen;
	}
	
	private int optimisedStack(String input) {
		Stack<Integer> stack = new Stack<Integer>();
		//add -1 to the stack
		stack.push(-1);
		int max = 0;
		for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '{') stack.push(i);
			else {
				stack.pop();
				if(stack.isEmpty()) stack.push(i);
				//if stack is not empty then  calculate the lenght of string
				else {
					int len = i-stack.peek();
					max = Math.max(max, len);
				}
			}
		}
		
		return max;
		
	}

}
