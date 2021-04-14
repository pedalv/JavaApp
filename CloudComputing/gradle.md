# [Gradle](https://gradle.org/)
- What Is gradle?
 * Convention based build tool
 * DSL to describe the build
 * Supports multiproject builds
 * Easily customizable
 * Builds many lamguages
 * Supports dependencies
- How I sgrade Used?
 * Create a buld script: Kotlin or Groovy DSL
 * Defines tasks: build, clean, etc
 * Run the appropreiate task: from the command line or an IDE  
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
    - Dependencies can be refreshed
        * --refresh-dependencies flag
        * Will check if it needs to re-download
        ```
        gradle --refresh-dependencies build
        'not fetch from caches which is locaded c:\Users\user\.gradle\caches'
       ```
    - can safely delete cached files
        * Cache will re-download them
 * Creating and Maging Multi Project Builds
    - Applications generally consist of multiple projects
    - Top level settings file to specify projects
    - Top level build file to configure projects
       * and set dependencies
    - Project level build files
        * Set project level properties and tasks 
 * 

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
