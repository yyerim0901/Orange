dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
        maven("https://devrepo.kakao.com/nexus/content/groups/public/")
    }
}

rootProject.name = "orange"

include(
    ":app",
    ":data",
    ":common",
    ":domain",
    ":ui-auth",
    ":ui-feed",
    ":ui-fight",
    ":ui-noti",
    ":ui-season",
)
arrayOf(
    ":ui-auth",
    ":ui-feed",
    ":ui-fight",
    ":ui-noti",
    ":ui-season",
).forEach { name ->
    project(name).projectDir = File(rootDir, "features/${name.substring(startIndex = 1)}")
}