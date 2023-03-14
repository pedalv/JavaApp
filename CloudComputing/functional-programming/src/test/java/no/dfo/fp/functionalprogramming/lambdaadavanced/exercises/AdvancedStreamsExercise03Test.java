package no.dfo.fp.functionalprogramming.lambdaadavanced.exercises;

import no.dfo.fp.functionalprogramming.streamsadvances.exercises.AdvancedStreamsExercise03;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static no.dfo.fp.functionalprogramming.lambdaadavanced.exercises.TestData.*;
import static no.dfo.fp.functionalprogramming.streamsadvances.exercises.AdvancedStreamsExercise03.PriceRange.CHEAP;
import static no.dfo.fp.functionalprogramming.streamsadvances.exercises.AdvancedStreamsExercise03.PriceRange.EXPENSIVE;
import static no.dfo.fp.functionalprogramming.streamsadvances.exercises.AdvancedStreamsExercise03.PriceRange.MEDIUM;
import static org.assertj.core.api.Assertions.assertThat;

class AdvancedStreamsExercise03Test {

    private AdvancedStreamsExercise03 exercise = new AdvancedStreamsExercise03();

    @Test
    @DisplayName("Group products by price range")
    void groupProductsByPriceRange() {
        assertThat(exercise.groupProductsByPriceRange(TestData.getProducts(), new BigDecimal("3.00"), new BigDecimal("6.00")))
                .describedAs("Exercise 4: Your solution does not return the correct result.")
                .containsExactlyInAnyOrderEntriesOf(Map.of(
                        CHEAP, List.of(APPLES, SPAGHETTI),
                        MEDIUM, List.of(PENCILS, DETERGENT),
                        EXPENSIVE, List.of(PLATES, KNIVES, FORKS)));
    }
}
