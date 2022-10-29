package org.codingtasks;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 *
 * @author olysenko
 */
public class LRUCache_M_146 {

   static class LRUCache {

      static class Node {
         int key;
         int value;

         public Node(int key, int value) {
            this.key = key;
            this.value = value;
         }

         Node prev;
         Node next;
      }

      private final Map<Integer, Node> cache = new HashMap<>();
      private final int capacity;

      private final Node tail;
      private final Node head;

      public LRUCache(int capacity) {
         this.capacity = capacity;
         this.tail = new Node(0, 0);
         this.head = new Node(0, 0);
         this.tail.next = this.head;
         this.head.prev = this.tail;
      }

      private void remove(Node node) {
         Node prev = node.prev;
         Node next = node.next;
         prev.next = next;
         next.prev = prev;
      }

      private void insert(Node node) {
         Node prev = this.head.prev;
         Node next = this.head;

         prev.next = node;
         next.prev = node;

         node.next = next;
         node.prev = prev;
      }

      public int get(int key) {
         Node node = cache.get(key);
         if (node == null) {
            return -1;
         }
         remove(node);
         insert(node);
         return node.value;
      }

      public void put(int key, int value) {
         Node node = cache.get(key);
         if (node != null) {
            node.value = value;
            remove(node);
         }
         insert(node != null ? node : (node = new Node(key, value)));
         cache.put(key, node);

         if (cache.size() > capacity) {
            Node lru = tail.next;
            remove(lru);
            cache.remove(lru.key);
         }
      }

   }

   public static void main(String[] args) {
      //["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
      //[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
      //Output
      //[null, null, null, 1, null, -1, null, -1, 3, 4]

      LRUCache lRUCache = new LRUCache(2);
      lRUCache.put(1, 1);                     // cache is {1=1}
      lRUCache.put(2, 2);                     // cache is {1=1, 2=2}
      System.out.println(lRUCache.get(1));    // return 1
      lRUCache.put(3, 3);                     // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
      System.out.println(lRUCache.get(2));    // returns -1 (not found)
      lRUCache.put(4, 4);                     // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
      System.out.println(lRUCache.get(1));    // return -1 (not found)
      System.out.println(lRUCache.get(3));    // return 3
      System.out.println(lRUCache.get(4));    // return 4


      //["LRUCache","put","put","put","put","get","get"]
      //[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
      //Output: [null,null,null,null,null,-1,3]
      lRUCache = new LRUCache(2);
      lRUCache.put(2, 1);
      lRUCache.put(1, 1);
      lRUCache.put(2, 3);
      lRUCache.put(4, 1);
      System.out.println(lRUCache.get(1)); //-1
      System.out.println(lRUCache.get(2)); //3

   }


}
