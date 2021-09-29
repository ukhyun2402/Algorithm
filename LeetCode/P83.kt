// Problem Name : Remove Duplicates from Sorted List
// URL : https://leetcode.com/problems/remove-duplicates-from-sorted-list/

class P83 {
	fun deleteDuplicates(head: ListNode?): ListNode? {
		var answer: ListNode? = null
		if(head != null ){
			answer = ListNode(head.`val`)
		}

		var headCursor = head
		var answerCursor = answer

		while(headCursor != null && answerCursor != null){
			if(answerCursor.`val` < headCursor.`val`){
				answerCursor.next = ListNode(headCursor.`val`)
				answerCursor = answerCursor.next
			}
			headCursor = headCursor.next
		}

		return answer
	}
}

fun main() {
	val input:ListNode = ListNode(1)
	var cursor = input
	for( i in arrayOf(1,2)){
		cursor.next = ListNode(i )
		cursor = cursor.next!!
	}
	val sol = P83()
	sol.deleteDuplicates(input)
}