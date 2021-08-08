package hacker.rank.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;


/*
 * Given a list of items like apple, orange, guava, apple, orange
 * Get the output in List of strings as 
 * apple 2, orange 2, guava 1
 * the output should be sorted with count in descending order and if two items has same count
 * then sort by alphabetical order of item 
 */

public class GroupByItems {

	@Test
	public void test1() {
		List<String> input = new ArrayList<String>(Arrays.asList(new String[] {"orange","guava","apple","apple","orange"}));
		//Assert.assertTrue(false);
		List<String> output = new ArrayList<String>(Arrays.asList(new String[] {"apple 2", "orange 2", "guava 1"}));

		Assert.assertTrue(output.toString().equals(usingCollectionStream(input).toString()));
	}

	private List<String> groupByItems(List<String> input) {

		List<String> ali = new ArrayList<String>();
		Map<String,Integer> tm = new TreeMap<String,Integer>();

		//add the occurence of items in list
		for (String eachItem : input) {
			tm.put(eachItem, tm.getOrDefault(eachItem, 0)+1);
		}

		//get the map entry that has highest value and add it to output list
		//remove that entry once added
		//again get highest value and repeat the step till the mapsize becomes zero

		while(tm.size()>0) {
			String keyToBeRemoved = null;
			int maxValue = Collections.max(tm.values());
			for (Map.Entry<String, Integer> eachItem : tm.entrySet()) {
				if(eachItem.getValue() == maxValue) {
					ali.add(eachItem.getKey()+" "+eachItem.getValue());
					keyToBeRemoved = eachItem.getKey();
					break;
				}
			}
			tm.remove(keyToBeRemoved);

		}

		System.out.println(ali.toString());
		return ali; 

	}

	private List<String> usingCollectionStream(List<String> input) {

		List<String> ali = new ArrayList<String>();
		Map<String,Integer> tm = new TreeMap<String,Integer>();

		//add the occurence of items in list
		for (String eachItem : input) {
			tm.put(eachItem, tm.getOrDefault(eachItem, 0)+1);
		}

		//get the map entry that has highest value and add it to output list
		//remove that entry once added
		//again get highest value and repeat the step till the mapsize becomes zero

		while(tm.size()>0) {
			int maxValue = Collections.max(tm.values());
			//using collection streaming find the entry that mataches maxValue
			ali.add(tm.entrySet().stream().filter(x -> x.getValue() == maxValue).findFirst().get().getKey()+" "+maxValue);
			tm.remove(tm.entrySet().stream().filter(x -> x.getValue() == maxValue).findFirst().get().getKey());

		}

		System.out.println(ali.toString());
		return ali; 

	}


}
