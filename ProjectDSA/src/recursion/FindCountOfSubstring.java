package recursion;

import org.junit.Test;

import junit.framework.Assert;

public class FindCountOfSubstring {
	/*
	 * basecase
	 * str1 does not contain str2 retrun 0
	 * else return 1
	 * pattern
	 * findCount(st1.replacefirst(str2,""))
	 */

	@Test
	public void test1() {
		String str1 = "test of test is a test made";
		String str2 = "test";
		Assert.assertEquals(3, findCount(str1,str2));
	}
	
	@Test
	public void test2() {
		String str1 = "test of test is a test made";
		String str2 = "common";
		Assert.assertEquals(0, findCount(str1,str2));
	}
	
	@Test
	public void test3() {
		String str1 = "test of test is a test made common";
		String str2 = "common";
		Assert.assertEquals(1, findCount(str1,str2));
	}
	
	@Test
	public void test4() {
		String str1 = "common test of test is a test made";
		String str2 = "common";
		Assert.assertEquals(1, findCount(str1,str2));
	}

	private int findCount(String str1, String str2) {
		
		//base condition
		//str1 does not contain str2 retrun 0
		if(!str1.contains(str2)) return 0;
		//findCount(st1.replacefirst(str2,""))
		//on every replace make count 1 incremented
		return 1+findCount(str1.replaceFirst(str2, ""), str2);
	}
}
