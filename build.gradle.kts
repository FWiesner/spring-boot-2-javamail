import org.jetbrains.kotlin.gradle.tasks.KotlinCompile



//val javaMailVersion = "1.6.1" // works
val javaMailVersion = "1.6.2-SNAPSHOT" // BOOM



plugins {
    kotlin("jvm") version "1.2.60"
    kotlin("plugin.spring") version "1.2.60"

    id("org.springframework.boot") version "2.0.4.RELEASE"
}

repositories {
    mavenLocal() // to fetch JavaMail from
    mavenCentral()
    jcenter()
}


val springBootVersion = "2.0.4.RELEASE"
val springIntegrationVersion = "5.0.7.RELEASE"

val micrometerVersion = "1.0.6"

val logbackVersion = "1.2.3"
val kotlinLoggingVersion = "1.5.4"

dependencies {
    compile(kotlin("reflect", "1.2.60"))
    compile(kotlin("stdlib-jdk8", "1.2.60"))
    compile("org.springframework.boot", "spring-boot-starter-webflux", springBootVersion)
    compile("org.springframework.boot", "spring-boot-starter-actuator", springBootVersion)
    compile("org.springframework.integration", "spring-integration-mail", springIntegrationVersion)

    compile(group = "ch.qos.logback", name = "logback-core", version = logbackVersion)
    compile(group = "io.github.microutils", name = "kotlin-logging", version = kotlinLoggingVersion)
    compile(group = "io.micrometer", name = "micrometer-core", version = micrometerVersion)
    compile(group = "io.micrometer", name = "micrometer-registry-prometheus", version = micrometerVersion)

    compile(group = "com.sun.mail", name = "smtp", version = javaMailVersion)

}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

group = "info.florian_wiesner"
version = "1.0.0-SNAPSHOT"

springBoot {
    mainClassName = "info.florian_wiesner.springbootjavamail.SpringBoot2Integration5JavaMailMainKt"
}

tasks {
    withType<Wrapper> {
        gradleVersion = "4.9"
    }

    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

}