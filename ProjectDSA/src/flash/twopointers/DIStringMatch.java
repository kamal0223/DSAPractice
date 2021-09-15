package flash.twopointers;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/di-string-match/
public class DIStringMatch {

	@Test
	public void test1() {
		String s = "IDID";
		Assert.assertTrue(Arrays.equals(new int[] {0,4,1,3,2}, diString(s)));
	}
	
	@Test
	public void test2() {
		String s = "III";
		Assert.assertTrue(Arrays.equals(new int[] {0,1,2,3}, diString(s)));
	}
	
	@Test
	public void test3() {
		String s = "DDI";
		Assert.assertTrue(Arrays.equals(new int[] {3,2,0,1}, diString(s)));
	}
	
	 //declare start  = 0 and end  = s.length
    //declare an output array of integer of sizes s.length+1
    //iterate the string s
    //if the char is I then make output[i] = start, increment start
    //if the char is D then make output[i] = end, decrement end
    //out of the loop
    //output[s.length] = start
	//return output

	private int[] diString(String s) {
		int start = 0, end = s.length();
        int[] output = new int[s.length()+1];
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == 'I') output[i] = start++;
            else output[i] = end--;
        }
        output[s.length()] = start;
        return output;
	}
}
