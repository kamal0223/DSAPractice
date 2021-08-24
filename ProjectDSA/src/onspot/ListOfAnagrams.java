package onspot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/*
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
List<List<String>>
 */
public class ListOfAnagrams {
	
	
	@Test
	public void test1() {
		String[] input = {"eat","tea","tan","ate","nat","bat"}; 
		List<List<String>> output = listOfAnagrams(input);
		System.out.println(output.toString());
	}
	
	@Test
	public void test2() {
		String[] input = {""}; 
		List<List<String>> output = listOfAnagrams(input);
		System.out.println(output.toString());
	}
	
	@Test
	public void test3() {
		String[] input = {"a"}; 
		List<List<String>> output = listOfAnagrams(input);
		System.out.println(output.toString());
	}

	private List<List<String>> listOfAnagrams(String[] input) {
		
		//declare a hashMap of String,List
		//iterate the input array and get string
		//create an ascii array of 26 size
		//iterate the string and get each char, get the index and increment its value
		//convert the array of int to string decoded
		//check if the decoded string is present in map
		//if not present add a entry with decoded as key, its input string
		//if present add to the list which is present as value to that key
		//get all values and return it
		
		Map<String,List<String>> hm = new HashMap<String,List<String>>();
		for (int i = 0; i < input.length; i++) {
			int[] ascii = new int[26];
			for (int j = 0; j < input[i].length(); j++) {
				ascii[input[i].charAt(j)-'a']++;
			}
			//convert the ascii array to string
			String asciiStr = Arrays.toString(ascii);
			//check if the ascii is present in map keys
			if(hm.containsKey(asciiStr)) {
				//as the ascii is already present get the value and add the string to the value
				List<String> list = hm.get(asciiStr);
				list.add(input[i]);
				//replace the list with this list
				hm.put(asciiStr, list);
			}else {
				//as the ascii is not present in map add a new entry
				List<String> ali = new ArrayList<String>();
				ali.add(input[i]);
				hm.put(asciiStr,ali);
			}
		}
		List<List<String>> listOfList = new ArrayList<List<String>>();
		listOfList.addAll(hm.values());
		return listOfList;
	}

}
