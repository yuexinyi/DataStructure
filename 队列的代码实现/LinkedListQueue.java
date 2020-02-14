package RQueue;

import RStack.LinkedListStack;

/**
 * @Author:Star
 * @Date:Created in 20:27 2020/2/9
 * @Description:
 */
public class LinkedListQueue<E> implements QueueImpl {

    //节点类
    public class Node{
        private E data;//元素
        private Node next;//引用

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head = null;//队首指针
    private Node tail = null;//队尾指针
    private int Size;

    @Override
    public void enqueue(Object o) {
        //队列空
        if (tail == head){
            Node newNode = new Node((E) o,null);
            head = newNode;
            tail = newNode;
        }else{
            tail.next = new Node((E) o,null);
            tail = tail.next;
        }
        Size++;
    }

    @Override
    public Object dequeue() {
        //队空
        if (head == null){
            return null;
        }
        E e = head.data;
        head = head.next;
        if (head == null){
            tail = null;
        }
        Size--;
        return e;
    }

    @Override
    public Object peek() {
        //队空
        if (head == null){
            return null;
        }
        E e = head.data;
        return e;
    }

    @Override
    public int getSize() {
        return Size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    //测试主方法
    public static void main(String[] args) {
        LinkedListQueue<Integer> lq = new LinkedListQueue<>();
        //入队
        lq.enqueue(1);
        lq.enqueue(2);
        lq.enqueue(3);
        lq.enqueue(4);
        lq.enqueue(5);
        //返回队列内元素个数
        System.out.println("队列中有"+lq.getSize()+"个元素");
        //判断队列空
        System.out.println("队列是否为空？"+lq.isEmpty());
        //出队
        System.out.println(lq.dequeue()+"出队列啦");
        System.out.println(lq.dequeue()+"出队列啦");
        //取得队列头元素
        System.out.println(lq.peek()+"是队列头元素");
    }
}