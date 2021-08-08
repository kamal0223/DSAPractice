package marathon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReverseString {
	
	/*
	 * Find unique characters in given string Input: "TestLeaf" Output: s,a,f,l
	 */
	
	
	private static List findDuplicateBruteforce() {
		String s = "testleaf";
		//char[] output = new char[s.length()];
		
		List<Character> ali = new ArrayList<Character>();
		for(int i =0;i<s.length();i++) {
			boolean flag = false;
			for(int j = 0;j<s.length();j++) {
				if(i!=j && s.charAt(i) == s.charAt(j)) {
					flag = true;
					break;
				}
			}
			if(!flag) ali.add(s.charAt(i));
			
		}
		
		System.out.println(ali);
		return ali;
	}
	
	
	//using set
	private static Set findDuplicateUsingSet() {
		String s = "testleaf";
		Set<Character> set = new HashSet<Character>();
		for(int i =0;i<s.length();i++) {
			set.add(s.charAt(i));
		}
		System.out.println(set);
		return set;
	}
	
	
	
	public static void main(String[] args) {
		findDuplicateUsingSet();
		
	}
}
