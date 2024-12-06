package com.duodian.myapplication;

public class NodeCircle {


    public Node isCircle(Node header){
        if (header==null || header.next==null){
            return null;
        }

        Node slow = header;
        Node fast = header.next;

        while (fast!=null && fast.next!=null){
            if (slow == fast){
                fast = header;
                while (fast!=slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return null;
    }

    public static class Node{
        public int var;
        public Node next;
    }





    public void test(){
        int[] array = new int[]{3,2,4,1,6};


        quickSort(array,0,array.length-1);

    }




    private void quickSort(int[] array,int low,int height){
        int base = array[low];
        int i = low;
        int j = height;


        while (i!=j){

            while (array[j]>=base && i<j){
                j--;
            }

            while (array[i]<=base && i<j){
                i++;
            }



            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;

        }

        array[low] = array[i];
        array[i] = base;

        quickSort(array,low,i);
        quickSort(array,i-1,height);
    }


}




