import java.lang.Math.round

// url: https://leetcode.com/problems/repeated-substring-pattern/
// problem_name :  Repeated Substring Pattern

class P459 {
	fun repeatedSubstringPattern(s: String?): Boolean {
		var middleIndex = s!!.length / 2
		while (middleIndex > 0) {
			var subString = s.substring(0, middleIndex)
			if (s.replace(subString, "").isEmpty()) {
				return true
			} else {
				middleIndex -= 1
			}
		}
		return false
	}
}

fun main() {
	val A = P459()
	println(A.repeatedSubstringPattern("babbabbabbabbab"))
	println(A.repeatedSubstringPattern("aba"))
}