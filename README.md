[![Build Status](https://travis-ci.com/Vyacheslav-Lapin/java-fundamentals-epam.svg?branch=master)](https://travis-ci.com/Vyacheslav-Lapin/java-fundamentals-epam)
[![JitPack Code Repository](https://jitpack.io/v/Vyacheslav-Lapin/java-fundamentals-epam.svg)](https://jitpack.io/#Vyacheslav-Lapin/java-fundamentals-epam)

# java-fundamentals-epam project - the "how-to-use" instruction

## Requirements
For working with project you should have installed on you machine:
   1. Make (for installation instructions - see below)
   2. Maven (for installation instructions - see below)

## How to install project
in {project.basedir} run
```sh
$ make init
```  
## How use as a library (in maven)
### Step 1
Add the JitPack repository to your build file  
```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>
```  
### Step 2
Add the dependency 
```xml
<dependency>
  <groupId>com.github.Vyacheslav-Lapin</groupId>
  <artifactId>java-fundamentals-epam</artifactId>
  <version>MASTER</version>
</dependency>
```  
## How to install Make
Before install, you may need to check if it\'s already installed
### How to check if installed
For check, please write in terminal:
```sh
$ make -v
```  
output should looks like this:  
```text
GNU Make 4.2.1
Built for x86_64-apple-darwin18.2.0
Copyright (C) 1988-2016 Free Software Foundation, Inc.
License GPLv3+: GNU GPL version 3 or later <http://gnu.org/licenses/gpl.html>
This is free software: you are free to change and redistribute it.
There is NO WARRANTY, to the extent permitted by law.
```  

### Install
#### On Mac
```sh
$ brew install make
```  
#### On Debian Linux
```sh
$ apt install make
```  
#### On Windows
```sh
$ cinst make
```  

## How to install Maven
Before install, you may need to check if it''s already installed
### How to check if installed
For check, please write in terminal:
```sh
$ mvn -v
```  
output should looks like this:  
```text
Apache Maven 3.6.1 (d66c9c0b3152b2e69ee9bac180bb8fcc8e6af555; 2019-04-04T22:00:29+03:00)
Maven home: /usr/local/Cellar/maven/3.6.1/libexec
Java version: 12, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/openjdk-12.jdk/Contents/Home
Default locale: en_GB, platform encoding: UTF-8
OS name: "mac os x", version: "10.14.4", arch: "x86_64", family: "mac"
```  

### Install
#### On Mac
```sh
$ brew install mvn
```  
#### On Debian Linux
```sh
$ apt install mvn
```  
#### On Windows
```sh
$ cinst mvn
```  
