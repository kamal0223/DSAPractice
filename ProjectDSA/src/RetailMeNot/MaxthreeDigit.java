package RetailMeNot;

import java.util.Random;

import org.junit.Test;

import junit.framework.Assert;

public class MaxthreeDigit {
	
	
	@Test
	public void test1() {
		int N = 512;
		int K = 10;
		Assert.assertEquals(972, maxThreeDigitOptimized(N,K));
	}
	
	@Test
	public void test2() {
		int N = 191;
		int K = 4;  //2
		Assert.assertEquals(591, maxThreeDigitOptimized(N,K));
	}
	
	@Test
	public void test3() {
		int N = 998;
		int K = 3;
		Assert.assertEquals(999, maxThreeDigitOptimized(N,K));
	}
	
	@Test
	public void test4() {
		int N = 285;
		int K = 20;
		Assert.assertEquals(999, maxThreeDigitOptimized(N,K));
	}
	
	
	/*
	 * iterate till k ! = 0 or last digit is exhausted
	 * Get the first digit of number
	 * check if the first digit is 9-firstDigit < K  //4<10
	 * yes-> make firstDigit as 9 and make k = K - (9-firstDigit)
	 * no-> make firstDigit as firstDigit+k and make k = 0 
	 */
	private int maxThreeDigit(int N, int K) {
		
		String s = "";
		int i = 2;
		while(K != 0 || N != 0) {
			//get the each digit from N
				int divider = (int) Math.pow(10, i);
				int eachDigit = N/divider;
				int nextInt = rand.nextInt()+1;
				N = N%divider;  //0
				if(9-eachDigit < K) {
					eachDigit = 9;
					K = K - (9-eachDigit);
				}else {
					eachDigit = eachDigit+K;
					K = 0;
				}
				s += String.valueOf(eachDigit);  //920
				i--;
		}
		
		//convert s to int		
		return Integer.parseInt(s);
		
	}

	private int maxThreeDigitOptimized(int N, int K) {
		String num = String.valueOf(N);
		String s = "";
		//iterate and get each char of num
		for (int i = 0; i < num.length(); i++) {
			int eachDigit = Integer.parseInt(num.charAt(i)+"");
			int temp = 9-eachDigit;
			if(temp < K) {
				eachDigit = 9;
				K = K - temp;  //2
			}else {
				eachDigit = eachDigit+K;  //0+2
				K = 0;
			}
			s += String.valueOf(eachDigit);  //9
		}
		return Integer.parseInt(s);
	}
	
	public int[] solution(int N) {
        //create an array from 1 to N
        int[] input = new int[N];
        //generate a random number
        Random rand = new Random();
        
        for(int i = 0;i<input.length;i++){
          //Generates Randome number from 1 to 10000
          int temp =   rand.nextInt(999)+1;
            input[i] = temp;
        }
        return input;

    }
}
