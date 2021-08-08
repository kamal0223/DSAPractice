package week5;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/the-kth-factor-of-n/


/*
 * input: integer n, integer k
 * output:integer
 * constraint: no
 * did you understand the question
 * Write test data like positive, negative and edge
 * validate the test data with interviewer
 * ask whether I can write pseudocode
 * ask whether I can code using IDE
 * code it 
 * run the positive case only
 * if successful then run other cases
 * if not successful debug the failing cases
 */

public class KthFactorOfN {

	@Test
	public void test1() {
		int n = 12;
		int k = 3;
		Assert.assertEquals(3, withoutAuxiliary(n,k));
	}
	
	@Test
	public void test2() {
		int n = 1;
		int k = 1;
		Assert.assertEquals(1, withoutAuxiliary(n,k));
	}
	
	@Test
	public void test3() {
		int n = 7;
		int k = 2;
		Assert.assertEquals(7, withoutAuxiliary(n,k));
	}
	
	//find all the factors of n
    //factor is something n/factor == 0 
    //declare an arraylist
    //iterate from 1 to n
    //if n%i == 0 then add it to an arraylist
    //if the size of arraylist less than k return -1
    //else return the k-1 index value from list

	private int usingBruteForce(int n, int k) {
		List<Integer> ali = new ArrayList<Integer>();
        for(int i =1;i<=n;i++){
            if(n%i == 0) ali.add(i);
        }
        if(ali.size()<k) return -1;
        else return ali.get(k-1);
	}
	
	private int withoutAuxiliary(int n, int k) {
		
		//List<Integer> ali = new ArrayList<Integer>();
		int count = 0;
        for(int i =1;i<=n;i++){
        	 if(n%i == 0) {
        		 count++;
        	}
        	 if(count == k) return i; 
        }
		return -1;
	}
	
}
