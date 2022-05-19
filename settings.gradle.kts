pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "beats-compose"
include(
    ":app",
    ":core:navigation",
    ":core:view-model",
    ":data:data",
    ":data:remote",
    ":domain",
    ":feature:login",
    ":ui:compose",
)
