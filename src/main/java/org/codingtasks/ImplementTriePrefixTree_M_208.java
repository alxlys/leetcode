package org.codingtasks;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 *
 * @author olysenko
 */
public class ImplementTriePrefixTree_M_208 {

   public static void main(String[] args) {

      //Input
      //["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
      //[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
      //Output
      //[null, null, true, false, true, null, true]
      //
      //Explanation
      Trie trie = new Trie();
      trie.insert("apple");
      System.out.println(trie.search("apple"));   // return True
      System.out.println(trie.search("app"));     // return False
      System.out.println(trie.startsWith("app")); // return True
      trie.insert("app");
      System.out.println(trie.search("app"));     // return True
   }

   static class Trie {

      Map<Character, Trie> children;
      boolean word;

      public Trie() {
         this.children = new HashMap<>();
         this.word = false;
      }

      public void insert(String word) {
         Trie current = this;
         for (char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new Trie());
            current = current.children.get(c);
         }
         current.word = true;
      }

      public boolean search(String word) {
         Trie current = this;
         for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
               return false;
            }
            current = current.children.get(c);
         }
         return current.word;
      }

      public boolean startsWith(String prefix) {
         Trie current = this;
         for (char c : prefix.toCharArray()) {
            if (!current.children.containsKey(c)) {
               return false;
            }
            current = current.children.get(c);
         }
         return true;
      }
   }

}
