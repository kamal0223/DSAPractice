package flash.slidingwindow;

import org.junit.Assert;
import org.junit.Test;

public class SubStringHavingabc_1358 {

	@Test
	public void test1() {
		String s = "aaacb";
		Assert.assertEquals(3, numberOfSubstrings(s));
	}
	
	@Test
	public void test2() {
		String s = "abcabc";
		Assert.assertEquals(10, numberOfSubstrings(s));
	}
	
	@Test
	public void test3() {
		String s = "abc";
		Assert.assertEquals(10, numberOfSubstrings(s));
	}
	
	public int numberOfSubstrings(String s) {
        //4.43
        
        //create an asciiArr of size 3
        //create an array for window of size 3
        //fill the asciiArr with 1
        //traverse the string from 0 to 
        
        //get the number of elements from i to length 
        
  
        int[] asciiWindow = new int[3];
            
        int low = 0, high = 0, count = 0;
        while(high<s.length()){
            asciiWindow[s.charAt(high)-'a']++;
            while(asciiWindow[0]>0 && asciiWindow[1]>0 && asciiWindow[2]>0){
                asciiWindow[s.charAt(low)-'a']--;
                low++;
            }
            count = count+low;
            high++;
        }
        return count;
    }
}
