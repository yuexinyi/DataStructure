package RQueue;

/**
 * @Author:Star
 * @Date:Created in 20:10 2020/2/9
 * @Description:
 */
public interface QueueImpl<E> {
    void enqueue(E e);//入队
    E dequeue();//出队
    E peek();//返回队列元素
    int getSize();//获得队列大小
    boolean isEmpty();//判断队列是否为空
}
