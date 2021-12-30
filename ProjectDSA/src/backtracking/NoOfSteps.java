package backtracking;

public class NoOfSteps {
	
	
	public static int findStep(int n)
    {
        if ( n == 0)
            return 1;
        else if (n < 0)
            return 0;
      
       return findStep(n - 3) + findStep(n - 2) + findStep(n - 1);
    }
 
    // Driver function
    public static void main(String argc[])
    {
        int n = 0;
        System.out.println(findStep(n));
    }

}
