package com.thoughtworks.collection;

/**
 * Created by 筱湮 on 2018/4/7 0007.
 */
public class SingleLinkImpl<T> implements SingleLink<T> {
    private class Node{//节点类
        private T data;
        private Node next;
        public Node() {}
        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;//指向链表头节点的引用变量
    private Node tail;//指向链表尾节点的引用变量
    int size;//链表中当前总节点数

    //生成链表对象是一个空表
    public SingleLinkImpl() {
        head = null;
        tail = null;
    }

    //生成链表对象时有一个头节点 （有参构造器）
    public SingleLinkImpl(T data) {
        head = new Node(data,null);//指定一个头节点的数据域值为data,不指向其他节点
        tail = head;
        size++;
    }

    @Override
    public T getHeaderData() {
        return getNode(1);
    }

    @Override
    public T getTailData() {
        return getNode(size);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean deleteFirst() {
        T data = delete(1);
        boolean result = (data != null);
        return result;
    }

    @Override
    public boolean deleteLast() {
        T data = delete(size);
        boolean result = (data != null);
        return result;
    }

    @Override
    public void addHeadPointer(T item) {
        //在头部插入新节点，就是让新节点的next指向原来的head,让新节点作为链表的头节点
        head = new Node(item,head);
        //如果插入之前是空链表
        if(tail==null) {
            tail=head;
        }
    }

    @Override
    public void addTailPointer(T item) {
        if(head == null) {
            head = new Node(item,null);
            tail = head;
        } else {
            Node newNode = new Node(item,null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    //获取指定位置的元素
    @Override
    public T getNode(int index) {
        return findNodeByIndex(index).data;
    }

    //查找    指定索引位置的节点
    public Node findNodeByIndex(int index)
    {
        if(index < 1 || index > size) {
            throw new IndexOutOfBoundsException("单链表索引越界");
        }
        Node current = head;//从头节点开始下移遍历
        for (int i = 1; i <= size && current.next != null; i++,current = current.next) {
            if(i == index) {
                return current;
            }
        }
        return null;
    }

    //删除指定位置的节点 返回删除节点中的元素值
    public T delete (int index) {
        Node deleteNode = null;
        if(index < 1 || index > size) {
            throw new IndexOutOfBoundsException("单链表索引越界");
        }
        if(index == 1){//删除头节点
            deleteNode = head;
            head = head.next;
        } else {
            Node prev = findNodeByIndex(index-1);//获取要删除的节点的前一个节点
            deleteNode = prev.next;//要删除的节点就是prev的next指向的节点
            prev.next = deleteNode.next;//删除以后prev的next指向被删除节点之前所指向的next

            deleteNode.next = null;
        }
        return deleteNode.data;
    }

    //清除链表中所有的元素
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}
