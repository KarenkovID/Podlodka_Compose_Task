package ru.ikarenkov.podlodca.compose.ui

fun Int.formatReviewCount(): String = when {
    this < 1_000 -> toString()
    this < 1_000_000 -> "${(this / 1_000)}K"
    else -> "${(this / 1_000_000)}M"
}