package org.luapp.demo

/**
 * Created by lumeng on 2014/12/7.
 */
object Main3 extends App{

    if (args.length > 0) {
        println("Hello " + args(0))
    } else {
        println("Hello, world!")
    }

    delayedInit({println("test")})


}
