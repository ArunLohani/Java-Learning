import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8);

        Predicate<Integer> p = (num) -> (num & 1) == 0;

        Consumer<Integer> c = (num)->System.out.print( num+" ");

        nums.stream().filter(p).forEach(c);
        System.out.println();
        Supplier<Integer> s = ()-> (int) (10*Math.random());

        List<Integer> l =nums.stream().map(n->n*s.get()).toList();

//        for(Integer n : nums){
//            l.add(n * s.get());
//        }

        System.out.println(l.toString());

        Function<Integer,Integer> f = (value) -> value*value;
        List<Integer> squaredNumbers =  l.stream().map(f).toList();

        System.out.println(squaredNumbers);

    }
}