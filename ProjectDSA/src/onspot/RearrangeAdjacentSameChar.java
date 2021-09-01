package onspot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

/*
Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.

 */

public class RearrangeAdjacentSameChar {
	
	@Test
	public void test1() {
		String str = "bbaabacaa";
		System.out.println(dpRearrange(str));
	}
	
	@Test
	public void test2() {
		String str = "aabbcc";
		System.out.println(dpRearrange(str));
	}
	
	@Test
	public void test3() {
		String str = "aabbbbbc";
		System.out.println(dpRearrange(str));
	}
	
	@Test
	public void test4() {
		String str = "aab";
		System.out.println(dpRearrange(str));
	}
	

	/*
	 * add all the occurence to a map
	 * Get the enries as set
	 * convert the set to list to use collection sort
	 * sort the list of entry in descending order by value
	 * iterate till the list size becomes 1
	 * 	  Get the first entry from list
	 *    iterate from 1 to size of list
	 *    	 get each entries
	 *    	 append the firstentry and decrement its char count
	 *    	 appdend each entry and decrement its char count
	 *    after inner loop check if last element or first element count is 0
	 *    remove that entry from list
	 * end of all loops
	 * check the only entry value i.e count is 1 then append to sb
	 * else if more than 1 return ""
	 * return sb   
	 */
	private String dpRearrange(String str) {
		StringBuilder sb = new StringBuilder();
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(Character each:str.toCharArray()) {
			map.put(each, map.getOrDefault(each, 0)+1);
		}
		//sort the map by descending order of value
		Set<Entry<Character, Integer>> entrySet = map.entrySet();
		//add it to a list to use collection sort comparator
		List<Entry<Character,Integer>> li = new ArrayList(entrySet);
		Collections.sort(li, (a,b)->{
			return b.getValue()-(a.getValue());
		});
		while(li.size()>1) {
			Entry<Character,Integer> firstEntry = li.get(0);
			for(int j = 1;j<li.size();j++) {
				Entry<Character,Integer> secondEntry = li.get(j);
				sb.append(firstEntry.getKey());
				firstEntry.setValue(firstEntry.getValue()-1);
				sb.append(secondEntry.getKey());
				secondEntry.setValue(secondEntry.getValue()-1);
			}
			if(li.get(li.size()-1).getValue() == 0) li.remove(li.size()-1);
			else if(li.get(0).getValue() == 0) li.remove(0);
		}
		Entry<Character, Integer> firstEntry = li.get(0);
		if(firstEntry.getValue() == 1) sb.append(firstEntry.getKey());
		else if(firstEntry.getValue() > 1) return "";
		
		return sb.toString();
	}	
}
