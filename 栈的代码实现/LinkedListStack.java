package RStack;

/**
 * @Author:Star
 * @Date:Created in 19:37 2020/2/9
 * @Description:
 */
public class LinkedListStack implements StackImpl {

    //节点类
    public class Node{
        private Object data;
        private Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node top = null;//栈顶
    private int NodeSize;//栈大小

    //入栈
    @Override
    public void push(Object data) {
        Node newNode = new Node(data,null);
        if(top == null){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
        NodeSize++;
    }

    //出栈
    @Override
    public Object pop() {
        if(top == null){
            return null;
        }
        Object value = top.data;
        top = top.next;
        NodeSize--;
        return value;
    }

    //获得栈顶元素
    @Override
    public Object peek() {
        return top.data;
    }

    //获得栈大小
    @Override
    public int getSize() {
        return NodeSize;
    }

    //判断栈空
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    //测试主方法
    public static void main(String[] args) {
        LinkedListStack ls = new LinkedListStack();
        //入栈
        ls.push(1);
        ls.push(2);
        ls.push(3);
        ls.push(4);
        ls.push(5);
        //返回栈内元素个数
        System.out.println("栈中有"+ls.getSize()+"个元素");
        //判断栈空
        System.out.println("栈是否为空？"+ls.isEmpty());
        //出栈
        System.out.println(ls.pop()+"出栈啦");
        System.out.println(ls.pop()+"出栈啦");
        //取得栈顶元素3
        System.out.println(ls.peek()+"是栈顶元素");
    }
}