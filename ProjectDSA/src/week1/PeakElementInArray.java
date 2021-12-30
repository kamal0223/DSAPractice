package week1;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
 * 1. Do we understand problem yes 
 * a. Input - int[] array
 * b. Output int peakValue 
 * c. constraint - Do not sort the array  
 * e. Do I have all information to solve the problem
 * 		yes
 *2) Test Data Set
 *  Minimum of 3 data set !! 
 *  Positive {1,2,5,4}, 
 *  Edge {1,2,3,4,5,6} return 6
 *       {2,2,2,2,2}   return -1
 *  Negative { } throw exception
 *  Validate the data set with the interviewer 
 *
 *3) Do I know how to solver it? - yes with brute force
 *    Yes - great, Is there any alternate solution?
 *    No - Can I break down the problem to sub problems?
 *
 *4) Ask for the hint (If you don't know how to solve it)
 *
 *
 *5) Do I know alternate solution to solve this problem? 
 *		yes- brute force, Using hashmap
 *
 */

public class PeakElementInArray {
	
	@Test
	public void test1() {
		int[] input = {1,2,5,4};
		try {
			Assert.assertEquals(5, bruteForce(input));
		} catch (Exception e) {
			System.out.println("the input array cannot be empty");
		}
		
	}
	
	@Test
	public void test5() {
		int[] input = {5,4,1};
		try {
			Assert.assertEquals(5, bruteForce(input));
		} catch (Exception e) {
			System.out.println("the input array cannot be empty");
		}
		
	}
	
	@Test
	public void test2() {
		int[] input = {1,2,3,4,5,6};
		try {
			Assert.assertEquals(6, bruteForce(input));
		} catch (Exception e) {
			System.out.println("the input array cannot be empty");
		}
	}
	
	@Test
	public void test3() {
		int[] input = {2,2,2,2,2};
		try {
			System.out.println(bruteForce(input));
			Assert.assertEquals(-1, bruteForce(input));
		} catch (Exception e) {
			System.out.println("the input array cannot be empty");
		}
	}
	
	@Test(expected = Exception.class)
	public void test4() throws Exception {
		int[] input = {};
		bruteForce(input);
	}
	/*PseudoCode
	 * 1. initialize pointerone = 0
	 * 2. Traverse through the array length using i
	 * 3. create another pointertwo ans assign i+1;
	 * 4.condition if(pointerone value<iteratorValue>pointertwo value)
	 * 		return iterator value
	 * 5. else increment pointerone++
	 * 6. When iterator reaches last element, then assign value of pointertwo =0;
	 * 
	 * TimeComplexity is o[n] spacecomplexity is o[1]
	*/
	public int bruteForce(int[] array) throws Exception {
		if(array.length == 0) throw new Exception();
		
		int pointerOne = 0;  //O[1]
		for(int i=0;i<array.length;i++) {  //o[n]
			int pointerTwo;
			if(i!=array.length-1)  pointerTwo = array[i+1];
			else pointerTwo = 0;
			if(pointerOne<array[i] && array[i]>pointerTwo) {
				return array[i];
			} else {
				pointerOne = array[i];
			}
			//once iterator reaches last
		}
		return -1;
		
	}

}
