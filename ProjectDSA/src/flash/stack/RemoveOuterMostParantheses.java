package flash.stack;

import java.util.Iterator;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class RemoveOuterMostParantheses {

	@Test
	public void test1() {
		String s = "(()())(())";
		Assert.assertEquals("()()()", removeOuter(s));
	}

	@Test
	public void test2() {
		String s = "(()())(())(()(()))";
		Assert.assertEquals("()()()()(())", removeOuter(s));
	}

	@Test
	public void test3() {
		String s = "()()";
		Assert.assertEquals("", removeOuter(s));
	}
	
	//two pointer left at
	//go to the last closing braces i.e endIndex
	//from that position iterate backwards till the count pair opening is found i.e startIndex
	//remove the startIndex and endIndex from s
	//from endIndex-1 be the end Index
	//again iterate 
	
	/*
	 * if the stack size is 1 and incoming is a closing bracket then pop the stack
	 * if the stack is 0 and incoming is open bracket then push it to stack
	 * if the stack size is not 1 and incoming is closing bracket then append 
	 */
	private String removeOuter(String s) {
		Stack<Character> st = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if(st.size() == 1 && s.charAt(i) == ')') {
				st.pop();
			}else if(st.size() == 0 && s.charAt(i) == '(') {   //st size can be 0 or more than 1
				st.push('(');
			}else if(s.charAt(i) == '(') {
				sb.append('(');
				st.push('(');
			}else {
				sb.append(')');
				st.pop();
			}
		}
		return sb.toString();
		
	}
	
	 public String removeOuterParentheses(String s) {
	        /*
	        declare a stringbuilder
	        declare a openBraces, closeBraces
	        iterate the string from 0 to end
	        if each char is (, increment openBraces
	        else each char is ), increment closeBraces
	        check if the open braces equal to close braces
	        then make the openbraces, closeBraces to 0
	        else if openbraces is 1 then ignore
	        else if open braces greater than to close braces
	        append the char to string builder
	        */
	        
	        StringBuilder sb = new StringBuilder();
	        int openBraces = 0, closeBraces = 0;
	        for(int i = 0;i<s.length();i++){
	            if(s.charAt(i) == '(') openBraces++;
	            else closeBraces++; 
	            
	            if(openBraces != 1 && openBraces != closeBraces){
	                sb.append(s.charAt(i));
	            }
	            if(openBraces == closeBraces) {
	                openBraces = 0;
	                closeBraces = 0;
	            }
	        }
	       return sb.toString();
	    }

}
