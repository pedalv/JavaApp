package no.book.chapter3GenericsandCollections.ReviewingOCACollections.searchingandsorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchingandSorting {

    public static void main(String ... args){
        int[] numbers = {6,9,1,8}; // Line 11
        Arrays.sort(numbers); // [1,6,8,9]
        /*
        Line 12 sorts the array because binary search assumes the input is sorted.
         */
        System.out.println(Arrays.binarySearch(numbers, 6)); // 1 // Line 13
        /*
        [1,6,8,9]
        [0,1,2,3]
        Line 13 prints the index at which a match is found.
         */
        System.out.println(Arrays.binarySearch(numbers, 3)); // -2 // Line 14
        /*
        Line 14 prints one less than the negated index of where the requested value would need to be inserted.
        The number 3 would need to be inserted at index 1
            (after the number 1 but before the number 6).
            Negating that gives us -1 and subtracting 1 gives us -2.
         */
        System.out.println(Arrays.binarySearch(numbers, 7)); // -3 index 2
        System.out.println(Arrays.binarySearch(numbers, 10)); // -5 index 4
        System.out.println(Arrays.binarySearch(numbers, 40)); // -5 index 4


        List<Integer> list = Arrays.asList(9,7,5,3); // Line 15
        Collections.sort(list); // [3, 5, 7, 9] // Line 16
        System.out.println(Collections.binarySearch(list, 3)); // 0 // Line 17
        System.out.println(Collections.binarySearch(list, 2)); // -1 // Line 18
        /*
        Similarly,
            we needed to sort first.
        Line 17
            prints the index of a match.
        For line 18,
            we would need to insert 2 at index 0,
                since it is smaller than any of the numbers in the list.
                Negating 0 is still 0 and subtracting 1 gives us -1.
         */

    }

    /*
    We call sort()
        and binarySearch()
        on Collections
        rather than Collection.

    In the past,
        Collection could not have concrete methods
        because it is an interface.
    Some were added in Java 8.
    We will explore these in Chapter 4 ,
        “Functional Programming.”
    Keep this change in mind if you practice with any older mock exams.
     */


}
