package onspot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

/*
You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.
We repeatedly make k duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
 */
public class KAdjacentRemovelString {

	@Test
	public void test1() {
		String str = "deeedbbcccbdaa";
		int k = 3;
		Assert.assertEquals("aa", adjacentRemovalUsingMap(str, k));
	}
	
	@Test
	public void test2() {
		String str = "abcd";
		int k = 2;
		Assert.assertEquals("abcd", adjacentRemovalUsingMap(str, k));
	}
	
	@Test
	public void test3() {
		String str = "abcd";
		int k = 1;
		Assert.assertEquals("", adjacentRemovalUsingMap(str, k));
	}
	
	@Test
	public void test4() {
		String str = "aabad";
		int k = 3;
		Assert.assertEquals("aabad", adjacentRemovalUsingMap(str, k));
	}

	/*
	 * Delcare two stacks
	 * Declare a output String
	 * iterate the input string from 0 to lenght
	 * check if the stack is not empty and the last element in index stack is not k
	 *  yes->peek the charstack in if the input char is same and push to charstack
	 *       then increment the count in index stack and push to index stack
	 *  No->pop the indexStack and charStack k number of times
	 * convert the stack to string output and return
	 * 
	 * time complexity = O(n) and space complexity = O(2n)
	 */
	
	private String adjacentRemoval(String str, int k) {
		Stack<Character> charStack = new Stack<Character>();
		Stack<Integer> indexStack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<str.length();i++) {
			if(!charStack.isEmpty()) {
				if(charStack.peek() == str.charAt(i)) indexStack.push(indexStack.peek()+1);
				else indexStack.push(1);
				charStack.push(str.charAt(i));
			}else {
				charStack.push(str.charAt(i));
				indexStack.push(1);
			}
			if(indexStack.peek() == k) {
				int j = 0;
				while(j<k) {
					charStack.pop();
					indexStack.pop();
					j++;
				}
				
			}
		}
		
		for(Character each:charStack) {
			sb.append(each);
		}
		return sb.toString();
	}
	
	/*
	 * Declare a LinkedHashMap of character and integer
	 * Declare a stringBuilder
	 * Iterate the input string
	 * 	  get occurence of each character and add to it values
	 * 	  check if the value is equal to k
	 * 	  yes-> remove that entry from map
	 * Iterate the map entries
	 *    loop the value number of times
	 *    append the key to stringbuilder
	 * return sb
	 * 
	 * time complexity  = O(n) remove worst case is O(n*m) and space complexity = O(n)
	 */
	
	private String adjacentRemovalUsingMap(String str, int k) {
		Map<Character,Integer> linkedMap = new LinkedHashMap<Character,Integer>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<str.length();i++) {
			linkedMap.put(str.charAt(i), linkedMap.getOrDefault(str.charAt(i), 0)+1);
			//add that char to output string
			sb.append(str.charAt(i));
			//check the count of this char is k
			if(linkedMap.get(str.charAt(i)) == k) {
				//iterate and check the last k chars in sb are all same
				int end = sb.length()-1;
				int start = sb.length()-k;
				while(end>=start) {
					if(sb.charAt(end) != str.charAt(i)) break;
					end--;
				}
				if(start == end+1) sb.delete(start, start+k);
			}
			
		}
		return sb.toString();
		
	}
}
