package binarysearch;

import org.junit.Test;

import junit.framework.Assert;

/*Find the next biggest char  in sorted array of characters*/

/*Input: char[] input, char target
Output: char output
constraints: time complexity should be O(logn)


TestData set: Positive
			  Negative
			  Edge
Approaches Known:binary search
*/

public class NextBiggestChar {
	
	//a b c d e f g h
	@Test
	public void test1() {
		char[] input = {'b','h','d'};
		char target = 'b';
		Assert.assertEquals('d', usingBinarySearch(input, target));
	}
	@Test
	
	public void test2() {
		char[] input = {'b'};
		char target = 'c';
		Assert.assertEquals(' ', usingBinarySearch(input, target));
	}
	@Test
	public void test3() {
		char[] input = {'b','d','h'};
		char target = 'd';
		Assert.assertEquals('h', usingBinarySearch(input, target));
	}
	
	@Test
	public void test4() {
		char[] input = {'z','y','x'};
		char target = 'y';
		Assert.assertEquals('z', usingBinarySearch(input, target));
	}
	
	
	private char usingBruteForce(char[] input, char target) {
		
		
		for(int i = 0;i<input.length;i++) {
			if(input[i]>target) return input[i];
		}
		
		
		return ' ';
	}

	private char usingBinarySearch(char[] input, char target) {
		int low = 0, high = input.length-1;
		
		while(low<=high) {
			int mid = (low+high)/2;
			
			//if(input[mid]>target) return input[mid];
			if(input[mid] == target && input[mid+1]<target) high = mid-1;
			else if(input[mid] == target && input[mid+1]>target) return input[mid+1];
			else low = mid+1;
			
		}
		
		
		return ' ';
		
		
	}
}
