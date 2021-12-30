package vmware;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class ValidParenthesis {

	@Test
	public void test1() {
		String s = "()";
		Assert.assertTrue(validParanthesis(s));
	}

	@Test
	public void test2() {
		String s = "([)]";
		Assert.assertFalse(validParanthesis(s));
	}
	@Test
	public void test3() {
		String s = "([])";
		Assert.assertTrue(validParanthesis(s));
	}
	@Test
	public void test4() {
		String s = "{}()()";
		Assert.assertTrue(validParanthesis(s));
	}

	@Test
	public void test5() {
		String s = "[)";
		Assert.assertFalse(validParanthesis(s));
	}

	/*using stack since I have to remove valid paranthesis and check the stack is empty
	 * decalre a stack of character
	 * iterate the string 
	 * if the current char is one among ) } ] this and stack is not empty
	 * yes-> then peek the stack value == opposite of the current char, pair found pop the stack
	 * no->push the current char to stack
	 * if the current char is not amoung ) } ]
	 * yes-> push current char to stack
	 * out of the loop
	 * check if the stack is empty if yes return true if no return false
	 */
	private boolean validParanthesis(String s) {

		Stack<Character> stack = new Stack<Character>();
		for (Character character : s.toCharArray()) {
			if(!stack.isEmpty()) {
				if(character == ')') {
					if(stack.peek() == '(') {
						stack.pop();
						continue;
					}
				} 
				if(character == '}') {
					if(stack.peek() == '{') {
						stack.pop();
						continue;
					}
				} 
				if(character == ']') {
					if(stack.peek() == '[') {
						stack.pop();
						continue;
					}

				}
			} 
				stack.push(character);
		}
		if(stack.isEmpty()) return true;
		else return false;
	}
	
	 public boolean isValid(String s) {
	      Map<Character, Character> hm = new HashMap<Character,Character>();
	        hm.put(')','(');
	        hm.put('}','{');
	        hm.put(']','[');
	        Stack<Character> stack = new Stack<Character>();
	        //traverse through the string
	        for(int i =0;i<s.length();i++){
	            //check if the character at i is present in map key
	            //if yes then pop it and check the poped character is the value of that key
	            if(hm.containsKey(s.charAt(i)) && !stack.isEmpty()){
	                if(!(stack.pop() == hm.get(s.charAt(i)))) return false;
	            } 
	            else stack.push(s.charAt(i));
	        }
	        if(stack.size() == 0) return true;
	        else return false;
	    }

}
