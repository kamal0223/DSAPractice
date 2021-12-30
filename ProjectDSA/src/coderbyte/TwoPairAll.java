package coderbyte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TwoPairAll {
	
	@Test
	public void test1() {
		int[] arr = {7,6,4,1,7,-2,3,12};
		System.out.println(twoSum(arr));
	}
	
	@Test
	public void test2() {
		int[] arr = {17,4,5,6,10,11,4,-3,-5,3,15,2,7};
		System.out.println(twoSum(arr));
		
		//6,11 15,2 10,7
		//6,11 10,7 15,2
	}

	private String twoSum(int[] arr) {
		String output = "";
		//create a map number and its index
		Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
		for (int i = 1; i < arr.length; i++) {
			if(!hm.containsKey(arr[0]-arr[i])) hm.put(arr[i], i);
			else {
				output += arr[0]-arr[i]+","+arr[i]+" ";
			}
		}
		if(output == "") return "-1";
		return output;
	}
	
	private List<String> twoSum1(int[] arr) {
		List<String> output = new ArrayList<String>();
		//create a map number and its index
		
		Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
		for (int i = 1; i < arr.length; i++) {
			if(!hm.containsKey(arr[0]-arr[i])) hm.put(arr[i], i);
			else {
				output.add(arr[0]-arr[i]+","+arr[i]);
			}
		}
		if(output.size() == 0) output.add("-1");
		return output;
	}

}
