package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author long
 * @Date 2021/10/6 21:28
 * @Title
 * @Description //TODO
 **/

public class AuthenticationManager {

    private final int timeToLive;
    private final Map<String, Integer> container;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.container = new HashMap<>();
    }

    //currentTime 的值严格递增
    public void generate(String tokenId, int currentTime) {
        container.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if (container.containsKey(tokenId)) {
            int time = container.get(tokenId);
            if (time > currentTime) {
                container.put(tokenId, currentTime + timeToLive);
            } else {
                container.remove(tokenId);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        Set<String> expired = new HashSet<>();
        for (Map.Entry<String, Integer> entry : container.entrySet()) {
            if (entry.getValue() <= currentTime) {
                expired.add(entry.getKey());
            }
        }
        for (String token : expired) {
            container.remove(token);
        }
        return container.size();
    }
}
