package org.codingtasks;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 *
 * @author olysenko
 */
public class DesignAddandSearchWordsDataStructure_M_211 {


   public static void main(String[] args) {
      //Input
      //["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
      //[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
      //Output
      //[null,null,null,null,false,true,true,true]
      //
      //Explanation
//      WordDictionary wordDictionary = new WordDictionary();
//      wordDictionary.addWord("bad");
//      wordDictionary.addWord("dad");
//      wordDictionary.addWord("mad");
//      System.out.println(wordDictionary.search("pad")); // return False
//      System.out.println(wordDictionary.search("bad")); // return True
//      System.out.println(wordDictionary.search(".ad")); // return True
//      System.out.println(wordDictionary.search("b..")); // return True



      //["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
      //[[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
      //[null,null,null,null,null,false,false,null,true,true,false,false,true,false]
//      WordDictionary wordDictionary = new WordDictionary();
//      wordDictionary.addWord("at");
//      wordDictionary.addWord("and");
//      wordDictionary.addWord("an");
//      wordDictionary.addWord("add");
//      System.out.println(wordDictionary.search("a")); //false
//      System.out.println(wordDictionary.search(".at")); //false
//      wordDictionary.addWord("bat");
//      System.out.println(wordDictionary.search(".at")); //true
//      System.out.println(wordDictionary.search("an.")); //true
//      System.out.println(wordDictionary.search("a.d.")); //false
//      System.out.println(wordDictionary.search("b.")); //false
//      System.out.println(wordDictionary.search("a.d")); //true
//      System.out.println(wordDictionary.search(".")); //false

      //["WordDictionary","addWord","addWord","search","search","search","search","search","search","search","search"]
      //[[],["a"],["ab"],["a"],["a."],["ab"],[".a"],[".b"],["ab."],["."],[".."]]
      //[null,null,null,true,true,true,false,true,false,true,true]
      WordDictionary wordDictionary = new WordDictionary();
      wordDictionary.addWord("a");
      wordDictionary.addWord("ab");
      System.out.println(wordDictionary.search("a")); //true
      System.out.println(wordDictionary.search("a.")); //true
      System.out.println(wordDictionary.search("ab")); //true
      System.out.println(wordDictionary.search(".a")); //false
      System.out.println(wordDictionary.search(".b")); //true
      System.out.println(wordDictionary.search("ab.")); //false
      System.out.println(wordDictionary.search(".")); //true
      System.out.println(wordDictionary.search("..")); //true
   }

//   static class WordDictionary {
//
//      static class Node {
//         Map<Character, Node> children;
//         boolean word;
//
//         Node() {
//            this.children = new HashMap<>();
//            this.word = false;
//         }
//      }
//
//      Node root;
//
//      public WordDictionary() {
//         this.root = new Node();
//      }
//
//      public void addWord(String word) {
//         Node current = root;
//         for (char c : word.toCharArray()) {
//            current.children.putIfAbsent(c, new Node());
//            current = current.children.get(c);
//         }
//         current.word = true;
//      }
//
//
//      public boolean search(String word) {
//         return search(word, root.children);
//      }
//
//      private boolean search(String word, Map<Character, Node> children) {
//         if (word.isEmpty()) {
//            return false;
//         } else if (word.length() == 1) {
//            char c = word.charAt(0);
//            if (!children.isEmpty() && c == '.') {
//               return children.values().stream().allMatch(node -> node.children.isEmpty() || node.word);
//            } else if (children.containsKey(c)) {
//               return children.get(c).word;
//            }
//            return false;
//         } else {
//            char c = word.charAt(0);
//            if (c == '.') {
//               for (Node node : children.values()) {
//                  if (search(word.substring(1), node.children)) {
//                     return true;
//                  }
//               }
//               return false;
//            } else {
//               Node node = children.get(c);
//               if (node == null) {
//                  return false;
//               } else {
//                  return search(word.substring(1), node.children);
//               }
//            }
//         }
//      }
//   }

   static class WordDictionary {

      Node root;

      private class Node {

         char value;
         boolean isWord;
         Node[] children;

         public Node(char value) {
            this.value = value;
            isWord = false;
            children = new Node[26];
         }
      }

      public WordDictionary() {
         root = new Node('\0');
      }

      public void addWord(String word) {
         Node curr = root;

         for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (curr.children[ch - 'a'] == null) {
               curr.children[ch - 'a'] = new Node(ch);
            }

            curr = curr.children[ch - 'a'];
         }

         curr.isWord = true;
      }

      // TC O(m^2)
      public boolean search(String word) {
         return searchHelper(word, root, 0);
      }

      private boolean searchHelper(String word, Node curr, int index) {
         for (int i = index; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch == '.') {
               for (Node temp : curr.children) {
                  if (temp != null && searchHelper(word, temp, i + 1)) {
                     return true;
                  }
               }

               return false;
            }

            if (curr.children[ch - 'a'] == null) {
               return false;
            }

            curr = curr.children[ch - 'a'];
         }

         return curr.isWord;
      }
   }

}
