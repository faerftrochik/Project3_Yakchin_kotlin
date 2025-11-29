fun main(args: Array<String>) {

    println("Приветствую")
    println("Список задач:")
    println("Первая задача - 1")
    println("Вторая задача - 2")
    println("Третья задача - 3")
    println("Четвертая задача - 4")
    println("Пятая задача - 5")
    println("Шестая задача - 6")
    println("Введите задачу какую хотите увидеть - ")

    val inp = readLine()

    when (inp)
    {
        "0" -> return
        "1" -> teat1()
        "2" -> teat2()
        "3" -> teat3()

        else -> print("Ввести надо одну цифру...")
    }
}

fun teat1()
{
    //Задание 1

    println("Приветствую в игре камень, ножницы, бумага")
    println("Список возможностей: ")
    println("1 - это камень")
    println("2 - ножницы")
    println("3 - бумага")
    println("Правила игры:")
    println("Бумага побеждает камень («бумага обёртывает камень»).\n Камень побеждает ножницы («камень затупляет или ломает ножницы»). \n" +
            "Ножницы побеждают бумагу («ножницы разрезают бумагу»). \n" +
            "Если игроки показали одинаковый знак, то засчитывается ничья и игра переигрывается.")
    println("Хотите начать игру? => ")
    val input = readLine() ?: ""
    if (input.isEmpty()) {
        println("Строка пустая")
        return
    }

    var result = ""
    var count = 1

    for (i in 1 until input.length) {
        if (input[i] == input[i - 1]) {
            count++
        } else {
            result += input[i - 1]
            if (count > 1) result += count
            count = 1
        }
    }

    result += input.last()
    if (count > 1) result += count

    println("Результат: $result")
}

fun teat2()
{
    //Задание 2

    println("Введите строку:")
    val input = readLine() ?: ""
    if (input.isEmpty()) {
        println("Строка пустая")
        return
    }

    val map = mutableMapOf<Char, Int>()

    for (ch in input) {
        map[ch] = (map[ch] ?: 0) + 1
    }

    val sorted = map.toSortedMap()

    for ((key, value) in sorted) {
        println("$key - $value")
    }
}

fun teat3()
{
    //Задание 3

    println("Введите натуральное число:")
    val input = readLine()

    try {
        val number = input?.toInt() ?: throw Exception("Пустой ввод")
        if (number < 0)
        {
            println("введите неотрицательное число")
            return
        }
        println("В двоичной системе: ${number.toString(2)}")
    } catch (e: Exception) {
        println("Ошибка ввода: введите целое число")
    }
}
