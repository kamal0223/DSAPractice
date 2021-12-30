package RetailMeNot;

import junit.framework.Assert;

/*
 * Given an integer, add 5 once before any digit to make it maximum integer
Eg., 670 - 6750   987 -> 9587, 9857 ,
       -999 -> -5999

 */
public class Add5ToMax {

	public static void main(String[] args) {
		Add5ToMax obj = new Add5ToMax();
		Assert.assertEquals(6750, obj.add5TomaxIt2(670));
		Assert.assertEquals(-5999, obj.add5TomaxIt2(-999));
		Assert.assertEquals(-1599, obj.add5TomaxIt2(-199));  //-5199, -1599, -1959
		//523 - > 5523, 5253 4361-> 54361, 45361, 678-> 5678, 6578, 6758
		//for positive numbers from left side check which digit is less than or equal to 5, add before that
		//for negative numbers from left which digit is greater than 9, add 5 before it
	}
	
	public int add5TomaxIt(int n) {
		//convert the int to string
		//declare a stringbuilder with input int as string
		//declare a int max value of int minimum
		//iterate the string from left to right
		//insert 5 before 0 index and update max by comparing with max
		
		String input = String.valueOf(n);
		int negation = 0;
		if(n<0)  negation = 1;
		int max = Integer.MIN_VALUE;
		for (int i = negation; i < input.length(); i++) {
			StringBuilder sb = new StringBuilder(input);
			sb.insert(i, 5);
			max = Math.max(max, Integer.parseInt(sb.toString()));
		}
		System.out.println(max);
		return max;
	}
	
	public int add5TomaxIt2(int n) {
		//convert the int to string
		//get the substring of by selecting 
		String input = String.valueOf(n);
		int negation = 0;
		if(n<0)  negation = 1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < input.length()-1; i++) {
			//get the first element as substring and rest as another substring
			//firstSubstring+5+"secondSubString"
			String firstSub = input.substring(0, i+1);
			String secondSub = input.substring(i+1);
			String output = firstSub+5+secondSub;
			max = Math.max(max, Integer.parseInt(output));
		}
		System.out.println(max);
		return max;
	}
}
