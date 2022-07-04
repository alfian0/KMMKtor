import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

buildscript {
    extra.apply{
        set("compose_version", "1.2.0")
        set("ktor_version", "2.0.3")
    }
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
        classpath("com.android.tools.build:gradle:7.2.1")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
    afterEvaluate {
        // Remove log pollution until Android support in KMP improves.
        project.extensions.findByType<KotlinMultiplatformExtension>()?.let { kmpExt ->
            kmpExt.sourceSets.removeAll {
                setOf(
                    "androidAndroidTestRelease",
                    "androidTestFixtures",
                    "androidTestFixturesDebug",
                    "androidTestFixturesRelease",
                ).contains(it.name)
            }
        }
    }
}

//plugins {
//    id ("com.android.application") version "7.2.1" apply false
//    id ("com.android.library") version "7.2.1" apply false
//    id ("org.jetbrains.kotlin.android") version "1.5.31" apply false
//}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}