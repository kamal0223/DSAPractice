package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/word-break/

public class WordBreak {
	
	@Test
	public void test1() {
		String input = "leetcodeleet";
		List<String> wordDict = new ArrayList<String>(Arrays.asList(new String[] {"leet", "code"}));
		wordBreak(input, wordDict);
		//Assert.assertTrue(wordBreak(input, wordDict));
	}
	
	@Test
	public void test2() {
		String input = "applepenapple";
		List<String> wordDict = new ArrayList<String>(Arrays.asList(new String[] {"apple", "pen"}));
		Assert.assertTrue(wordBreak(input, wordDict));
	}
	
	@Test
	public void test3() {
		String input = "catsandog";
		List<String> wordDict = new ArrayList<String>(Arrays.asList(new String[] {"cats","dog","sand","and","cat"}));
		Assert.assertFalse(wordBreak(input, wordDict));
	}

	@Test
	public void test4() {
		String input = "cars";
		List<String> wordDict = new ArrayList<String>(Arrays.asList(new String[] {"car","ca","rs"}));
		Assert.assertTrue(wordBreak(input, wordDict));
	}
	
	@Test
	public void test5() {
		String input = "cbca";
		List<String> wordDict = new ArrayList<String>(Arrays.asList(new String[] {"bc","ca"}));
		Assert.assertFalse(wordBreak(input, wordDict));
	}
	
	@Test
	public void test6() {
		String input = "aaaaaaa";
		List<String> wordDict = new ArrayList<String>(Arrays.asList(new String[] {"aaaa","aaa"}));
		Assert.assertTrue(wordBreak(input, wordDict));
	}

	private boolean wordBreak(String input, List<String> dict) {
		//using window sliding
		//create two pointer start and end both at zero
		//create a arraylist to hold the matching substring index
		//iterate through the input string from 0 index
		//	loop the pointer end till a matching substring is found for first wordDict
		//  if there are no matching substring found and end goes to length return false
		//  get the index of the match and append to arraylist at position 0
		//  continue with next wordDict
		// if all the words are found in substring return true
		
		if (input==null||input.length()==0) return false;
        else if (dict.contains(input)) return true;
        
        List<Integer> starts = new LinkedList<Integer>();
        starts.add(0);
        for (int end=1;end<=input.length();end++){
        	boolean found=false;
            for (Integer start:starts)
                if (dict.contains(input.substring(start,end))){
                	found=true;
                	break;
                }
            if(found)  starts.add(0,end);
        }

        return (starts.get(0)==input.length());
	}

}
