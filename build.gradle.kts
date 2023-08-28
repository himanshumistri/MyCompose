// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    //build.gradle.kts (Kotlin)
    alias(libs.plugins.org.jetbrains.kotlin.kapt) apply false
    //id("com.google.devtools.ksp") version "1.8.10" apply false
}
true // Needed to make the Suppress annotation work for the plugins block