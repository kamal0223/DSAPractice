package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class ValidParanthesis {

	@Test  //positive
	public void test1() {
		String input = "()[]{}";
		Assert.assertTrue(usingThreeVariables(input));
	}
	
	@Test //negative
	public void test2() {
		String input = "([)]";
		Assert.assertFalse(usingThreeVariables(input));
	}
	
	@Test //positive
	public void test3() {
		String input = "{[]}";
		Assert.assertTrue(usingThreeVariables(input));
	}
	
	@Test //edge
	public void test4() {
		String input = "[";
		Assert.assertFalse(usingThreeVariables(input));
	}
	@Test //edge
	public void test5() {
		String input = "}";
		Assert.assertFalse(usingThreeVariables(input));
	}

	@Test //edge
	public void test6() {
		String input = "(]";
		Assert.assertFalse(usingThreeVariables(input));
	}
	private boolean isValidParenthesis(String s) {
		//to check if all the opening brackets are closed
        //check if the stack is empty then add the bracket
        //add the brackets speficed in map such that closing bracket is key
        //and its partner as value
        //check if the incoming symbols is present in map key
        //  if yes then pop the value of it
        
        Map<Character, Character> hm = new HashMap<Character,Character>();
        hm.put(')','(');
        hm.put('}','{');
        hm.put(']','[');
        
        Stack<Character> stack = new Stack<Character>();
        
        //traverse through the string   ([)]
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
	
	private boolean usingThreeVariables(String s) {
		//to check if all the opening brackets are closed
        //check if the stack is empty then add the bracket
        //add the brackets speficed in map such that closing bracket is key
        //and its partner as value
        //check if the incoming symbols is present in map key
        //  if yes then pop the value of it
		int a = 5;
		System.out.println(Math.sqrt(a));
        Stack<Character> stack = new Stack<Character>();
        //traverse through the string   ([)]
        for(int i =0;i<s.length();i++){
        	if(s.charAt(i) == ')' && !stack.isEmpty()) {
        		 if(!(stack.pop() == '(')) return false;
        	}else stack.push(s.charAt(i));
        	if(s.charAt(i) == ']' && !stack.isEmpty()) {
       		 if(!(stack.pop() == '[')) return false;
        	} else stack.push(s.charAt(i));
        	if(s.charAt(i) == '}' && !stack.isEmpty()) {
       		 if(!(stack.pop() == '{')) return false;
        	} else stack.push(s.charAt(i));
        	
        	
           
        }
        if(stack.size() == 0) return true;
        else return false;
	}
}
