import java.util.LinkedHashMap;
import java.util.Map;
/**
 * @author lizifan 695199262@qq.com
 * @since 2020.2.16 23:05
 */
public class LeetCode146 {
    static class LRUCache {
        private Integer removeKey;
        private final Map<Integer, Integer> map;

        public LRUCache(int capacity) {
            this.map = new LinkedHashMap<Integer, Integer>(32, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    boolean over = size() > capacity;
                    if(over) {
                        removeKey = eldest.getKey();
                    }
                    return over;
                }
            };
        }

        public int get(int key) {
            remove();
            Integer v;
            return (v = map.get(key)) != null ? v : -1;
        }

        public void put(int key, int value) {
            remove();
            map.put(key, value);
        }

        private void remove() {
            if(removeKey != null) {
                map.remove(removeKey);
                removeKey = null;
            }
        }
    }
}
