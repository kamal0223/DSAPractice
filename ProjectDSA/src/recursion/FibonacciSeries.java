package recursion;

import org.junit.Test;

import junit.framework.Assert;

/*
 * 1,1,2,3,5,8...
 * Base case fibonacci(1)-> return 1
 * Play with positive test case. Negative numbers return 0
 * Hard cases to simple case
 * fib(n-1)+fibonacci(n-2)
 * implement
 */


public class FibonacciSeries {
	
	
	@Test
	public void test1() {
		int n = 6;
		Assert.assertEquals(8, finbonacciSeries(n));
		
	}
	
	@Test
	public void test2() {
		int n = 2;
		Assert.assertEquals(1, finbonacciSeries(n));
		
	}

	@Test
	public void test3() {
		int n = 0;
		Assert.assertEquals(0, finbonacciSeries(n));
		
	}

	private int finbonacciSeries(int n) {
		//edge and negative case
		if(n<=0) return 0;
		//Base case
		if(n == 1) return 1;
		int fib =finbonacciSeries(n-1)+finbonacciSeries(n-2);
		return fib;
	}

}
