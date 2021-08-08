package recursion;

import java.util.Arrays;

import org.junit.Test;

import LinkedList.CountNodeLinkedList.ListNode;
import junit.framework.Assert;

//https://leetcode.com/problems/remove-linked-list-elements/
public class RemoveTargetSingleyLinkedList {
	
	public class ListNode {
		 int val;
		 ListNode next;
		 
		 ListNode() {
		 }
		 
		 ListNode(int val) { 
			 this.val = val; 
			 }
		 
		 ListNode(int val, ListNode next) {
			 this.val = val; 
			 this.next = next; 
			 }
	}
	
	@Test
	public void test1() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(6);
		
		int target = 6;
		printAllNode(removeRecursively(head, target));
		System.out.println();
	}
	
	@Test
	public void test2() {
		ListNode head = new ListNode();
		int target = 6;
		printAllNode(removeRecursively(head, target));
		System.out.println();
	}
	
	@Test
	public void test3() {
		ListNode head = new ListNode(7);
		head.next = new ListNode(7);
		head.next.next = new ListNode(7);
		head.next.next.next = new ListNode(7);
		int target = 7;
		printAllNode(removeRecursively(head, target));
		System.out.println();
	}
	
	private ListNode removeTarget(ListNode head, int val) {
		//iterate till head == null
		//check if the value of each node is equal to target
		//remove that node
		//decrement the list from top
	        ListNode removedHead = new ListNode();
			removedHead.next = head;
			ListNode prev = removedHead, current = head;
			
			while(current!=null) {
				if (current.val == val) prev.next = current.next;
					prev = current;
					current = current.next;
			}
			return removedHead.next;
	}
	
	private ListNode removeRecursively(ListNode head, int val) {
		//base case
		if(head == null) return null;
        ListNode result = removeRecursively(head.next,val);
        if(head.val == val){
            return result;
        }
        else head.next = result;
        return head;
	}
	
	public void printAllNode(ListNode head) {
		//iterate till head == null
		//get the value each node
		//decrement the list from top
		while (head!=null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}
