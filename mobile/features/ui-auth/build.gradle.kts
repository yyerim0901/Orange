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
    implementation(project(":common"))
    implementation(project(":domain"))

    implementation("com.google.android.material:material:1.4.0")

    implementation(AndroidX.navigation_ui)
    implementation(AndroidX.navigation_fragment)

    implementation("com.kakao.sdk:v2-user:2.5.2")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.annotation:annotation:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
}
android {
    buildFeatures {
        viewBinding = true
    }
}

