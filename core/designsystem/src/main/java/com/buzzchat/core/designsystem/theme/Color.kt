package com.buzzchat.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val md_theme_light_primary = Color(0xFF506600)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFD2EE80)
val md_theme_light_onPrimaryContainer = Color(0xFF161E00)
val md_theme_light_secondary = Color(0xFF855300)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFFFDDB8)
val md_theme_light_onSecondaryContainer = Color(0xFF2A1700)
val md_theme_light_tertiary = Color(0xFF3A665E)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFBCECE2)
val md_theme_light_onTertiaryContainer = Color(0xFF00201C)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFFEFCF4)
val md_theme_light_onBackground = Color(0xFF1B1C17)
val md_theme_light_surface = Color(0xFFFEFCF4)
val md_theme_light_onSurface = Color(0xFF1B1C17)
val md_theme_light_surfaceVariant = Color(0xFFE3E4D3)
val md_theme_light_onSurfaceVariant = Color(0xFF46483C)
val md_theme_light_outline = Color(0xFF76786B)
val md_theme_light_inverseOnSurface = Color(0xFFF3F1E9)
val md_theme_light_inverseSurface = Color(0xFF30312C)
val md_theme_light_inversePrimary = Color(0xFFB6D167)
val md_theme_light_shadow = Color(0xFF000000)
val md_theme_light_surfaceTint = Color(0xFF506600)
val md_theme_light_outlineVariant = Color(0xFFC6C8B8)
val md_theme_light_scrim = Color(0xFF000000)

val md_theme_dark_primary = Color(0xFFB6D167)
val md_theme_dark_onPrimary = Color(0xFF283500)
val md_theme_dark_primaryContainer = Color(0xFF3C4D00)
val md_theme_dark_onPrimaryContainer = Color(0xFFD2EE80)
val md_theme_dark_secondary = Color(0xFFFFB95F)
val md_theme_dark_onSecondary = Color(0xFF472A00)
val md_theme_dark_secondaryContainer = Color(0xFF653E00)
val md_theme_dark_onSecondaryContainer = Color(0xFFFFDDB8)
val md_theme_dark_tertiary = Color(0xFFA1D0C6)
val md_theme_dark_onTertiary = Color(0xFF033731)
val md_theme_dark_tertiaryContainer = Color(0xFF204E47)
val md_theme_dark_onTertiaryContainer = Color(0xFFBCECE2)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Color(0xFF1B1C17)
val md_theme_dark_onBackground = Color(0xFFE4E3DB)
val md_theme_dark_surface = Color(0xFF1B1C17)
val md_theme_dark_onSurface = Color(0xFFE4E3DB)
val md_theme_dark_surfaceVariant = Color(0xFF46483C)
val md_theme_dark_onSurfaceVariant = Color(0xFFC6C8B8)
val md_theme_dark_outline = Color(0xFF909284)
val md_theme_dark_inverseOnSurface = Color(0xFF1B1C17)
val md_theme_dark_inverseSurface = Color(0xFFE4E3DB)
val md_theme_dark_inversePrimary = Color(0xFF506600)
val md_theme_dark_shadow = Color(0xFF000000)
val md_theme_dark_surfaceTint = Color(0xFFB6D167)
val md_theme_dark_outlineVariant = Color(0xFF46483C)
val md_theme_dark_scrim = Color(0xFF000000)

