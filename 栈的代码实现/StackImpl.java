package RStack;

/**
 * @Author:Star
 * @Date:Created in 19:16 2020/2/9
 * @Description:
 */
public interface StackImpl {
    void push(Object data);//元素入栈
    Object pop();//元素出栈
    Object peek();//返回栈顶元素
    int getSize();//获得栈的大小
    boolean isEmpty();//判断栈空
}
