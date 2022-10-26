package org.codingtasks;

/**
 * https://leetcode.com/problems/design-browser-history/
 *
 * @author olysenko
 */
public class DesignBrowserHistory_M_1472 {

   public static void main(String[] args) {
      BrowserHistory browserHistory = new DesignBrowserHistory_M_1472().new BrowserHistory("leetcode.com");
      browserHistory.visit("google.com"); // You are in "leetcode.com". Visit "google.com"
      browserHistory.visit("facebook.com"); // You are in "google.com". Visit "facebook.com"
      browserHistory.visit("youtube.com"); // You are in "facebook.com". Visit "youtube.com"
      System.out.println(browserHistory.back(1)); // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
      System.out.println(browserHistory.back(1)); // You are in "facebook.com", move back to "google.com" return "google.com"
      System.out.println(browserHistory.forward(1)); // You are in "google.com", move forward to "facebook.com" return "facebook.com"
      browserHistory.visit("linkedin.com"); // You are in "facebook.com". Visit "linkedin.com"
      System.out.println(browserHistory.forward(2)); // You are in "linkedin.com", you cannot move forward any steps.
      System.out.println(browserHistory.back(2)); // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
      System.out.println(browserHistory.back(7)); // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
   }

   class BrowserHistory {

      class Node {
         public String val;
         public Node prev;
         public Node next;

         public Node() {
         }

         public Node(String val) {
            this.val = val;
         }

         public Node(String val, Node next) {
            this.val = val;
            this.next = next;
         }

         public Node(String val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
         }
      }

      private Node current;

      public BrowserHistory(String homepage) {
         this.current = new Node(homepage);

      }

      public void visit(String url) {
         Node newCurrent = new Node(url, current, null);
         current.next = newCurrent;
         current = newCurrent;
      }

      public String back(int steps) {
         int i = 0;
         while (i < steps && current.prev != null) {
            current = current.prev;
            i++;
         }
         return current.val;
      }

      public String forward(int steps) {
         int i = 0;
         while (i < steps && current.next != null) {
            current = current.next;
            i++;
         }
         return current.val;
      }
   }

}
