@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.sqrt

// Урок 3: циклы
// Максимальное количество баллов = 9
// Рекомендуемое количество баллов = 7
// Вместе с предыдущими уроками = 16/21

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result *= i // Please do not fix in master
    }
    return result
}


/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая (2 балла) РЕШЕНО (Какие дополнительные проверки добавить в тестовую функцию я не придумал)
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {

    var count = 0
    var number = n
    if (number == 0) count++
    while (number > 0) {
        count++
        number /= 10
    }
    return count
}


/**
 * Простая (2 балла) РЕШЕНО
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int = if (n > 2) fib(n - 1) + fib(n - 2) else 1


/**
 * Простая (2 балла) РЕШЕНО
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var minDiv = 1
    for (i in 2..n) {
        if (n % i == 0) {
            minDiv = i
            break
        }
    }
    return minDiv
}


/**
 * Простая (2 балла) РЕШЕНО
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var minDiv = 1
    for (i in 2..n) {
        if (n % i == 0 && i < n) {
            minDiv = i
        }
    }
    return minDiv
}


/**
 * Простая (2 балла) РЕШЕНО
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {

    var counter = 0
    var xNext = x

    while (xNext != 1) {
        xNext = if (xNext % 2 == 0) {
            counter++
            xNext / 2
        } else {
            counter++
            xNext * 3 + 1
        }

    }
    return counter
}


/**
 * Средняя (3 балла) РЕШЕНО
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var k1 = m
    var k2 = n
    while (k2 != 0) {
        val d = k2
        k2 = k1 % k2
        k1 = d

    }

    return m * n / k1
}


/**
 * Средняя (3 балла) РЕШЕНО
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var k1 = m
    var k2 = n
    while (k2 != 0) {
        val d = k2
        k2 = k1 % k2
        k1 = d

    }

    return k1 == 1
}


/**
 * Средняя (3 балла) РЕШЕНО
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var n1 = n
    var n2 = 0
    while (n1 != 0) {
        val d = n1 % 10
        n1 /= 10
        n2 = n2 * 10 + d
    }
    return n2
}


/**
 * Средняя (3 балла) РЕШЕНО
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    var n1 = n
    var n2 = 0
    while (n1 != 0) {
        val d = n1 % 10
        n1 /= 10
        n2 = n2 * 10 + d
    }
    return n2 == n
}


/**
 * Средняя (3 балла) РЕШЕНО
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var n1 = n
    while (n1 != 0) {
        val d1 = n1 % 10
        n1 /= 10
        val d2 = n1 % 10
        if (d1 != d2 && d2 != 0) return true
    }

    return false
}


/**
 * Средняя (4 балла) РЕШЕНО
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double {
    var y = 0.0
    var sign = 1.0
    var n = 1
    val minX: Double = ((((x) * 180 / PI) % 360) * PI) / 180
    var sqrX = minX
    do {
        val y1 = sign * sqrX / factorial(n)
        y += y1
        sign *= -1
        sqrX *= minX * minX
        n += 2
    } while (abs(eps) < abs(y1))
    return y
}


/**
 * Средняя (4 балла) РЕШЕНО
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double {
    var y = 1.0
    var sign = 1.0
    var n = 2
    val minX: Double = ((((x) * 180 / PI) % 360) * PI) / 180
    var sqrX = minX * minX
    do {
        val y1 = -sign * sqrX / factorial(n)
        y += y1
        sign *= -1
        sqrX *= minX * minX
        n += 2
    } while (abs(eps) < abs(y1))
    return y
}

/**
 * Сложная (4 балла)
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var sqrX: Int
    var count = 0
    for (i in 1..n) {
        sqrX = i * i
        sqrX /= 10
        count++

    }

    return count
}

fun main() = println(squareSequenceDigit(9))

/**
 * Сложная (5 баллов)
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int = TODO()
