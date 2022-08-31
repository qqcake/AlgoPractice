package com.bigcake.algopractice.sort

import kotlin.math.min

object MergeSort {
    fun bottomUp(input: IntArray): IntArray {
        val size = input.size
        if (size == 1) {
            return input
        }
        var currentSize = 1
        while (currentSize < size) {
            var start = 0
            while (start < size) {
                val mid = min(start + currentSize, size)
                val end = min(start + currentSize + currentSize, size)
                val left = input.copyOfRange(start, mid)
                val right = input.copyOfRange(mid, end)
                merge(input, start, left, right)
                start += (2 * currentSize)
            }
            currentSize += currentSize
        }
        return input
    }

    fun topDown(input: IntArray) {
        val n = input.size
        if (n == 1) {
            return
        }
        val mid = n / 2
        val (left, right) = Pair(input.copyOfRange(0, mid), input.copyOfRange(mid, n))
        topDown(left)
        topDown(right)
        merge(input, 0, left, right)
    }

    private fun merge(destination: IntArray, start: Int, left: IntArray, right: IntArray) {
        var (i, j, k) = intArrayOf(0, 0, start)
        while (i < left.size && j < right.size) {
            destination[k++] = if (left[i] < right[j]) left[i++] else right[j++]
        }
        while (i < left.size) {
            destination[k++] = left[i++]
        }
        while (j < right.size) {
            destination[k++] = right[j++]
        }
    }
}