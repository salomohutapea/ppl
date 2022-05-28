import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.tasks.testing.TestResult.ResultType

plugins {
    kotlin("jvm") version "1.6.21"
    id("org.jetbrains.kotlinx.kover") version "0.5.1"
}

group = "org.example"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("org.jetbrains.kotlinx:kover:0.5.1")

    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
}

apply(plugin = "kover")

tasks.test {
    useJUnitPlatform()

    extensions.configure(kotlinx.kover.api.KoverTaskExtension::class) {
        isDisabled = false
        binaryReportFile.set(file("$buildDir/custom/result.bin"))
    }

    reports {
        junitXml.required.set(false)
        html.required.set(true)
    }

    testLogging {
        showCauses = false
        showExceptions = false
        showStackTraces = false
        showStandardStreams = false

        val ansiReset = "\u001B[0m"
        val ansiGreen = "\u001B[32m"
        val ansiRed = "\u001B[31m"
        val ansiYellow = "\u001B[33m"

        fun getColoredResultType(resultType: ResultType): String {
            return when (resultType) {
                ResultType.SUCCESS -> "$ansiGreen $resultType $ansiReset"
                ResultType.FAILURE -> "$ansiRed $resultType $ansiReset"
                ResultType.SKIPPED -> "$ansiYellow $resultType $ansiReset"
            }
        }

        afterTest(
            KotlinClosure2({ desc: TestDescriptor, result: TestResult ->
                println("${desc.className} | ${desc.displayName} = ${getColoredResultType(result.resultType)}")
            })
        )

        afterSuite(
            KotlinClosure2({ desc: TestDescriptor, result: TestResult ->
                if (desc.parent == null) {
                    println("Result: ${result.resultType} (${result.testCount} tests, ${result.successfulTestCount} passed, ${result.failedTestCount} failed, ${result.skippedTestCount} skipped)")
                }
            })
        )
    }
}

tasks.koverHtmlReport {
    isEnabled = true                        // false to disable report generation
    htmlReportDir.set(layout.buildDirectory.dir("my-project-report/html-result"))
}


tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}