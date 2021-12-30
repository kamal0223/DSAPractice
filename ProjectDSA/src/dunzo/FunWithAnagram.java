package dunzo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class FunWithAnagram {
	
	@Test
	public void test1() {
		List<String> lt = Arrays.asList("code","ocde","ecod","farmer","farm");
		System.out.println(funWithAnagram(lt));
	}
	
	@Test
	public void test2() {
		List<String> lt = Arrays.asList("code","farmer","farm");
		System.out.println(funWithAnagram(lt));
	}

	private List<String> funWithAnagram(List<String> lt) {
		//declare an ascii counter char as key and its count as value
		List<String> output = new ArrayList<String>();
		//int[] asciiCount = new int[26];
		Set<String> set = new HashSet<String>();
		for(String s:lt) {
			int[] asciiCount = new int[26];
			for(int i = 0;i<s.length();i++) {
				asciiCount[s.charAt(i)-'a']++;
			}
			//check if the asciiCount exist
			if(!set.contains(Arrays.toString(asciiCount))) { 
				output.add(s);
				set.add(Arrays.toString(asciiCount));
			}
		}
		return output;
	}	

}
