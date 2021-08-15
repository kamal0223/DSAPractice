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
    
    public Node mergeTwoList(Node l1, Node l2) {
    	//compare the node values of l1 and l2 by iterating both the nodes till node is null
        //iterating till both the nodes become null
    	Node n = new Node();
        Node newOne = n ;
           while (l1!=null && l2!=null)
           {  
               if (l1.value>l2.value)
               {
                  newOne.next = l2;
                   l2= l2.next;
               }
               else {
                    newOne.next=l1;
                   l1=l1.next;
               }
           newOne = newOne.next;     
           }
           if(l1 != null)
               newOne.next = l1;
           else if(l2 != null)
               newOne.next = l2;
        
           return n.next;
    }
    
    public Node mergeRecursively(Node l1, Node l2) {
    	Node n = new Node();
        Node newOne = n ;
    	//base condition
    	if(l1 == null) return l2;
    	else if(l2 == null) return l1;
    		
    	 if (l1.value>=l2.value)
         {
            l2.next = mergeRecursively(l1, l2.next);
            return l2;
         }
         else {
        	 l1.next = mergeRecursively(l1.next, l2);
             return l1;
         }
    }

    @Test
    public void test1() {
        Node head = addNode(1);
        head.next = addNode(2);
        head.next.next = addNode(4);
       
        Node l2 = addNode(1);
        l2.next = addNode(3);
        l2.next.next = addNode(4);
        printAllNodes(mergeRecursively(head, l2));
    }
}
