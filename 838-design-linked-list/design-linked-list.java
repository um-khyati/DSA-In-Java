import java.util.LinkedList;
class MyLinkedList {
    LinkedList<Integer> obj;
    public MyLinkedList() {
        obj=new LinkedList<>();
    }
    
    public int get(int index) {
        if(index<0 ||index>=obj.size()){
            return -1;
        }
        return obj.get(index);
    }
    
    public void addAtHead(int val) {
        obj.addFirst(val);
    }
    
    public void addAtTail(int val) {
        obj.addLast(val);
    }
    
    public void addAtIndex(int index, int val) {
        if(index>obj.size()){
            return;
        }
        obj.add(index,val);
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=obj.size()){
            return;
        }
        obj.remove(index);
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