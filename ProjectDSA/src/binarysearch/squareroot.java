package binarysearch;

import org.junit.Test;

import junit.framework.Assert;

public class squareroot {
	
	@Test
	public void test1() {
		int x = 2147395599;
		Assert.assertEquals(46339, squareRoot(x));
	}
	
	@Test
	public void test2() {
		int x = 8;
		Assert.assertEquals(2, squareRoot(x));
	}

	private Object squareRoot(int x) {
		if(x == 0 || x == 1) return x;
        int low = 1, high = x/2;
        while(low<=high){
            int mid = (low+high)/2;
            if(mid == x/mid) return mid;
            else if(mid > x/mid) high = mid-1;
            else low = mid+1;
        }
        return high;
	}

}
