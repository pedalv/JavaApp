package no.dfo.fp.functionalprogramming.lambdaadavanced.exercises;

import no.dfo.fp.functionalprogramming.streamsadvances.exercises.AdvancedStreamsExercise02;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static no.dfo.fp.functionalprogramming.model.Category.CLEANING;
import static no.dfo.fp.functionalprogramming.model.Category.FOOD;
import static no.dfo.fp.functionalprogramming.model.Category.OFFICE;
import static no.dfo.fp.functionalprogramming.model.Category.UTENSILS;
import static org.assertj.core.api.Assertions.assertThat;

class AdvancedStreamsExercise02Test {

    private AdvancedStreamsExercise02 exercise = new AdvancedStreamsExercise02();

    @Test
    @DisplayName("Count products per category")
    void countProductsPerCategory() {
        assertThat(exercise.countProductsPerCategory(TestData.getProducts()))
                .describedAs("Exercise 3: Your solution does not return the correct result.")
                .containsExactlyInAnyOrderEntriesOf(Map.of(FOOD, 2L, UTENSILS, 3L, CLEANING, 1L, OFFICE, 1L));
    }
}
