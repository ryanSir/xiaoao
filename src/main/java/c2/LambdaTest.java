package c2;

import lombok.var;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ryan
 * @version Id: LambdaTest, v 0.1 2023/2/28 5:44 PM ryan Exp $
 */
public class LambdaTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Stream.of(1, 2, 3, 4, 5).map(integer -> integer.toString()).map(x -> Integer.parseInt(x));
        Stream.of(1, 2, 3, 4, 5).map(Object::toString).map(Integer::parseInt).collect(Collectors.toList()).forEach(System.out::println);

        Optional<Integer> reduce = Stream.of(1, 2, 3, 4, 5).reduce(Math::max);         // 值有没有被设置
        System.out.println(reduce.isPresent());
        // 设置初始值，比较安全,返回值也不一样
        Integer reduce1 = Stream.of(1, 2, 3, 4, 5).reduce(0, Math::max);

        OptionalInt reduce2 = IntStream.of(1, 2, 3, 4, 5).reduce(Math::max);
        System.out.println(reduce2.getAsInt());

        var reduce3 = IntStream.of().reduce(Math::max);
        System.out.println(reduce3.orElseGet(() -> 0));

        Stream.of("My", "Mine").flatMap(str -> str.chars().mapToObj(i -> (char) i)).collect(Collectors.toSet()).forEach(System.out::println);

        var r = new Random();
        var list = IntStream.range(0, 1_000_000).map(x -> r.nextInt(1_000_000)).boxed().collect(Collectors.toList());
        var t0 = System.currentTimeMillis();
        // 串行化
        System.out.println(list.stream().max((a, b) -> a - b));
        System.out.println("串行化: " + (System.currentTimeMillis() - t0));

        var t1 = System.currentTimeMillis();
        list.parallelStream().max((a, b) -> a - b);
        System.out.println("parallel: " + (System.currentTimeMillis() - t1));

        System.out.println(Runtime.getRuntime().availableProcessors());

        // 默认拆分1024
        var pool = new ForkJoinPool(2);
        var f1 = System.currentTimeMillis();
        var max = pool.submit(() -> list.parallelStream().max((a, b) -> a - b)).get();
        System.out.println("forkJoinPool: " + (System.currentTimeMillis() - f1));

    }
}
