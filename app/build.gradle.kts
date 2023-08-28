import org.jetbrains.kotlin.js.translate.context.Namer.kotlin

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {

    //id(libs.plugins.androidApplication.get().pluginId) apply false
    //id(libs.plugins.kotlinAndroid.get().pluginId) apply false
    //id(libs.plugins.org.jetbrains.kotlin.kapt.get().pluginId) apply false

    //id("com.google.dagger.hilt.android") version "2.44" apply false
    //id(libs.plugins.daggerHiltAndroid.get().pluginId) apply false

    alias(libs.plugins.androidApplication) apply true
    alias(libs.plugins.kotlinAndroid) apply true
    alias(libs.plugins.daggerHiltAndroid) apply true
    alias(libs.plugins.org.jetbrains.kotlin.kapt) apply  true
   // alias(libs.plugins.kotlin.kapt)
    //alias(libs.plugins.google.ksp)
    //id (libs.plugins.org.jetbrains.kotlin.kapt.get().pluginId)
    //alias(libs.plugins.)
}

android {
    namespace = "com.himanshu.compose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.himanshu.compose"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
   /* kotlinOptions {
        jvmTarget = "1.8"
    }*/
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

hilt {
    enableAggregatingTask = false
}

kapt {
    correctErrorTypes =true
}
/*tasks.withType<org.jetbrains.kotlin.gradle.tasks.KaptGenerateStubs> {
    kotlinOptions {
        jvmTarget="1.8"
    }
}*/


dependencies {

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
    //implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.10"))
    //Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    kapt(libs.hilt.android.compiler)
    //hilt-android-compiler

    //hilt-navigation-compose
    implementation (libs.hilt.navigation.compose)
    //hilt-kapt


    implementation (libs.navigation.compose)

    //kapt "com.google.dagger:hilt-compiler:2.45"

   // implementation 'androidx.navigation:navigation-compose:2.6.0'
    //kapt()
}