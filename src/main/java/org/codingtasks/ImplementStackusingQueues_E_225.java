package org.codingtasks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 *
 * @author olysenko
 */
public class ImplementStackusingQueues_E_225 {

   public static void main(String[] args) {
      ImplementStackusingQueues_E_225 solution = new ImplementStackusingQueues_E_225();

      MyStack myStack = new ImplementStackusingQueues_E_225().new MyStack();
      myStack.push(1);
      myStack.push(2);
      System.out.println(myStack.top()); // return 2
      System.out.println(myStack.pop()); // return 2
      System.out.println(myStack.empty()); // return False

   }

   class MyStack {

      private Queue<Integer> queue;

      public MyStack() {
         queue = new LinkedList<>();
      }

      public void push(int x) {
         queue.add(x);
      }

      public int pop() {
         for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
         }
         return queue.poll();
      }

      public int top() {
         for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
         }
         Integer value = queue.poll();
         queue.add(value);
         return value;
      }

      public boolean empty() {
         return queue.isEmpty();
      }
   }

}
