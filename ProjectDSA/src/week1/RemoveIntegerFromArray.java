package week1;

import java.util.Arrays;
import java.util.*;

import org.junit.Assert;
import org.junit.Test;

/*
 * 1. Do we understand problem yes 
 * a. Input - int[] array, int target 
 * b. Output int[] removedArray 
 * c. constraint- Remove all occurence if there are multiple
 * occurence 
 * e. Do I have all information to solve the problem
 * 
 *2) Test Data Set
 *  Minimum of 3 data set !! Positive {2,3,4,6} target 3 or {-1,2,3} target -1, 
 *  Edge {1,2,3,3,4} target 3
 *  Negative {1,2,3,4} target 5
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
 *
 *
 *
 */

public class RemoveIntegerFromArray {

	@Test
	public void test1() {
		int[] input = { 1, 2, 2, 3, 4, 5 };
		int target = 2;
		Assert.assertTrue(Arrays.equals(removeElementByOnePass(input, target), new int[] { 1, 3, 4, 5 }));
	}

	@Test
	public void test2() {
		int[] input = { 2, 2, 2, 2 };
		int target = 2;
		Assert.assertTrue(Arrays.equals(removeElementByOnePass(input, target), new int[] {}));
	}

	@Test
	public void test3() {
		int[] input = { 2, 3, 4, 2 };
		int target = 6;
		Assert.assertTrue(Arrays.equals(removeElementByOnePass(input, target), new int[] {2, 3, 4, 2}));
	}

	@Test
	public void test4() {
		int[] input = { 2, 3, 4, 2 };
		int target = 2;
		Assert.assertTrue(Arrays.equals(removeElementByOnePass(input, target), new int[] {3, 4}));
	}

	private int[] removeElementFromArray(int[] array, int target) {
		// PseudoCode for 2 pass:

		/*
		 * 1. Input: int[] array, int target 2. Output:int[] remvoedIntArray 3. Traverse
		 * through each element in the array 4. find the number of occurence of the
		 * target 5. create an array with length = input array size - number of target
		 * occurence 6. Traverse through the input array and add the not matching
		 * element in new array 7. Return the new array
		 */

		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				count++;
			}
		}
		if (count == 0)
			return array;
		int[] output = new int[array.length - count];
		count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != target) {
				output[count++] = array[i];
			}
		}
		return output;
	}

	
	//brute force one pass
	private int[] removeElementByOnePass(int[] array, int target) {
		//Pseudocode for 1 pass:
		//1 pass means using only one loop so the time complexity is O[n]
		/*
		 * 1. create two pointers- one for swap and other - iterator pointer for traversing which operates based on index
		 * 2. Traverse through the array length
		 * 3. get the count of the target if 
		 * 4. iterator pointer index is set as i and it traverses through the length
		 * 5. if swapper pointer value == target and 
		 * 		if iterator value != target then swap the value of iterator and swap pointer using temp variable
		 *   	then swap pointer index is incremented
		 *      else if iterator value == target then increment counter
		 * 7. else if swapper pointer value != target, just increment swapper index
		 * 8. create a int[] outputArray of length = lenght of input array - counter
		 * 9. 
		 * 8. return the int[] array
		 */
		int swapper = 0;   //O[1]
		int counter = 0;   //O[1]
		for(int i=0;i<array.length;i++) {   //O[n]
			if(array[swapper] == target) {
				if(array[i] != target) {
					//initialize a temp integer
					int temp = 0;
					//swap the values of swapper pointer and iterator pointer
					temp = array[swapper];
					array[swapper] = array[i];
					array[i] = temp;
					//after swappin operation, increment swap index
					swapper++;
				} else counter++;
			} else swapper++;
		}
		return Arrays.copyOf(array, array.length-counter);
	}
	
	//using map
	private Integer[] removeElementUsingMap(int[] array, int target) {
		//1. Add all the element from array to map using for loop
	    //2. add in such a way that key = index and value = arrayvalue
		//3. another for loop to check if target matches array value
		//4. if match found then remove that entry in map
		
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int mapPointer = 0;
		int counter = 0;
		for(int i=0;i<array.length;i++) {
			hm.put(mapPointer, array[i]);
			if(hm.containsValue(target)) {
				counter++;
				hm.remove(mapPointer, array[i]);
			} else mapPointer++;
		}
		Integer[] output = hm.values().toArray(new Integer[array.length-counter]);
		System.out.println(Arrays.toString(output));
		return output;
		
	}
	
}
