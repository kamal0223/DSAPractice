package conference.meetings.problems;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
 * Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, 
return the earliest time slot that works for both of them and is of duration duration.
If there is no common time slot that satisfies the requirements, return an empty array.
The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.
It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time 
slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.
 */
public class AvailableIntersectingSlot {
	
	@Test
	public void test1() {
		int[][] slot1= {{10,50},{60,120},{140,210}};
		int[][] slot2= {{0,15},{60,70}};
		int duration = 8;
		Assert.assertTrue(Arrays.equals(new int[] {60,68}, findIntersectionTimeSlot(slot1,slot2,duration)));
	}

	@Test
	public void test2() {
		int[][] slot1= {{10,50},{60,120},{140,210}};
		int[][] slot2= {{0,15},{60,70}};
		int duration = 12;
		Assert.assertTrue(Arrays.equals(new int[] {}, findIntersectionTimeSlot(slot1,slot2,duration)));
	}
	
	/*
	 * declare a output array of size 2
	 * sort the p1 array 
	   sort the p2 array 
	   declare two pointers p1 pointing to 0 (indicates row)
	    		   pointer p2 pointing to 0 (indicates row)

	   iterate till any p1Pointer and p2Pointer reaches end
   		check if endTime of p1<starTime of p2
  			yes increment p1 and stay in p2
  			no check if startTime of p1>endTime of p2
 				yes,stay in p1 and increment p2 row
  				no, intersection found
				intersect = min of p1 end and p2 end-min of p1 start and p2 start
				if intersection >=duration return min of p1 start and p2 start+duration

		return the output array
	 */

	private int[] findIntersectionTimeSlot(int[][] slot1, int[][] slot2, int duration) {
		int[] output = new int[2];
		//sort the slot1
		Arrays.sort(slot1, (a,b)->{
			if(a[1]!=b[1]) return a[1]-b[1];
			else return a[0]-b[0];
		});
		//sort the slot2
		Arrays.sort(slot2, (a,b)->{
			if(a[1]!=b[1]) return a[1]-b[1];
			else return a[0]-b[0];
		});
		//declare two pointers to denote the rows
		int p1Pointer = 0, p2Pointer = 0;
		while(p1Pointer<slot1.length && p2Pointer<slot2.length) {
			if(slot1[p1Pointer][1] < slot2[p2Pointer][0]) p1Pointer++;
			else if(slot1[p1Pointer][0] > slot2[p2Pointer][1]) {
				p2Pointer++;
			}else {
				int maxStart = Math.max(slot1[p1Pointer][0], slot2[p2Pointer][0]);
				int minEnd = Math.min(slot1[p1Pointer][1], slot2[p2Pointer][1]);
				int intersect = minEnd - maxStart;
				if(intersect>=duration) {
					output[0] = maxStart;
					output[1] = maxStart+duration;
					return output;
				}else {
					if(slot1[p1Pointer][1]>slot2[p2Pointer][1]) p2Pointer++;
					else p1Pointer++;
				}
			}
		}
		return new int[0];
	}
}
