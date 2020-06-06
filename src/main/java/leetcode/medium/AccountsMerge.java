package leetcode.medium;

import java.util.*;

/**
 * @Author long
 * @Date 2020/5/14 10:59
 * @Title 721. 账户合并
 * @Description //TODO
 **/

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Set<Account> set = new HashSet<>();
        for (List<String> account : accounts) {
            int size = account.size();
            String name = account.get(0);
            Account act = new Account(name);
            for (int i = 1; i < size; i++) {
                act.addEmails(account.get(i));
            }
            Iterator<Account> iterator = set.iterator();
            while (iterator.hasNext()){
                Account a = iterator.next();
                if (act.isUnion(a)) {
                    iterator.remove();
                    act.union(a);
                }
            }
            set.add(act);
        }
        List<List<String>> output = new ArrayList<>(set.size());
        for (Account a : set) {
            LinkedList<String> list = new LinkedList<>(a.emails);
            Collections.sort(list);
            list.addFirst(a.name);
            output.add(list);
        }
        return output;
    }

    static class Account {
        String name;
        Set<String> emails;

        public Account(String name) {
            this.name = name;
            emails = new HashSet<>();
        }

        public boolean isUnion(Account p) {
            for (String email : p.emails) {
                if (emails.contains(email)) return true;
            }
            return false;
        }

        public void union(Account p) {
            emails.addAll(p.emails);
        }

        public void addEmails(String email) {
            emails.add(email);
        }
    }
}
