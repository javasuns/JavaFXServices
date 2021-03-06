# JavaFX Services (Gradle)

This software leverages the [Gluon Client plugin for Gradle](https://github.com/gluonhq/client-gradle-plugin) for compiling the application into native code along with its required dependencies, so it can directly be executed as a native application on the target platform. Mobile hardware access is achieved through [Gluon Attach](https://gluonhq.com/products/mobile/attach). The software utilizes some of its pre-built services (Browser, Device, Push Notifications and Share) 

[![BSD-3 license](https://img.shields.io/badge/license-BSD--3-%230778B9.svg)](https://opensource.org/licenses/BSD-3-Clause)

## Screenshots

| Windows | MacOS X |  iOS  |
| :----:  | :----:  | :----:|
|<img src="https://user-images.githubusercontent.com/13131668/107875171-010b5800-6ec7-11eb-9318-afe4571bcf1a.png" width="120"/> <img src="https://user-images.githubusercontent.com/13131668/107875211-3f087c00-6ec7-11eb-9d8a-97f54acdd8f5.png" width="120"/>|<img src="https://user-images.githubusercontent.com/13131668/107875338-fb624200-6ec7-11eb-9609-0e6a07a0b764.png" width="120"/> <img src="https://user-images.githubusercontent.com/13131668/107875501-09649280-6ec9-11eb-8c33-4b94c4feba1b.png" width="120"/>|<img src="https://user-images.githubusercontent.com/13131668/107877998-6ca9f100-6ed8-11eb-9676-42c2dad60caf.png" width="120"/> <img src="https://user-images.githubusercontent.com/13131668/107877996-69af0080-6ed8-11eb-9816-908bf4eb94a7.png" width="120"/>

## Builds

|  Windows |  MacOS X  |
|  :----:  | :----:    |
|  [Download](https://bitbucket.org/javasuns/javafx-services/downloads/JavaFX_Services.exe)|  [Download](https://bitbucket.org/javasuns/javafx-services/downloads/JavaFXServices)  |

## Getting started

To compile the software code in your desired platform you would need to apply the following steps:

### 1. Setting JAVA_HOME and GRAALVM_HOME

GraalVM is mandatory for creating native apps. It is available for download on the [GraalVM website](https://www.graalvm.org/downloads/). If you have a JDK already installed on your PC, it would be a wise to place GraalVM binaries under the same Java directory for consolidation. 
JavaFX Services app has been tested against OpenJDK version 11.0.2 and GraalVM Community Edition 21.0.

**Windows Sample**

    JAVA_HOME=C:\Programs\Java\jdk-11.0.2
    GRAALVM_HOME=C:\Programs\Java\graalvm-ce-java11-21.0.0

**MacOS X Sample**

    JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-11.0.2.jdk/Contents/Home
    GRAALVM_HOME=/Library/Java/JavaVirtualMachines/graalvm-ce-java11-21.0.0/Contents/Home

### 2. Tasks

You can run the regular tasks to build and run your project as a regular Java project:

    ./gradlew clean build
    ./gradlew run
    
Once you are able to run the pure Java project, you proceed with the native taks:    

#### `Desktop Native Application`

This task does the AOT compilation. It is a very intensive and lengthy task (several minutes, depending on your project and CPU).

Run:

    ./gradlew nativeCompile  # AOT Compilation
    ./gradlew nativeLink     # Generates native executable
    ./gradlew nativeRun      # Runs the generated executable

Alternatively, you may combine all the above commands into one:

    ./gradlew nativeBuild nativeRun  # "nativeBuild" combines nativeCompile and nativeLink.
    
**Important Note:** Opening URLs through an External Browser is not yet supported for Desktop Native Apps [GraalVM Issue](https://github.com/oracle/graal/issues/2430).
    
#### `Mobile Native Application (iOS)`

Make sure that you have filled in the iOS related information in build.info before compiling for iOS. 
You should create an Apple ID before being able to run this task. For more information read [Gluon iOS Development](https://docs.gluonhq.com/#platforms_ios_deployment). This task can be run only on MacOS.

Tasks for creating Mobile App are the same as Desktop Native Application.  
You just need to add the **-ptarget=ios** parameter 

Run:

    ./gradlew nativeCompile -Ptarget=ios
    ./gradlew nativeLink -Ptarget=ios
    ./gradlew nativeRun -Ptarget=ios

Alternatively, you may combine all the above commands into one line

    ./gradlew nativeBuild nativeRun -Ptarget=ios
    
### Requirements

More information on platform requirements you may check the [target platform](https://docs.gluonhq.com/#_platforms) section on Gluon website.