val seed = Color(0xFF8CA14E)
val ElectricBlue = Color(0xFF1CAEEE)
val MintGreen = Color(0xFF4EE39B)
val RoyalPurple = Color(0xFF5025BA)
val DeepRuby = Color(0xFF4E072E)
val BrilliantTurquoise = Color(0xFF60FCD5)
val SlateBlue = Color(0xFF5C6EBA)
val DarkMagenta = Color(0xFF942765)
val JungleGreen = Color(0xFF077E32)
val EmeraldGreen = Color(0xFF1DC487)
val Goldenrod = Color(0xFFFDB128)
val light_ElectricBlue = Color(0xFF00658D)
val light_onElectricBlue = Color(0xFFFFFFFF)
val light_ElectricBlueContainer = Color(0xFFC6E7FF)
val light_onElectricBlueContainer = Color(0xFF001E2D)
val dark_ElectricBlue = Color(0xFF83CFFF)
val dark_onElectricBlue = Color(0xFF00344B)
val dark_ElectricBlueContainer = Color(0xFF004C6B)
val dark_onElectricBlueContainer = Color(0xFFC6E7FF)
val light_MintGreen = Color(0xFF006D43)
val light_onMintGreen = Color(0xFFFFFFFF)
val light_MintGreenContainer = Color(0xFF6BFDB2)
val light_onMintGreenContainer = Color(0xFF002111)
val dark_MintGreen = Color(0xFF4ADF98)
val dark_onMintGreen = Color(0xFF003921)
val dark_MintGreenContainer = Color(0xFF005231)
val dark_onMintGreenContainer = Color(0xFF6BFDB2)
val light_RoyalPurple = Color(0xFF6641D1)
val light_onRoyalPurple = Color(0xFFFFFFFF)
val light_RoyalPurpleContainer = Color(0xFFE7DEFF)
val light_onRoyalPurpleContainer = Color(0xFF20005F)
val dark_RoyalPurple = Color(0xFFCDBDFF)
val dark_onRoyalPurple = Color(0xFF360096)
val dark_RoyalPurpleContainer = Color(0xFF4E22B8)
val dark_onRoyalPurpleContainer = Color(0xFFE7DEFF)
val light_DeepRuby = Color(0xFF974068)
val light_onDeepRuby = Color(0xFFFFFFFF)
val light_DeepRubyContainer = Color(0xFFFFD9E5)
val light_onDeepRubyContainer = Color(0xFF3E0022)
val dark_DeepRuby = Color(0xFFFFB0CE)
val dark_onDeepRuby = Color(0xFF5D1139)
val dark_DeepRubyContainer = Color(0xFF792950)
val dark_onDeepRubyContainer = Color(0xFFFFD9E5)
val light_BrilliantTurquoise = Color(0xFF006B57)
val light_onBrilliantTurquoise = Color(0xFFFFFFFF)
val light_BrilliantTurquoiseContainer = Color(0xFF5FFBD4)
val light_onBrilliantTurquoiseContainer = Color(0xFF002019)
val dark_BrilliantTurquoise = Color(0xFF38DEB9)
val dark_onBrilliantTurquoise = Color(0xFF00382C)
val dark_BrilliantTurquoiseContainer = Color(0xFF005141)
val dark_onBrilliantTurquoiseContainer = Color(0xFF5FFBD4)
val light_SlateBlue = Color(0xFF4559A9)
val light_onSlateBlue = Color(0xFFFFFFFF)
val light_SlateBlueContainer = Color(0xFFDDE1FF)
val light_onSlateBlueContainer = Color(0xFF001453)
val dark_SlateBlue = Color(0xFFB8C4FF)
val dark_onSlateBlue = Color(0xFF0F2878)
val dark_SlateBlueContainer = Color(0xFF2B4090)
val dark_onSlateBlueContainer = Color(0xFFDDE1FF)
val light_DarkMagenta = Color(0xFFA23371)
val light_onDarkMagenta = Color(0xFFFFFFFF)
val light_DarkMagentaContainer = Color(0xFFFFD8E7)
val light_onDarkMagentaContainer = Color(0xFF3D0025)
val dark_DarkMagenta = Color(0xFFFFAFD2)
val dark_onDarkMagenta = Color(0xFF63003F)
val dark_DarkMagentaContainer = Color(0xFF841858)
val dark_onDarkMagentaContainer = Color(0xFFFFD8E7)
val light_JungleGreen = Color(0xFF006E2A)
val light_onJungleGreen = Color(0xFFFFFFFF)
val light_JungleGreenContainer = Color(0xFF92F99D)
val light_onJungleGreenContainer = Color(0xFF002107)
val dark_JungleGreen = Color(0xFF76DC83)
val dark_onJungleGreen = Color(0xFF003912)
val dark_JungleGreenContainer = Color(0xFF00531D)
val dark_onJungleGreenContainer = Color(0xFF92F99D)
val light_EmeraldGreen = Color(0xFF006C48)
val light_onEmeraldGreen = Color(0xFFFFFFFF)
val light_EmeraldGreenContainer = Color(0xFF6AFCBA)
val light_onEmeraldGreenContainer = Color(0xFF002113)
val dark_EmeraldGreen = Color(0xFF48DF9F)
val dark_onEmeraldGreen = Color(0xFF003823)
val dark_EmeraldGreenContainer = Color(0xFF005235)
val dark_onEmeraldGreenContainer = Color(0xFF6AFCBA)
val light_Goldenrod = Color(0xFF815600)
val light_onGoldenrod = Color(0xFFFFFFFF)
val light_GoldenrodContainer = Color(0xFFFFDDB1)
val light_onGoldenrodContainer = Color(0xFF291800)
val dark_Goldenrod = Color(0xFFFFBA48)
val dark_onGoldenrod = Color(0xFF442B00)
val dark_GoldenrodContainer = Color(0xFF614000)
val dark_onGoldenrodContainer = Color(0xFFFFDDB1)

