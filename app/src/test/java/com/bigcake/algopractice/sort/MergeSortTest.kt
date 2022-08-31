package com.bigcake.algopractice.sort

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class MergeSortTest {
    @DisplayName("Should sort list return correct results")
    @ParameterizedTest
    @MethodSource("sortDataProvider")
    fun iterativeSortTest(input: IntArray, expected: IntArray) {
        Assertions.assertTrue(MergeSort.bottomUp(input).contentEquals(expected))
    }

    @DisplayName("Should sort list return correct results")
    @ParameterizedTest
    @MethodSource("sortDataProvider")
    fun recursionSortTest(input: IntArray, expected: IntArray) {
        MergeSort.topDown(input)
        Assertions.assertTrue(input.contentEquals(expected))
    }

    companion object {
        @JvmStatic
        private fun sortDataProvider(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(
                    intArrayOf(3, 2, 1),
                    intArrayOf(1, 2, 3)
                ),
                Arguments.of(
                    IntRange(1, 100).step(1).shuffled().toIntArray(),
                    IntRange(1, 100).toList().toIntArray()
                )
            )
        }
    }
}