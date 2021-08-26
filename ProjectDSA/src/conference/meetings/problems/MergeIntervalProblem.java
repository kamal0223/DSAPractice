package conference.meetings.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MergeIntervalProblem {
	
	@Test
    public void test1(){
        int[][] intervals = {{1,3},{2,4},{6,9}};
        System.out.println(Arrays.deepToString(mergeIntervals(intervals)));
    }

    @Test
    public void test2(){
        int[][] intervals = {{1,3},{4,5},{6,9}};
        System.out.println(Arrays.deepToString(mergeIntervals(intervals)));
    }

    
    /*
     * sort the intervals by starttime
     * declare a output list of int[]
     * add the first interval to list
     * iterate the interval from index 1 to length
     * 	check if end interval of last element in output >= start interval of current
     * 	yes->overlapping, update the output last elements end interval -> max of end time of current, output last element
     * 		 also add the updated value to the same position in output
     * 	no-> then add the current int[]  to output list
     * 
     * convert list of int[]  to 2d int using toArray
     * return the 2d array
     */
    
	private int[][] mergeIntervals(int[][] intervals) {
		List<int[]> output = new ArrayList<int[]>();
		//sort the interval
		Arrays.sort(intervals, (a,b)->{
			return a[0]-b[0];
		});
		output.add(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			int lastEle = output.size()-1;
			if((output.get(lastEle))[1] >= intervals[i][0]) {
				(output.get(lastEle))[1] = Math.max(intervals[i][1], (output.get(lastEle))[1]);
			}else {
				output.add(intervals[i]);
			}
		}
		//convert the list of int[] to int[][]
		int[][] result = output.toArray(new int[0][2]);
		return result;
	}


}
