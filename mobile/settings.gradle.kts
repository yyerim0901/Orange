
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://plugins.gradle.org/m2/")
    }
}
rootProject.name = "orange"

include(
    ":app",
    ":common",
    ":data",
    ":domain",
    ":ui-feed",
    ":ui-noti",
    ":ui-season",
    ":ui-auth",
    ":ui-fight",
)

arrayOf(
    ":ui-feed",
    ":ui-noti",
    ":ui-season",
    ":ui-auth",
    ":ui-fight",
).forEach { name ->
    project(name).projectDir = File(rootDir, "features/${name.substring(startIndex = 1)}")
}
