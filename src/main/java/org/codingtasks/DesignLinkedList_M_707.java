package org.codingtasks;

/**
 * https://leetcode.com/problems/design-linked-list/
 *
 * @author olysenko
 */
public class DesignLinkedList_M_707 {

   class MyLinkedList {

      class ListNode {
         public int val;
         public ListNode prev;
         public ListNode next;

         public ListNode() {
         }

         public ListNode(int val) {
            this.val = val;
         }

         public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
         }

         public ListNode(int val, ListNode prev, ListNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
         }

      }

      ListNode head;
      ListNode tail;

      int length = 0;

      public MyLinkedList() {
      }

      public int get(int index) {
         ListNode node = getByIndex(index);
         return node != null ? node.val : -1;
      }

      public void addAtHead(int val) {
         ListNode newHead = new ListNode(val, head);
         if (head != null) {
            head.prev = newHead;
         }
         head = newHead;
         if (tail == null) {
            tail = head;
         }
         length++;
      }

      public void addAtTail(int val) {
         ListNode newTail = new ListNode(val, tail, null);
         if (tail != null) {
            tail.next = newTail;
         }
         tail = newTail;
         if (head == null) {
            head = tail;
         }
         length++;
      }

      public void addAtIndex(int index, int val) {
         if (index == length) {
            addAtTail(val);
            return;
         }
         if (index == 0) {
            addAtHead(val);
            return;
         }
         ListNode node = getByIndex(index);
         if (node == null) {
            return;
         }
         ListNode newNode = new ListNode(val, node.prev, node);
         if (node.prev != null) {
            node.prev.next = newNode;
            node.prev = newNode;
         }
         length++;
      }

      public void deleteAtIndex(int index) {
         ListNode node = getByIndex(index);
         if (node == null) {
            return;
         }

         ListNode prev = node.prev;
         ListNode next = node.next;

         if (prev != null) {
            prev.next = next;
         }

         if (next != null) {
            next.prev = prev;
         }

         if (node == head) {
            head = next;
         }

         if (node == tail) {
            tail = prev;
         }
         length--;
      }

      private ListNode getByIndex(int index) {
         int i = 0;
         ListNode res = head;
         while (i < index && res != null) {
            res = res.next;
            i++;
         }
         return res;
      }
   }

   public static void main(String[] args) {
      //      MyLinkedList myLinkedList = new DesignLinkedList_M_707().new MyLinkedList();
      //      myLinkedList.addAtHead(1);
      //      myLinkedList.addAtTail(3);
      //      myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
      //      myLinkedList.get(1);              // return 2
      //      myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
      //      myLinkedList.get(1);              // return 3


      // ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead",
      // "addAtTail","get","addAtHead","addAtIndex","addAtHead"]
      // [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
//      MyLinkedList myLinkedList = new DesignLinkedList_M_707().new MyLinkedList();
//      myLinkedList.addAtHead(7);
//      myLinkedList.addAtHead(2);
//      myLinkedList.addAtHead(1);
//      myLinkedList.addAtIndex(3, 0);
//      myLinkedList.deleteAtIndex(2);
//      myLinkedList.addAtHead(6);
//      myLinkedList.addAtTail(4);
//      myLinkedList.get(4);
//      myLinkedList.addAtHead(4);
//      myLinkedList.addAtIndex(5, 0);
//      myLinkedList.addAtHead(6);


      //["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
      //[[],[1],[3],[1,2],[1],[0],[0]]
//      MyLinkedList myLinkedList = new DesignLinkedList_M_707().new MyLinkedList();
//      myLinkedList.addAtHead(1);
//      myLinkedList.addAtTail(3);
//      myLinkedList.addAtIndex(1, 2);
//      myLinkedList.get(1);
//      myLinkedList.deleteAtIndex(0);
//      myLinkedList.get(0);

      // ["MyLinkedList","addAtIndex","addAtIndex","addAtIndex","get"]
      // [[],[0,10],[0,20],[1,30],[0]]
      MyLinkedList myLinkedList = new DesignLinkedList_M_707().new MyLinkedList();
      myLinkedList.addAtIndex(0, 10);
      myLinkedList.addAtIndex(0, 20);
      myLinkedList.addAtIndex(1, 30);
      myLinkedList.get(0);

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

}