@Stable
class BuzzChatColorScheme(
    electricBlue: Color,
    onElectricBlue: Color,
    electricBlueContainer: Color,
    onElectricBlueContainer: Color,
    mintGreen: Color,
    onMintGreen: Color,
    mintGreenContainer: Color,
    onMintGreenContainer: Color,
    royalPurple: Color,
    onRoyalPurple: Color,
    royalPurpleContainer: Color,
    onRoyalPurpleContainer: Color,
    deepRuby: Color,
    onDeepRuby: Color,
    deepRubyContainer: Color,
    onDeepRubyContainer: Color,
    brilliantTurquoise: Color,
    onBrilliantTurquoise: Color,
    brilliantTurquoiseContainer: Color,
    onBrilliantTurquoiseContainer: Color,
    slateBlue: Color,
    onSlateBlue: Color,
    slateBlueContainer: Color,
    onSlateBlueContainer: Color,
    darkMagenta: Color,
    onDarkMagenta: Color,
    darkMagentaContainer: Color,
    onDarkMagentaContainer: Color,
    jungleGreen: Color,
    onJungleGreen: Color,
    jungleGreenContainer: Color,
    onJungleGreenContainer: Color,
    emeraldGreen: Color,
    onEmeraldGreen: Color,
    emeraldGreenContainer: Color,
    onEmeraldGreenContainer: Color,
    goldenrod: Color,
    onGoldenrod: Color,
    goldenrodContainer: Color,
    onGoldenrodContainer: Color,
) {
    var electricBlue by mutableStateOf(electricBlue)
        private set

    var onElectricBlue by mutableStateOf(onElectricBlue)
        private set

    var electricBlueContainer by mutableStateOf(electricBlueContainer)
        private set

    var onElectricBlueContainer by mutableStateOf(onElectricBlueContainer)
        private set

    var mintGreen by mutableStateOf(mintGreen)
        private set

    var onMintGreen by mutableStateOf(onMintGreen)
        private set

    var mintGreenContainer by mutableStateOf(mintGreenContainer)
        private set

    var onMintGreenContainer by mutableStateOf(onMintGreenContainer)
        private set

    var royalPurple by mutableStateOf(royalPurple)
        private set

    var onRoyalPurple by mutableStateOf(onRoyalPurple)
        private set

    var royalPurpleContainer by mutableStateOf(royalPurpleContainer)
        private set

    var onRoyalPurpleContainer by mutableStateOf(onRoyalPurpleContainer)
        private set

    var deepRuby by mutableStateOf(deepRuby)
        private set

    var onDeepRuby by mutableStateOf(onDeepRuby)
        private set

    var deepRubyContainer by mutableStateOf(deepRubyContainer)
        private set

    var onDeepRubyContainer by mutableStateOf(onDeepRubyContainer)
        private set

    var brilliantTurquoise by mutableStateOf(brilliantTurquoise)
        private set

    var onBrilliantTurquoise by mutableStateOf(onBrilliantTurquoise)
        private set

    var brilliantTurquoiseContainer by mutableStateOf(brilliantTurquoiseContainer)
        private set

    var onBrilliantTurquoiseContainer by mutableStateOf(onBrilliantTurquoiseContainer)
        private set

    var slateBlue by mutableStateOf(slateBlue)
        private set

    var onSlateBlue by mutableStateOf(onSlateBlue)
        private set

    var slateBlueContainer by mutableStateOf(slateBlueContainer)
        private set

    var onSlateBlueContainer by mutableStateOf(onSlateBlueContainer)
        private set

    var darkMagenta by mutableStateOf(darkMagenta)
        private set

    var onDarkMagenta by mutableStateOf(onDarkMagenta)
        private set

    var darkMagentaContainer by mutableStateOf(darkMagentaContainer)
        private set

    var onDarkMagentaContainer by mutableStateOf(onDarkMagentaContainer)
        private set

    var jungleGreen by mutableStateOf(jungleGreen)
        private set

    var onJungleGreen by mutableStateOf(onJungleGreen)
        private set

    var jungleGreenContainer by mutableStateOf(jungleGreenContainer)
        private set

    var onJungleGreenContainer by mutableStateOf(onJungleGreenContainer)
        private set

    var emeraldGreen by mutableStateOf(emeraldGreen)
        private set

    var onEmeraldGreen by mutableStateOf(onEmeraldGreen)
        private set

    var emeraldGreenContainer by mutableStateOf(emeraldGreenContainer)
        private set

    var onEmeraldGreenContainer by mutableStateOf(onEmeraldGreenContainer)
        private set

    var goldenrod by mutableStateOf(goldenrod)
        private set

    var onGoldenrod by mutableStateOf(onGoldenrod)
        private set

    var goldenrodContainer by mutableStateOf(goldenrodContainer)
        private set

    var onGoldenrodContainer by mutableStateOf(onGoldenrodContainer)
        private set

    fun copy(
        electricBlue: Color = this.electricBlue,
        onElectricBlue: Color = this.onElectricBlue,
        electricBlueContainer: Color = this.electricBlueContainer,
        onElectricBlueContainer: Color = this.onElectricBlueContainer,
        mintGreen: Color = this.mintGreen,
        onMintGreen: Color = this.onMintGreen,
        mintGreenContainer: Color = this.mintGreenContainer,
        onMintGreenContainer: Color = this.onMintGreenContainer,
        royalPurple: Color = this.royalPurple,
        onRoyalPurple: Color = this.onRoyalPurple,
        royalPurpleContainer: Color = this.royalPurpleContainer,
        onRoyalPurpleContainer: Color = this.onRoyalPurpleContainer,
        deepRuby: Color = this.deepRuby,
        onDeepRuby: Color = this.onDeepRuby,
        deepRubyContainer: Color = this.deepRubyContainer,
        onDeepRubyContainer: Color = this.onDeepRubyContainer,
        brilliantTurquoise: Color = this.brilliantTurquoise,
        onBrilliantTurquoise: Color = this.onBrilliantTurquoise,
        brilliantTurquoiseContainer: Color = this.brilliantTurquoiseContainer,
        onBrilliantTurquoiseContainer: Color = this.onBrilliantTurquoiseContainer,
        slateBlue: Color = this.slateBlue,
        onSlateBlue: Color = this.onSlateBlue,
        slateBlueContainer: Color = this.slateBlueContainer,
        onSlateBlueContainer: Color = this.onSlateBlueContainer,
        darkMagenta: Color = this.darkMagenta,
        onDarkMagenta: Color = this.onDarkMagenta,
        darkMagentaContainer: Color = this.darkMagentaContainer,
        onDarkMagentaContainer: Color = this.onDarkMagentaContainer,
        jungleGreen: Color = this.jungleGreen,
        onJungleGreen: Color = this.onJungleGreen,
        jungleGreenContainer: Color = this.jungleGreenContainer,
        onJungleGreenContainer: Color = this.onJungleGreenContainer,
        emeraldGreen: Color = this.emeraldGreen,
        onEmeraldGreen: Color = this.onEmeraldGreen,
        emeraldGreenContainer: Color = this.emeraldGreenContainer,
        onEmeraldGreenContainer: Color = this.onEmeraldGreenContainer,
        goldenrod: Color = this.goldenrod,
        onGoldenrod: Color = this.onGoldenrod,
        goldenrodContainer: Color = this.goldenrodContainer,
        onGoldenrodContainer: Color = this.onGoldenrodContainer,
    ): BuzzChatColorScheme = BuzzChatColorScheme(
        electricBlue = electricBlue,
        onElectricBlue = onElectricBlue,
        electricBlueContainer = electricBlueContainer,
        onElectricBlueContainer = onElectricBlueContainer,
        mintGreen = mintGreen,
        onMintGreen = onMintGreen,
        mintGreenContainer = mintGreenContainer,
        onMintGreenContainer = onMintGreenContainer,
        royalPurple = royalPurple,
        onRoyalPurple = onRoyalPurple,
        royalPurpleContainer = royalPurpleContainer,
        onRoyalPurpleContainer = onRoyalPurpleContainer,
        deepRuby = deepRuby,
        onDeepRuby = onDeepRuby,
        deepRubyContainer = deepRubyContainer,
        onDeepRubyContainer = onDeepRubyContainer,
        brilliantTurquoise = brilliantTurquoise,
        onBrilliantTurquoise = onBrilliantTurquoise,
        brilliantTurquoiseContainer = brilliantTurquoiseContainer,
        onBrilliantTurquoiseContainer = onBrilliantTurquoiseContainer,
        slateBlue = slateBlue,
        onSlateBlue = onSlateBlue,
        slateBlueContainer = slateBlueContainer,
        onSlateBlueContainer = onSlateBlueContainer,
        darkMagenta = darkMagenta,
        onDarkMagenta = onDarkMagenta,
        darkMagentaContainer = darkMagentaContainer,
        onDarkMagentaContainer = onDarkMagentaContainer,
        jungleGreen = jungleGreen,
        onJungleGreen = onJungleGreen,
        jungleGreenContainer = jungleGreenContainer,
        onJungleGreenContainer = onJungleGreenContainer,
        emeraldGreen = emeraldGreen,
        onEmeraldGreen = onEmeraldGreen,
        emeraldGreenContainer = emeraldGreenContainer,
        onEmeraldGreenContainer = onEmeraldGreenContainer,
        goldenrod = goldenrod,
        onGoldenrod = onGoldenrod,
        goldenrodContainer = goldenrodContainer,
        onGoldenrodContainer = onGoldenrodContainer,
    )

    override fun toString(): String {
        return "BuzzChatColorScheme(" +
            "electricBlue=$electricBlue, " +
            "onElectricBlue=$onElectricBlue, " +
            "electricBlueContainer=$electricBlueContainer, " +
            "onElectricBlueContainer=$onElectricBlueContainer, " +
            "mintGreen=$mintGreen, onMintGreen=$onMintGreen, " +
            "mintGreenContainer=$mintGreenContainer, " +
            "onMintGreenContainer=$onMintGreenContainer, " +
            "royalPurple=$royalPurple, " +
            "onRoyalPurple=$onRoyalPurple, " +
            "royalPurpleContainer=$royalPurpleContainer, " +
            "onRoyalPurpleContainer=$onRoyalPurpleContainer, " +
            "deepRuby=$deepRuby, " +
            "onDeepRuby=$onDeepRuby, " +
            "deepRubyContainer=$deepRubyContainer, " +
            "onDeepRubyContainer=$onDeepRubyContainer, " +
            "brilliantTurquoise=$brilliantTurquoise, " +
            "onBrilliantTurquoise=$onBrilliantTurquoise, " +
            "brilliantTurquoiseContainer=$brilliantTurquoiseContainer, " +
            "onBrilliantTurquoiseContainer=$onBrilliantTurquoiseContainer, " +
            "slateBlue=$slateBlue, " +
            "onSlateBlue=$onSlateBlue, " +
            "slateBlueContainer=$slateBlueContainer, " +
            "onSlateBlueContainer=$onSlateBlueContainer, " +
            "darkMagenta=$darkMagenta, " +
            "onDarkMagenta=$onDarkMagenta, " +
            "darkMagentaContainer=$darkMagentaContainer, " +
            "onDarkMagentaContainer=$onDarkMagentaContainer, " +
            "jungleGreen=$jungleGreen, " +
            "onJungleGreen=$onJungleGreen, " +
            "jungleGreenContainer=$jungleGreenContainer, " +
            "onJungleGreenContainer=$onJungleGreenContainer, " +
            "emeraldGreen=$emeraldGreen, " +
            "onEmeraldGreen=$onEmeraldGreen, " +
            "emeraldGreenContainer=$emeraldGreenContainer, " +
            "onEmeraldGreenContainer=$onEmeraldGreenContainer, " +
            "goldenrod=$goldenrod, " +
            "onGoldenrod=$onGoldenrod, " +
            "goldenrodContainer=$goldenrodContainer, " +
            "onGoldenrodContainer=$onGoldenrodContainer)"
    }
}

