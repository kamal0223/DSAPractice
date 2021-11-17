package dequeue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

import junit.framework.Assert;

public class DailyTemperature {

	@Test
	public void test1() {
		int[] temperature = {73,74,75,71,69,72,76,73};
		Assert.assertTrue(Arrays.equals(new int[] {1,1,4,2,1,1,0,0}, dailyTemperature(temperature)));
	}

	//declare a queue of integer
	private int[] dailyTemperature(int[] temperature) {
		Queue<Integer> q = new PriorityQueue<>();
		
		return null;
	}
}
