package flash.twopointer;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {

	@Test
	public void test1() {
		int[]  height = {1,8,6,2,5,4,8,3,7};
		Assert.assertEquals(49, containerWithMostWater(height));
	}
	
	@Test
	public void test2() {
		int[]  height = {1,1};
		Assert.assertEquals(1, containerWithMostWater(height));
	}
	
	@Test
	public void test3() {
		int[]  height = {4,9,2,9,4};
		Assert.assertEquals(49, containerWithMostWater(height));
	}
	
	//start time - 10.30 end time - 11.05
    //if height of left or right value is 0 then move to next
    //get the min of leftValue and righValue
    //get the distance between left and right index R-L
    //waterContained = multiple the distance* minValue
    //get max of watercontained by comparing with previousMax

	private int containerWithMostWater(int[] height) {
		int waterContained = 0;
        int left = 0, right = height.length-1;
        while(left<right){
             
            int currentContainer = (right-left) * Math.min(height[left],height[right]);
            if(currentContainer>waterContained) waterContained = currentContainer;
            if(height[left]<height[right]) left++;
            else if(height[left]>height[right]) right--;
            else {
                left++;
                right--;
            }
        }
        return waterContained;
	}
}
