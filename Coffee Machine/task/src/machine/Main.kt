package machine
import java.util.Scanner

fun main() {
    CoffeeMachine.whatWant()
}

class CoffeeMachine {
    companion object {
        fun whatWant() {
            var water = 400
            var milk = 540
            var coffee = 120
            var cup = 9
            var money = 550
            var type: String
            var exit = true
            while (exit) {
                println("Write action (buy, fill, take, remaining, exit):")
                var scanner = Scanner(System.`in`)
                val want = scanner.next()
                when (want) {
                    "buy" -> {
                        type = buy()
                        when (type) {
                            "back" -> {

                            }
                            "1" -> {
                                if (water - 250 >= 0 && coffee - 16 >= 0 && cup >= 1) {
                                    water -= 250
                                    milk -= 0
                                    coffee -= 16
                                    cup -= 1
                                    money += 4
                                    println("I have enough resources, making you a coffee!")
                                } else println("Sorry, not enough resources!")
                            }

                            "2" -> {
                                if (water - 350 >= 0 && milk - 75 >= 0 && coffee - 20 >= 0 && cup >= 1) {
                                    water -= 350
                                    milk -= 75
                                    coffee -= 20
                                    cup -= 1
                                    money += 7
                                    println("I have enough resources, making you a coffee!")
                                } else println("Sorry, not enough resources!")
                            }

                            "3" -> {
                                if (water - 200 >= 0 && milk - 100 >= 0 && coffee - 12 >= 0 && cup >= 1) {
                                    water -= 200
                                    milk -= 100
                                    coffee -= 12
                                    cup -= 1
                                    money += 6
                                    println("I have enough resources, making you a coffee!")
                                } else println("Sorry, not enough resources!")
                            }

                        }
                    }
                    "fill" -> {
                        println("Write how many ml of water do you want to add:")
                        water = water + scanner.nextInt()
                        println("Write how many ml of milk do you want to add:")
                        milk = milk + scanner.nextInt()
                        println("Write how many grams of coffee beans do you want to add:")
                        coffee = coffee + scanner.nextInt()
                        println("Write how many disposable cups of coffee do you want to add:")
                        cup = cup + scanner.nextInt()
                    }
                    "take" -> {
                        take(money)
                        money = 0
                    }
                    "remaining" -> remaining(water, milk, coffee, cup, money)
                    "exit" -> exit = false
                }
            }
        }

        fun remaining(water: Int, milk: Int, coffee: Int, cup: Int, money: Int) {
            println("The coffee machine has:\n" +
                    "$water of water\n" +
                    "$milk of milk\n" +
                    "$coffee of coffee beans\n" +
                    "$cup of disposable cups\n" +
                    "$money of money\n")
        }

        fun buy(): String {
            println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
            var scanner = Scanner(System.`in`)
            val type = scanner.next()
            return type
        }

        fun take(money: Int) {
            println("I gave you \$$money")
        }
    }
}
