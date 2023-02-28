package c2;

import java.util.*;

import lombok.var;

/**
 * @author ryan
 * @version Id: CommonIterator, v 0.1 2023/2/27 5:31 PM ryan Exp $
 */
public class CommonIterator<T> implements Iterable<T> {

    private final List<T> list;

    public CommonIterator(List<T> list) {
        this.list = list;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public T next() {
                return list.get((int) (list.size() * Math.random()));
            }
        };
    }

    public static void main(String[] args) {
//        // var 动态类型，用来定义局部变量
//        var list = Arrays.asList("List", "Tree", "Array");
//        var gen = new CommonIterator<String>(list);
//
//        // for循环的会进入到iterator()方法，先判断hasNext,返回true，再执行next
//        for (var s : gen) {
//            System.out.println(s);
//        }
//
//        var it = gen.iterator();
//        for (int i = 0; i < 100; i++) {
//            System.out.println(it.next());
//        }
//
//        ArrayList<String> arr = new ArrayList<>();
//        arr.add("123");
//        var stringArr = arr.toArray(new String[10]);

        ArrayList<String> arr2 = new ArrayList<>();
        arr2.add("333");
        arr2.add("222");
        String[] strings = arr2.stream().toArray(value -> new String[value]);
        System.out.println(strings);

    }
}
