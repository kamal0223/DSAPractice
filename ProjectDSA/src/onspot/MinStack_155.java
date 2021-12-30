package onspot;

import java.util.ArrayList;

import org.junit.Test;

public class MinStack_155 {
	
	@Test
	public void test1() {
		MinStack obj = new MinStack();
		obj.push(-2);
		obj.push(-3);
		obj.push(0);
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.top());
		System.out.println(obj.getMin());
	}
	
	/** initialize your data structure here. */
    int[] arr;
    int i;
    public MinStack_155() {
        arr = new int[30000];
        i = 0;
    }
    
    public void push(int val) {
        arr[i] = val;
		i++;
    }
    
    public void pop() {
        i--;
        arr[i] = 0;
    }
    
    public int top() {
        return arr[i-1];
    }
    
    public int getMin() {
        //iterate in reverse
        int minCounter = i-1;
        int min = Integer.MAX_VALUE;
        while(minCounter>=0){
          min = Math.min(min, arr[minCounter--]);
        }
        return min;
    }

}

class MinStack {

    ArrayList<Integer> ans;
    ArrayList<Integer> min;
    public MinStack() {
        ans=new ArrayList<>();
        min=new ArrayList<>();
    }
    
    public void push(int x) {
        ans.add(x);
        if(min.size()==0)
            min.add(x);
        else
            min.add(Math.min(min.get(min.size()-1),x));
    }
    
    public void pop() {
        ans.remove(ans.size()-1);
        min.remove(min.size()-1);
    }
    
    public int top() {
        return ans.get(ans.size()-1);
    }
    
    public int getMin() {
        return min.get(ans.size()-1);
    }
}
