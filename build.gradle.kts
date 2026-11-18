plugins {
    java
    antlr
}

repositories {
    mavenCentral()
}

dependencies {
    // Parser generator, used at build time only. The runtime below is what ships in the jars.
    antlr("org.antlr:antlr4:4.7.2")
    implementation("org.antlr:antlr4-runtime:4.7.1")
    // 2.0.21, used before the Gradle migration, was never published to Maven Central.
    implementation("args4j:args4j:2.0.22")
    implementation("org.apache.commons:commons-lang3:3.1")

    testImplementation(platform("org.junit:junit-bom:5.11.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// The antlr plugin adds the whole ANTLR tool to the compile and runtime classpaths; only the runtime is needed.
configurations.api {
    setExtendsFrom(extendsFrom.filterNot { it.name == "antlr" })
}

tasks.generateGrammarSource {
    packageName = "nusmv_counterexample_visualizer.generated"
}

tasks.withType<JavaCompile>().configureEach {
    // The jars must keep running on Java 8.
    options.release = 8
    options.encoding = "UTF-8"
    // Silences "source value 8 is obsolete" on newer JDKs.
    options.compilerArgs.add("-Xlint:-options")
}

// Self-contained jars, one per entry point.
fun registerFatJar(taskName: String, fileName: String, mainClass: String) =
    tasks.register<Jar>(taskName) {
        group = BasePlugin.BUILD_GROUP
        description = "Builds $fileName, including all dependencies."
        archiveFileName = fileName
        manifest {
            attributes("Main-Class" to mainClass)
        }
        from(sourceSets.main.get().output)
        from(configurations.runtimeClasspath.map { classpath -> classpath.map { zipTree(it) } })
        exclude("META-INF/*.SF", "META-INF/*.DSA", "META-INF/*.RSA")
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }

val consoleJar = registerFatJar("consoleJar", "visualizer-console.jar", "nusmv_counterexample_visualizer.ConsoleMain")
val guiJar = registerFatJar("guiJar", "visualizer-gui.jar", "nusmv_counterexample_visualizer.GUIMain")

tasks.assemble {
    dependsOn(consoleJar, guiJar)
}

tasks.register<Copy>("updateJars") {
    group = BasePlugin.BUILD_GROUP
    description = "Copies the built jars into jars/, the downloadable binaries referenced by the README."
    from(consoleJar, guiJar)
    into(layout.projectDirectory.dir("jars"))
}

// Snapshot tests read the example inputs from the project root.
val exampleInputs = files("example-input.txt", "example-input-nuxmv-reals.txt")

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    // ConsoleMain writes its output with the platform charset.
    jvmArgs("-Dfile.encoding=UTF-8")
    inputs.files(exampleInputs)
    testLogging {
        events("failed", "skipped")
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}

tasks.register<Test>("updateGolden") {
    group = LifecycleBasePlugin.VERIFICATION_GROUP
    description = "Re-records the snapshot files in src/test/resources/golden. Review the diff afterwards."
    testClassesDirs = sourceSets.test.get().output.classesDirs
    classpath = sourceSets.test.get().runtimeClasspath
    systemProperty("golden.update", "true")
    filter {
        includeTestsMatching("*GoldenOutputTest")
    }
    outputs.upToDateWhen { false }
}
