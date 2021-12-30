package flash.twopointer;

import java.awt.image.IndexColorModel;
import java.util.ArrayDeque;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/jump-game-vii/
public class JumpGame7_1871 {

	@Test
	public void test1() {
		String s = "011010";
		int minJump = 2;
		int maxJump = 3;
		Assert.assertTrue(jumpGame(s, minJump,maxJump));
	}
	
	@Test
	public void test2() {
		String s = "01101110";
		int minJump = 2;
		int maxJump = 3;
		Assert.assertFalse(jumpGame(s, minJump,maxJump));
	}

	/*using queue
	 * declare a queue of int
	 * declare an maxIndex int of 0
	 * add 0 to queue
	 * if the queue is not empty loop
	 * poll the element from queue and keep in a variable i
	 * check if i is last index yes->return true
	 * get the i+minJump as min
	 * get the i+maxJump as max
	 * declare start index as max of min and maxIndex
	 * traverse from min to max or min to length of string say index k
	 * 	check if value at K is 0
	 * 	add the value to queue
	 * get the maxIndex as max of max and maxIndex.
	 */
	
	private boolean jumpGame(String s, int minJump, int maxJump) {
		if(s.charAt(s.length()-1) == '1') return false;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		int maxIndex = 0;
		q.offer(0);
		while(!q.isEmpty()) {
			int i = q.remove();
			if(i == s.length()-1) return true;
			int min = i+minJump;
			int max = i+maxJump;
			int start = Math.max(min, maxIndex);
			for(int j = start;j<=max && j<s.length();j++) {
				if(s.charAt(j) == '0') q.offer(j);
			}
			maxIndex = Math.max(maxIndex, max);
		}
		return false;
	}
}
