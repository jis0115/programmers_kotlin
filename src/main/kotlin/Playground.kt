
fun main() {
    //신고 결과 받기
//    println(solutionReport(arrayOf("muzi", "frodo", "apeach", "neo"), arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"),2).map { it })
//    println(solutionReport(arrayOf("con", "ryan"), arrayOf("ryan con", "ryan con", "ryan con", "ryan con"),3).map { it })

    //로또의 최고 순위와 최저 순위
//    println(solutionLottoRank(intArrayOf(45, 4, 35, 20, 3, 9), intArrayOf(20, 9, 3, 45, 4, 35)).map { it })
//    println(solutionLottoRank(intArrayOf(0, 0, 0, 0, 0, 0), intArrayOf(38, 19, 20, 40, 15, 25)).map { it })

    // 소수 만들기
//    println(solutionMakeDecimal(intArrayOf(1,2,3,4)))
//    println(solutionMakeDecimal(intArrayOf(1,2,7,6,4)))

    //H-Index
    println(solutionHIndex(intArrayOf(3, 0, 6, 1, 5)))
    println(solutionHIndex(intArrayOf(3,44,1,2,4,5,9,6,7,445,243,45)))
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

//로또의 최고 순위와 최저 순위
fun solutionLottoRank(lottos: IntArray, win_nums: IntArray): IntArray {
    fun getWinRank(num:Int) = (6-num) + if (num > 0) {1} else {0}
    val sameCount = lottos.filter { it>0 }.count {num-> win_nums.contains(num) }
    return intArrayOf(getWinRank(sameCount+(lottos.count { it == 0 })),getWinRank(sameCount))
}


//소수 만들기
fun solutionMakeDecimal(nums: IntArray): Int {
    //개수찾기
    fun <T> combination(answer: MutableList<List<T>>, el: List<T>, ck: Array<Boolean>, start: Int, target: Int) {
        if(target == 0) {
            answer.addAll( listOf(el.filterIndexed { index, t -> ck[index] }) )
        } else {
            for(i in start until el.size) {
                ck[i] = true
                combination(answer, el, ck, i + 1, target - 1)
                ck[i] = false
            }
        }
    }
    //소수체크
    fun isDecimal(n:Int):Boolean {
        var i = 2
        while(i * i <= n){
            if( n % i++ == 0) return false
        }
        return true
    }
    val combinationList = mutableListOf<List<Int>>()
    combination(combinationList,nums.toList(), Array(nums.size){false},0,3)
    return combinationList.count {isDecimal(it.sum())}
}


//H-Index
fun solutionHIndex(citations: IntArray): Int {
    var answer = 0
    citations.sort()
    for (i in citations.indices){
        answer = answer.coerceAtLeast(citations[i].coerceAtMost(citations.size - i))
    }
    return answer
}