package org.codingtasks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * https://leetcode.com/problems/design-hashmap/
 *
 * @author olysenko
 */
public class DesignHashMap_E_706 {

   static class MyHashMap {

      static class Entry {
         int key;
         int value;

         public Entry(int key, int value) {
            this.key = key;
            this.value = value;
         }

         @Override
         public boolean equals(Object o) {
            if (this == o)
               return true;
            if (o == null || getClass() != o.getClass())
               return false;
            Entry entry = (Entry) o;
            return key == entry.key;
         }

         @Override
         public int hashCode() {
            return Objects.hash(key);
         }
      }

      private Object[] storage;
      private int size;

      public MyHashMap() {
         this.storage = new Object[3];
         this.size = 0;
      }

      @SuppressWarnings("unchecked")
      public void put(int key, int value) {
         int idx = hash(key);
         Object obj = storage[idx];
         if (obj == null) {
            storage[idx] = new Entry(key, value);
         } else if (obj instanceof Entry) {
            Entry entry = (Entry) obj;
            if (entry.key == key) {
               entry.value = value;
               return;
            }
            LinkedList<Entry> linkedList = new LinkedList<>();
            linkedList.add(entry);
            linkedList.add(new Entry(key, value));
            storage[idx] = linkedList;
         } else {
            LinkedList<Entry> linkedList = (LinkedList<Entry>) obj;
            for (Entry entry : linkedList) {
               if (entry.key == key) {
                  entry.value = value;
                  return;
               }
            }
            linkedList.add(new Entry(key, value));
         }
         this.size++;
         if (size >= storage.length) {
            rehash();
         }
      }

      @SuppressWarnings("unchecked")
      public int get(int key) {
         int idx = hash(key);
         Object obj = storage[idx];
         if (obj == null) {
            return -1;
         } else if (obj instanceof Entry) {
            if (((Entry) obj).key == key) {
               return ((Entry) obj).value;
            }
         } else {
            LinkedList<Entry> linkedList = (LinkedList<Entry>) obj;
            for (Entry entry : linkedList) {
               if (entry.key == key) {
                  return entry.value;
               }
            }
         }
         return -1;
      }

      @SuppressWarnings("unchecked")
      public void remove(int key) {
         int idx = hash(key);
         Object obj = storage[idx];
         if (obj == null) {
            return;
         } else if (obj instanceof Entry) {
            if (((Entry) obj).key == key) {
               storage[idx] = null;
            }
         } else {
            LinkedList<Entry> linkedList = (LinkedList<Entry>) obj;
            boolean removed = linkedList.remove(new Entry(key, 0));
            if (!removed) {
               return;
            }
         }
         this.size--;
      }

      private int hash(int value) {
         return value % storage.length;
      }

      @SuppressWarnings("unchecked")
      private void rehash() {
         Object[] oldStorage = this.storage;
         this.storage = new Object[oldStorage.length * 2];
         this.size = 0;
         for (Object obj : oldStorage) {
            if (obj == null) {
               continue;
            } else if (obj instanceof Entry) {
               Entry entry = (Entry) obj;
               put(entry.key, entry.value);
            } else {
               LinkedList<Entry> linkedList = (LinkedList<Entry>) obj;
               linkedList.forEach(entry -> put(entry.key, entry.value));
            }
         }
      }
   }

   public static void main(String[] args) {
      //Input
      //["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
      //[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
      //Output
      //[null, null, null, 1, -1, null, 1, null, -1]

      //      MyHashMap myHashMap = new MyHashMap();
      //      myHashMap.put(1, 1);                     // The map is now [[1,1]]
      //      myHashMap.put(2, 2);                     // The map is now [[1,1], [2,2]]
      //      System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
      //      System.out.println(myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
      //      myHashMap.put(2, 1);                     // The map is now [[1,1], [2,1]] (i.e., update the existing value)
      //      System.out.println(myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
      //      myHashMap.remove(2);                // remove the mapping for 2, The map is now [[1,1]]
      //      System.out.println(myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]

      List<Integer> list = new ArrayList<>();

      MyHashMap myHashMap = new MyHashMap();
      myHashMap.remove(27);
      myHashMap.put(65, 65);
      myHashMap.remove(19);
      myHashMap.remove(0);
      list.add(myHashMap.get(18));
      myHashMap.remove(3);
      myHashMap.put(42, 0);
      list.add(myHashMap.get(19));
      myHashMap.remove(42);
      myHashMap.put(17, 90);
      myHashMap.put(31, 76);
      myHashMap.put(48, 71);
      myHashMap.put(5, 50);
      myHashMap.put(7, 68);
      myHashMap.put(73, 74);
      myHashMap.put(85, 18);
      myHashMap.put(74, 95);
      myHashMap.put(84, 82);
      myHashMap.put(59, 29);
      myHashMap.put(71, 71);
      myHashMap.remove(42);
      myHashMap.put(51, 40);
      myHashMap.put(33, 76);
      list.add(myHashMap.get(17));
      myHashMap.put(89, 95);
      list.add(myHashMap.get(95));
      myHashMap.put(30, 31);
      myHashMap.put(37, 99);
      list.add(myHashMap.get(51));

      System.out.println(list);

   }

}
