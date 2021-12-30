package binarysearch;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

//Given a string with duplicate characters, find the count and append to its proceeding index

//String str = "aabbcceeed" output = "a2b2c2e3d1"

/*Input: String input
Output: String output
constraints:


TestData set: Positive
			  Negative
			  Edge
Approaches Known: brute force and binary search
 */
public class CountInNumbers {


	@Test
	public void test1() {
		String input = "bbaddd";
		Assert.assertTrue(usingTwoPointer(input).equals("a1b2d3"));
	}

	@Test (expected = RuntimeException.class)
	public void test2() {
		String input = "";
		usingHashMap(input);
	}

	@Test
	public void test3() {
		String input = "a";
		Assert.assertTrue(usingHashMap(input).equals("a1"));
	}


	//time complexity - O(n) and space complexity - O(128)

	private String bruteForce(String input) {

		if(input.length() == 0) throw new RuntimeException("input stirng cannot be emtpy");
		String output = "";
		//add the count of characters to ascii array
		int[] asciiCount = new int[128];
		for (int i = 0; i < input.length(); i++) {
			asciiCount[input.charAt(i)]++;
		}
		//now iterate through the asciicounter and get the count
		/*
		 * for (int i = 0; i < input.length(); i++) { output =
		 * output+input.charAt(i)+asciiCount[input.charAt(i)]; }
		 */


		for (int i = 0; i < asciiCount.length; i++) {
			if(asciiCount[i]!=0) {
				output = output+(char) i+asciiCount[i];
			}
		}

		System.out.println(output);

		return output;

	}

	//declare a haspmap
	//delcare a string output
	//delcare two pointer left and right as zero and end of string
	//iterate till left is less than or equal to right
	//if left and right are at same point, count the left value alone
	//add element value as key and count as value
	//if element is already presetn in map then just increment count
	//iterate the entry and add it to output string
	//return output

	//time complexity = o(n/2) and space - o(n)
	private String usingHashMap(String input) {

		if(input.length() == 0) throw new RuntimeException("input stirng cannot be emtpy");

		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		String output = "";
		int left = 0, right = input.length()-1;
		while(left<=right) {
			if(left == right) {
				hm.put(input.charAt(left), hm.getOrDefault(input.charAt(left++), 0)+1);
			}
			else{
				hm.put(input.charAt(left), hm.getOrDefault(input.charAt(left++), 0)+1);
				hm.put(input.charAt(right), hm.getOrDefault(input.charAt(right--), 0)+1);
			}

		}
		System.out.println(hm);

		for(Map.Entry<Character, Integer> each:hm.entrySet()) {
			output = output+each.getKey()+each.getValue();
		}

		System.out.println(output);
		return output;
	}

	private String usingTwoPointer(String input) {

		if(input.length() == 0) throw new RuntimeException("input stirng cannot be emtpy");

		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		String output = "";
		int left = 0, right = input.length()-1;
		int leftCounter = 1, rightCounter = 1;
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		while(left<=right) {
			if(left == right) {
				if(input.charAt(left) == input.charAt(left+1)) {
					leftCounter++;
				}else {
					sb1.append(input.charAt(left)+leftCounter+"");
					leftCounter = 1;
				}
			}
			else{
				//if value at left  ==  value at left+1 the increment leftCounter,
				//else append the value at left to stringBuilder + leftcounter and reset counter
				//if value at right == valut at right-1 then increment rightCounter
				//else appedn the rightcounter+value at right from the end of string builder
				
				if(input.charAt(left) == input.charAt(left+1)) {
					leftCounter++;
				}else {
					sb1.append(input.charAt(left)+""+leftCounter);
					leftCounter = 1;
				}
				if(input.charAt(right) == input.charAt(right-1)) {
					rightCounter++;
				}else {
					sb2.insert(0, input.charAt(right)+""+rightCounter);
					rightCounter = 1;
				}
			}
			left++;
			right--;
		}
		System.out.println(sb1.toString());
		System.out.println(sb2.toString());

		
		return sb1.toString()+sb2.toString();

	}

}