fun lightBuzzChatColorScheme() = BuzzChatColorScheme(
    electricBlue = light_ElectricBlue,
    onElectricBlue = light_onElectricBlue,
    electricBlueContainer = light_ElectricBlueContainer,
    onElectricBlueContainer = light_onElectricBlueContainer,
    mintGreen = light_MintGreen,
    onMintGreen = light_onMintGreen,
    mintGreenContainer = light_MintGreenContainer,
    onMintGreenContainer = light_onMintGreenContainer,
    royalPurple = light_RoyalPurple,
    onRoyalPurple = light_onRoyalPurple,
    royalPurpleContainer = light_RoyalPurpleContainer,
    onRoyalPurpleContainer = light_onRoyalPurpleContainer,
    deepRuby = light_DeepRuby,
    onDeepRuby = light_onDeepRuby,
    deepRubyContainer = light_DeepRubyContainer,
    onDeepRubyContainer = light_onDeepRubyContainer,
    brilliantTurquoise = light_BrilliantTurquoise,
    onBrilliantTurquoise = light_onBrilliantTurquoise,
    brilliantTurquoiseContainer = light_BrilliantTurquoiseContainer,
    onBrilliantTurquoiseContainer = light_onBrilliantTurquoiseContainer,
    slateBlue = light_SlateBlue,
    onSlateBlue = light_onSlateBlue,
    slateBlueContainer = light_SlateBlueContainer,
    onSlateBlueContainer = light_onSlateBlueContainer,
    darkMagenta = light_DarkMagenta,
    onDarkMagenta = light_onDarkMagenta,
    darkMagentaContainer = light_DarkMagentaContainer,
    onDarkMagentaContainer = light_onDarkMagentaContainer,
    jungleGreen = light_JungleGreen,
    onJungleGreen = light_onJungleGreen,
    jungleGreenContainer = light_JungleGreenContainer,
    onJungleGreenContainer = light_onJungleGreenContainer,
    emeraldGreen = light_EmeraldGreen,
    onEmeraldGreen = light_onEmeraldGreen,
    emeraldGreenContainer = light_EmeraldGreenContainer,
    onEmeraldGreenContainer = light_onEmeraldGreenContainer,
    goldenrod = light_Goldenrod,
    onGoldenrod = light_onGoldenrod,
    goldenrodContainer = light_GoldenrodContainer,
    onGoldenrodContainer = light_onGoldenrodContainer
)

