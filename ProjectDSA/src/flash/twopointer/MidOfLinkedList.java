package flash.twopointer;

import org.junit.Test;

import LinkedList.CountNodeLinkedList.ListNode;

//https://leetcode.com/problems/middle-of-the-linked-list/
public class MidOfLinkedList {
	
	@Test
	public void test1() {
		ListNode head = new ListNode(11);
        head.next = new ListNode(21);
        head.next.next = new ListNode(23);
        head.next.next.next = new ListNode(40);
        printAllNodes(middleNode(head));
	}
	
	@Test
	public void test2() {
		ListNode head = new ListNode(1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(7);
        System.out.println();
        printAllNodes(middleNode(head));
	}

	private void printAllNodes(ListNode head) {
		while(head!=null) {
			System.out.println(head.val);
			head = head.next;
		}
		
	}

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	
	public ListNode middleNode(ListNode head) {
        //to find the mid node for odd number of list
        //to find mid+1 node for even number of list
        //create two pointers right as head and left as head
        //right is the fast pointer
        //iterate till right.next becomes null
        //mid = get the value at right /2 and add 1 
        //move left till it reaches mid value
        //return left
        
        ListNode left = head;
        ListNode right = head;
        int leftIndex = 1;
        int rightIndex = 1;
        while(right != null){
            int mid = (rightIndex)/2+1;
            while(leftIndex < mid) {
                left = left.next;
                leftIndex++;
            }
            right = right.next;
            rightIndex++;
        }
        
        return left;
    }
}
