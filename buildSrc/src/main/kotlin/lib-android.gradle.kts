plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlinx-serialization")
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
    }

    namespace = "eu.kanade.tachiyomi.lib.${name.replace("-", "")}"
}

dependencies {
    compileOnly(versionCatalogs.named("libs").findBundle("common").get())
}