fun darkBuzzChatColorScheme() = BuzzChatColorScheme(
    electricBlue = dark_ElectricBlue,
    onElectricBlue = dark_onElectricBlue,
    electricBlueContainer = dark_ElectricBlueContainer,
    onElectricBlueContainer = dark_onElectricBlueContainer,
    mintGreen = dark_MintGreen,
    onMintGreen = dark_onMintGreen,
    mintGreenContainer = dark_MintGreenContainer,
    onMintGreenContainer = dark_onMintGreenContainer,
    royalPurple = dark_RoyalPurple,
    onRoyalPurple = dark_onRoyalPurple,
    royalPurpleContainer = dark_RoyalPurpleContainer,
    onRoyalPurpleContainer = dark_onRoyalPurpleContainer,
    deepRuby = dark_DeepRuby,
    onDeepRuby = dark_onDeepRuby,
    deepRubyContainer = dark_DeepRubyContainer,
    onDeepRubyContainer = dark_onDeepRubyContainer,
    brilliantTurquoise = dark_BrilliantTurquoise,
    onBrilliantTurquoise = dark_onBrilliantTurquoise,
    brilliantTurquoiseContainer = dark_BrilliantTurquoiseContainer,
    onBrilliantTurquoiseContainer = dark_onBrilliantTurquoiseContainer,
    slateBlue = dark_SlateBlue,
    onSlateBlue = dark_onSlateBlue,
    slateBlueContainer = dark_SlateBlueContainer,
    onSlateBlueContainer = dark_onSlateBlueContainer,
    darkMagenta = dark_DarkMagenta,
    onDarkMagenta = dark_onDarkMagenta,
    darkMagentaContainer = dark_DarkMagentaContainer,
    onDarkMagentaContainer = dark_onDarkMagentaContainer,
    jungleGreen = dark_JungleGreen,
    onJungleGreen = dark_onJungleGreen,
    jungleGreenContainer = dark_JungleGreenContainer,
    onJungleGreenContainer = dark_onJungleGreenContainer,
    emeraldGreen = dark_EmeraldGreen,
    onEmeraldGreen = dark_onEmeraldGreen,
    emeraldGreenContainer = dark_EmeraldGreenContainer,
    onEmeraldGreenContainer = dark_onEmeraldGreenContainer,
    goldenrod = dark_Goldenrod,
    onGoldenrod = dark_onGoldenrod,
    goldenrodContainer = dark_GoldenrodContainer,
    onGoldenrodContainer = dark_onGoldenrodContainer
)

