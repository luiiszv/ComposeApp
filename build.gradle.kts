// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.compose.compiler) apply false

    // Plugin Hilt
    alias(libs.plugins.hilt) apply false

    // Plugin Kapt (no uses KSP si no es necesario)
    alias(libs.plugins.kapt) apply false
}
