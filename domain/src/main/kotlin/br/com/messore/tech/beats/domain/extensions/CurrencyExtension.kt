package br.com.messore.tech.beats.domain.extensions

import java.text.NumberFormat

fun Double.formatCurrency(): String {
    return NumberFormat.getCurrencyInstance()
        .format(this)
}
