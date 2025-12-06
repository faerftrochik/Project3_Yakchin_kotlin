fun main(args: Array<String>) {

    println("Приветствую")
    println("Список задач:")
    println("Первая задача - 1")
    println("Вторая задача - 2")
    println("Третья задача - 3")
    println("Четвертая задача - 4")
    println("Введите задачу какую хотите увидеть - ")

    val inp = readLine()

    when (inp)
    {
        "0" -> return
        "1" -> teat1()
        "2" -> teat2()
        "3" -> teat3()
        "4" -> teat4()

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
    println("Введите ваш выбор => ")
    val user = readLine()!!.toInt()
    val comp = (1..3).random()

    println("Компьютер выбрал: $comp")

    if (user == comp)
    {
        println("Ничья")
    }
    else if (user == 1 && comp == 2 ||
        user == 2 && comp == 3 ||
        user == 3 && comp == 1)
    {
        println("Вы выиграли!")
    }
    else
    {
        println("Вы проиграли")
    }
}

fun teat2()
{
    //Задание 2

    println("Вы вошли в задачу 2, впишите сообщение что нужно зашифровать => ")

    val text = readLine()!!.uppercase()
    val helper = 'Я'
    var fix = text
    if (fix.length % 2 == 1) fix += helper

    val table = mutableMapOf<String, String>()
    var num = 1
    for (a in 'А'..'Я') {
        for (b in 'А'..'Я') {
            table["$a$b"] = num.toString().padStart(3, '0')
            num++
        }
    }

    var result = ""
    for (i in 0 until fix.length step 2) {
        val pair = "" + fix[i] + fix[i+1]
        result += table[pair] + " "
    }
    println(result)
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
