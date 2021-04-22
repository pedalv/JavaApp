# [Gradle](https://gradle.org/)
- What Is gradle?
 * Convention based build tool
 * DSL to describe the build
 * Supports multi-project builds
 * Easily customizable
 * Builds many languages
 * Supports dependencies
- Install
 * From the web site
  - All platforms
 * SDK manager (for Linux and Mac)
  - https://sdkman.io
   * curl -s 'https://get.sdkman.io' | bash
   * add to path
   * install Gradle
   	* sdk install gradle
  - *nix platforms
  - Can also install on Cygwin etc...
 * Homebrew (for Mac)
  - brew update
  - brew install gradle     
- How Is Grade Used?
 * Create a build script: Kotlin or Groovy DSL
 * This defines tasks: build, clean, etc
 * Run the appropriate task: from the command line or an IDE  
- Gradle mostly consists of 
 * Projects
 * Tasks
- Build has one or more projects
- Project has one or more tasks
- Plugins extend project
- What Is in a Project?
  * 'build' file
    - build.grade
    - build.gradle.kts
  * Optional settings file
- What Is in a Build File
 * Build file defines the tasks
    - Either pre-defined
    - Or directly
    - Or indirectly through plugins
- Build Phases
 * Initialization
 * Configuration
 * Execution
- Execution Phase
 * doFirst
 * doLast
- Task Dependencies
- Creating a Build
  * Create a 'build' file
  * Add the appropriate plugin(s)
  * Override task and properties
- Plugins
 * Extend project's capabilities
 ```
 plugins { java } // kts
 plugins { id 'java' } // groovy preferred
 apply plugin: 'java' // groovy
 ```
 * Java Plugins
     - Expect to find source code in standard locations
     ```
     plugins { java } 
     plugins { java-library } 
     plugins { application } 
     ```
    - Can change this using SourceSets
    ``` 
    // Groovy DSL
    sourceSets {
        main {
            java {
                srcDir 'src/java'
            }
            resources {
                srcDir 'src/resources'
            }
        }
    }
    ```  
 * Configure the kotlin Plugin
    - Add the plugin
    ```
    // kotlin DSL
    plugins {
    kotlin("jvm") version "1.3.70"
    }
    ```
    - Configure the target JVM version
    ```
    tasks {
        compileKotlin {
            kotlinOptions.jvmTarget = "1.8"
        }
        compileTestKotlin {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    ```
- Gradle Dependency Management
 * Your Project Has
    - Other projects
    - External libraries
    - Internal libraries
 * Dependencies Can Be Satisfied from
    - Other projects
    - File system
    - Maven repositories
    - Ivy repositories
 * Can Have Many Configurations
    - Compilation
    - Runtime
    - Test compilation
    - Test runtime
 * Transitive Dependencies
    - Some dependencies will depend on other libraries
 * Listing Dependencies
    ```
    gradle –q dependencies
    gradle –q dependencies --configuration implementation
    ```
 * Repository
    - Dependencies are satisified from repositories
        * Remote
        ```
        repositories {
            mavenCentral()
        }
        repositories {
            jcenter()
        }
        repositories {
            url "http://jcenter.bintray.com/"
        }
        ```
        * Local
        ```
        repositories {
            mavenLocal()
        }
        ```
      * Custom
        ```
        repositories {
            //custom
            maven {
                url "http://repo.mycompany.com/maven2"
            }
        }
        repositories {
            ivy {
                url "http://repo.mycompany.com/repo"
            }
        }
        ```
        * Multiple
        ```
        repositories {
            maven {
                url "http://repo.mycompany.com/maven2"
            }
            ivy {
                url "http://repo.mycompany.com/repo"
            }
        }
        ```
        * File system
        ```
        repositories {
            flatDir {
                dirs("lib")
            }
        }      
        ```
 * Configuration scopes
    - Implementation
        * compileOnly
        * runtimeOnly
    - testImplementation
        * testCompileOnly
        * testRuntimeOnly
 * Gradle Cache
    - Modules are cached
        * File based 
        * Metadata and files stored separately
        * Repository caches are independent
    - Dependencies can be refreshed
        * --refresh-dependencies flag
        * Will check if it needs to re-download
        ```
        gradle --refresh-dependencies build
        'not fetch from caches which is locaded c:\Users\user\.gradle\caches'
       ```
    - can safely delete cached files
        * Cache will re-download them
 * Creating and Managing Multi Project Builds
    - Applications generally consist of multiple projects
    - Top level settings file to specify projects
    - Top level build file to configure projects
       * and set dependencies
    - Project level build files
        * Set project level properties and tasks 
