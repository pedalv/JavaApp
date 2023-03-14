package no.dfo.fp.functionalprogramming.streamsbasic.exercises;

import no.dfo.fp.functionalprogramming.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static no.dfo.fp.functionalprogramming.streamsbasic.exercises.TestData.APPLES;
import static no.dfo.fp.functionalprogramming.streamsbasic.exercises.TestData.PENCILS;
import static no.dfo.fp.functionalprogramming.streamsbasic.exercises.TestData.PLATES;
import static no.dfo.fp.functionalprogramming.streamsbasic.exercises.TestData.SPAGHETTI;
import static org.assertj.core.api.Assertions.assertThat;

class BasicStreamsExercise06Test {

    private static final List<Product> TEST_PRODUCTS = List.of(PENCILS, APPLES, PLATES, SPAGHETTI);

    private BasicStreamsExercise06 exercise = new BasicStreamsExercise06();

    @Test
    @DisplayName("Format a list of products")
    void formatProductList() {
        assertThat(exercise.formatProductList(new ArrayList<>(TEST_PRODUCTS)))
                .describedAs("Exercise 6: Your solution does not return the correct result.")
                .isEqualTo("OFFICE     Pencils          $   5.79\n" +
                        "FOOD       Apples           $   1.29\n" +
                        "UTENSILS   Plates           $  12.95\n" +
                        "FOOD       Spaghetti        $   2.79");
    }
}
