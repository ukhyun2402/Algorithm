class SplitLinkedListInParts {
	fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
		val nums = ArrayList<Int>()
		var cursor = head
		while(cursor != null) {
			nums.add(cursor.`val`)
			cursor = cursor.next
		}
		val perUnitCount = (nums.size / k).coerceAtLeast(1)
		var left = (nums.size - perUnitCount * k).coerceAtLeast(0)

		val answer: Array<ListNode?> = Array(k){null}

		for(i in 0 until k){
			if(nums.size == 0) break
			val tmpListNode = ListNode(nums.removeAt(0))
 			var tmpCursor = tmpListNode

			var sup = if (left-- > 0 ) 1 else 0

			for(j in 0 until perUnitCount - 1 + sup){
				tmpCursor.next = ListNode(nums.removeAt(0))
				tmpCursor = tmpCursor.next!!
			}
			answer[i] = tmpListNode
		}
		return answer
	}
}

class ListNode(var `val`: Int) {
	var next: ListNode? = null
}

fun main() {
	val input:ListNode = ListNode(1)
	var cursor = input
	for( i in 0 .. 8){
		cursor.next = ListNode(i + 2)
		cursor = cursor.next!!
	}

	val sol = SplitLinkedListInParts()
	sol.splitListToParts(input,3)
}