- Manage Testing
 * There Is a Test Source Set
   - By default looks for unit tests in src/test/java
   - Outputs to build/classes/test
   - Reports to build/reports/test
 * Dependencies
   - Use testImplementation to define test dependencies
   ```
   testImplementation("junit:junit:4.12")
   ```
 * Configuration
   - Use test block to configure testing
   ```
   test {
      testLogging {
         events TestLogEvent.FAILED,
         TestLogEvent.PASSED,
         TestLogEvent.SKIPPED
      }
   }
   ```
 * Configure jUnit5
   - Add use jUnitPlatform to configure jUnit5
   ```
   tasks {
      test {
         useJUnitPlatform()
         testLogging.events = setOf(TestLogEvent.FAILED, TestLogEvent.PASSED,TestLogEvent.SKIPPED)
      }
   }
   ```
   - Use testImplementation to define test dependencies
   ```   
   testImplementation("org.junit.jupiter:junit-jupiter-api:$junit_version")
   testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junit_version")
   ```
   * Filtering tests
   ```
   test {
      filter {
         includeTestsMatching "com.foo.shouldCreateASession"
         includeTestsMatching "*shouldCreateASession"
      }
   }
   ```
   
   ```
   tasks.register<Test>("singleTest") {
      group = "Verification"
      description = "Runs a single test"
      dependsOn("testClasses")
      filter {
         includeTestsMatching("com.pluralsight.security.TestCreateStreams.testWhenInputFileDoesExist")
      }
   }   
   ```
   * Filtering (JUnit 5)   
   ``` 
   tasks.register<Test>("singleTest") {
      group = "Verification"
      description = "Runs a single test"
      dependsOn("testClasses")
      useJUnitPlatform()
      filter {
         includeTestsMatching("com.pluralsight.security.TestCreateStreams.testWhenInputFileDoesExist")
      }
   }   
   ```
   
   ```
   gradle test --tests *shouldCreateASession
   ```
-  Gradle Wrapper and How to Use it
   * What Is the Gradle Wrapper?
      - Gives the project a specific version of Gradle
      - Get consistent builds
      - gradlew.bat on Windows
      - gradlew shell script on *nix environments
   * Wrapper Task
      - Standard task
      - Can override in build file
      - Install Bootstrap Files
      ```
      myproject/
         gradlew
         gradlew.bat
         gradle/wrapper/
            gradle-wrapper.jar
            gradle-wrapper.properties
      ```
   * Why Use the Wrapper?
      - IDEs need it when loading a project
      - Build Servers need it to create a build
   * Why Use a Build Server?
      - Continuous integration is very important
      - If not CI then at least nightly builds
      - If not nightly then a clean place to build
      - 'Works on my machine'
      - Tem City
         * Build Server from JetBrains
         * https://www.jetbrains.com/teamcity/

## Tutorials 
- [Gradle Build Tool Fundamentals](https://app.pluralsight.com/library/courses/gradle-build-tool-fundamentals/table-of-contents) from 2020
- [Gradle Fundamentals](https://app.pluralsight.com/library/courses/gradle-fundamentals/table-of-contents) from 2015

##Tips and Tricks
- [How To Create And Delete A Junction Link on Windows 10?](https://mywindowshub.com/how-to-create-and-delete-a-junction-link-on-windows-10/)
```
Linux: junction gradle <path>
Windows: mklink /J "path to junction link" "path to target folder"
```
- [Gradle Build Language Reference](https://docs.gradle.org/current/dsl/)
- [The Java Plugin](https://docs.gradle.org/current/userguide/java_plugin.html)
