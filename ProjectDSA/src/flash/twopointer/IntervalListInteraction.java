package flash.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class IntervalListInteraction {
	
	@Test
	public void test1() {
		int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
		int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};
		Assert.assertTrue(Arrays.deepEquals(new int[][] {{1,2},{5,5},{8,10},{15,23},{24,24},{25,25}}, intervalInteraction(firstList,secondList)));
	}

	private int[][] intervalInteraction(int[][] firstList, int[][] secondList) {
		 //declare two pointers i for list1 row and j for list2 row
        //loop till i and j reaches both reaches end
        //check if the start of firstlist<=end of second list and end of firstList>=start of secondlist
        //yes-> then get max of start[i], start[j] 
        //      get min of end[i], end[j]
        //      add it as a array to output list
        //check if the end of first list> end of second list then increment j
        //if end of first list< end of second lsit then incrment i
        
        int i = 0, j = 0;
        List<int[]> output = new ArrayList<int[]>();
        while(i < firstList.length && j < secondList.length){
                if(firstList[i][0]<=secondList[j][1] && secondList[j][0]<=firstList[i][1]){
                    output.add(new int[] {Math.max(firstList[i][0],secondList[j][0]), Math.min(firstList[i][1],secondList[j][1])});
                }  
            if(secondList[j][1]<firstList[i][1]) j++;
            else i++;
        }  
        
        return output.toArray(new int[output.size()][2]);
	}

}
