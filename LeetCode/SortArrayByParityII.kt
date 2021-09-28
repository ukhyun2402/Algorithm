import java.util.*

class SortArrayByParityII {
	fun sortArrayByParityII(nums: IntArray): IntArray {
		// 짝수 자리에 짝수 홀수 자리에 홀수 들어갈 수 있는 경우 찾아서 리턴
		val N = ArrayList<Int>(nums.toList())
		val result = IntArray(N.size) { 0 }
		var index = 0
		while(N.isNotEmpty()){
			if(index % 2 == 0 && N[0] % 2 == 0){
				result[index++] = N.removeAt(0)
			} else if(index % 2 == 1 && N[0] % 2 == 1){
				result[index++] = N.removeAt(0)
			} else {
				N.add(N.removeAt(0))
			}
		}
//		println(result.toList())
		return result
	}
}

fun main() {
	val sol = SortArrayByParityII()
	sol.sortArrayByParityII(intArrayOf(4,2,5,7))
}