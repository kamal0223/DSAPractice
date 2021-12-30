package flash.stack;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

//https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
public class MaxNestingDepth_1614 {
	
	@Test
	public void test1() {
		String s = "(1+(2*3)+((8)/4))+1";
		Assert.assertEquals(3, maxDepth(s));
	}
	
	@Test
	public void test2() {
		String s = "(1+(2*3)+((8)/4))+1";
		Assert.assertEquals(3, maxDepth(s));
	}
	@Test
	public void test3() {
		String s = "1+(2*3)/(2-1)";
		Assert.assertEquals(1, maxDepth(s));
	}

	private int maxDepthStack(String s) {
		Stack<Character> st = new Stack<Character>();
        int popCount = 0, maxDep = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == ')'){
                st.pop();
                popCount--;
            } else if(s.charAt(i) == '(') {
                st.push(s.charAt(i));
                popCount++;
            }
            maxDep = Math.max(maxDep,popCount);
        }
        
        return maxDep;
	}
	
	private int maxDepth(String s) {
		 int parenthesesCount = 0, maxDep = 0;
	        for(int i = 0;i<s.length();i++){
	            if(s.charAt(i) == '('){
	                parenthesesCount++;
	            }
	            if(s.charAt(i) == ')') parenthesesCount--;
	            maxDep = Math.max(maxDep,parenthesesCount);
	        }
	        return maxDep;
	}
}
