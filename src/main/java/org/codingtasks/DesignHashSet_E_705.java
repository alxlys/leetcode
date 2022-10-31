package org.codingtasks;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/design-hashset/
 *
 * @author olysenko
 */
public class DesignHashSet_E_705 {

   static class MyHashSet {

      private Object[] storage;
      private int size;

      public MyHashSet() {
         this.storage = new Object[10];
         this.size = 0;
      }

      @SuppressWarnings("unchecked")
      public void add(int key) {
         int idx = hash(key);
         Object obj = storage[idx];
         if (obj == null) {
            storage[idx] = key;
         } else if (obj instanceof Integer) {
            int value = (int) obj;
            if (value == key) {
               return;
            }
            LinkedList<Integer> linkedList = new LinkedList<>();
            linkedList.add(value);
            linkedList.add(key);
            storage[idx] = linkedList;
         } else {
            LinkedList<Integer> linkedList = (LinkedList<Integer>) obj;
            if (linkedList.contains(key)) {
               return;
            }
            linkedList.add(key);
         }
         this.size++;
         if (size >= storage.length) {
            rehash();
         }
      }

      @SuppressWarnings("unchecked")
      public void remove(int key) {
         int idx = hash(key);
         Object obj = storage[idx];
         if (obj == null) {
            return;
         } else if (obj instanceof Integer) {
            if ((int) storage[idx] == key) {
               storage[idx] = null;
            }
         } else {
            LinkedList<Integer> linkedList = (LinkedList<Integer>) obj;
            boolean removed = linkedList.remove((Integer) key);
            if (!removed) {
               return;
            }
         }
         this.size--;
      }

      @SuppressWarnings("unchecked")
      public boolean contains(int key) {
         int idx = hash(key);
         Object obj = storage[idx];
         if (obj == null) {
            return false;
         } else if (obj instanceof Integer) {
            return key == (Integer) obj;
         }
         LinkedList<Integer> linkedList = (LinkedList<Integer>) obj;
         return linkedList.contains(key);
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
            } else if (obj instanceof Integer) {
               add((int) obj);
            } else {
               LinkedList<Integer> linkedList = (LinkedList<Integer>) obj;
               linkedList.forEach(this::add);
            }
         }
      }

   }

   public static void main(String[] args) {
      //Input
      //["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
      //[[], [1], [2], [1], [3], [2], [2], [2], [2]]
      //Output
      //[null, null, null, true, false, null, true, null, false]

//      MyHashSet myHashSet = new MyHashSet();
//      myHashSet.add(1);                          // set = [1]
//      myHashSet.add(2);                          // set = [1, 2]
//      System.out.println(myHashSet.contains(1)); // return True
//      System.out.println(myHashSet.contains(3)); // return False, (not found)
//      myHashSet.add(2);                          // set = [1, 2]
//      System.out.println(myHashSet.contains(2)); // return True
//      myHashSet.remove(2);                  // set = [1]
//      System.out.println(myHashSet.contains(2)); // return False, (already removed)


      MyHashSet myHashSet = new MyHashSet();
      System.out.println(myHashSet.contains(72));
      myHashSet.remove(91);
      myHashSet.add(48);
      myHashSet.add(41);
      System.out.println(myHashSet.contains(96));
      myHashSet.remove(87);
      System.out.println(myHashSet.contains(48));
      System.out.println(myHashSet.contains(49));

//                ,[48],[49],[84],[82],[24],[7],[56],[87]
//            ,"add","add","add","add","remove","add","add","add","add","add","add","add","add","add","add","contains","add","contains","add","add","contains","add","add","remove","add","add","add","add","add","contains","add","add","add","remove","contains","add","contains","add","add","add","add","add","contains","remove","remove","add","remove","contains","add","remove","add","add","add","add","contains","contains","add","remove","remove","remove","remove","add","add","contains","add","add","remove","add","add","add","add","add","add","add","add","remove","add","remove","remove","add","remove","add","remove","add","add","add","remove","remove","remove","add","contains","add"


   }

}
