package flash.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class KLenSubString_1100 {

	@Test
	public void test1() {
		String s = "havefunonleetcode";  //hhavefun
		int k = 5;
		Assert.assertEquals(6, findSubstringsOfKLenOptimized(s, k));
	}
	
	@Test
	public void test2() {
		String s = "have";
		int k = 5;
		Assert.assertEquals(0, findSubstringsOfKLenOptimized(s, k));
	}

	/*
	 * brute force
	 * O(n^2) and O(1)
	 */
	private int findSubstringsOfKLen(String s, int k) {
		if(s == null || s.length() < k) return 0;
		int count = 0;
		for (int i = 0; i <= s.length()-k; i++) {
			Set<Character> st = new HashSet<Character>();
			for (int j = i; j < i+k; j++) {
				st.add(s.charAt(j));
			}
			if(st.size() == k) count++;
		}
		return count;
	}
	
	/*
	 * 
	 */
	private int findSubstringsOfKLenOptimized(String s, int k) {
		if(s.length() < k) return 0;
		
		Map<Character,Integer> hm = new HashMap<Character,Integer>();
		int count = 0;
		for (int i = 0; i < k; i++) {
			hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0)+1);
		}
		if(hm.size() == k) count++;
		//havefun
		for (int i = k; i < s.length(); i++) {
			hm.put(s.charAt(i-k), hm.get(s.charAt(i-k))-1);
			if(hm.get(s.charAt(i-k)) == 0) hm.remove(s.charAt(i-k));
			hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0)+1);
			if (hm.size() == k) {
				count++;
			}
		}
		return count;
	}
}
