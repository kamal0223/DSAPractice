package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

/*find out how many missing brackets to make a valid parentheses
input can have only open and closing brackets

String st = "(((("  output 4
String st = "(()))" output 1*/

/*Input: String input
Output: int output
constraints: stack


TestData set: Positive
			  Negative
			  Edge
Approaches Known: stack
*/

public class FindingMissingBracketCount {
	
	
	@Test
	public void test1() {
		String input = "((((";
		Assert.assertEquals(4, usingStack(input));
	}
	
	@Test
	public void test2() {
		String input = "(())";
		Assert.assertEquals(0, usingStack(input));
	}
	
	@Test
	public void test3() {
		String input = "(())))";
		Assert.assertEquals(2, usingStack(input));
	}
	
	@Test
	public void test4() {
		String input = "(";
		Assert.assertEquals(1, usingStack(input));
	}

	
	/*
		   }    {
		   )    (
		   ]    [
	*/
	/*
	 * declare stack and map
	 * conver the input string to char array
	 * add all types of closing brackets as key and partners as value
	 * if char array size is one return one
	 * iterate the char array
	 *  check if the char is in map key	
	 *  	if yes then check the value of map is equal to the character then pop the char
	 *  		else push
	 *  	if no then push to stack
	 *  
	 * 
	 * return size of stack
	
	
	*/
	private Object usingStack(String input) {
	
		Stack<Character> st = new Stack<Character>();
		Map<Character,Character> hm = new HashMap<Character,Character>();
		hm.put(')', '(');
		hm.put('}', '{');
		hm.put(']', '[');
		for (int i = 0; i < input.length(); i++) {
			//if it is not a close bracket then push it
			if(hm.containsKey(input.charAt(i)) && !st.isEmpty() && st.peek() == hm.get(input.charAt(i))) st.pop();
			else st.push(input.charAt(i));
		}
		return st.size();
	}
}
