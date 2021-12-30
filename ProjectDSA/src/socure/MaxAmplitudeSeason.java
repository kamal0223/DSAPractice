package socure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MaxAmplitudeSeason {
	
	@Test
	public void test1() {
		int[] T = {-3,14,-5,7,8,42,8,3};
		Assert.assertEquals("SUMMER", findmaxAmplitude2(T));
		assertEquals(T, T);
	}
	
	@Test
	public void test2() {
		int[] T = {2,-3,3,1,10,8,2,5,13,-5,3,-18};
		Assert.assertEquals("AUTUMN", findmaxAmplitude2(T));
	}
	
	@Test
	public void test3() {
		int[] T = {2,0,-2,-2,0,1,0,0};
		Assert.assertEquals("WINTER", findmaxAmplitude2(T));
	}
	
	//2, 0, 1, 0
	/*
	 * declare maxAmplitude = -1001, minSeasonTemp = int max, maxSeasonTemp= int min
	 * Traverse the array from 0 to n
	 * declare startSeason = T.length/4
	 * get the minSeasonTemp and index by 
	 * 		if(currentElemen<minSeasonTemp)minSeasonTemp  = currentEle minIndex = i
	 * get the maxSeasonTemp
	 * 		if(currentElemen>maxSeasonTemp)maxSeasonTemp  = currentEle maxIndex = i
	 * check if the new season started by if index%startSeason == 0
	 * 		check if Math.abs(maxSeasonTemp-minSeasonTemp)>maxAmplitude, 
	 * 			maxAmplitude = (max-min)
	 * 			seasonIndex = minIndex/3 == maxIndex/3
	 * 		reset maxSeasonTemp = currentElement and ,minSeasonTemp = currentElem 
	 * 
	 * if(seasonIndex == 0) return Winter
	 * if(seasonIndex == 1) return Spring
	 * if(seasonIndex == 2) return Summer
	 * if (seasonIndex == 3) return Autumn
	 */
	private String findmaxAmplitude(int[] T) {
		int maxAmplitude = 0, minSeasonTemp = T[0], maxSeasonTemp = T[0];
		int startSeason = T.length/4;
		int index = 0, seasonIndex = -1;
		for (int i = 1; i < T.length; i++) {
			if(T[i]<minSeasonTemp) {
				minSeasonTemp = T[i]; 
				index = i;
			}
			if(T[i]>maxSeasonTemp) {  
				maxSeasonTemp = T[i];
				index = i;
			}
			if((i+1)%startSeason == 0 && Math.abs(maxSeasonTemp-minSeasonTemp) > maxAmplitude) {
				maxAmplitude = Math.abs(maxSeasonTemp-minSeasonTemp);
				seasonIndex = index/startSeason;
				if(i == T.length-1) break;
				minSeasonTemp = T[i+1];
				maxSeasonTemp = T[i+1];
			}
		}
		
		
		if(seasonIndex == 0) return "WINTER";
		if(seasonIndex == 1) return "SPRING";
		if(seasonIndex == 2) return "SUMMER";
		if(seasonIndex == 3) return "AUTUMN";
		return null;
	}
	
	private String findmaxAmplitude2(int[] T) {
		int seasonIndex = 0;
		int seasonSize = T.length/4;
		int maxAmplitude = 0, seasonC = -1;
		for (int i = 0; i < T.length; i+= seasonSize) {
			int maxSeasonTemp = Integer.MIN_VALUE;
			int minSeasonTemp = Integer.MAX_VALUE;
			int counter = 0;
			seasonC++;
			while(counter<seasonSize) {
				maxSeasonTemp = Math.max(maxSeasonTemp, T[i+counter]);
				minSeasonTemp = Math.min(minSeasonTemp, T[i+counter]);
				counter++;
			}
			if(Math.abs(maxSeasonTemp-minSeasonTemp)>maxAmplitude) {
				maxAmplitude = Math.abs(maxSeasonTemp-minSeasonTemp);
				seasonIndex = seasonC; 
			}
		}
		if(seasonIndex == 0) return "WINTER";
		else if(seasonIndex == 1) return "SPRING";
		else if(seasonIndex == 2) return "SUMMER";
		else return "AUTUMN";
	}

}
