package com.duodian.myapplication.rollingtextview.util

/**
 * 可以在原来的[list]上额外添加一个头元素[first]和一个尾元素[last]
 *
 * @param list 原来的list
 * @param first 可选的头节点，为空则不会添加
 * @param last 可选的尾节点，尾空则不会添加
 *
 * @author YvesCheung
 * 2018/3/3
 */
class ExtraList<T>(
        private val list: List<T>,
        private val first: T? = null,
        private val last: T? = null
) : List<T> {

    override val size: Int = when {
        first != null && last != null -> list.size + 2
        first != null || last != null -> list.size + 1
        else -> list.size
    }

    override fun contains(element: T): Boolean {
        return first == element || last == element || list.contains(element)
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return elements.all { contains(it) }
    }

    override fun get(index: Int): T {
        return when {
            index == 0 && first != null -> first
            index == size - 1 && last != null -> last
            first != null ->list[index - 1]
            else -> list[index]
        }
    }

    override fun indexOf(element: T): Int {
        if (first != null && first == element) {
            return 0
        }
        val rawFirstIndex = list.indexOf(element)
        return when {
            rawFirstIndex != -1 -> {
                when {
                    first != null -> rawFirstIndex + 1
                    else -> rawFirstIndex
                }
            }
            last != null && last == element -> size - 1
            else -> rawFirstIndex
        }
    }

    override fun isEmpty(): Boolean {
        return size <= 0
    }

    override fun iterator(): Iterator<T> = ExtraIterator()

    override fun lastIndexOf(element: T): Int {
        if (last != null && last == element) {
            return size - 1
        }
        val rawLastIndex = list.lastIndexOf(element)
        return when {
            rawLastIndex != -1 -> {
                when {
                    first != null -> rawLastIndex + 1
                    else -> rawLastIndex
                }
            }
            first != null && first == element -> 0
            else -> rawLastIndex
        }
    }

    override fun listIterator(): ListIterator<T> = ExtraIterator()

    override fun listIterator(index: Int): ListIterator<T> = ExtraIterator(index)

    override fun subList(fromIndex: Int, toIndex: Int): List<T> {
        throw IllegalStateException("Not Support")
    }

    private inner class ExtraIterator(private var index: Int = 0) : ListIterator<T> {

        init {
            if (index < 0 || index > size) {
                throw ArrayIndexOutOfBoundsException("index should be in range [0,$size] but now is $index")
            }
        }

        override fun hasNext() = index < size

        override fun hasPrevious() = index > 0

        override fun next(): T {
            if (!hasNext()) throw NoSuchElementException()
            return get(index++)
        }

        override fun nextIndex(): Int = index

        override fun previous(): T {
            if (!hasPrevious()) throw NoSuchElementException()
            return get(--index)
        }

        override fun previousIndex(): Int = index - 1
    }
}