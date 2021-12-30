package onspot;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class FindLargestGroup {
	
	@Test
	public void test1() {
		int n = 13;
		Assert.assertEquals(4, findLargestGroup(n));
	}
	
	@Test
	public void test2() {
		int n = 15;
		Assert.assertEquals(6, findLargestGroup(n));
	}
	
	@Test
	public void test3() {
		int n = 24;
		Assert.assertEquals(5, findLargestGroup(n));
	}

	private int findLargestGroup(int n) {
		
		//iterate from 1 to n 
        //create a map key as digitSum and count of entries as value
        // each element find sum of its digit
        //check the digitSum is in map key 
        //yes increment the count
        //no add an entry in map with count 1
        //get the largest number in count and find how many has this same count
        
        int result = 0;
        Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i = 1;i<=n;i++){
            int digitSum = findDigitSum(i);
            if(hm.containsKey(digitSum)){
                hm.put(digitSum, hm.get(digitSum)+1);
            }else hm.put(digitSum, 1);
        }
        int max = Collections.max(hm.values());
        for(Map.Entry<Integer,Integer> each :hm.entrySet()) {
			 if(each.getValue() == max) result++;
		 }
        return result;
        String s = "";
        Set<Character> lowerCase = new HashSet<Character>();
        
    }
    public int findDigitSum(int num){
            int sum = 0;
            while(num !=0){
                sum += num%10;
                num = num/10;
            }
            return sum;
	}

}
