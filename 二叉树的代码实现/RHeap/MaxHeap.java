package RBinTree.RHeap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author:Star
 * @Date:Created in 20:15 2020/2/11
 * @Description:堆的实现
 */
public class MaxHeap<E> {
    private E[] element;//数组存储堆元素
    private static final int DEFAULT_CAPACITY = 10;//默认大小
    private int size;//元素个数
    private Comparator<E> comparator;//外部比较器对象

    public MaxHeap() {
        this(DEFAULT_CAPACITY);
    }

    public MaxHeap(int initialCapacity) {
        this(initialCapacity,null);
    }

    public MaxHeap(int initialCapacity,Comparator<E> comparator) {
        this.element = (E[]) new Object[initialCapacity];
        this.comparator = comparator;
    }

    //将一个数组调整为最大堆

    //取得元素个数
    public int getSize(){
        return size;
    }

    //判断堆事是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //添加元素到堆中
    public void add(E e){
        //元素个数达到数组规定长度，此时需要数组扩容
        if(size == element.length){
            grow();//扩容操作
        }
        element[size++] = e;//保存元素至堆中
        siftUp(size - 1);//调整最大堆结构
    }

    //返回堆的最大值
    public E getMax(){
        //堆为空
        if (size == 0){
            throw new IllegalArgumentException("Heap is empty");
        }
        //最大堆自然最大值在第一个
        return element[0];
    }

    //删除堆的最大值
    public E deleteMax(){
        E max = getMax();//取得最大值
        element[0] = element[size - 1];//将堆中最后一个叶子节点换为堆顶元素
        element[--size] = null;//将最后一个元素删除
        siftDown(0);//调整最大堆堆的结构
        return max;//返回删除的最大值
    }

    //将堆顶元素替换为新值
    public E replaceMax(E newValue){
        E max = getMax();//取得最大值
        element[0] = newValue;//替换为新值
        siftDown(0);//调整最大堆结构
        return max;//返回替换前的旧最大值
    }

    //获得当前节点父节点的索引下标
    private int parentIndex(int childIndex){
        //当前节点为第一个节点（根节点）
        if(childIndex == 0){
            throw new IllegalArgumentException("当前节点没有父节点");
        }
        return (childIndex-1)/2;
    }

    //获得当前节点左孩子节点的索引下标
    private int lChildIndex(int parentIndex){
        return parentIndex*2+1;
    }

    //获得当前节点右孩子节点的索引下标
    private int rChildIndex(int parentIndex){
        return parentIndex*2+2;
    }

    //数组扩容
    public void grow(){
        //获得此时数组的大小
        int oldCap = element.length;
        //新容量为旧容量的两倍
        int newCap = oldCap << 1;
        //数组容量达到最大阈值
        if(newCap > Integer.MAX_VALUE-8){
            throw new IndexOutOfBoundsException("数组容量达到阈值");
        }
        //数组拷贝，将原来旧的数组拷贝至扩容后的大数组中
        element = Arrays.copyOf(element,newCap);
    }

    //新元素入堆后重新调整堆结构
    private void siftUp(int k){
        //当新元素的值大于它的父节点值时交换两个值，并交换索引值继续向上比较
        while (k > 0 && compare(element[parentIndex(k)],element[k]) < 0){
            swapArray(k,parentIndex(k));
            k = parentIndex(k);
        }
    }

    //最大值元素出堆后重新调整堆结构
    private void siftDown(int k){
        while (lChildIndex(k) < getSize()){
            //取得当前节点的左孩子节点索引值
            int index = lChildIndex(k);
            if (index + 1 < getSize()){
                //该节点存在右孩子节点
                if (compare(element[index],element[index+1]) < 0){
                    //右孩子节点值大
                    index++;
                }
            }
            if(compare(element[k],element[index]) > 0){
                //此时父节点的值大于左右孩子节点值
                break;
            }
            //此时父节点与左右孩子的最大值交换数值
            swapArray(k,index);
            //交换当前节点索引和它的最大值孩子索引，继续向下比较
            k = index;
        }
    }

    //通过索引值进行数组元素交换
    private void swapArray(int x,int y){
        //索引值越界
        if(x < 0 || x >= size || y < 0 || y >= size){
            throw new IllegalArgumentException("交换失败");
        }
        //交换元素值
        E temp = element[x];
        element[x] = element[y];
        element[y] = temp;
    }

    //比较两个对象的大小
    private int compare(E o1,E o2){
        if (comparator != null){
            return comparator.compare(o1,o2);
        }else{
            return ((Comparable)o1).compareTo(o2);
        }
    }





}