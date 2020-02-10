package xianxingbiao.shunxubiao;

/**
 * @Author:Star
 * @Date:Created in 19:15 2020/2/7
 * @Description:
 */
public interface Sequence {
    void add(Object data);//添加元素
    Object remove(int index);//删除元素
    Object set(int index,Object newData);//将index位置的元素替换为newData
    Object get(int index);//获得index位置的元素
    boolean contains(Object data);//判断data是否在该顺序表中
    int size();//获得顺序表的大小
    Object[] toArray();//转换为数组
    void clear();//清除
}
