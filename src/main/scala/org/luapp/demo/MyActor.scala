package org.luapp.demo

import akka.actor.Actor
import akka.actor.Actor.Receive
import akka.event.Logging


/**
 * Created by lumeng on 2014/12/15.
 */
class MyActor extends Actor{

    val log = Logging(context.system,this)

    override def receive: Receive = {
        case "test" => log.info("received test")
        case _ => log.info("received unknown message")
    }
}
