//fun main(args: Array<String>) {
//    val size = readLine()!!.toInt()
//    println(size)
//    for (idx in 1 .. size){
//        println("*".repeat(idx))
//    }
//}

fun main() {
    println("test")

//    solution1(intArrayOf(2,1,3,4,1))
//    solution1(intArrayOf(5,0,2,7))

//    solution3(5).forEach { println(it) }

//    solution1(
//        arrayOf(
//            intArrayOf(1,4),
//            intArrayOf(3,4),
//            intArrayOf(3,10)
//        )
//    )
//
//    solution1(
//        arrayOf(
//            intArrayOf(1,1),
//            intArrayOf(2,2),
//            intArrayOf(1,2)
//        )
//    )

    solution2(
        arrayOf(
            arrayOf("b","a","a","d"),
            arrayOf("b","c","a","c"),
            arrayOf("b","a","d","c")
        )
    )

}

/*
풀이
위와 같이 2차원 배열의 3개의 값을 이용해 나머지 한 점을 구하면 된다.
직사각형을 만들기 위해선 직선이 필요하다. 이 말이 무엇이냐면 x와 y의 좌표 값은 두 개씩 중복된다.

[[1,4],[3,4],[3,10]] 을 보면 x값 3이 2개이고 y값 4가 2개이다. 그렇다면 하나씩 남은 1과 10을 이용해서 답을 구할 수 있다. [1,10]
 */
fun solution1(v: Array<IntArray>): IntArray {
    var answer = intArrayOf()
//    answer = intArrayOf(v.minOf { it[0] },v.maxOf { it[1] })
    answer = intArrayOf(
        v[0][0].xor(v[1][0].xor(v[2][0])),
        v[0][1].xor(v[1][1].xor(v[2][1]))
    )

    println("Hello Kotlin >> ${answer[0]},${answer[1]}")




    return answer
}


fun solution3(n: Int): IntArray {
    val answer = IntArray(n,{ it+1 })
    println(answer)
    return answer
}



fun solution2(rounds:Array<Array<String>>):Int{
    var result = 0
    data class People(var name:String,var prevCoupleName:String= ""){
        fun isSelectMe() = name ==prevCoupleName
    }

    var oldSelect:MutableList<People> = mutableListOf()
    rounds.forEach {
        val convert = it.mapIndexed { index, s ->
            if (index == 0){
                People("a",s)
            }else if (index == 1){
                People("b",s)
            }else if (index == 2){
                People("c",s)
            }else{
                People("d",s)
            }
        }
        if (oldSelect.isEmpty()){
            convert.forEach {
                if (it.isSelectMe()){
                    result++
                }
                println(it)
            }
            oldSelect.addAll(convert)
        }else{
            
        }
    }

    intArrayOf(1,2,3,).forEachIndexed { index, i ->

    }

    println("result > $result")


//    var peopleMap:MutableMap = mutableMapOf<>()





    /*
    1. 규칙을어겼는지 체크..
    2. 규칙 = 나 자신을 선택 했는지
    3. 규칙 = 이전에 나와 커플 됐던 사람을 또 선택했는지.
    결과 : 내가 선택한 사람이 나를 선택 했으면 커플이됨.
     */

    return result
}


//fun solution1(numbers: IntArray): IntArray {
//    var answer: IntArray = intArrayOf()
//    numbers.sort()
//    val result = mutableListOf<Int>()
//    for (idx in 0 until numbers.size-1)
//    {
//        val num1 = numbers[idx]
//        for (idx2 in idx+1 until numbers.size)
//        {
//            val num2 = numbers[idx2]
//            result.add(num1 + num2)
//        }
//    }
//    answer = result.distinct().toIntArray()
//    return answer
//}


