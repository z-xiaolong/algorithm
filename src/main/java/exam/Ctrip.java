package exam;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @Author: long
 * @Date: 2020/8/15 19:02
 * @Title
 * @Description:
 */
public class Ctrip {


    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        String s = cin.nextLine();
        WorkflowNode node = WorkflowNode.load(s);
        if (!WorkflowNode.flag) {
            System.out.println(-1);
            return;
        }
        System.out.println(dfs(node));
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
    }

    public static int dfs(WorkflowNode node) {
        if (node == null) return 0;
        if (node.nextNodes == null) return node.timeoutMillis;
        List<WorkflowNode> next = node.nextNodes;
        int maxTimeout = Integer.MIN_VALUE;
        for (WorkflowNode n : next) {
            maxTimeout = Math.max(maxTimeout, dfs(n));
        }
        return maxTimeout + node.timeoutMillis;
    }


}

class WorkflowNode {
    String nodeId;
    int timeoutMillis;
    List<WorkflowNode> nextNodes;
    boolean initialised;
    static boolean flag = true;

    public static WorkflowNode load(String value) {
        // Create head node;
        Map<String, WorkflowNode> map = new HashMap<>();
        WorkflowNode head = new WorkflowNode("HEAD", 0, null);
        map.put(head.nodeId, head);

        for (String nodeValue : value.split("\\|")) {
            String[] properties = nodeValue.split("`");
            if (properties.length != 3) {
                flag = false;
                return head;
            }
            WorkflowNode node = map.get(properties[0]);

            try {
                node.timeoutMillis = Integer.parseInt(properties[1]);
            } catch (Exception e) {
                flag = false;
                return head;
            }

            node.initialised = true;

            // Check next nodes
            if ("END".equals(properties[2])) {
                continue;
            }
            String[] str = properties[2].split(",");
            for (String s : str) {
                if (s.length() == 0) {
                    flag = true;
                    return head;
                }
            }
            node.nextNodes = Arrays.stream(properties[2].split(","))
                    .map(p -> new WorkflowNode(p, 0, null))
                    .collect(Collectors.toList());
            node.nextNodes.forEach(p -> map.put(p.nodeId, p));

            map.put(node.nodeId, node);
        }
        return head;
    }

    public WorkflowNode(String nodeId, int timeoutMillis, List<WorkflowNode> nextNodes) {
        this.nodeId = nodeId;
        this.timeoutMillis = timeoutMillis;
        this.nextNodes = nextNodes;
    }
}
