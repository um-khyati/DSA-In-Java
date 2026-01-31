class MyLinkedList {
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
        }
    }
    private Node head;
    private int size = 0;

    public MyLinkedList() {
        head = new Node(0);
        size = 0;  
    }
    
    public int get(int index) {
        if ( index<0 || index>=size){
            return -1;
        }
        Node temp = head.next;
        for(int i = 0; i<index; i++){
            temp = temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node temp = new Node(val);
        temp.next = head.next;
        head.next = temp;
        size++;
    }
    
    public void addAtTail(int val) {
        Node t= new Node(val);
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=t;
        t.next=null;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index>size){
            return;
        }
        if(index==size){
            addAtTail(val);
            return;
        }
            Node temp=head;
            Node t= new Node(val);
            for(int i=0;i<index;i++){
                temp=temp.next;
            }
            t.next=temp.next;
            temp.next=t;
            size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=size){
            return;
        }
        Node temp=head;

        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */