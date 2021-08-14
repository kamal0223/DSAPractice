package stack;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class MinimumRemovalToMakeValid {

	@Test
	public void test1() {
		String input = "lee(t(c)o)de)";
		Assert.assertTrue(usingStack(input).equals("lee(t(c)o)de"));
	}
	
	@Test
	public void test2() {
		String input = "a)b(c)d";
		Assert.assertTrue(usingStack(input).equals("ab(c)d"));
	}
	
	@Test
	public void test3() {
		String input = "))((";
		Assert.assertTrue(usingStack(input).equals(""));
	}

	private String usingStack(String input) {
		/*
		 * a)b((c)d
        using stack
            iterate the input string and get each character
            
            check if the character is ( or stack is empty and current char is ')'
                push the index of it to the stack
            else check if the character is )
            	then check if the associated bracket it ( then pop stack
                if associated bracket is not found than push the current index
        stack we got the index that has to be removed to make the string invalid
        Create a string builder with the input
        iterate the stack and delete the character in input using stack values
        return string builder to string
		 */
		
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '(' || (stack.isEmpty() && input.charAt(i) == ')')) {
				stack.push(i);
			}else if(input.charAt(i) == ')') {
				if(input.charAt(stack.peek()) == '(') stack.pop();
				else stack.push(i);
			}
		}
		
		StringBuilder sb = new StringBuilder(input);
		while(!stack.isEmpty()) {
			sb.deleteCharAt(stack.pop());
		}
		return sb.toString();
	}	
}
