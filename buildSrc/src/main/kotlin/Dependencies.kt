object Dependencies {
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    object AndroidX {
        const val core = "androidx.core:core-ktx:${Versions.AndroidX.core}"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.AndroidX.lifecycleRuntime}"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.Compose.ui}"
        const val material = "androidx.compose.material:material:${Versions.Compose.material}"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.Compose.uiToolingPreview}"
        const val activity = "androidx.activity:activity-compose:${Versions.Compose.activity}"
        const val uiTest = "androidx.compose.ui:ui-test-junit4:${Versions.Compose.uiTestJUnit}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.Compose.uiTooling}"
    }

    object Testing {
        const val junit = "junit:junit:${Versions.Testing.junit}"
        const val junitExt = "androidx.test.ext:junit:${Versions.Testing.junitExt}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.Testing.espresso}"
    }
}
