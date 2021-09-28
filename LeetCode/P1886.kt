//문제 이름 : Determine Whether Matrix Can Be Obtained By Rotation
//URL : https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/

class P1886 {
	fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
		var rotated: Array<IntArray> = mat.clone()

		for (k in 0..3) {
			rotated = rotate(rotated)
			if(isEquals(rotated, target)){
				return true
			}
		}
		return false
	}

	fun rotate(dim2 : Array<IntArray>) : Array<IntArray>{
		val tmp:Array<IntArray> = Array(dim2.size) { IntArray(dim2.size) { 0 } }
		for (i in dim2.indices) {
			for (j in dim2.indices) {
				tmp[dim2.size - 1 - j][i] = dim2[i][j]
			}
		}
		return tmp
	}

	fun isEquals(dim1: Array<IntArray>, dim2: Array<IntArray>) : Boolean{
		for( i in dim2.indices){
			for( j in dim2.indices){
				if(dim1[i][j] != dim2[i][j]){
					return false
				}
			}
		}
		return true
	}
}

fun main() {
	val sol = P1886()
	sol.findRotation(arrayOf(intArrayOf(0, 1), intArrayOf(1, 0)), arrayOf(intArrayOf(1, 0), intArrayOf(0, 1)))
}