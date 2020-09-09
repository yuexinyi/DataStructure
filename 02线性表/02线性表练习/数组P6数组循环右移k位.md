# 题目描述

假设要把数组序列12345678右移2位变成78123456

# 解题思路

算法步骤如下（以12345678为例）：

1）逆序数组子序列123456，数组序列的形式变为65432178;

2）逆序数组子序列78，数组序列的形式变为65432187；

3）数组全部逆序，数组序列的形式变为78123456；

# Code Show

```java
public class test4 {
    private static void reverse(int[] a,int b,int e){
        for (;b < e;b++,e--){
            int temp = a[b];
            a[b] = a[e];
            a[e] = temp;
        }
    }
    public static void shift_k(int[] a,int k){
        int n = a.length;
        k = k % n;
        reverse(a,n-k,n-1);
        reverse(a,0,n-k-1);
        reverse(a,0,n-1);
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        shift_k(array,2);
        for (int i : array){
            System.out.print(i+"、");
        }
    }
}
```

