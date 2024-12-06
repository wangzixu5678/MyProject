package com.duodian.myapplication;

public class Test4 {


    private static volatile Test4 test4;

    private Test4(){

    }


    public static Test4 newInstance(){
        if (test4==null){
            synchronized (Test4.class){
                if (test4==null){
                    test4 = new Test4();
                }
            }
        }
        return test4;
    }


    public void test(){


    }

    //二维数组 横竖单调递增 给定一个值 查询是否在二维数组中


//    [1 2 3]
//    [4 5 6]
//    [7 8 9]
    public boolean searchTargetNum(int[][] nums,int target){

        for (int[] num : nums) {
            int low = 0;
            int high = num.length - 1;

            while (low != high) {
                int mid = num.length / 2;

                if (num[mid] > target) {
                    high = mid;
                } else if (num[mid] < target) {
                    low = mid;
                } else {
                    return true;
                }
            }
        }

        return false;


    }


}
