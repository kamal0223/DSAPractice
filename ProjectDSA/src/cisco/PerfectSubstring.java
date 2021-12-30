package cisco;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class PerfectSubstring {
	
	@Test
	public void test1() {
		String str = "1102021222";
		int k = 2;
		Assert.assertEquals(6, perfectSubstring(str, k));
	}
	
	@Test
	public void test2() {
		String str = "1234";
		int k = 2;
		Assert.assertEquals(0, perfectSubstring(str, k));
	}
	
	@Test
	public void test3() {
		String str = "1212";
		int k = 2;
		Assert.assertEquals(1, perfectSubstring(str, k));
	}
	
	/*
	 * brute force
	 * get each substring from string using two for loops
	 * for each substring check each elements count to k
	 * yes-> increment perfectCount
	 *
	 * time = O(n^2*m) space  = O(1) is the methods space since map is used only in loops
	 */

	private int subStringWithAllKTimeOccurance(String str, int k) {
		int perfectCount = 0;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				String substring = str.substring(i, j+1);
				if(perfectSubString(substring, k)) perfectCount++;
			}
		}
		return perfectCount;
	}
	
	public boolean perfectSubString(String st, int k) {
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < st.length(); i++) {
			hm.put(st.charAt(i), hm.getOrDefault(st.charAt(i), 0)+1);
		}
		Collection<Integer> values = hm.values();
		for (Integer count : values) {
			if(count !=k) return false;
		}
		return true;
	}

	/*
	 * sliding window
	 * 012345678
	 * 1102021222]
	 *       122
	 * 1212
	 * 1234
	 */
	
	public int slidingWindow(String str, int k) {
		int perfectCount = 0, left = 0;
		int[] ascii = new int[10];
		for(int i = 0;i<str.length();i++) {
			ascii[str.charAt(i)-'0']++;
			while(ascii[str.charAt(i)-'0'] >k) {
				ascii[str.charAt(left)-'0']--;
				left++;
			}
			if(perfectString(ascii, k)) perfectCount++;
		}
		
		return perfectCount;
	}
	
	public boolean perfectString(int[] ascii, int k) {
		for (int i : ascii) {
			if(i!=0) {
				if(i!=k) return false;
			}
		}
		return true;
	}
	
	
	public boolean check(int[] arr, int k) {
		for(int val : arr) {
			if(val != 0 && val != k) return false;
		}
		return true;
	}
	
	public int perfectSubstring(String s, int k) {
		int res = 0;
		for(int i=0; i<s.length(); i++) {
			int[] arr = new int[10];
			for(int j = i; j<s.length(); j++) {
				if(j > i + (10*k)) {
					System.out.println("inside the inner loop break"); 
					break;
				}
				char ch = s.charAt(j);
				arr[ch-'0']++;
				if(check(arr, k)) res++;
			}
		}
		return res;
	}
}
