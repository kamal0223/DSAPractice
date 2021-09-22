package flash.twopointer;

import org.junit.Test;

import junit.framework.Assert;

public class MinTimeVisitingAllPoints {
	
	@Test
	public void test1() {
		int[][] points = {{1,1},{3,4},{-1,0}};
		Assert.assertEquals(7, minVisitingTime(points));
	}
	
	@Test
	public void test2() {
		int[][] points = {{3,0},{0,2}};
		Assert.assertEquals(5, minVisitingTime(points));
	}
	
	@Test
	public void test3() {
		int[][] points = {{-2,0},{2,0}};
		Assert.assertEquals(4, minVisitingTime(points));
	}

	private int minVisitingTime(int[][] points) {
		//start time - 8.40pm
		//end time - 8.55pm
        //the abs value of x1-x2 
        //get the abs value of y1-y2
        //max of above abs values gives the answer
		
		int minTime = 0;
        for(int i = 0;i<points.length-1;i++){
            //get the 0th element in i - get the 0th element in i+1
        
        minTime +=  Math.max(Math.abs(points[i][0] - points[i+1][0]), Math.abs(points[i][1] - points[i+1][1]));
        }
        return minTime;
	}
}
