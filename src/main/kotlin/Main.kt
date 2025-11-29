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
        "4" -> teat4()
        "5" -> teat5()
        "6" -> teat6()

        else -> print("Ввести надо одну цифру...")
    }
}

fun teat1()
{
    //Задание 1

    println("Введите строку:")
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

fun teat4()
{
    //Задание 4

    println("Введите выражение (число1 число2 операция):")
    val input = readLine() ?: ""

    val parts = input.trim().split(Regex("\\s+"))
    if (parts.size != 3) {
        println("Неверный ввод. Введите: число1 число2 операция")
        return
    }

    try {
        val a = parts[0].toDouble()
        val b = parts[1].toDouble()
        val op = parts[2]

        val result = when (op) {
            "+" -> println("Результат: ${a + b}")
            "-" -> println("Результат: ${a - b}")
            "*" -> println("Результат: ${a * b}")
            "/" -> if (b != 0.0) println("Результат: ${a / b}") else "Деление на ноль"
            else -> "Неизвестная операция"
        }

        println("Результат: $result")
    } catch (e: Exception) {
        println("Ошибка ввода")
    }
}

fun teat5()
{
    //Задание 5

    println("Введите число n:")
    val nInput = readLine()
    println("Введите основание степени x:")
    val xInput = readLine()

    try {
        val n = nInput?.toInt() ?: 0
        val x = xInput?.toInt() ?: 0

        var y = 0
        var pow = 1
        var found = false

        while (pow <= n) {
            if (pow == n) {
                found = true
                break
            }
            y++
            pow *= x
        }

        if (found) {
            println("Целочисленный показатель y = $y")
        } else {
            println("Целочисленный показатель не существует")
        }
    } catch (e: Exception) {
        println("Ошибка ввода")
    }
}

fun teat6()
{
    //Задание 6

    println("Введите первую цифру:")
    val aInput = readLine()
    println("Введите вторую цифру:")
    val bInput = readLine()

    try {
        val a = aInput?.toInt() ?: 0
        val b = bInput?.toInt() ?: 0

        if (a == b) {
            println("Цифры должны быть разными")
            return
        }

// число нечётное если последняя цифра нечётная
        if (a % 2 == 1) {
            println("Результат: ${b * 10 + a}")
        } else if (b % 2 == 1) {
            println("Результат: ${a * 10 + b}")
        } else {
            println("Создать нечетное число невозможно")
        }
    } catch (e: Exception) {
        println("Ошибка ввода")
    }
}
