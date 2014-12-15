package org.luapp.demo

import akka.actor.{ActorSystem, Props}

/**
 * Created by lumeng on 2014/12/15.
 */
object ActorTest extends App {

    """ ref: http://doc.akka.io/docs/akka/snapshot/scala/actors.html """

    val props1 = Props[MyActor]


    val system = ActorSystem("mySystem")
    val myActor = system.actorOf(Props[MyActor], "myActor")

    myActor ! "test"
    myActor ! "other"
}
