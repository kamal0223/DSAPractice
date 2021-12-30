package stack;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

/*Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
The canonical path should have the following format:
The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
Return the simplified canonical path.*/


/*Input: String input
Output: String output
constraints: stack


TestData set: Positive
			  Negative
			  Edge
Approaches Known: stack
 */

public class CanonicalPath {

	@Test
	public void test1() {
		String input = "/home/";
		Assert.assertTrue(usingStack(input).equals("/home"));
	}

	@Test
	public void test2() {
		String input = "/a/../../b/../c//.//";
		Assert.assertTrue(usingStack(input).equals("/c"));
	}



	@Test
	public void test3() {
		String input = "/a/./b/../../c/";
		Assert.assertTrue(usingStack(input).equals("/c"));
	}

	/*
	 * split the string based on '/' and get a string array
	 * create a stack
	 * iterate the string array
	 * if we see .. then pop 
	 * if we . then don't push  // ignore
	 * if both cases fail push
	 * 
	 * create a strinbuilder
	 * loop the stack
	 * 
	 * 


	 */
	private String usingStack(String input) {
		String[] split = input.split("/");
		Stack<String> st = new Stack<String>();
		for (int i = 0; i < split.length; i++) {
			if(split[i].trim().equals("..") && !st.isEmpty()) st.pop();
			else if(!split[i].trim().equals(".") && !split[i].trim().equals("") && !split[i].trim().equals("..")) st.push(split[i].trim());
		}
		String output = "";
		if(st.isEmpty()) return "/";
		for(String each:st) {
			output = output+"/"+each;
		}
		return "/" + String.join("/", st);
	}

	private String usingStack2(String input) {
		String[] split = input.split("/");
		Stack<String> st = new Stack<String>();
		for(String each:split) {
			if(each.equals("")) continue;
			if(each.equals(".")) continue;
			if(each.equals("..") && !st.isEmpty()) st.pop();
			else if(!each.equals("..")) st.push(each);
		}
		return "/" + String.join("/", st);
	}
}
