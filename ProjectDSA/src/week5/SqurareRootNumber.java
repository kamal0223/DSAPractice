package week5;

import org.junit.Assert;
import org.junit.Test;

public class SqurareRootNumber {
	
	@Test
	public void test1() {
		int input = 1;
		Assert.assertEquals(1, squareRootUsingBrute(input));
	}
	
	@Test
	public void test2() {
		int input = 8;
		Assert.assertEquals(2, squareRootUsingBrute(input));
	}
	
	@Test
	public void test3() {
		int input = 0;
		Assert.assertEquals(0, squareRootUsingBrute(input));
	}
	//2147395600
	@Test
	public void test4() {
		int input = 2147483647;
		Assert.assertEquals(46340, squareRootUsingBrute(input));
	}

	private int squareRootUsingBrute(int input) {
		if(input == 1 || input == 0) return input;
		long max = 0;
		for (long i = 1; i<=input/2; i++) {
			long square = i*i;
			if(square == input) return (int) i;
			if(square<input) {
				max = Math.max(max, i);
			}else {
				break;
			}
		}
		return (int )max;
		
	}
	
	private int squareRootUsingBinarysearch(int input) {
		if(input == 1) return 1;
		
		long low = 0, high = input/2;
		int count = 0;
		while (low<=high) {
			count++;
			long mid = (low+high)/2;
			if(mid*mid == input) return (int) mid;
			else if(mid*mid>input) high = mid-1;
			else if(mid*mid<input) low = mid+1;
		}
		System.out.println(count);
		return (int) high;
	}
	
	

}
