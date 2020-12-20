package Design;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        Node(int key, int value){
            this.key=key;
            this.value=value;
            pre=null;
            next=null;
        }
    }

    int capacity;
    Map<Integer,Node> map=new HashMap<>();
    //     least recent
    Node head;
    //     recent
    Node tail;


    public LRUCache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
//         the key doesn't exist
        if(!map.containsKey(key)){
            return -1;
        }
//         get the node
        Node curNode=map.get(key);
//         update the position in the list
        if(curNode==tail){
//             unnecessary to do any operations
            return curNode.value;
        }
//         delete the node
        deleteNode(curNode);
//         add to tail
        addToTail(curNode);
        return curNode.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
//             update the value
            Node curNode=map.get(key);
            curNode.value=value;
//             update the position
            deleteNode(curNode);
            addToTail(curNode);
            return;
        }
        Node curNode=new Node(key,value);
//         is full
        if(map.size()==capacity){
//             remove head
            Node temp=removeHead();
            map.remove(temp.key);
        }
        addToTail(curNode);
        map.put(key,curNode);
    }

    public void deleteNode(Node curNode){
        if(curNode==head){
            if(head.next==null){
//                 only one node in the list
                head=null;
                tail=null;
                curNode.next=null;
                curNode.pre=null;
            }else{
                head=head.next;
                head.pre=null;
                curNode.next=null;
            }
        }else if(curNode==tail){
            if(tail.pre==null){
//                 only one node in the list
                tail=null;
                head=null;
                curNode.next=null;
                curNode.pre=null;
            }else{
                tail=tail.pre;
                tail.next=null;
                curNode.pre=null;
            }
        }else{
            curNode.pre.next=curNode.next;
            curNode.next.pre=curNode.pre;
            curNode.pre=null;
            curNode.next=null;
        }
    }

    public void addToTail(Node curNode){
        if(tail==null){
            head=curNode;
            tail=curNode;
            curNode.pre=null;
            curNode.next=null;
        }else{
            tail.next=curNode;
            curNode.pre=tail;
            tail=curNode;
        }
    }

    public Node removeHead(){
        if(head==null){
            return null;
        }
        if(head.next==null){
            Node temp=head;
            head=null;
            tail=null;
            temp.next=null;
            temp.pre=null;
            return temp;
        }
        Node temp=head;
        head=head.next;
        head.pre=null;
        return temp;
    }
}
