package recursion;

import java.util.Arrays;

import org.junit.Test;

import LinkedList.CountNodeLinkedList.ListNode;
import junit.framework.Assert;

//https://leetcode.com/problems/remove-linked-list-elements/
public class ReverseSingleyLinkedList {
	
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
		printAllNode(reverseRecursively2(head));
		System.out.println();
	}
	
	@Test
	public void test2() {
		ListNode head = new ListNode();
		printAllNode(reverseRecursively2(head));
		System.out.println();
	}
	
	@Test
	public void test3() {
		ListNode head = new ListNode(7);
		head.next = new ListNode(7);
		head.next.next = new ListNode(7);
		head.next.next.next = new ListNode(7);
		printAllNode(reverseRecursively2(head));
		System.out.println();
	}

	private ListNode reverseRecursively(ListNode head, ListNode result) {
		//base case
		if(head == null) return result;
		ListNode next = head.next;     //all nodes except first
		head.next = result;    //current holds only theh first node
		result = head;         //result holds only the first node
		head = next;           //current holds all nodes except first
        return reverseRecursively(head,result);
	}
	
	private ListNode reverseRecursively2(ListNode head) {
		//base case
		if(head == null || head.next == null) return head;
		ListNode next = reverseRecursively2(head.next);
		head.next.next = head;
		head.next = null;
		return next;
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
