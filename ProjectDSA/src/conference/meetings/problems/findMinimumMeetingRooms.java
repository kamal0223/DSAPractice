package conference.meetings.problems;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;


public class findMinimumMeetingRooms {
	
	@Test
	public void test1() {
		String[] timings = {"09 30 10 30","10 40 12 00",
				"11 00 13 00","11 45 14 00","16 00 17 00","09 00 09 45"};
		int numberOfMeetings = 6;
		Assert.assertEquals(3, findMinMeetingRooms(timings,numberOfMeetings));
	}
	
	@Test
	public void test2() {
		String[] timings = {"09 00 09 45","09 00 09 45","09 00 09 45",
				"09 00 09 45"};
		int numberOfMeetings = 4;
		Assert.assertEquals(4, findMinMeetingRooms(timings,numberOfMeetings));
	}

	/*
	 * create an 2 dimensional array of string to hold the start and endtime of each meeting
	 * declare a minRooms int
	 * iterate the timings array
	 * 	get the first half of each string as startTime
	 * 	get the second half of each string as endTime
	 * 	add each startTime in row and endtime in column
	 * sort the 2 dimensional array based on:
	 * 		first by endtime
	 * 		if endtime are same, then by starttime
	 * declare two pointers startTime = second meeting startime index, endTime = firstMeeting endtime index
	 * iterate till the startTime index reaches length
	 * 	check if endTime of meeting <= Start time of meeting
	 * 	if yes, then decrement minRoom and increment endtime index
	 * 	if no, then increment start time index
	 * 
	 * return minRoom
	 */
	private int findMinMeetingRooms(String[] timings, int numberOfMeetings) {
	
		int[][] meetings = new int[numberOfMeetings][2];
		int minRoom = numberOfMeetings;
		for (int i = 0; i < timings.length; i++) {
			//get the first half as startTime  and second half as endtime
			meetings[i][0] = Integer.parseInt(timings[i].substring(0,6).replace(" ", ""));
			meetings[i][1] = Integer.parseInt(timings[i].substring(6, 11).replace(" ", ""));
		}
		/*
	   {{"09 00", "09 45"},
		{"09 30", "10 30"},
		{"10 40", "12 00"},
		{"11 00", "13 00"},
		{"11 45", "14 00"},
		{"16 00", "17 00"}};
		*/
		
		//sort based on endtime and then by starttime
		Arrays.sort(meetings, (s1,s2)->{
			if(s1[1]!=s2[1]) return s1[1] - s2[1];
			else return s1[0] - s2[0];
		});
		
		int endTime = 0, startTime = 1;
		while (startTime<meetings.length) {
			//check if endTime of meeting <= Start time of meeting
			if(meetings[endTime][1] <= meetings[startTime][0]) {
				minRoom--;
				endTime++;
			}
			startTime++;
		}
		return minRoom;
	}

}
