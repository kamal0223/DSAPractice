package refresher;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class FirstReapeatingAndNonRepeating {

	@Test
	public void test1() {
		String str = "abcdabc";
		findRepeatingAndNonRepeating(str);
	}

	@Test //no non repeating char
	public void test2() {
		String str = "abcdabcd";
		//abccda
		findRepeatingAndNonRepeating(str);
	}

	@Test  //no repeating char
	public void test3() {
		String str = "abcd";
		findRepeatingAndNonRepeating(str);
	}

	@Test  //empty or null string
	public void test4() {
		String str = "";
		findRepeatingAndNonRepeating(str);
	}

	private void findRepeatingAndNonRepeating(String str) {
		if(str.equals("") || str == null) {
			System.out.println("input string is null or empty");
			return;
		}
		System.out.println("the first repeating char is "+findFirstRepeating(str));
		System.out.println("the first non repeating char is "+findFirstNonRepeating(str));


	}

	/**
	 * @return first character that is non repeating
	 * <br>
	 * If no non repeating char found '0' is returned
	 * @author kamalakannan.s
	 * @param
	 */
	private char findFirstNonRepeating(String str) {
		//get the freq of each char in a map and
		//iterate the map and return the key that has value 1
		//if no value is 1 then return '0'
		Map<Character,Integer> hm = new HashMap<Character,Integer>();
		for (int i = 0; i < str.length(); i++) {
			hm.put(str.charAt(i), hm.getOrDefault(str.charAt(i), 0)+1);
		}
		for (Map.Entry<Character,Integer> eachEntry : hm.entrySet()) {
			if(eachEntry.getValue() == 1) return eachEntry.getKey();
		}
		return '0';
	}

	private char findFirstRepeating(String str) {
		//add the char from string to set
		//iterate the str
		//check if current char is contained in the set
		//yes-> return that char
		//return '0';

		Set<Character> set = new HashSet<Character>();
		for (Character charac : str.toCharArray()) {
			if(!set.add(charac)) return charac;
		}
		return '0';
	}
}
