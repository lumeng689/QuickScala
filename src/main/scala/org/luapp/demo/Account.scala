package org.luapp.demo

/**
 * Created by lumeng on 2014/12/7.
 */
class Account private(val id: Int, initialBalance: Double) {
    //val id = Account.newUniqueNumber()

    private var balance = initialBalance

    def deposit(amount: Double): Unit = {
        balance += amount
    }
}

/**
 * 每个类都可以有一个伴生对象，必须和类放到同一个源文件中
 */
object Account {
    private var lastNumber = 0

    def apply(initialBalance: Double) = {
        new Account(newUniqueNumber(), initialBalance);
    }

    private def newUniqueNumber() = {
        lastNumber += 1
        lastNumber
    }
}
