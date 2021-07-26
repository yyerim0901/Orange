val kotlin_version: String by extra
plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}
apply {
    plugin("kotlin-android")
}

listOf(
    "android.gradle",
).forEach { file ->
    apply(from = "${rootDir}/gradle/${file}")
}

dependencies {
    implementation(project(":data"))
    implementation("com.google.android.material:material:1.4.0")

    implementation(AndroidX.navigation_ui)
    implementation(AndroidX.navigation_fragment)
    
}

