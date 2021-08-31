data class SearchResult<T>(val maxDepth: Int, val values: List<T>)
data class BstNode<T : Comparable<T>>(val value: T, var left: BstNode<T>?, var right: BstNode<T>?)

class BstSearch {

    companion object {
        fun <T : Comparable<T>> findDeepestNodes(input: List<T>): SearchResult<T> {
            if (input.isEmpty()) {
                return SearchResult(0, emptyList())
            }
            val bstTree = BstNode(input.first(), null, null)
            if (input.size == 1) {
                return SearchResult(0, listOf(bstTree.value))
            }
            var maxDepth = 0
            var valuesAtMaxDepth = mutableListOf<T>()
            input.subList(1, input.size).forEach { i ->
                val insertDepth = bstTree.placeItemInTree(1, i)
                if (insertDepth > maxDepth) {
                    maxDepth = insertDepth
                    valuesAtMaxDepth = mutableListOf(i)
                } else if (insertDepth == maxDepth) {
                    valuesAtMaxDepth.add(i)
                }
            }
            return SearchResult(maxDepth, valuesAtMaxDepth)
        }

        private fun <T : Comparable<T>> BstNode<T>.placeItemInTree(layer: Int, value: T): Int =
            when(value >= this.value) {
                true -> {
                    this.right?.placeItemInTree(layer + 1, value) ?: run {
                        this.right = BstNode(value, null, null)
                        layer
                    }
                }
                false -> {
                    this.left?.placeItemInTree(layer + 1, value) ?: run {
                        this.left = BstNode(value, null, null)
                        layer
                    }
                }
            }
    }
}
