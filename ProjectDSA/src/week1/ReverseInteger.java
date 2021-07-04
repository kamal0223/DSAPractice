package week1;

public class ReverseInteger {

	public int reverseInteger(int a) {
		/*
		 * get the last digit of the digits by traversing in a loop modulus being the
		 * last digit remainder being the remaining digit formula = previous last
		 * digit*10+last digit initiate the sum to 0
		 */
		//loop till the remainder becomes 0
		
		//if the number is single digit just print that number
		
		if(a/10==0) return a;
		
		int remainder = a;
		int sum = 0;
		while(remainder>0){
			sum = (sum*10)+(remainder%10);
			remainder = remainder/10;
		}
		
		return sum;
		
	}
	
	public static void main(String[] args) {
		
		/*
		 * 1. did I understand the problem Yes 
		 * 2. What is the input for the problem
		 * integer of 10 digits if the number of digits is only one then we can just
		 * return that value if the integer has proceeding 0 ex: 120000 
		 * 3. What is the
		 * output for the problem integer of the reverse the preceeding integers doesn't
		 * have any value ex:000021 21
		 * 
		 * 4. Test data set: 
		 * positive: a-> 1234567 
		 * Negative: -2345 
		 * edgecase: 0000
		 * 00123
		 */
		
		ReverseInteger reverse = new ReverseInteger();
		
		System.out.println(reverse.reverseInteger(123));
		
		}

}
