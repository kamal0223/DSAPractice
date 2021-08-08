package LinkedList;

import org.junit.Test;

/*
 * 
 * linkedList1: 1,3,5
 * linkedList2: 2,4,6
 * 
 * currentNode1 is of linked list 1
 * currentNode2 is of linked list 2
 * currentNode1.value<currentNode2.value


*/
public class MergeTwoLinkedList {
	
	public class Node{
        int value;
        Node next;
        Node(int key){
            this.value = key;
            next = null;
        }

        Node(){
            next = null;
        }
    }
    public Node addNode(int key) {
        return new Node(key);
    }


    public void printAllNodes(Node node) {
        while(node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public Node printOddNodes(Node node) {
        Node oddNode = new Node();
        Node current = oddNode;


        while(node != null) {
            current.next = node;
            node = node.next.next;
            if(node!= null)
            current = current.next;

           /* if(node.next == null)
                break;
            node = node.next.next;*/


        }
        return oddNode.next;
    }

    public void reverseNode(Node node) {
       Node currentNode = node;
       Node prevNode = null;
       Node nextNode = null;
       while(node!=null) {
    	   prevNode = node.next;  //2 3 4
    	   currentNode.next = nextNode;  //null
    	   
    	   
    	   
       }
    }

    @Test
    public void test1() {
        Node head = addNode(1);
        head.next = addNode(2);
        head.next.next = addNode(3);
        head.next.next.next = addNode(4);
        printAllNodes(head);
    }
}
