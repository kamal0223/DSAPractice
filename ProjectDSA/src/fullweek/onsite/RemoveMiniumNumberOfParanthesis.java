package fullweek.onsite;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

/*
Remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.

input - string
output -  string
 */
public class RemoveMiniumNumberOfParanthesis {

	@Test
	public void test1() {
		String input = "abc(a(c)e)de)";
		Assert.assertEquals("abc(a(c)e)de", removeMiniumParanthesis(input));
	}
	
	@Test
	public void test2() {
		String input = "((a)b(c)d";
		Assert.assertEquals("(a)b(c)d", removeMiniumParanthesis(input));
	}
	
	@Test
	public void test3() {
		String input = "))((";
		Assert.assertEquals("", removeMiniumParanthesis(input));
	}
	
	@Test
	public void test4() {
		String input = "(a(b(c)d)";
		Assert.assertEquals("a(b(c)d)", removeMiniumParanthesis(input));
	}

	
	/*
	 * declare a string builder sb and pass the string
	 * declare a stack of characters
	 * traverse the string from left to right
	 * check if the stack is not empty and the current value is ')' and the current value is not letter
	 * 		yes-> check if stack peek value is '('
	 * 			  yes-> pop the stack
	 * 			  no-> push the indexes to stack
	 *      no-> if(current value not a letter) push the indexs to stack
	 * 
	 * iterate the stack till becomes empty
	 * pop the stack and delete that index in sb
	 * 	
	 * return sb as string
	 */
	private String removeMiniumParanthesis(String input) {
		
		StringBuilder sb = new StringBuilder(input);
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < input.length(); i++) {
			Character current = input.charAt(i);
			if(!stack.isEmpty() && !Character.isLetter(current) && current == ')') {
				if(input.charAt(stack.peek()) == '(') stack.pop();
				else stack.push(i);
			}else if(!Character.isLetter(current)) stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			sb.deleteCharAt(stack.pop());
		}
		return sb.toString();
	}
}
