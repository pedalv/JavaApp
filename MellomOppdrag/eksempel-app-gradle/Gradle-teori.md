## [Gradle](https://gradle.org/)
- Accelerate developer productivity
- From mobile apps to microservices, from small startups to big enterprises, Gradle helps teams build, automate and deliver better software, faster.
- [Upcoming trainings](https://gradle.com/training/?_ga=2.252432457.1519713676.1600255208-1287073750.1600255208)
- [Migrating Builds From Apache Maven](https://docs.gradle.org/current/userguide/migrating_from_maven.html)

> [The Java Plugin](https://docs.gradle.org/current/userguide/java_plugin.html#sec:java_project_layout)

> [Get started with build scans](https://scans.gradle.com/?_ga=2.172224995.1519713676.1600255208-1287073750.1600255208#maven)

> [Get started with build scans](https://scans.gradle.com/?_ga=2.172224995.1519713676.1600255208-1287073750.1600255208#gradle)

> [Performing an automatic conversion](https://docs.gradle.org/current/userguide/migrating_from_maven.html#migmvn:automatic_conversion)

> [Migrating multi-module builds (project aggregation)](https://docs.gradle.org/current/userguide/migrating_from_maven.html#migmvn:multimodule_builds)

- [Gradle vs Maven Comparison](https://gradle.org/maven-vs-gradle/)
- [Install Gradle](https://gradle.org/install/)

> [Releases](https://gradle.org/releases/)

- [Get Started Guides](https://gradle.org/guides/#getting-started)

> [Free Training](https://gradle.com/training/?_ga=2.145872116.1519713676.1600255208-1287073750.1600255208)

> [Building Java Libraries](https://guides.gradle.org/building-java-libraries/)

> [Building Java Applications](https://guides.gradle.org/building-java-applications/)

```
> gradle init
> gradle build
>./gradlew build --scan vs mvn clean install
>./gradlew tasks
>./gradlew run

rmdir /s /q .gradle
```

```

D:\Workspace\JavaApp\MellomOppdrag\eksempel-app>gradle tasks

> Task :tasks

------------------------------------------------------------
Tasks runnable from root project - eksempel-app
------------------------------------------------------------

Build tasks
-----------
assemble - Assembles the outputs of this project.
build - Assembles and tests this project.
buildDependents - Assembles and tests this project and all projects that depend on it.
buildNeeded - Assembles and tests this project and all projects it depends on.
classes - Assembles main classes.
clean - Deletes the build directory.
jar - Assembles a jar archive containing the main classes.
testClasses - Assembles test classes.

Build Setup tasks
-----------------
init - Initializes a new Gradle build.
wrapper - Generates Gradle wrapper files.

Documentation tasks
-------------------
javadoc - Generates Javadoc API documentation for the main source code.

Help tasks
----------
buildEnvironment - Displays all buildscript dependencies declared in root project 'eksempel-app'.
components - Displays the components produced by root project 'eksempel-app'. [incubating]
dependencies - Displays all dependencies declared in root project 'eksempel-app'.
dependencyInsight - Displays the insight into a specific dependency in root project 'eksempel-app'.
dependentComponents - Displays the dependent components of components in root project 'eksempel-app'. [incubating]
help - Displays a help message.
model - Displays the configuration model of root project 'eksempel-app'. [incubating]
outgoingVariants - Displays the outgoing variants of root project 'eksempel-app'.
projects - Displays the sub-projects of root project 'eksempel-app'.
properties - Displays the properties of root project 'eksempel-app'.
tasks - Displays the tasks runnable from root project 'eksempel-app'.

Publishing tasks
----------------
generateMetadataFileForMavenPublication - Generates the Gradle metadata file for publication 'maven'.
generatePomFileForMavenPublication - Generates the Maven POM file for publication 'maven'.
publish - Publishes all publications produced by this project.
publishMavenPublicationToMavenLocal - Publishes Maven publication 'maven' to the local Maven repository.
publishToMavenLocal - Publishes all Maven publications produced by this project to the local Maven cache.

Verification tasks
------------------
check - Runs all checks.
test - Runs the unit tests.

Rules
-----
Pattern: clean<TaskName>: Cleans the output files of a task.
Pattern: build<ConfigurationName>: Assembles the artifacts of a configuration.
Pattern: upload<ConfigurationName>: Assembles and uploads the artifacts belonging to a configuration.

To see all tasks and more detail, run gradle tasks --all

To see more detail about a task, run gradle help --task <task>

BUILD SUCCESSFUL in 690ms
1 actionable task: 1 executed
D:\Workspace\JavaApp\MellomOppdrag\eksempel-app>

```
