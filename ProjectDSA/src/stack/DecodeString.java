package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class DecodeString {
	
	@Test
	public void test1() {
		String str = "3[a2[cds]ef]";
		Assert.assertEquals("acdscdsefacdscdsefacdscdsef", decodeString(str));
	}
	
	@Test
	public void test2() {
		String str = "3[cd[sda]]";
		Assert.assertEquals("cdsdacdsdacdsda", decodeString(str));
	}
	
	@Test
	public void test3() {
		String str = "3[a2[cd]s]ef";
		Assert.assertEquals("acdcdsacdcdsacdcdsef", decodeString(str));
	}
	
	@Test
	public void test4() {
		String str = "acd";
		Assert.assertEquals("acd", decodeString(str));
	}

	private String decodeString(String str) {
		//declare a stack of character
		//declare a string builder
		Stack<Character> st = new Stack<Character>();
		//iterate the string
		for(Character c: str.toCharArray()) {
			//find the first closing bracket.push characters other than ']' to stack
			if(c!=']') {
				st.push(c);
			}else {
				StringBuilder sb = new StringBuilder();
				//pop the stack till the '[' braces
				while(!st.isEmpty() && st.peek() != '[') {
					sb.insert(0, st.pop());
				}
				//pop the [ braces from stack
				st.pop();
				int count = 1;
				//pop the digit from the stack if there is no digit make it as 1
				if(!st.isEmpty() && Character.isDigit(st.peek())) count = Integer.parseInt(st.pop().toString());
				//loop the decoded string in [] to count numbers
				while(count>0) {
					for(Character ch:sb.toString().toCharArray()) {
						st.push(ch);
					}
					count--;
				}
				
			}
		}
		String output = "";
		for(Character s:st) {
			output += s;
		}
		return output;
	}
	
	private String decodeStringRecursion(String str) {
		int[] nums = new int[3];
		 List<Integer> li = new ArrayList();
		 li.add
		 li.add(new ArrayList().add(Arrays.asList(nums)));
		 List<int[]> asList = Arrays.asList(new int[] {1,2,3});
		 li.add(new ArrayList<Integer>().add(Arrays.asList(new int[] {1,2,3})));
		return "";
	}

}
