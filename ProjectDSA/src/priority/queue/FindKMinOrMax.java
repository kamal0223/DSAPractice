package priority.queue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

import org.junit.Test;

import junit.framework.Assert;

public class FindKMinOrMax { // 1 2 2 4  
	
	@Test
	public void test11() {
		int[] num = {13,7,5,4,12,8,6};
		Assert.assertEquals(12, findKMaxWithoutComparator(num,2));
	}
	
	@Test
	public void test1() {
		int[] num = {2,2,2};
		Assert.assertEquals(-1, findKMaxWithoutComparator(num,2));
	}
	
	@Test
	public void test3() {
		int[] num = {2,1,2,3};   //3 2 1 5 4  k = 2
		Assert.assertEquals(1, findKMaxWithoutComparator(num,3));
	}
	

	private int findKMin(int[] num, int k) {
		PriorityQueue<Integer> priority = new PriorityQueue<Integer>();
		for (int i = 0; i < num.length; i++) {
			if(!priority.contains(num[i])) priority.offer(num[i]);
		}
		k = k-1;
		while(k>0) {
			if(!priority.isEmpty())
			priority.poll();
			k--;
		}
		return priority.isEmpty()?-1:priority.peek();
	}
	
	private int findKMax(int[] num, int k) { //3 2 1 5 4  k = 2  
		PriorityQueue<Integer> priority = new PriorityQueue<Integer>((a,b) -> {
			return b-a;
		});
		for (int i = 0; i < num.length; i++) {
			if(!priority.contains(num[i])) priority.offer(num[i]);
		}
		k = k-1;
		while(k>0 && !priority.isEmpty()) {
			priority.poll();
			k--;
		}
		return priority.isEmpty()?-1:priority.peek();
	}
	
	private int findKMaxWithoutComparator(int[] num, int k) { //3 2 1 5 4  k = 3
		PriorityQueue<Integer> priority = new PriorityQueue<Integer>();
		//while adding to priority queue make sure the size is always equals k
		//if not then poll till it becomes k size
		for (int i = 0; i < num.length; i++) {
			if(!priority.contains(num[i])) priority.offer(num[i]);
			while(priority.size()>k) {
				priority.poll();   // 3 2 5 4
			}
		}
		return (priority.isEmpty() || priority.size()<k)?-1:priority.peek();
	}

}
