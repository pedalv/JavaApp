package no.dfo.fp.functionalprogramming.functionreactive.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * Introduction to the map / filter / reduce
 * A focus on the reduction step
 * - associative operation WORKS LIKE IN SERIE OR PARALLELLE
 * - ***************IMPORTANT BUG TO KNOW IN ADVANCE***************
 * - The reduction is critical
 * - It is very easy to write a non-associative reduction
 *      1. (i1, i2) -> i1*i1 + i2*i2
 *      2. (i1, i2) -> (i1 + i2)/2
 * - Associative saples:
 *      1. (i1, i2) -> i1 + i2
 *      2. (i1, i2) -> Integer.max(i1, i2)
 *      3. (i1, i2) -> i1
 * - It is very easy to write a reduction with no identity element
 *      1. Sample for MAX with negatives as -1, -2, -3, -4 === -1 but it will be 0 as 'valueIfEmpty'
 *      2. The JDK introduces a new concept: Option === maybe empty
 * How to implement it in the JDK
 * - average
 * - sum
 * - counting
 * - etc
 *
 */
public class MainReduction {

    public static int reduce(
            List<Integer> values,
            int valueIfEmpty,
            BinaryOperator<Integer> reduction) {

        int result = valueIfEmpty;
        for (int value : values) {
            result = reduction.apply(result, value);
        }
        return result;
    }

    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4, -1, -2, -3, -4);

        List<Integer> ints1 = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> ints2 = Arrays.asList(-1, -2, -3, -4);

        BinaryOperator<Integer> op = (i1, i2) -> Integer.max(i1, i2) ; //no associative operation
        BinaryOperator<Integer> opsum = (i1, i2) -> i1 + i2; //associative operation WORKS LIKE IN SERIE OR PARALLELLE IMPORTANT BUG***************
                                                             // It works with positive and negative values
        BinaryOperator<Integer> opsummul = (i1, i2) -> (i1 + i2)*(i1 + i2) ; //no associative operation

        int reduction1 = reduce(ints1, 0, op);
        int reduction2 = reduce(ints2, 0, op);
        int reductionparallelle = reduce(Arrays.asList(reduction1, reduction2), 0, op);     // in parallelle
        int reductionserie = reduce(ints, 0, op);                                           //in serie
        System.out.println("Reduction : " + reduction1);
        System.out.println("Reduction : " + reduction2);
        System.out.println("Reduction parallelle: " + reductionparallelle); //ok
        System.out.println("Reduction serie: " + reductionserie); //ok

        int reduction1summul = reduce(ints1, 0, opsummul);
        int reduction2summul = reduce(ints2, 0, opsummul);
        int reductionparallellesummul = reduce(Arrays.asList(reduction1summul, reduction2summul), 0, opsummul);     // in parallelle
        int reductionseriesummul = reduce(ints, 0, opsummul);
        System.out.println("Reduction : " + reduction1summul);
        System.out.println("Reduction : " + reduction2summul);
        System.out.println("Reduction parallelle: " + reductionparallellesummul); //not the same result
        System.out.println("Reduction serie: " + reductionseriesummul); //not the same result

        int reduction1sum = reduce(ints1, 0, opsum);
        int reduction2sum = reduce(ints2, 0, opsum);
        int reductionparallellesum = reduce(Arrays.asList(reduction1sum, reduction2sum), 0, opsum);     // in parallelle
        int reductionseriesum = reduce(ints, 0, opsum);
        System.out.println("Reduction : " + reduction1sum);
        System.out.println("Reduction : " + reduction2sum);
        System.out.println("Reduction parallelle : " + reductionparallellesum); //not the same result
        System.out.println("Reduction serie: " + reductionseriesum); //not the same result


        // peoples MAP age FILTER age>20 REDUCE avg
        // MAP List<Person> -> List<Integer>
        // FILTER List<Integer> -> List<Integer>
        // REDUCE List<Integer> -> Integer
        // List<Person> peoples =....
        // List<Integer> ages       = Lists.map(peoples, person -> person.getAge());
        // List<Integer> agesGT20   = Lists.filter(ages, age -> age > 20);
        // int sum                  = Lists.reduce(agesGT20, (a1, a2) -> a1 + a2);

        // peoples
        //      .map(person -> person.getAge())
        //      .filter(ages, age -> age > 20)   //it is to cost for computation
        //      .reduce((a1, a2) -> a1 + a2)

        // peoples
        //      .stream
        //      .filter(ages, age -> age > 20)   //Reduce the list with only correct values
        //      .map(person -> person.getAge()) //Mapping Person to Integer
        //      .average()

    }

}
