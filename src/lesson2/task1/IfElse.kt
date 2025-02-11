package lesson2.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.sqrt

// Урок 2: ветвления (здесь), логический тип (см. 2.2).
// Максимальное количество баллов = 6
// Рекомендуемое количество баллов = 5
// Вместе с предыдущими уроками = 9/12

/**
 * Пример
 *
 * Найти число корней квадратного уравнения ax^2 + bx + c = 0
 */
fun quadraticRootNumber(a: Double, b: Double, c: Double): Int {
    val discriminant = discriminant(a, b, c)
    return when {
        discriminant > 0.0 -> 2
        discriminant == 0.0 -> 1
        else -> 0
    }
}

/**
 * Пример
 *
 * Получить строковую нотацию для оценки по пятибалльной системе
 */
fun gradeNotation(grade: Int): String = when (grade) {
    5 -> "отлично"
    4 -> "хорошо"
    3 -> "удовлетворительно"
    2 -> "неудовлетворительно"
    else -> "несуществующая оценка $grade"
}

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    val y3 = max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -sqrt(y3)           // 7
}

/**
 * Простая (2 балла) РЕШЕНО
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
/**
Напишем алгоритм к первой задаче
Сначала определимся с интервалами
Лет: 0, 5-20, 25-30, 35-40, 45-50, 55-60, 65-70, 75-80, 85-90, 95-100, 105-120
Год: 1, 21, 31, 41, 51, 61, 71, 81, 91, 101
Года: 2, 3, 4, 22-24, 32-34, 42-44, 52-54, 62-64, 72-74, 82-84, 92-94, 102-104
Слишком много интервалов пока больше не могу придумать как реализовать решение!
Тесты то прошли и все работает, но вот размер когда смущает.
 */
fun ageDescription(age: Int): String {
    return when {
        (age in 5..20) ||
                (age in 25..30) ||
                (age in 35..40) ||
                (age in 45..50) ||
                (age in 55..60) ||
                (age in 65..70) ||
                (age in 75..80) ||
                (age in 85..90) ||
                (age in 95..100) ||
                (age in 105..120) ||
                (age in 125..130) ||
                (age in 135..140) ||
                (age in 145..150) ||
                (age in 155..160) ||
                (age in 165..170) ||
                (age in 175..180) ||
                (age in 185..190) ||
                (age in 195..199) -> "$age лет"

        (age == 2) ||
                (age == 3) ||
                (age == 4) ||
                (age in 22..24) ||
                (age in 32..34) ||
                (age in 42..44) ||
                (age in 52..54) ||
                (age in 62..64) ||
                (age in 72..74) ||
                (age in 82..84) ||
                (age in 92..94) ||
                (age in 102..104) ||
                (age in 122..124) ||
                (age in 132..134) ||
                (age in 142..144) ||
                (age in 152..154) ||
                (age in 162..164) ||
                (age in 172..174) ||
                (age in 182..184) ||
                (age in 192..194) -> "$age года"

        (age == 1) ||
                (age == 21) ||
                (age == 31) ||
                (age == 41) ||
                (age == 51) ||
                (age == 61) ||
                (age == 71) ||
                (age == 81) ||
                (age == 91) ||
                (age == 101) ||
                (age == 121) ||
                (age == 131) ||
                (age == 141) ||
                (age == 151) ||
                (age == 161) ||
                (age == 171) ||
                (age == 181) ||
                (age == 191) -> "$age год"

        else -> return ("Wasted")
    }

}


/**
 * Простая (2 балла) РЕШЕНО
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(
    t1: Double, v1: Double,
    t2: Double, v2: Double,
    t3: Double, v3: Double
): Double {

    val s1 = t1 * v1
    val s2 = t2 * v2
    val s3 = t3 * v3
    val halfS = (s1 + s2 + s3) / 2

    return if (halfS <= s1) {
        halfS / v1
    } else if ((halfS <= (s1 + s2))) {
        t1 + (halfS - s1) / v2
    } else if (halfS > (s1 + s2) && halfS <= (s1 + s2 + s3)) {
        t1 + t2 + (halfS - s1 - s2) / v3
    } else return halfS

}


/**
 * Простая (2 балла) РЕШЕНО
 *
 * На шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(
    kingX: Int, kingY: Int,
    rookX1: Int, rookY1: Int,
    rookX2: Int, rookY2: Int
): Int {
    return if (kingX == rookX1 && kingY == rookY2 || kingX == rookX2 && kingY == rookY1) {
        3
    } else if (kingX == rookX2 || kingY == rookY2) {
        2
    } else if (kingX == rookX1 || kingY == rookY1) {
        1
    } else 0
}


/**
 * Простая (2 балла) РЕШЕНО
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(
    kingX: Int, kingY: Int,
    rookX: Int, rookY: Int,
    bishopX: Int, bishopY: Int
): Int {
    return if (kingX == rookX && abs(kingX - bishopX) == abs(kingY - bishopY) || kingY == rookY && abs(kingX - bishopX) == abs(kingY - bishopY)) {
        3
    } else if (kingX == rookX || kingY == rookY) {
        1
    } else if (abs(kingX - bishopX) == abs(kingY - bishopY)) {
        2
    } else 0
}


/**
 * Простая (2 балла) РЕШЕНО
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */

fun triangleKind(a: Double, b: Double, c: Double): Int {

    if (a >= b && a >= c) {
        if ((sqr(a) < sqr(b) + sqr(c))) return 0
        if ((sqr(a) == sqr(b) + sqr(c))) return 1
        if ((sqr(a) > sqr(b) + sqr(c))) return 2
    }

    if (c >= a && c >= b) {
        if ((sqr(c) < sqr(a) + sqr(b))) return 0
        if ((sqr(c) == sqr(a) + sqr(b))) return 1
        if ((sqr(c) > sqr(a) + sqr(b))) return 2
    }
    return -1

}


/**
 * Средняя (3 балла) РЕШЕНО
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
    return if (b >= a && d >= c && a in c..d && b in c..d) {
        b - a
    } else if (b >= a && d >= c && c in a..b && d in a..b) {
        d - c
    } else if (b >= a && d >= c && b in c..d) {
        b - c
    } else if (b >= a && d >= c && d in a..b) {
        d - a
    } else return -1
}
