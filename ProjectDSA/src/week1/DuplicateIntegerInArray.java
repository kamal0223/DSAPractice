package week1;

public class DuplicateIntegerInArray {
	
	public int duplicateInteger(int[] array) {
		
		/*
		 * 1. initialize an int for duplicate variable 2. initialize isduplicate boolean
		 * variable to false 3. Traverse through the length of the array-1 and get
		 * pointer i 4. For each pointer i, traverse through the length of the array 5.
		 * if the array in index i and its next index are equal 6. Then set isduplicate
		 * boolean to true and return the value of that index
		 */
		
		int duplicate = 0;     //space complex o(1)
		boolean isduplicate = false;  
		//to find the duplicate 
		//using a nested for loop
		//for each element of the array
		//timecomplexity -> o(n^2)
		for(int i=0;i<array.length-1;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i]==array[j]) {
					duplicate =  array[i];
					isduplicate = true;
					return duplicate;
				}
			}
			if(isduplicate==true) break;
		}
		return duplicate;
	}

	public static void main(String[] args) {
		/*
		 * 1. did I understand the problem Yes 
		 * 2. What is the input for the problem
		 * input t1-> int[] {2,4,2,8,3}
		 * 3. what is the output for the problem 
		 * First duplicate element in an array
		 * output -> int ex:2
		 * 
		 * constraint assumtion: input is array of integers
		 * 4. Test data set: 
		 * positive: {2,4,2,8,3}
		 * Negative: {3,-1,4,5,-1}
		 * if there are no duplicates then return ;
		 */
		
		int[] i = {1,4,2,7,5,3};
		
		DuplicateIntegerInArray obj = new DuplicateIntegerInArray();
		System.out.println("duplicate integer is "+obj.duplicateInteger(i));
	}

}
