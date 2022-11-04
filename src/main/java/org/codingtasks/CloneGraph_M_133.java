package org.codingtasks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/clone-graph/
 *
 * @author olysenko
 */
public class CloneGraph_M_133 {

   static class Node {
      public int val;
      public List<Node> neighbors;

      public Node() {
         val = 0;
         neighbors = new ArrayList<>();
      }

      public Node(int _val) {
         val = _val;
         neighbors = new ArrayList<>();
      }

      public Node(int _val, ArrayList<Node> _neighbors) {
         val = _val;
         neighbors = _neighbors;
      }
   }

   private final Map<Integer, Node> map = new HashMap<>();

   public Node cloneGraph(Node node) {
      if (node == null) {
         return null;
      }
      Node existingNode = map.get(node.val);
      if (existingNode != null) {
         return existingNode;
      }
      Node newNode = new Node(node.val, new ArrayList<>());
      map.put(node.val, newNode);
      for (Node neighbor : node.neighbors) {
         newNode.neighbors.add(cloneGraph(neighbor));
      }
      return newNode;
   }

}
