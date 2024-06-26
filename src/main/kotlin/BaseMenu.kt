import java.util.Scanner

abstract class BaseMenu<T>(val items: MutableList<T>, val itemName: String) : Menu {
    private val scanner = Scanner(System.`in`)

    override fun showMenu() {
        while (true) {
            println("Список $itemName:")
            println("0. Создать $itemName")

            for (i in items.indices) {
                println("${i + 1}. ${getItemName(items[i])}")
            }
            println("${items.size + 1}. Выход")

            val choice = checkInput(items.size + 1)
            when (choice) {
                0 -> createItem()
                items.size + 1 ->{
                    println("До свидания!")
                    break
                }
                else -> openItem(choice - 1)
            }
        }
    }

    abstract fun getItemName(item: T): String
    abstract fun createItem()
    abstract fun openItem(index: Int)

    protected fun checkInput(maxChoice: Int): Int {
        while (true) {
            val input = scanner.nextLine().trim()

            if (input.toIntOrNull() == null) {
                println("Следует вводить цифру. Попробуйте снова.")
                showMenu()
            } else {
                val number = input.toInt()
                if (number !in 0..maxChoice) {
                    println("Такой цифры нет. Введите корректное число от 0 до $maxChoice.")
                    showMenu()
                } else {
                    return number
                }
            }
        }
    }
}