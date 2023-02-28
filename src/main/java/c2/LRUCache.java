package c2;

import lombok.var;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author ryan
 * @version Id: LRUCache, v 0.1 2023/2/28 2:05 PM ryan Exp $
 */
public class LRUCache<K, V> implements Iterable<K> {

    /***/
    int                 MAX   = 3;
    LinkedHashMap<K, V> cache = new LinkedHashMap<>();

    public void cache(K key, V value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        } else if (cache.size() >= MAX) {
            var it = cache.keySet().iterator();
            var first = it.next();
            cache.remove(first);
        }
        cache.put(key, value);

    }

    @Override
    public Iterator<K> iterator() {
        var it = cache.entrySet().iterator();
        return new Iterator<K>() {
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public K next() {
                return it.next().getKey();
            }
        };
    }

    public static void main(String[] args) {
        var lru = new LRUCache<String, Integer>();
        lru.cache("A", 1);
        lru.cache("B", 2);
        lru.cache("C", 3);
        lru.cache("D", 4);
        lru.cache("C", 10);

        System.out.println("leave <-" + StreamSupport.stream(lru.spliterator(), false).collect(Collectors.joining("<-")));
    }
}
