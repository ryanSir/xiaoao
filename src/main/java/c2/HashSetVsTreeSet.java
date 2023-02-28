package c2;

import lombok.var;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author ryan
 * @version Id: HashSetVsTreeSet, v 0.1 2023/2/28 1:35 PM ryan Exp $
 */
public class HashSetVsTreeSet {

    public static void main(String[] args) {
        var hashSet = new HashSet<>();
        hashSet.add(3);
        hashSet.add(7);
        hashSet.add(2);
        hashSet.add(81);
        System.out.println(hashSet.stream().map(x -> x.toString()).collect(Collectors.joining(",")));

        var treeSet = new TreeSet<Integer>();
        treeSet.add(3);
        treeSet.add(7);
        treeSet.add(2);
        treeSet.add(81);
        System.out.println(treeSet.stream().map(x -> x.toString()).collect(Collectors.joining(",")));

        Integer x = 3;
        var treeSetX = new TreeSet<Integer>();
        treeSetX.add(x);
        treeSetX.add(7);
        treeSetX.add(2);
        treeSetX.add(81);
        System.out.println(treeSetX.lower(x));
        System.out.println(treeSetX.higher(x));
        // 包含等于
        System.out.println(treeSetX.floor(8));
        System.out.println(treeSetX.ceiling(8));

    }
}
