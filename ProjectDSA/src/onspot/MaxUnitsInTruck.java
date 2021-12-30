package onspot;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

numberOfBoxesi is the number of boxes of type i.
numberOfUnitsPerBoxi is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.

Return the maximum total number of units that can be put on the truck.


Input: 2D array of int[] and trucksize of int
Approaches: brute force
 */
public class MaxUnitsInTruck {
	
	@Test
	public void test1() {
		int[][] input = {{1,3},{2,2},{3,1}};
		int truckSize = 4;
		Assert.assertEquals(8, maxUnitsTruck(input,truckSize));
	}
	
	@Test
	public void test2() {
		int[][] input = {{6,4},{6,4},{6,4}};
		int truckSize = 3;
		Assert.assertEquals(12, maxUnitsTruck(input,truckSize));
	}
	
	@Test
	public void test3() {
		int[][] input = {{1,5}, {1,3}};
		int truckSize = 3;
		Assert.assertEquals(8, maxUnitsTruck(input,truckSize));
	}
	
	@Test
	public void tes4() {
		int[][] input = {{4,5}, {4,3}};
		int truckSize = 5;
		Assert.assertEquals(23, maxUnitsTruck(input,truckSize));
	}

	/*brute force
	 * Each row of the 2d array contains only 2 column
	 * first column is number of boxes and second is number of units
	 * find the row that has max number of units
	 * declare a int of maxUnits
	 * declare a boxSum
	 * sort the array in descending order using compartor based on the second column
	 * iterate the array rows till length
	 *    check if the trucksize>=boxSum first column
	 *    	Get the sum of number of boxes and update the boxSum with previous
	 *    	yes-> multiple the i and j of the row and add to maxUnits
	 *    
	 * return maxUnits
	 */
	
	private int maxUnitsTruck(int[][] input, int truckSize) {
	
		int maxUnits = 0;
		
		Arrays.sort(input, (a,b)->{
			return b[1]-a[1];
		});
		int boxSum = input[0][0];
		for(int i = 0;i<input.length;i++) {
			if(truckSize>=boxSum) {
				maxUnits += input[i][1]*input[i][0];
				if(i != 0) boxSum += input[i][0];
				truckSize = truckSize-boxSum;
			}
		}
		
		return maxUnits;
	}

}
