package flash.twopointer;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class HappyNumber {
	
	@Test
	public void test1() {
		int n = 19;
		Assert.assertTrue(isHappyOptimized(n));
	}
	
	@Test
	public void test2() {
		int n = 2;
		Assert.assertFalse(isHappyOptimized(n));
	}
	
	
	 public boolean isHappy(int n) {
	        
	       //when the sum of squre of digits repeat in the loop than it is not happy
	        Set<Integer> repeatedNumbers = new HashSet<Integer>();
	        repeatedNumbers.add(n);
	        int sqSum = sumOfSquares(n);
	        while(sqSum != 1){
	            if(!repeatedNumbers.add(sqSum)) return false;
	            sqSum = sumOfSquares(sqSum);
	        }
	        return true;
	    }
	    
	    int sumOfSquares(int num){
	        int sum = 0;
	        while(num !=0){
	            int digit = num%10;
	            sum += digit*digit;
	            num = num/10;
	        }
	        return sum;
	    }
	    
	    /*
	     * floyd's cycyle finding algo
	     * find the sum of squares of first number say slow
	     * find the sum of squares of output of first number. we calculate two times say fast
	     * if the slow equals fast then the numbers repeate itself in a cycle not a happy number
	     */
	    public boolean isHappyOptimized(int n) {
	    	int slow = n, fast = n;
	    	slow = sumOfSquares(slow);
	    	fast = sumOfSquares(sumOfSquares(fast));
	    	if(slow == 1) return true;
	    	while(slow!=fast) {
	    		slow = sumOfSquares(slow);
		    	fast = sumOfSquares(sumOfSquares(fast));
		    	if(slow == 1) return true;
	    	}
	    	return false;
	    }

}
