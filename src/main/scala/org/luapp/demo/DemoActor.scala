package org.luapp.demo

import akka.actor.{Props, Actor}
import akka.actor.Actor.Receive

/**
 * Created by lumeng on 2014/12/15.
 */
object DemoActor {

    def props(magicNumber: Int): Props = {
        Props(new DemoActor(magicNumber))
    }
}

class DemoActor(magicNumber: Int) extends Actor {
    override def receive: Receive = {
        case x: Int => sender() ! (x + magicNumber)
    }
}
