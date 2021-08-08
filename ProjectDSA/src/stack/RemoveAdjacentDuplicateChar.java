package stack;

import java.util.Iterator;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

/*Remove the adjacent duplicates in a string
abbaaba = aba
abccba  = empty string*/

/*Input: String input
Output: String output
constraints: stack


TestData set: Positive
			  Negative
			  Edge
Approaches Known: stack
*/

public class RemoveAdjacentDuplicateChar {
	
	@Test
	public void test1() {
		String input = "abbaaba";
		Assert.assertTrue(usingStack(input).equals("aba"));
	}
	
	@Test
	public void test2() {
		String input = "abccba";
		Assert.assertTrue(usingStack(input).equals(""));
	}
	
	@Test
	public void test3() {
		String input = "abbabba";
		Assert.assertTrue(usingStack(input).equals("a"));
	}
	
	/*
	 * create a stack of character
	 * convert string to char array
	 * iterate the char array
	 * peek if the char is in stack
	 * 	if yes pop the char from stack
	 * 	if no push the character to stack
	 * 
	 * retrun stack
	
	
	*/
	private String usingStack(String input) {
		
		Stack<Character> st = new Stack<Character>();
		
		char[] charArray = input.toCharArray();
		
		for (int i = 0; i < charArray.length; i++) {
			if(st.isEmpty()) st.push(charArray[i]);
			else if(st.peek() == charArray[i]) {
				st.pop();
			} else st.push(charArray[i]);
				
		}	
		
		System.out.println(st.toString());
		
		StringBuilder sb = new StringBuilder();
		for(Character each:st) {
			sb.append(each);
		}
		
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	//private String usingStack(String input) {

}