fun BuzzChatColorScheme.contentColorFor(backgroundColor: Color): Color =
    when (backgroundColor) {
        light_ElectricBlueContainer -> light_onElectricBlue
        light_MintGreenContainer -> light_onMintGreen
        light_RoyalPurpleContainer -> light_onRoyalPurple
        light_DeepRubyContainer -> light_onDeepRuby
        light_BrilliantTurquoiseContainer -> light_onBrilliantTurquoise
        light_SlateBlueContainer -> light_onSlateBlue
        light_DarkMagentaContainer -> light_onDarkMagenta
        light_JungleGreenContainer -> light_onJungleGreen
        light_EmeraldGreenContainer -> light_onEmeraldGreen
        light_GoldenrodContainer -> light_onGoldenrod
        dark_ElectricBlueContainer -> dark_onElectricBlue
        dark_MintGreenContainer -> dark_onMintGreen
        dark_RoyalPurpleContainer -> dark_onRoyalPurple
        dark_DeepRubyContainer -> dark_onDeepRuby
        dark_BrilliantTurquoiseContainer -> dark_onBrilliantTurquoise
        dark_SlateBlueContainer -> dark_onSlateBlue
        dark_DarkMagentaContainer -> dark_onDarkMagenta
        dark_JungleGreenContainer -> dark_onJungleGreen
        dark_EmeraldGreenContainer -> dark_onEmeraldGreen
        dark_GoldenrodContainer -> dark_onGoldenrod
        else -> Color.Unspecified
    }

