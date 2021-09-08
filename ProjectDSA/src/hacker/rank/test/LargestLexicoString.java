package hacker.rank.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class LargestLexicoString {
	
	@Test
	public void test1() {
		String str = "baccc";
		int k = 2;
		Assert.assertEquals("ccbca", largestLexicoUsingPointers(str,k));
	}
	
	@Test
	public void test2() {
		String str = "zzzzza";
		int k = 2;
		Assert.assertEquals("zzazz", largestString(str,k));
	}
	
	@Test
	public void test3() {
		String str = "zzzzzaa";
		int k = 2;
		Assert.assertEquals("zzazzaz", largestString(str,k));
	}


	
	/*
declare a treemap
iterate the string and get the count of each char in treeMap
get all keys as set and put it in a list
declare a pointer j at end of list
now iterate the list in reverse direction
	if i and j are same 
	get the min of i count  and k
	iterate the min number of times and append the char to output string
	decrement the value of that entry
	after the inner loop check the value is 0
	if yes then decrement j
	
	else if i and j are not same
	get the char at i and append to the output
	decrement count
	iterate min times of j value count and k
	decrement the value of that entry
	after the inner loop check the value is 0
	if yes then decrement j
	
return the output
	 */
	private String largestLexString(String str, int k) {
		
		Map<Character,Integer> tm = new TreeMap<Character,Integer>();
		for (int i = 0; i < str.length(); i++) {
			tm.put(str.charAt(i), tm.getOrDefault(str.charAt(i), 0)+1);
		}
		
		
		//get all the keys as set and convert to array
		List<Character> li = new ArrayList<Character>(tm.keySet());
		int j = li.size()-1;
		for (int i = li.size()-1; i >= 0; i--) {
			if(i == j) {
				int loopCount = Math.min(tm.get(li.get(i)), k);
				while(loopCount>=0) {
					
				}
			}
		}
		return null;
	}
	
	
	/*Declare a strinb builder sb
	declare a ascii array of 26 chars
	iterate the input string and get the occurence in ascii array
	iterate the ascii array in reverse direction with index i
	  check if the value at i is greater than k
	    iterate the k number of times and append the character to string builder
	    decrement the count of i in ascii array
	    iterate from i-1 to start of ascii 
	      check if anyValue greater than 1
	        yes-> append the char to string builder and decrement count in ascii array
		No-> return the string builder as string
	  if the value is in range 1 to k
	     iterate the char value number of times
	     append the char to string builder
	  if the value is equal to 0 continue to outer loop
 */
	
	private String largestString(String str, int k) {
		StringBuilder sb = new StringBuilder();
		int[] asciiCount = new int[26];
		int count = 0;
		for(int i = 0; i<str.length();i++) {
			asciiCount[str.charAt(i)-'a']++;  //97
		}
		for (int i = asciiCount.length-1; i >= 0 ; i--) {
			if(asciiCount[i]>k) {
				int temp = k;
				while(temp>0) {
					sb.append((char) (i+'a'));
					asciiCount[i]--;
					temp--;
				}
				for (int j = i-1; j >= 0 ; j--) {
					if(asciiCount[j]>0) {
						sb.append((char) (j+'a'));
						asciiCount[j]--;
						break;
					}
				}
				i++;
			}
			else if(asciiCount[i]>0 && asciiCount[i]<=k && sb.charAt(sb.length()-1) != (char) (i+'a')) {
				
				int temp = asciiCount[i] ;
				while(temp>0) {
					sb.append((char) (i+'a'));
					asciiCount[i]--;
					temp--;
				}
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	private String largestLexicoUsingPointers(String str, int k) {
		Map<Character,Integer> hm = new HashMap<Character,Integer>();
		for (int i = 0; i < str.length(); i++) hm.put(str.charAt(i), hm.getOrDefault(str.charAt(i), 0)+1);
		//sort the entry set of the map based on the key
		Set<Entry<Character, Integer>> entrySet = hm.entrySet();
		List<Entry<Character, Integer>> li = new ArrayList<Entry<Character,Integer>>(entrySet);
		Collections.sort(li, (a,b) -> (b.getKey().compareTo(a.getKey())));
		
		
		return str;
	}
}
