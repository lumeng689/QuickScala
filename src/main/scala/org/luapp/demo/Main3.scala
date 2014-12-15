package org.luapp.demo

import java.io.{File, PrintWriter, IOException}
import java.net.MalformedURLException
import java.nio.file.attribute.BasicFileAttributes
import java.nio.file.{Files, FileVisitResult, Path, SimpleFileVisitor}

import scala.io.Source

/**
 * Created by lumeng on 2014/12/7.
 */
object Main3 extends App {

    if (args.length > 0) {
        println("Hello " + args(0))
    } else {
        println("Hello, world!")
    }

    // 以下语句会最后输出
    delayedInit({
        println("in end, test")
    })

    lazy val source = Source.fromFile(getClass.getResource("/myfile.txt").getFile(), "UTF-8")

    try {
        val lineIterator = source.getLines

        for (line <- lineIterator) {
            println(line)
        }

        println(source.mkString)
    } catch {
        case _: MalformedURLException => println("Bad file")
        case ex: IOException => ex.printStackTrace()
    } finally {
        source.asInstanceOf[Source].close()
    }

    val out = new PrintWriter("numbers.txt")
    for (i <- 1 to 100) {
        out.println(i)
    }

    out.close()

    println("write completed......");

    implicit def makeFileVisitor(f:(Path) =>Unit) = new SimpleFileVisitor[Path] {
        override def visitFile(p: Path, attrs: BasicFileAttributes): FileVisitResult = {
            f(p)
            FileVisitResult.CONTINUE
        }
    }

    Files.walkFileTree(new File("d:/test").toPath,(f:Path)=>println(f))

    val numPattern = "[0-9]+".r
    for (matchString <- numPattern.findAllIn("99 bottles,98 bottles")) {
        println("find:" + matchString)
    }

    // 正则表达式组
    val numitemPattern = "([0-9]+) ([a-z]+)".r

    val numitemPattern(num,item) = "99 bottles"

    println("get num:" + num)
    println("get item:" + item)
}
