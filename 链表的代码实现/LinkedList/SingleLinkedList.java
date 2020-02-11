package xianxingbiao.LinkedList;

/**
 * @Author:Star
 * @Date:Created in 8:53 2020/2/8
 * @Description:
 */
public class SingleLinkedList<T> {


    //定义一个内部类Node,包括节点数据，结点引用
    public class Node{
        private T data;
        private Node next;

        public Node() {
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    //链表头节点
    private Node header;

    //链表尾节点
    private Node tail;

    //链表节点数
    private int size;

    //创建空链表

    public SingleLinkedList() {
        this.header = null;
        this.tail = null;
        this.size = 0;
    }


    //指定元素创建链表，只含有一个元素的链表
    public SingleLinkedList(T element){
        this.header = new Node(element,null);
        this.tail = this.header;
        this.size++;
    }

    //求链表长度
    public int length(){
        return size;
    }

    //获取链表中指定索引的元素
    public T get(int index){
        Node node = this.getNodeByIndex(index);
        return node == null ? null : node.data;
    }

    private Node getNodeByIndex(int index) {
        if(index < 0 || index > this.size - 1){
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
        Node curr = this.header;
        for(int i = 0;i < this.size && curr != null;i++,curr = curr.next){
            if(i == index){
                return curr;
            }
        }
        return null;
    }


    //查找链表中指定元素的索引
    public int locate(T element){
        Node curr = this.header;
        for(int i = 0;i < this.size && curr != null;i++,curr = curr.next){
            if (curr.data.equals(element)){
                return i;
            }
        }
        return -1;
    }

    //指定位置插入元素
    public void insert(T element,int index){
        indexCheck(index);
        //空链表
        if(this.header == null){
            this.addAtTail(element);
        }else{
            Node preNode = this.getNodeByIndex(index-1);
            if(preNode == null){
                throw new IllegalArgumentException("前一结点不存在");
            }
            preNode.next = new Node(element,preNode.next);
            this.size++;
        }
    }

    //尾插法插入新节点
    public void addAtTail(T element){
        if(this.header == null){
            this.header = new Node(element,null);
            this.tail = this.header;
        }else {
            //创建新节点
            Node newNode = new Node(element,null);
            //新节点作为尾节点
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    //头插法插入新节点
    public void addAtHeader(T element){
        this.header = new Node(element,header);
        if(this.tail == null){
            this.tail = this.header;
        }
        this.size++;
    }

    //删除链表中指定索引的元素
    public T delete(int index){
        indexCheck(index);
        Node delNode;
        if(index == 0){
            delNode = this.header;
            this.header = header.next;
        }else{
            Node preNode = this.getNodeByIndex(index);
            this.NodeCheck(preNode);
            delNode = preNode.next;
            preNode.next = delNode.next;
            delNode.next = null;
        }
        this.size--;
        return delNode.data;
    }

    //判断链表是否为空
    public boolean empty(){
        return this.size == 0;
    }

    //清空链表
    public void clean(){
        this.header = null;
        this.tail = null;
        this.size = 0;
    }

    //索引检查
    public void indexCheck(int index){
        if(index < 0 || index > this.size -1){
            throw new IndexOutOfBoundsException("线性表索引越界");
        }
    }

    public void NodeCheck(Node node){
        if(node == null){
            throw new IllegalArgumentException("节点不存在");
        }
    }

}