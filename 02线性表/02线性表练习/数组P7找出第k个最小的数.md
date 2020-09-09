# 题目描述

给定一个无序的数组，从一个数组中找出第k个最小的数。

# 解题思路

方法一：排序法

对数组进行排序，排序后的数组中第k-1个位置上的数字即为数组的第k个最小的数。

时间复杂度：O(nlogn)

方法二：剪枝法

采用快速排序的思想；

一次快速排序后，基准值在其最终位置；

判断基准值的位置：

（1）小于k-1，说明第k个小的元素一定在数组的右半部分，采用递归的方法在数组的右半部分继续查找；

（2）否则，第k个小的元素在数组的左半部分，采用递归的方法在数组的左半部分继续查找；

# Code Show

```java
public class test5 {

    //方法一：排序法
    public static int getKMin1(int[] array,int k){
        Arrays.sort(array);//数组排序（Arrays.sort是基于快速排序的）
        return array[k-1];//第k个最小数就是下标为k-1的数组元素
    }

    //方法二：剪枝法
    public static int getKMin2(int[] array,int k){
        if (array.length == 0 || array.length < k){
            return Integer.MIN_VALUE;
        }
        return quickSort(array,0,array.length-1,k);
    }
    private static int quickSort(int[] array,int begin,int end,int k){
        if (begin >= end){
            return Integer.MIN_VALUE;
        }
        int index = array[begin];
        int j = begin;
        for(int i = begin+1;i < array.length;i++){
            if (array[i] < index) {
                swap(array, i, j + 1);
                j++;
            }
        }
        swap(array,begin,j);
        if(j == k){
            return array[j-1];
        }else if(j < k){
            return quickSort(array,j+1,end,k);
        }else {
            return quickSort(array,begin,j-1,k);
        }
    }
    private static void swap(int[] a,int x,int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }


    //主方法测试
    public static void main(String[] args) {
        int[] array = {1,5,2,6,8,0,6};
        //System.out.println(getKMin1(array,4));
        System.out.println(getKMin2(array,4));
    }
}
```

