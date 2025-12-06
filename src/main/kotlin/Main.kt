fun main(args: Array<String>) {

    println("Приветствую")
    println("Список задач:")
    println("Первая задача - 1")
    println("Вторая задача - 2")
    println("Третья задача - 3")
    println("Четвертая задача - 4")
    println("Пятая задача - 5")
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
    for (a in 'А'..'Я')
    {
        for (b in 'А'..'Я')
        {
            table["$a$b"] = num.toString().padStart(3, '0')
            num++
        }
    }

    var result = ""
    for (i in 0 until fix.length step 2)
    {
        val pair = "" + fix[i] + fix[i+1]
        result += table[pair] + " "
    }
    println(result)
}

fun teat3()
{
    //Задание  1 из 2го

    println("Вы вошли в задачу 3 => ")

    println("Введите количество строк:")
    val rows = readLine()!!.toInt()
    println("Введите количество столбцов:")
    val cols = readLine()!!.toInt()

    val arr = Array(rows){IntArray(cols)}
    println("Введите трехзначные числа:")
    for (i in 0 until rows)
    {
        for (j in 0 until cols)
        {
            arr[i][j] = readLine()!!.toInt()
        }
    }

    val digits = mutableSetOf<Char>()
    for (i in 0 until rows)
    {
        for (j in 0 until cols)
        {
            for (c in arr[i][j].toString()) digits.add(c)
        }
    }

    println("Массив:")
    for (i in 0 until rows)
    {
        for (j in 0 until cols) print("${arr[i][j]} ")
        println()
    }
    println("Различных цифр: ${digits.size}")
}

fun teat4()
{
    //Задание 3 из 2го

    println("Вы вошли в задачу 4 => ")

    val alphabet = arrayOf(
        'А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н','О','П',
        'Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ь','Ы','Ъ','Э','Ю','Я'
    )
    val nums = IntArray(33)
    println("Введите 33 числа:")
    for (i in 0..32) nums[i] = readLine()!!.toInt()

    println("1 - шифровать, 2 - расшифровать:")
    val mode = readLine()!!.toInt()
    println("Введите текст:")
    val text = readLine()!!.uppercase()
    println("Введите ключ:")
    val key = readLine()!!.uppercase()

    fun findIndex(ch: Char): Int = alphabet.indexOf(ch)

    var result = ""
    var k = 0
    for (c in text)
    {
        val shift = nums[ findIndex(key[k]) ]
        val pos = findIndex(c)
        val newPos =
            if (mode == 1) (pos + shift) % 33
            else (pos - shift + 33) % 33
        result += alphabet[newPos]
        k++; if (k == key.length) k = 0
    }
    println(result)
}

fun teat5()
{
    //Задание 5 из 2го

    println("Вы вошли в задачу 5 => ")

    println("Введите количество слов:")
    val n = readLine()!!.toInt()
    val map = mutableMapOf<String, MutableList<String>>()

    println("Введите слова:")
    for (i in 0 until n)
    {
        val w = readLine()!!.lowercase()
        val key = w.toCharArray().sorted().joinToString("")
        map.putIfAbsent(key, mutableListOf())
        map[key]!!.add(w)
    }

    println("Группы:")
    for (g in map.values)
    {
        println(g.joinToString(", "))
    }
}
