package org.luapp.demo

/**
 * Created by lumeng on 2014/12/7.
 */
class Counter {

    private var value = 0

    def increment(): Unit = {
        value+= 1
    }

    def current = value
}
