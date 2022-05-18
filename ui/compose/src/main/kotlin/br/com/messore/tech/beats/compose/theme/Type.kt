package br.com.messore.tech.beats.compose.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import br.com.messore.tech.beats.compose.R

private val DefaultFontFamily = FontFamily(
    Font(R.font.dm_sans, FontWeight.Normal),
    Font(R.font.dm_sans_bold, FontWeight.Bold),
)

private val TitleLarge = TextStyle(
    fontFamily = DefaultFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 45.sp,
    lineHeight = 58.sp,
    textAlign = TextAlign.Center
)

private val LabelLarge = TitleLarge.copy(
    fontSize = 18.sp,
    lineHeight = 23.sp,
    letterSpacing = (-0.5).sp
)

private val LabelMedium = LabelLarge.copy(
    fontSize = 14.sp,
    lineHeight = 18.sp,
    letterSpacing = 0.2.sp
)

private val LabelSmall = LabelMedium.copy(
    fontSize = 12.sp,
    lineHeight = 15.sp
)

val Typography = Typography(
    titleLarge = TitleLarge,
    labelLarge = LabelLarge,
    labelMedium = LabelMedium,
    labelSmall = LabelSmall,
)