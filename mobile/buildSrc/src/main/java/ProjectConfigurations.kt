import org.gradle.api.JavaVersion

object ProjectConfigurations {
    const val applicationId = "com.keelim.orange"
    const val compileSdk = 30
    const val minSdk = 24
    const val targetSdk = 30
    const val buildTools = "31.0.0"
    const val versionCode = 1
    const val versionName = "1.0.0"

    val javaVer = JavaVersion.VERSION_11
    const val javaVerString = "11"
}