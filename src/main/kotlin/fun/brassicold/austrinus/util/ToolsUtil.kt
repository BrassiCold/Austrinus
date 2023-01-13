package `fun`.brassicold.austrinus.util

fun percentInto(percent: String): Double {
    val percentWithoutSymbol = percent.removeSuffix("%")
    return percentWithoutSymbol.toDouble() / 100
}
