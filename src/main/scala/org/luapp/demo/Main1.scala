package org.luapp.demo

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks;
import scala.collection.JavaConversions.propertiesAsScalaMap;

/**
 * Created by lumeng on 2014/12/6.
 */
object Main1 {

    def main(args: Array[String]): Unit = {

        // val 代表对象不可变   可变的用var
        val hello = "hello world"

        val i: Int = 6

        println(hello.toUpperCase)
        println(i)

        // 构建range
        val r = 1.to(10)

        println(r)

        // apply方法
        println("Hello"(4))
        println("Hello".apply(4))

        for (i <- 1.to(10))
            print(i + " ")

        println()

        // 相当于双重循环
        for (i <- 1 to 3; j <- 1 to 3)
            print((10 * i + j) + " ")

        // 懒值
        lazy val words = scala.io.Source.fromFile("d:/test/1.txt")

        println(fn(2, 9))

        // 定长数组
        val nums = new Array[Int](10)
        // 提供了初值的就不在需要new操作符
        val s = Array("hello", "world")
        // 访问元素用()
        s(0) = "hello1"

        // 变长数组
        val b = ArrayBuffer[Int]()
        b += 1
        b ++= Array(2, 3, 4)

        // until 不包含上界值
        for (i <- 0 until b.length) {
            println(i + ":" + b(i))
        }

        val result = for (elem <- b) yield elem * 2
        println(result)

        val a = b.toArray
        val a1 = a.filter(_ % 2 == 0).map(_ * 2)
        for (elm <- a1) {
            println(elm)
        }

        val matrix1 = Array.ofDim[Int](3, 4)
        val matrix2 = new Array[Array[Int]](10)


        val scores = Map("alice" -> 10, "Bob" -> 20, "Jim" -> 30)
        println(scores)

        val scores2 = new mutable.HashMap[String, Int]()
        scores2 += "Alice" -> 30

        val bobScore = scores.getOrElse("Bob", 0)
        println(bobScore)

        scores2 -= "Alice"


        for ((k, v) <- scores) {
            println(k + ":" + v);
        }

        // key value 互换
        val scores3 = for ((k, v) <- scores) yield (v, k)
        println(scores3);

        val props: scala.collection.Map[String, String] = System.getProperties()
        println(props)

        val t = (1, 3.14, "Fred")
        println(t._2)

        println("New York".partition(_.isUpper))

        // 拉链操作
        val symbols = Array("<","-",">")
        val counts = Array(2,10,2)
        val pairs = symbols.zip(counts)
        for ((a,b) <-pairs) {
            Console.println(a + ":" + b)
        }
    }

    /**
     * 求X的N次方
     *
     * @param x
     * @param n
     * @return
     */
    def fn(x: Int, n: Int): Int = {

        if (n < 0) {
            // 不需要return ，最后一条表达式的值就是返回值
            1 / fn(x, -n)
        } else if (n == 0) {
            1
        } else if (n % 2 == 0) {
            val y: Int = fn(x, n / 2)
            y * y
        } else {
            x * fn(x, n - 1)
        }
    }
}
