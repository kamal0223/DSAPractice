package conference.meetings.problems;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
 * Given an array of meeting time intervals where intervals[i] = [starti, endi], 
 * determine if a person could attend all meetings.
 */
public class CanAttendAllMeetings {

	@Test
	public void test1() {
		int[][] intervals = {{0,30},{5,10},{15,20}};
		Assert.assertFalse(isAllMeetingsAttended(intervals));
	}
	
	@Test
	public void test2() {
		int[][] intervals = {{7,10},{2,4}};
		Assert.assertTrue(isAllMeetingsAttended(intervals));
	}

	/*
	 * Given the start and end time of meetings in 2 dimensional array intervals {start,end}
	 * sort the intervals array such a way first by endtime and if endtimes match then by starttime
	 * declare two pointers start to 1 and end to 0
	 * iterate the array till the start reaches end
	 * 	check if the endTime at endpointer < = startTime at startpointer
	 * 	if yes, move end pointer
	 * 	if no, return false
	 * 	always move the start pointer
	 * return true
	 */
	private boolean isAllMeetingsAttended(int[][] intervals) {
		
		Arrays.sort(intervals, (a,b)->{
			if(a[1]!=b[1]) {
				return a[1]>b[1]?1:-1;
			}
			else {
				return a[0]>b[0]?1:-1;
			}
		});
		int start = 1,end = 0;
		while(start<intervals.length) {
			if(intervals[end][1]<=intervals[start][0]) end++;
			else return false;
			start++;
		}
		
		return true;
	}
	
}
