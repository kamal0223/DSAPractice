package RandomSelf;

import org.junit.Assert;
import org.junit.Test;

public class AtoiMakestringToInt {

	@Test
	public void test1(){
		String s="  -42";
		Assert.assertEquals(convertToInteger(s),-42);
	}
	@Test
	public void test2(){
		String s="  +42";
		Assert.assertEquals(convertToInteger(s),42);
	}
	@Test
	public void test3(){
		String s="  +-42";
		Assert.assertEquals(convertToInteger(s),0);
	}
	@Test
	public void test4(){
		String s="word  42";
		Assert.assertEquals(convertToInteger(s),0);
	}
	@Test
	public void test5(){
		String s="-91283472332";
		Assert.assertEquals(convertToInteger(s),Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE%10);
	}

	@Test
	public void test6(){
		String s="234 with words";
		Assert.assertEquals(convertToInteger(s),234);
		System.out.println(Integer.MAX_VALUE%10);
	}

	@Test
	public void test7(){
		String s="3.2323";
		Assert.assertEquals(convertToInteger(s),3);
		System.out.println(Integer.MAX_VALUE%10);
	}
	
	 /*
    - Initialize a long number to hold the numbers, a boolean variable isNegative
    - trim the string to eliminate the whitespaces
    - check if the first character is negative then turn the isNegative into true
    - if the character + then continue
    - iterate the string until the non-digit character is met
    - convert this integer into string and return the same
     */
    // Time complexity- O(n)
    // space complexity - O(1)
	public int convertToInteger(String s) {
		double result=0;
		boolean isNegative=false;
		char[] chars = s.trim().toCharArray();
		for(int i=0;i<chars.length;i++){
			if(chars[i]=='-' && i==0) {
				isNegative=true;
				continue;
			}
			else if(chars[i]=='+' && i==0) continue;
			if(Character.isDigit(chars[i])) result= result*10+Integer.parseInt(chars[i]+"");
			else break;
		}
		if(isNegative) result*=-1;
		if(result<Integer.MIN_VALUE) result=Integer.MIN_VALUE;
		else if(result>Integer.MAX_VALUE) result=Integer.MAX_VALUE;
		return result==0?0:(int)result;
	}

}
