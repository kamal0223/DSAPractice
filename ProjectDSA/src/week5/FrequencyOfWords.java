package week5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrequencyOfWords {

	public static void main(String[] args) {
		String input = "the cat and the dog are";
		//get the count of count of each word
		//find the same word is coming again
		Map<String,Integer> hm = new HashMap<String,Integer>();
		//split the string with space
		String[] split = input.split(" ");
		
		for (int i = 0; i < split.length; i++) {
			hm.put(split[i], hm.getOrDefault(split[i], 0)+1);
		}
		System.out.println(hm);
	}
}
