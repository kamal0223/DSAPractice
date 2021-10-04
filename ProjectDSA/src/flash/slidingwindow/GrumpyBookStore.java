package flash.slidingwindow;

import org.junit.Test;

import junit.framework.Assert;

public class GrumpyBookStore {
	
	@Test
	public void test1() {
		int[] customers  = {1,0,1,2,1,1,7,5};
		int[] grumpy  = {0,1,0,1,0,1,0,1};
		int minutes = 3;
		Assert.assertEquals(16, maxSatisfied(customers, grumpy, minutes));
	}
	
	@Test
	public void test2() {
		int[] customers  = {1};
		int[] grumpy  = {0};
		int minutes = 1;
		Assert.assertEquals(1, maxSatisfied(customers, grumpy, minutes));
	}

	private int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
		int satisfiedCustomer = 0, windowUnsatisfied = 0, maxWindow = 0;
        for(int i = 0;i<customers.length;i++){
            if(grumpy[i] == 0) satisfiedCustomer += customers[i];
            else windowUnsatisfied += customers[i];
            //if the window length is broken
            if(i >= minutes && grumpy[i-minutes] == 1) {
                windowUnsatisfied -= customers[i-minutes];
            }
            maxWindow = Math.max(maxWindow, windowUnsatisfied);
        }
        return maxWindow+satisfiedCustomer;
	}
	
	/*
	 * find the window
	 */
	private int maxSatisfiedOptimized(int[] customers, int[] grumpy, int minutes) {
		
		
		return minutes;
	}
}
