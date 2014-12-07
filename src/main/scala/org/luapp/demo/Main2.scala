package org.luapp.demo

/**
 * Created by lumeng on 2014/12/7.
 */
object Main2 {

    def main(args: Array[String]): Unit = {

        val counter = new Counter();
        println(counter.current)
        counter.increment()
        println(counter.current)

        val p = new Person()
        p.age = 11
        println(p.age)

        p.setName("zhangsan")
        println(p.getName)

        val person2 = new Person2("lisi",30)
        println(person2.name)

        if (person2.isInstanceOf[Person2]) {
            println("is a person2")
            val p2 = person2.asInstanceOf[Person2]
        } else {
            println("is not a person2")
        }

        if(person2.getClass == classOf[Person2]) {
            println("is a person2")
        }

        // 枚举
        for(c <- TrafficLightColor.values) println(c.id)
    }
}
