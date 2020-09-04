package RQueue;

import java.util.Arrays;

/**
 * @Author:Star
 * @Date:Created in 20:12 2020/2/9
 * @Description:
 */
public class ArrayQueue<E> implements QueueImpl<E> {

    private E[] element;//数组
    private int head;//队列头
    private int tail;//队列尾
    private int queueSize;//队列大小

    public ArrayQueue(int queueSize) {
        this.element = (E[]) new Object[queueSize];
        this.queueSize = queueSize;
    }

    //入队
    @Override
    public void enqueue(E e) {
        //队列满
        if (tail == queueSize){
            //System.out.println("队列满");
            //throw new ArrayIndexOutOfBoundsException("队列已满，入队失败");
            grow(queueSize);//支持动态扩容
        }
        element[tail++] = e;
    }

    //底层数组动态扩容
    private void grow(int queueSize) {
        int oldSize = queueSize;
        int newSize = oldSize << 1;
        if((newSize+8) > Integer.MAX_VALUE){
            throw new ArrayIndexOutOfBoundsException("队列大小已超过最大阈值");
        }
        queueSize = newSize;
        element = Arrays.copyOf(element,newSize);
    }

    //出队
    @Override
    public E dequeue() {
        //队列为空
        if (head == tail){
            System.out.println("队列为空");
            throw new NullPointerException("队列为空，出队失败");
        }
        E data = element[head++];
        return data;
    }

    //返回队列头元素
    @Override
    public E peek() {
        //队列为空
        if (head == tail){
            System.out.println("队列为空");
            throw new NullPointerException("队列为空，出队失败");
        }
        E data = element[head];
        return data;
    }

    //获得队列元素个数
    @Override
    public int getSize() {
        return tail - head;
    }

    //判断队列是否为空
    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    //测试主方法
    public static void main(String[] args) {
        ArrayQueue<Integer> aq = new ArrayQueue<>(10);
        //入队
        aq.enqueue(1);
        aq.enqueue(2);
        aq.enqueue(3);
        aq.enqueue(4);
        aq.enqueue(5);
        //返回队列内元素个数
        System.out.println("队列中有"+aq.getSize()+"个元素");
        //判断队列空
        System.out.println("队列是否为空？"+aq.isEmpty());
        //出队
        System.out.println(aq.dequeue()+"出队列啦");
        System.out.println(aq.dequeue()+"出队列啦");
        //取得队列头元素
        System.out.println(aq.peek()+"是队列头元素");
    }
}