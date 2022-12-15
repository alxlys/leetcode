package org.codingtasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/accounts-merge/
 *
 * @author olysenko
 */
public class AccountsMerge_M_721 {

   public static void main(String[] args) {
      AccountsMerge_M_721 solution = new AccountsMerge_M_721();
      //Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
      //Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
      //Explanation:
      //The first and second John's are the same person as they have the common email "johnsmith@mail.com".
      //The third John and Mary are different people as none of their email addresses are used by other accounts.
      //We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
      //['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
      System.out.println(solution.accountsMerge(
            Arrays.asList(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                  Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                  Arrays.asList("Mary", "mary@mail.com"), Arrays.asList("John", "johnnybravo@mail.com"))));

      //Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
      //Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
   }

   public List<List<String>> accountsMerge(List<List<String>> accounts) {
      Map<String, String> parentMap = new HashMap<>();
      Map<String, Integer> rankMap = new HashMap<>();
      Map<String, String> mailToNameMap = new HashMap<>();

      for (List<String> account : accounts) {
         String name = account.get(0);
         for (String email : account.subList(1, account.size())) {
            mailToNameMap.put(email, name);
            parentMap.put(email, email);
            rankMap.put(email, 0);
         }
      }

      for (List<String> account : accounts) {
         String email1 = account.get(1);
         for (String email2 : account.subList(2, account.size())) {
            union(parentMap, rankMap, email1, email2);
            email1 = email2;
         }
      }

      Map<String, List<String>> mergedAccounts = new HashMap<>();
      for (String email : parentMap.keySet()) {
         String parent = find(parentMap, email);
         List<String> emailList = new ArrayList<>();
         emailList.add(email);
         mergedAccounts.merge(parent, emailList, (list1, list2) -> {
            list1.addAll(list2);
            return list1;
         });
      }

      return mergedAccounts.entrySet().stream().map(entry -> {
         List<String> mailList = entry.getValue();
         Collections.sort(mailList);
         String name = mailToNameMap.get(entry.getKey());
         mailList.add(0, name);
         return mailList;
      }).collect(Collectors.toList());
   }

   private void union(Map<String, String> parentMap, Map<String, Integer> rankMap, String email1, String email2) {
      String parent1 = find(parentMap, email1);
      String parent2 = find(parentMap, email2);
      if (parent1.equals(parent2)) {
         return;
      }
      Integer rank1 = rankMap.get(parent1);
      Integer rank2 = rankMap.get(parent2);

      if (rank1 > rank2) {
         parentMap.put(parent2, parent1);
      } else if (rank1 < rank2) {
         parentMap.put(parent1, parent2);
      } else {
         parentMap.put(parent1, parent2);
         rankMap.put(parent2, rankMap.get(parent2) + 1);
      }
   }

   private String find(Map<String, String> parentMap, String email) {
      String parent = parentMap.get(email);
      while (!parent.equals(parentMap.get(parent))) {
         parent = parentMap.get(parentMap.get(parent));
      }
      return parent;
   }

}
