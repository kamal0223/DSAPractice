package flash.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

//https://leetcode.com/problems/partition-labels/
public class PartitionLabels {

	@Test
	public void test1() {
		String s = "ababcbacadefegdehijhklij";
		Assert.assertTrue(Arrays.equals(new Integer[] {9,7,8}, partitionLabels(s)));
	}
	
	@Test
	public void test2() {
		String s = "eccbbbbdec";
		Assert.assertTrue(Arrays.equals(new Integer[] {10}, partitionLabels(s)));
	}
	

	/*
declare a list of integers
declare a map of char, integer
declare a k integer and lastIndex as 0
declare two pointers i and j at 0
convert the string to char array
decalre start as 0
traverse the char array till j goes out of length
check if i == j
yes->get j-start and add it to output array
     update start as i
     k++
get the i value last index and put in map
check if the ivalue last index is greater than lastIndex
yes-> update the lastIndex variable to this value
update j as lastIndex+1
increment i

once after the loop
get j-start and add it to output array at k

	 * 
	 */
	private Integer[] partitionLabels(String s) {
		List<Integer> output = new ArrayList<Integer>();
		int lastIndex = 0, i = 0, j = 1;
		char[] charArray = s.toCharArray();
		int start = 0;
		while(j<s.length()) {
			if(i==j) {
				output.add(j-start);
				start  = i;
			}
			if(s.lastIndexOf(charArray[i])>lastIndex) lastIndex = s.lastIndexOf(charArray[i]);
			j = lastIndex+1;
			i++;
		}
		output.add(j-start);
		//convert list to array
		System.out.println(output);
		return output.toArray(new Integer[0]);
	}
}
