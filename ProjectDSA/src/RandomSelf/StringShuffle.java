package RandomSelf;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class StringShuffle {

	@Test
	public void test1() {
		int[] indices = {4,5,6,7,0,2,1,3};
		String str = "codeleet";
		Assert.assertEquals("leetcode", shuffleString(indices,str));
	}

	@Test
	public void test2() {
		int[] indices = {0,1,2};
		String str = "abc";
		Assert.assertEquals("abc", shuffleString(indices,str));
	}

	private String shuffleString(int[] indices, String s) {
		StringBuilder sb = new StringBuilder(s);
		for(int i = 0;i<indices.length;i++){
			sb.setCharAt(indices[i], s.charAt(i));
		}
		return sb.toString();
	}

}
