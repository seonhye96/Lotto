package com.naesseuapp.lotto

import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

object LottonumberMaker {
    /* -- Shuffle 사용 랜덤번호 --*/
    fun getShuffleLottoNumbers():MutableList<Int>{
        // 1~45 번에 로또 번호를 저장할 리스트 생성
        var list = mutableListOf<Int>()

        // 1~45 까지 for 문을 돌면서 리스트에 로또 번호 저장
        for(number in 1..45){
            list.add(number)
        }

        // 리스트를 무작위로 섞음
        list.shuffle()

        return list.subList(0, 6)
    }

    /* -- Random() 사용 랜덤번호 --
    //    랜덤으로 1~45 번중 하나의 번호를 생성하는 함수
    fun getRandomLottoNumber() : Int {
        //Random.nextInt 는 0~전달받은 파라미터 값 미만의 번호를 생성
        // ex) Random().nextInt(10) 은 0~9 까지의 무작위 수를 반환
        // 1~45 까지의 번호를 생성하려면 파라미터의 45를 넣고 결과값의 1을 더한다.
        return Random().nextInt(45)+1
    }

    // 랜덤으로 추출하여 6개의 로또 번호를 만드는 함수
    fun getRandomLottoNumbers() : MutableList<Int>{
        //무작위로 생성된 로또 번호를 저장할 가변 리스트 생성
        val lottoNumbers = mutableListOf<Int>()

        // 6번 반복하는 for문
        for (i in 1..6){
            var number = 0
            do{
                //랜덤한 번호를 추출해 number 변수에 저장
                number = getRandomLottoNumber()
                // lottoNumbers 에 number 변수의 값이 없을 때까지 반복
            }while (lottoNumbers.contains(number))
            // 이미 뽑은 리스트에 없는 번호가 나올때까지 반복했으므로 중복이 없는 상태
            // 추출된 번호를 뽑은 리스트에 추가
            lottoNumbers.add(number)
        }
        return lottoNumbers
    }
     */

    /*입력받은 이름에 대한 해시코드를 사용하여 로또번호를 섞고 결과 반환*/
    fun getLottoNumbersFromHash(str : String):MutableList<Int>{
        var list = mutableListOf<Int>()

        for (number in 1..45){
            list.add(number)
        }

        var targetString = SimpleDateFormat("yyyy-MM-dd").format(Date()) + str

        list.shuffle(Random(targetString.hashCode().toLong()))

        return list.subList(0, 6)
    }
}