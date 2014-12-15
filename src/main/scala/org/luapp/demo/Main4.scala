package org.luapp.demo

import scala.math._

/**
 * Created by lumeng on 2014/12/9.
 */
object Main4 extends App {

    // _意味着指定的是函数，而不是忘记了传递参数
    val fun = ceil _

    for (item <- Array(3.14, 1.42, 2).map(fun)) println(item)

    val triple = (x: Double) => x * 3

    println(triple(5))

    for (item <- Array(3.14, 1.42, 2).map { (x: Double) => 3 * x}) println(item)

    def valueAtOneQuarter(f: (Double) => Double) = f(0.25)

    println(valueAtOneQuarter(ceil _))
    println(valueAtOneQuarter(sqrt _))

    println(valueAtOneQuarter(x => x * 3))
    println(valueAtOneQuarter(_ * 3))

    // '' 代表字符  "" 代表字符串
    (1 to 9).map("*" * _).foreach(println _)

    val digits = Set(1, 7, 2, 9)
    val primes = Set(2, 3, 5, 7)

    (digits union primes).foreach(println _)
    (digits & primes).foreach(println _)
    (digits -- primes).foreach(println _)

    println(identity(digits))

    def ulcase(s: String) = Vector(s.toUpperCase(), s.toLowerCase())

    val names = List("Peter", "Paul", "Mary")

    names.map(ulcase).foreach(println _)
    names.flatMap(ulcase).foreach(println _)

    // (1 - 7 - 2 - 9)
    println(List(1, 7, 2, 9).reduceLeft(_ - _))

    val prices = List(5.0, 20.0, 9.95)
    val quantities = List(10, 2, 1)

    println((prices zip quantities) map { p => p._1 * p._2} sum)

    "Scala".zipWithIndex.foreach(println _)

    // 流
    def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n + 1)

    val tenOrMore = numsFrom(10)

    println(tenOrMore)

    println(tenOrMore.take(5).force)

    // 懒视图
    println((0 to 1000).view.map(pow(10, _)).map(1 / _).force)
}
