import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import kotlin.test.assertEquals

class BstSearchTest {

    @Test
    fun `Execute base case`() {
        val input = "12,11,90,82,7,9"
            .split(",").map { it.toInt() }

        val result = BstSearch.findDeepestNodes(input)

        assertEquals(1, result.values.size)
        assertEquals(9, result.values.first())
        assertEquals(3, result.maxDepth)
    }

    @Test
    fun `Execute a 2nd test case`() {
        val input = "71,12,13,5,4,3,2,1,56,34,17,19"
            .split(",").map { it.toInt() }

        val result = BstSearch.findDeepestNodes(input)

        assertEquals(2, result.values.size)
        assertThat(result.values).containsAll(listOf(1, 19))
        assertEquals(6, result.maxDepth)
    }
}
