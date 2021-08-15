package hacker.rank.test;

import java.util.ArrayList;
import java.util.List;

public class MinimumBiasRatings {
	
	public static void main(String[] args) {
		List<Integer> ratings = new ArrayList<Integer>();
		ratings.add(4);
		ratings.add(2);
		ratings.add(5);
		ratings.add(1);
		
		
		int removeProgIndex = -1;
        int sum = 0;
        while(!ratings.isEmpty()){
            int programmer1 = ratings.get(0);
            //iterate the ratings from index1 
            int prevDiff = Integer.MAX_VALUE;
            for(int i = 1;i<ratings.size();i++){
                //check if the the diff
                int currentDiff = Math.abs(programmer1-ratings.get(i));
                if(currentDiff<prevDiff){
                    prevDiff = currentDiff;
                    removeProgIndex = i;
                }
            }
            //sum all the prevDiff
            sum = sum+prevDiff;
            //remove both the programmers from list
            ratings.remove(0);
            ratings.remove(removeProgIndex-1);
        }
    System.out.println(sum);
	}

}
