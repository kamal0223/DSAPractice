package greedy.algo;

import org.junit.Test;

import junit.framework.Assert;

public class GasStation_134 {

	@Test
	public void test1() {
		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		Assert.assertEquals(3, startFromStationOpt(gas,cost));
	}

	@Test
	public void test2() {
		int[] gas = {2,3,4};
		int[] cost = {3,4,3};
		Assert.assertEquals(-1, startFromStationOpt(gas,cost));
	}

	@Test
	public void test3() {
		int[] gas = {5,8,2,8};
		int[] cost = {6,5,6,6};
		Assert.assertEquals(3, startFromStationOpt(gas,cost));
	}


	@Test
	public void test4() {
		int[] gas = {6,0,1,3,2};
		int[] cost = {4,5,2,5,5};
		Assert.assertEquals(3, startFromStationOpt(gas,cost));
	}

	//int tank = 0;
	//start from station which is g[i]-c[i] as max compared to other i say start index
	//iterate from start to again start and no of loop is <=lengh
	//i = i%5  // 3,4,0,1,2
	//tank = tank+g[i]
	//tank = tank-c[i] //3,6,4,2,0
	//check if tank is negative return -1
	//out of loop return the start


	private int startFromStation(int[] gas, int[] cost) {

		int tank = 0;
		int start = -1;
		int maxTank = Integer.MIN_VALUE;
		for(int i = 0;i<gas.length;i++){
			if(gas[i]-cost[i]>maxTank){
				maxTank = gas[i]-cost[i];
				start = i;
			}
		}
		for(int i = start;i<gas.length+start;i++){
			int idx = i%gas.length;
			tank = tank+gas[idx]-cost[idx];
			if(tank<0) return -1;
		}      
		return start;
	}

	private int startFromStationOpt(int[] gas, int[] cost) {
		int tank = 0;
		int start = -1;
		int sum = 0;
		// int maxTank = Integer.MIN_VALUE;
		for(int i = 0;i<gas.length;i++){
			int idx = i%gas.length;
			sum += gas[idx]-cost[idx]; 
			if(sum < 0){
				sum = 0;
				start = -1;
				continue;
			}else {
				if(start>=0) start = Math.min(i, start);
				else start = i;
			} 

		}
		if(start == -1) return -1;
		for(int i = start;i<gas.length+start;i++){
			int idx = i%gas.length;
			tank = tank+gas[idx]-cost[idx];
			if(tank<0) return -1;
		}      
		return start;
	}

}
