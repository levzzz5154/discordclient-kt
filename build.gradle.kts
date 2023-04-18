plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("jakarta.websocket:jakarta.websocket-client-api:2.1.0")
    implementation("jakarta.websocket:jakarta.websocket-all:2.1.0")
    implementation("jakarta.websocket:jakarta.websocket-api:2.1.0")
    implementation("org.glassfish.tyrus.bundles:tyrus-standalone-client:2.1.3")

}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("MainKt")
}