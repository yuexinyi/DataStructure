package xianxingbiao.shunxubiao;

/**
 * @Author:Star
 * @Date:Created in 19:58 2020/2/7
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        SequenceArray sa = new SequenceArray();
        //顺序表里添加元素
        sa.add(1);
        sa.add(2);
        sa.add(3);
        sa.add(4);
        sa.add(5);
        //查看顺序表容量大小
        System.out.println("最开始的数组容量为："+sa.size());
        //删除下标为3的元素
        System.out.println("删除下标为3的元素："+sa.remove(3));
        //将下标为1的元素设置为100
        System.out.println("修改下标为1前的元素为："+sa.set(1,100));
        //获得下标为1的元素
        System.out.println(("下标为1的元素为："+sa.get(1)));
        //查看元素5在顺序表中吗
        System.out.println("元素5在顺序表中吗？"+sa.contains(5));
        //将顺序表转换为数组
        System.out.println("顺序表转换为数组为："+sa.toArray());
    }
}