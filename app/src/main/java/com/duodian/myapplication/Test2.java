package com.duodian.myapplication;

public class Test2 {



    private Node hasCircle(Node head){
        if (head==null || head.next==null){
            return null;
        }


        Node slow = head;
        Node fast = head.next;

        while (fast!=null &&fast.next!=null){
            if (fast==slow){
                fast = head;
                while (fast!=slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return null;
    }


    private static class Node{
        public int var;
        public Node next;

    }




    private void test(){
        int[] array = {3,1,5,4,2};
        quickSort(array,0,array.length-1);
    }

    private void quickSort(int[] array,int low,int high){
        int base = array[low];
        int i = low;
        int j = high;

        while (i!=j){
            if (array[i]<=base && i>j){
                i++;
            }

            if (array[j]>=base && i>j){
                j--;
            }

            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        array[low] = array[i];

        array[i] = base;

        quickSort(array,low,i);

        quickSort(array,i-1,high);

    }









    private Node reverseNodeLink(Node node){


        if (node==null || node.next ==null){
            return node;
        }


        Node pre = null;



        while (node.next!=null){
            Node next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }

        return pre;



    }


    private void test3(){
        int[] ints = {1, 2, 3, 4, 5};
        boolean b = searchTarget(ints, 1);
    }


    private boolean searchTarget(int[] array,int target){

        int start = 0;
        int end  = array.length;


        while (end>start){
            int mid = (start + end)/2;
            if (array[mid]>target){
                end = mid;
            }else if (array[mid]<target){
                start = mid;
            }else {
                return true;
            }
        }

        return false;
    }
}
