package onspot;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/*
 * confirm given string is a valid parenthesis. 
 */
public class ValidParenthesis {
	@Test
	public void test1() {
		String input = "{}()";
		Assert.assertTrue(validParenthesis(input));
	}
	
	@Test
	public void test2() {
		String input = "{([])}";	
		Assert.assertTrue(validParenthesis(input));
	}
	

	@Test
	public void test3() {
		String input = "{([]}";
		Assert.assertFalse(validParenthesis(input));
	}
	
	/*
	 * declare a stack of characters
	 * declare a hash map and hold the closing brackets in key and opening brackets in value
	 * iterate the input
	 * if the stack is not empty and if each character is present in map key
	 *    peek the stack and check if peeked value is equal to mapValue of each 
	 *    yes-> pop the stack
	 * else push to stack
	 * 
	 * if the stack is empty return true
	 * stack is not empty return false
	 */
	
	private boolean validParenthesis(String input) {
		Stack<Character> stack = new Stack<Character>();
		Map<Character,Character> hm = new HashMap<Character,Character>();
		hm.put(')', '(');
		hm.put('}', '{');
		hm.put(']', '[');
		for (int i = 0; i < input.length(); i++) {
			if(!stack.isEmpty() && hm.containsKey(input.charAt(i))) {
				if(stack.peek() == hm.get(input.charAt(i))) {
					stack.pop();
				}
			}else stack.push(input.charAt(i));
		}
		
		if(stack.isEmpty()) return true;
		else return false;
	}
	
	/*
	 * 
	 */
	
	private boolean validParenthesisUsingStringBuilder(String input) {
		
	}
}
