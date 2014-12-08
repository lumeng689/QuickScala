package org.luapp.demo

import scala.beans.BeanProperty

/**
 * Created by lumeng on 2014/12/7.
 */
@SerialVersionUID(42L) class Person extends Serializable{
    var age = 0

    // 自动生成get set，符合javabean 规范
    @BeanProperty var name: String = _

    def this(name: String) {
        this()
        this.name = name
    }

    def this(name: String, age: Int) {
        this(name)
        this.age = age
    }
}
