package RStack;

import java.util.Arrays;

/**
 * @Author:Star
 * @Date:Created in 19:18 2020/2/9
 * @Description:
 */
public class ArrayStack implements StackImpl{

    private Object[] element;//数组
    private int EleSize;//栈中元素个数
    private int StackSize;//栈大小

    //创建一个大小为stacksize的数组
    public ArrayStack(int stackSize) {
        this.element = new Object[stackSize];
        this.StackSize = stackSize;
        this.EleSize = 0;
    }

    //入栈
    @Override
    public void push(Object data) {
        //数组空间不够，入栈失败
        if(EleSize == StackSize){
            //System.out.println("空间不够，入栈失败");
            grow(StackSize);//支持动态扩容
        }
        element[EleSize] = data;
        EleSize++;
    }

    //元素出栈
    @Override
    public Object pop() {
        //栈空，返回null
        if(StackSize == 0){
            return null;
        }
        Object popData = element[EleSize - 1];
        EleSize--;
        return popData;
    }

    //返回栈顶元素
    @Override
    public Object peek() {
        //栈空，返回null
        if(StackSize == 0){
            return null;
        }
        Object popData = element[EleSize - 1];
        return popData;
    }

    //返回栈中元素个数
    @Override
    public int getSize() {
        return EleSize;
    }

    //判断栈是否为空
    @Override
    public boolean isEmpty() {
        return EleSize == 0;
    }

    //动态扩容
    public void grow(int StackSize){
        int oldStackSize = StackSize;
        int newStackSize = oldStackSize << 1;//栈大小扩大两倍
        //栈大小超过int最大值
        if((newStackSize+8) > Integer.MAX_VALUE){
            throw new ArrayIndexOutOfBoundsException("栈大小已超过最大阈值");
        }
        //数组扩容
        StackSize = newStackSize;
        element = Arrays.copyOf(element,newStackSize);
    }

    //测试代码
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        //入栈
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        //返回栈内元素个数
        System.out.println("栈中有"+arrayStack.getSize()+"个元素");
        //判断栈空
        System.out.println("栈是否为空？"+arrayStack.isEmpty());
        //出栈
        System.out.println(arrayStack.pop()+"出栈啦");
        System.out.println(arrayStack.pop()+"出栈啦");
        //取得栈顶元素3
        System.out.println(arrayStack.peek()+"是栈顶元素");
    }
}