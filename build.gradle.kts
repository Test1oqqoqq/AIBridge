plugins {
    id("java")
}

group = "com.aibridge"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_21
java.targetCompatibility = JavaVersion.VERSION_21

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    // Paper API 1.21.4
    compileOnly("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")

    // WebSocket Client
    implementation("org.java-websocket:Java-WebSocket:1.5.4")
    
    // JSON Processing
    implementation("com.google.code.gson:gson:2.10.1")
    
    // Apache Commons
    implementation("commons-io:commons-io:2.15.1")
    implementation("commons-codec:commons-codec:1.16.0")
    
    // JUnit for testing
    testImplementation("junit:junit:4.13.2")
}

tasks {
    jar {
        archiveFileName.set("AIBridge-1.0.0.jar")
        manifest {
            attributes(
                "Main-Class" to "com.aibridge.AIBridgePlugin",
                "Implementation-Title" to "AIBridge",
                "Implementation-Version" to "1.0.0"
            )
        }
    }

    compileJava {
        options.encoding = "UTF-8"
        options.release = 21
    }

    test {
        useJUnit()
    }
}
