package javaCore.javaStream;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author long
 * @Date 2020/3/23 22:36
 * @Title
 * @Description //TODO
 **/

public class Main {

    public static void main(String[] args) {
        String[] strings = new String[]{"adas", "dadasdas", "dafasfsd", "gre", "213344"};
        List<String> list = new ArrayList<>(Arrays.asList(strings));
        long c = Arrays.stream(strings).count();
        //System.out.println(c);
        long count = list.stream().filter(p -> p.length() > 5).count();
        //System.out.println(count);

        createStream(strings);
    }


    //流的创建
    public static Stream<String> createStream(String[] strings) {
        Stream<String> stream1 = Arrays.stream(strings);
        Stream.empty(); //创建空流
        //of 方法直接转化
        Stream<String> stream2 = Stream.of(strings);
        //generate 方法，接受一个lambda表达式
        Stream<Double> stream3 = Stream.generate(Math::random);
        Stream<String> stream4 = Stream.generate(() -> "hello");
        System.out.println();
        //iterate 方法
        Stream.iterate(1, n -> ++n)
                .limit(10).collect(Collectors.toList()).forEach(System.out::println);
        List<Integer> list = Stream.iterate(1, n -> ++n)
                .limit(10).collect(Collectors.toList());
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
            }
        });
        //基本类型流（三种）
        //IntStream LongStream DoubleStream
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);

        Stream<Integer> integerStream = intStream.boxed();
        IntStream intStream1 = integerStream.mapToInt(Integer::intValue);
        IntStream intStream2 = IntStream.range(1, 10000);

        //并行流
        Stream<Integer> stream6 = list.parallelStream();
        return stream4;
    }
}
