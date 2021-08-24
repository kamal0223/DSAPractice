package onspot;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.junit.Assert;
import org.junit.Test;

public class ProductSort {
	
	@Test
	public void test1() {
		int[] input = {4,5,6,5,4,3};
		Assert.assertTrue(Arrays.equals(new int[] {3,6,4,4,5,5}, productSort(input)));
	}
	
	@Test
	public void test2() {
		int[] input = {5,4,4,6,5,6};
		Assert.assertTrue(Arrays.equals(new int[] {4,4,5,5,6,6}, productSort(input)));
	}
	
	@Test
	public void test3() {
		int[] input = {5,6,1,2};
		Assert.assertTrue(Arrays.equals(new int[] {1,2,5,6}, productSort(input)));
	}
	
	/*
	 * declare a treemap to with key as Integer,value as Integer
	 * iterate the input array 
	 * add the each element as key and its occurence as value
	 * 3,1 and 4,2 and 5,2 and 6,1
	 * get all the values as collection
	 * get the min of the values from map
	 * int startIndex = 0;
	 * iterate the map and filter the entry that has minvalue
	 * 	iterate till entry.value times
	 * 		add the key to input array
	 * 		startIndex increment it
	 * remove the filtered entry from map
	 * time complexity = O(n^2)
	 * space complexity = O(n)
	 */

	private int[] productSort(int[] input) {
		
		Map<Integer,Integer> tm = new TreeMap<Integer,Integer>();
		int startIndex = 0;
		for (int i = 0; i < input.length; i++) {
			tm.put(input[i], tm.getOrDefault(input[i], 0)+1);
		}
		
		while (!tm.isEmpty()) {
			int min = Collections.min(tm.values());
			int matchingKey = -1;
			for (Map.Entry<Integer, Integer> each: tm.entrySet()) {
				if(each.getValue() == min) {
					matchingKey = each.getKey();
					int i = 0;
					while (i<each.getValue()) {
						input[startIndex] = each.getKey();
						startIndex++;
						i++;
					}
					break;
				}
			}
			tm.remove(matchingKey);
		}
			
		
		
		return input;
	}
	
	

}
