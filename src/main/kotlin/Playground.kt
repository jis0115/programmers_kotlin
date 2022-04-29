
fun main() {
    println(solutionReport(arrayOf("muzi", "frodo", "apeach", "neo"), arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"),2).map { it })
    println(solutionReport(arrayOf("con", "ryan"), arrayOf("ryan con", "ryan con", "ryan con", "ryan con"),3).map { it })
}

// 신고 결과 받기
fun solutionReport(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
    val check = mutableMapOf<String,Int>().apply {
        id_list.forEach {
            put(it,0)
        }
    }
    report.distinct().map {
        val split = it.split(" ")
        Pair(split.last(),split.first())
    }.groupBy {
        it.first
    }.filter {
        it.value.size >= k
    }.values.forEach {  pairList ->
        pairList.map {
            it.second
        }.forEach {
            check[it] = check.getOrDefault(it,0) + 1
        }
    }
    return check.values.toIntArray()
}