fun BuzzChatColorScheme.backgroundColorFor(contentColor: Color): Color =
    when (contentColor) {
        light_onElectricBlue -> light_ElectricBlueContainer
        light_onMintGreen -> light_MintGreenContainer
        light_onRoyalPurple -> light_RoyalPurpleContainer
        light_onDeepRuby -> light_DeepRubyContainer
        light_onBrilliantTurquoise -> light_BrilliantTurquoiseContainer
        light_onSlateBlue -> light_SlateBlueContainer
        light_onDarkMagenta -> light_DarkMagentaContainer
        light_onJungleGreen -> light_JungleGreenContainer
        light_onEmeraldGreen -> light_EmeraldGreenContainer
        light_onGoldenrod -> light_GoldenrodContainer
        dark_onElectricBlue -> dark_ElectricBlueContainer
        dark_onMintGreen -> dark_MintGreenContainer
        dark_onRoyalPurple -> dark_RoyalPurpleContainer
        dark_onDeepRuby -> dark_DeepRubyContainer
        dark_onBrilliantTurquoise -> dark_BrilliantTurquoiseContainer
        dark_onSlateBlue -> dark_SlateBlueContainer
        dark_onDarkMagenta -> dark_DarkMagentaContainer
        dark_onJungleGreen -> dark_JungleGreenContainer
        dark_onEmeraldGreen -> dark_EmeraldGreenContainer
        dark_onGoldenrod -> dark_GoldenrodContainer
        else -> Color.Unspecified
    }

val LocalBuzzChatColorScheme = staticCompositionLocalOf {
    lightBuzzChatColorScheme()
}

@Composable
fun buzzChatColorScheme(): BuzzChatColorScheme = LocalBuzzChatColorScheme.current