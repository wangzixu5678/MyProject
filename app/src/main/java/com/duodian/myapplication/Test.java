package com.duodian.myapplication;


public class Test {
    public Node isNodeCircle(Node head){
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast!=null && fast.next!=null){

             fast = fast.next.next;
             slow = slow.next;
             if (slow == fast){
                fast = head;
                while (fast!=slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }


    public static class Node{
        public int value;
        public Node next;

    }
}
