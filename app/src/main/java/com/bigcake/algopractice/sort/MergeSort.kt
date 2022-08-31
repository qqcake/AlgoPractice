package com.bigcake.algopractice.sort

import kotlin.math.min

object MergeSort {
    fun sort(input: IntArray): IntArray {
        val size = input.size
        if (size == 1) {
            return input
        }
        var currentSize = 1
        while (currentSize < size) {
            var start = 0
            while (start < size) {
                val mid = min(start + currentSize, size)
                val high = min(start + currentSize + currentSize, size)
                val (start1, end1) = Pair(start, mid)
                val (start2, end2) = Pair(mid, high)
                var i = 0
                var j = 0
                var k = start1
                val left = input.copyOfRange(start1, end1)
                val right = input.copyOfRange(start2, end2)
                while (i < left.size && j < right.size) {
                    input[k++] = if (left[i] < right[j]) left[i++] else right[j++]
                }
                while (i < left.size) {
                    input[k++] = left[i++]
                }
                while (j < right.size) {
                    input[k++] = right[j++]
                }
                start += (2 * currentSize)
            }
            currentSize += currentSize
        }
        return input
    }
}