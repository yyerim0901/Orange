plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
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
    implementation(project(":ui-main"))
    implementation ("com.kakao.sdk:v2-user:2.5.2")
    implementation("com.google.android.material:material:1.3.0")
    implementation("io.coil-kt:coil:1.3.1")

    implementation(AndroidX.navigation_ui)
    implementation(AndroidX.navigation_fragment)
}

