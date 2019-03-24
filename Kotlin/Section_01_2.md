# [kotlin](https://kotlinlang.org/) Prerequisites

```
Pedro Alves@DESKTOP-TC6U1JA MINGW64 /c/Space2/JavaApp/Kotlin (master)
$ java -version
java version "11.0.2" 2019-01-15 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.2+9-LTS)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.2+9-LTS, mixed mode)

Pedro Alves@DESKTOP-TC6U1JA MINGW64 /c/Space2/JavaApp/Kotlin (master)
$ mvn -version
Apache Maven 3.6.0 (97c98ec64a1fdfee7767ce5ffb20918da4f719f3; 2018-10-24T20:41:47+02:00)
Maven home: C:\JavaTools\apache-maven-3.6.0
Java version: 11.0.2, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-11.0.2
Default locale: no_NO, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
```

- Install JDK version

1. [Java Early Access Downloads](https://www.oracle.com/technetwork/articles/java/ea-jsp-142245.html) 
2. [Oracle Java Archive](https://www.oracle.com/technetwork/java/archive-139210.html) 
3. [jdk.java.net - JDK 13 Early-Access Builds](https://jdk.java.net/13/)

- Install JDK on Windows/MAC/Linux ([Ubuntu](https://www.ubuntu.com/), [Java SE Downloads](https://www.oracle.com/technetwork/java/javase/downloads/index.html) 

* Linux

```
sudo apt-get update
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java8-installer(*)
- accept instalation of java
sudo update-alternatives --config java
- java version when there are others
java -version
javac
```

(*) [How To Install Oracle Java 11 In Ubuntu, Linux Mint Or Debian (From PPA Repository)](https://www.linuxuprising.com/2018/10/how-to-install-oracle-java-11-in-ubuntu.html)

- Install Maven on Windows/MAC/Linux, [Downloading Apache Maven 3.6.0](https://maven.apache.org/download.cgi) 

![IDEs for Kotlin](https://raw.githubusercontent.com/pedalv/JavaApp/master/Kotlin/kotlin-ides.PNG)

- Install/Config IDE on Windows/MAC/Linux, [Intellij Idea](https://www.jetbrains.com/idea/download/?gclid=EAIaIQobChMI4avr5pOv4AIVFc-yCh0ypg_jEAAYASABEgIWBvD_BwE&gclsrc=aw.ds#section=windows) 

* Location JDK on MAC
![Location JDK on MAC](https://raw.githubusercontent.com/pedalv/JavaApp/master/Kotlin/LocationJDKMAC.PNG)

* Start Intellij Idea on Linux 
![Start Intellij Idea on Linux](https://raw.githubusercontent.com/pedalv/JavaApp/master/Kotlin/StartIntellijIdeaLinux.PNG)

* Location JDK on Linux
![Location JDK on Linux](https://raw.githubusercontent.com/pedalv/JavaApp/master/Kotlin/LocationJDKLinux.PNG)

- Config Kotlin on IDE
Download [Kotlin plugin for Intellij Idea](https://plugins.jetbrains.com/plugin/6954-kotlin)and copy kotlin plugint to 'C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2018.2.5\plugins'

![Kotlin plugin for Intellij Idea](https://raw.githubusercontent.com/pedalv/JavaApp/master/Kotlin/KotlinPluginIntellijIdea.PNG)

![Selected 'Show parameter name hints'](https://raw.githubusercontent.com/pedalv/JavaApp/master/Kotlin/ShowParameterNameHints.PNG)

![Result of selected 'Show parameter name hints'](https://raw.githubusercontent.com/pedalv/JavaApp/master/Kotlin/ShowParameterNameHints-Result.PNG)

![Code Style for Kotlin](https://raw.githubusercontent.com/pedalv/JavaApp/master/Kotlin/CodeStyle-Kotlin.PNG)

![Amart Keys for Kotlin](https://raw.githubusercontent.com/pedalv/JavaApp/master/Kotlin/SmartKeys-Kotlin.PNG)
