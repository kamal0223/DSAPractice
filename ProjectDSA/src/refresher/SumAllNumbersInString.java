package refresher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.junit.Test;

import junit.framework.Assert;

public class SumAllNumbersInString {

	@Test
	public void test1() {
		String str = "12abc20yz68";
		Assert.assertEquals(100, sumAllNumbersRegex(str));
	}

	@Test
	public void test2() {
		String str = "abdfa";
		Assert.assertEquals(0L, sumAllNumbersRegex(str));
	}

	@Test
	public void test3() {
		String str = "2147483647asad2";
		Assert.assertEquals(2147483649L, sumAllNumbersRegex(str));
	}

	/*
	 * iterate the string 1abc23
	   check if it is a digit using Character.isDigit
	   yes=>	append to String
	   no=> 
		 and parse the string to int
		 add it to the sum
		 make the string as empty ""
	 */
	private long sumAllNumbers(String str) {
		String number = "";
		long sum = 0;
		for(int i = 0;i<str.length();i++){
			if(Character.isDigit(str.charAt(i))) number+= str.charAt(i);
			else {
				if(number!="") {
					sum+= Long.parseLong(number);
					number = "";
				}
			}
		} 
		return (number == "")?0:sum+Long.parseLong(number);
	}
	
	private long sumAllNumbersRegex(String str) {
		long sum = 0;
		Matcher matcher = Pattern.compile("\\d+").matcher(str);
		while(matcher.find()) {
			sum+= Long.parseLong(matcher.group());
		}
		return sum;
		
	}
}

