package flash.twopointers;

import java.util.Arrays;

import org.junit.Test;

//https://leetcode.com/problems/flipping-an-image/
public class FlippingAnImage {

	@Test
	public void test1() {
		int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
		System.out.println(Arrays.deepToString(flippingAnImage(image)));
	}


	@Test
	public void test2() {
		int[][] image = {{1}};
		System.out.println(Arrays.deepToString(flippingAnImage(image)));
	}


	/*
	 * declare an output 2d array of input array size
	 * traverse the rows of image from 0 to length say i
	 *  traverse the rows from end to 0 say j
	 *  check if the image of i and j is 0 then add 1 to output of i and n-1-j
	 *  if image of i and j is 1 then add 0 to output
	 *  return output
	 */
	private int[][] flippingAnImage(int[][] image) {

		int n = image.length;
		int[][] output = new int[n][n];
		for (int i = 0; i < image.length; i++) {
			for(int j = n-1;j>=0;j--) {
				if(image[i][j] == 0) output[i][(n-1)-j] = 1;
				else output[i][(n-1)-j] = 0;  //2-2, 2-1, 2-0
			}
		}

		return output;
	}

	//two pointers used in while reversing/flipping 
	private int[][] flippingAnImageOptimized(int[][] image) {

		int n = image.length;
		for (int i = 0; i < image.length; i++) {
			int left = 0, right = n-1;
			while(left<=right) {
				//swap the left and right
                if(left != right){
				int temp = image[i][left];
				image[i][left] = image[i][right]==0?1:0;
				image[i][right] = temp==0?1:0;
                }else image[i][left] = image[i][left]==0?1:0;
                left++;
				right--;
			}
		}
		return image;
	}
}
