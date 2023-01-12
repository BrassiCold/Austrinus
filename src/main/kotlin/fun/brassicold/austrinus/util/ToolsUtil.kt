package `fun`.brassicold.austrinus.util

fun percentInto(amount: String): Int? {
    val length = amount.length
    if (amount.length > 3 ) { if (amount != "100%") { return null } }
    val lastChar = amount.last()
    if (lastChar != '%') { return null }
    val number = amount.subSequence(0,length-1).toString().toInt()
    return (number / 100)
}
