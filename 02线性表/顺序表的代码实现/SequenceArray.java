package xianxingbiao.shunxubiao;

import java.util.Arrays;

/**
 * @Author:Star
 * @Date:Created in 19:19 2020/2/7
 * @Description:
 */
public class SequenceArray implements Sequence{

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elementData;
    private static final int MAX_CAPACITY = Integer.MAX_VALUE-8;

    public SequenceArray() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(Object data) {
        ensureCapacity(size+1);
        elementData[size++] = data;
    }

    @Override
    public Object remove(int index) {
        rangeCheck(index);
        Object moveData = elementData[index];
        int moveSize = size - index -1;
        if(moveSize > 0){
            System.arraycopy(elementData,index+1,elementData,index,moveSize);
        }
        elementData[--size] = null;
        return moveData;
    }


    @Override
    public Object set(int index, Object newData) {
        rangeCheck(index);
        Object oldData = elementData[index];
        elementData[index] = newData;
        return oldData;
    }

    @Override
    public Object get(int index) {
        rangeCheck(index);
        Object data = elementData[index];
        return data;
    }

    @Override
    public boolean contains(Object data) {
        if(data == null){
            for(int i = 0;i < size;i++){
                if (elementData[i] == null){
                    return true;
                }
            }
        }else{
            for(int i = 0;i < size;i++){
                if (elementData[i].equals(data)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData,size);
    }

    @Override
    public void clear() {
        for(int i = 0;i < size;i++){
            elementData[i] = null;
        }
        this.size = 0;
    }

    //确保容量，容量不够增长
    private void ensureCapacity(int minCapacity) {
        if(minCapacity - elementData.length > 0){
            grow(minCapacity);
        }
    }

    //顺序表大小增长
    private void grow(int minCapacity) {
        int oldCap = elementData.length;
        int newCap = oldCap << 1;
        if (newCap - minCapacity < 0){
            newCap = minCapacity;
        }
        if (newCap > MAX_CAPACITY){
            throw new ArrayIndexOutOfBoundsException("数组最大容量");
        }
        elementData = Arrays.copyOf(elementData,newCap);
    }

    //检查index是否存在
    private void rangeCheck(int index) {
        if(index >= size){
            throw new IndexOutOfBoundsException("下标不存在");
        }
    }

}