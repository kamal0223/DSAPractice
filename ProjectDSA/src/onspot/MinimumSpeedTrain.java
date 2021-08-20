package onspot;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;



public class MinimumSpeedTrain {

	@Test
	public void test1() {
		int[] dist = {1,3,2};
		double hour = 6;
		Assert.assertEquals(1, minSpeedOnTimeDynamic(dist, hour));
	}

	@Test
	public void test2() {
		int[] dist = {1,3,2};
		double hour = 2.7;
		Assert.assertEquals(3, minSpeedOnTimeDynamic(dist, hour));
	}


	@Test
	public void test3() {
		int[] dist = {1,3,2};
		double hour = 1.9;
		Assert.assertEquals(-1, minSpeedOnTimeDynamic(dist, hour));
	}

	@Test
	public void test4() {
		int[] dist = {2,3,3,4,1};
		double hour = 6.7;
		Assert.assertEquals(3, minSpeedOnTimeDynamic(dist, hour));
	}

	@Test
	public void test5() {
		int[] dist = {5,3,4,6,2,2,7};
		double hour = 10.92;
		Assert.assertEquals(4, minSpeedOnTimeDynamic(dist, hour));
	}

	private int minSpeedOnTime(int[] dist, double hour) {

		//round off the hour and make it as target
		//the max speed can be 10^7
		//declare low = 1 and high = maxSpeed
		//iterate till left<=high
		//find mid of low and high
		//check if mid equals to target return mid value
		//if mid value<target, move low++
		//if mid value>target, move high--


		int maxTime = 1;
		int target = (int) Math.ceil(hour);
		maxTime = maxTime*target;

		int low = 0, high = maxTime;
		while(low<=high) {
			int mid = (low+high)/2;
			if(mid == target) return mid/target;
			else if(mid<target) low = mid+1;
			else high = mid-1;
		}
		return -1;
	}

	private int minSpeedOnTimeDynamic(int[] dist, double hour) {

		if(hour<=dist.length-1) return -1;
		int low = 1, high = 10000000;
		//iterate speed from 1 to 10^7
		int mid = 0;
		double totalHours = 0;
		while(low<=high) {
			mid = (low+high)/2;
			totalHours = 0;
			for(int j = 0;j<dist.length-1;j++){
				//divide each distance/each speed, and round off to highest giving time
				//sum all the time till n-1
				totalHours  += Math.ceil((double) dist[j]/mid);
			}
			//add the last element/each speed to the sum
			totalHours = totalHours+(double) dist[dist.length-1]/mid;
			//check if total hours is less than targeted hour
			DecimalFormat formatter = new DecimalFormat("#.#");
			//if((formatter.format(totalHours).equals(formatter.format(hour)))) return mid;
			if(totalHours<hour) high = mid-1;
			else if(totalHours>hour) low = mid+1;
			else return mid;
		}
		if(totalHours>hour) return mid+1;
		else return mid;
	}

}
