# @author Vyacheslav Lapin aka "C'est la vie". 2019 (c) http://vlapin.ru
# This Makefile is writen as command-line Project API for Java Maven multi-module
# projects with Lombok annotation processor. Required software list:
# - Maven, Git, JDK
# - JEnv - for *nix/Mac only!
# - XMLStarlet Toolkit
# - XsltProc

# For Windows users:
# - Comment or delete the JEnv block in "init" task
# - Delete "./" substring in some commands, like ./mvnw verify - it should looks like "mvnw verify"
# - Replace "ln" with "mklink" command (see https://stackoverflow.com/questions/17246558/what-is-the-windows-equivalent-to-the-ln-s-target-folder-link-folder-unix-s)

# Project GroupId
PG=`cat pom.xml | xml sel -N pom=http://maven.apache.org/POM/4.0.0 -t -v /pom:project/pom:groupId`

# Main package
MP=`cat pom.xml | xml sel -N pom=http://maven.apache.org/POM/4.0.0 -t -v /pom:project/pom:groupId | tr '.' '/'`

# Project Artifact id
PA=`cat pom.xml | xml sel -N pom=http://maven.apache.org/POM/4.0.0 -t -v /pom:project/pom:artifactId`

# Java Version
JV=`cat pom.xml | xml sel -N pom=http://maven.apache.org/POM/4.0.0 -t -v /pom:project/pom:properties/pom:java.version`

# Maven Version
MV=3.6.2

# Lombok Version
LV=`cat pom.xml | xml sel -N pom=http://maven.apache.org/POM/4.0.0 -t -v /pom:project/pom:properties/pom:lombok.version`

init:
	git init
	touch .git/info/exclude
	echo "\n/*/Makefile\n!/commons/Makefile\n" >> .git/info/exclude

#	Maven-wrapper
	mvn -N io.takari:maven:wrapper -Dmaven=$(MV)
	rm mvnw.cmd
	chmod +x ./mvnw
	echo "\n/.mvn\n/mvnw*\n" >> .git/info/exclude

#	jenv
	jenv local openjdk64-$(JV)
	echo "\n/.java-version\n" >> .git/info/exclude

#	CheckStyler
#	There is a problem with it. See: https://stackoverflow.com/questions/57723278/maven-checkstyle-plugin-does-not-execute-on-custom-rules
#	curl -O https://raw.githubusercontent.com/checkstyle/checkstyle/master/src/main/resources/google_checks.xml
	curl -O https://raw.githubusercontent.com/checkstyle/checkstyle/checkstyle-8.12/src/main/resources/google_checks.xml
	echo "\n/google_checks.xml\n" >> .git/info/exclude

# usage: $ make module A=module-name
module:
	mkdir -p $(A)/src/main/java/$(MP)/$(A) $(A)/src/main/resources $(A)/src/test/java $(A)/src/test/resources
	xsltproc --stringparam artifactId $(A) -o $(A)/pom.xml commons/pom2modulePom.xslt pom.xml
	xsltproc --stringparam artifactId $(A) -o pom.xml commons/pomModuleAdder.xslt pom.xml
	ln -s ../commons/Makefile $(A)/Makefile
	git add $(A)/pom.xml

uninit:
	rm -rf .mvn mvnw* google_checks.xml .git/info/exclude .java-version

reboot: clear uninit init

uninit-idea: clear uninit
	rm -rf .idea $(PA).iml

reboot-idea: uninit-idea init
	echo "\n/.idea/\n/$(PA).iml\n/out/\n/classes/\n" >> .git/info/exclude
#	git add src .editorconfig .gitignore Makefile pom.xml README.md
	idea pom.xml

# usage: $ make module-jshell A=module-name
module-jshell: module-delombok
	jshell --enable-preview --start PRINTING --start JAVASE --class-path `mvn dependency:build-classpath | grep -m2 -A1 'Dependencies classpath' | head -n2 | tail -1`:$(A)/target/generated-sources/delombok

jshell:
	jshell --enable-preview --start PRINTING --start JAVASE --class-path `mvn dependency:build-classpath | grep -m2 -A1 'Dependencies classpath' | head -n2 | tail -1`

build:
	./mvnw verify

run:
	java -jar --enable-preview intro/target/intro-0.0.1-SNAPSHOT-`cat pom.xml | xml sel -N pom=http://maven.apache.org/POM/4.0.0 -t -v /pom:project/pom:properties/pom:maven-assembly-plugin.descriptorRef`.jar

clear:
	./mvnw clean

test: clear
	./mvnw test

update:
	./mvnw versions:update-parent versions:update-properties versions:display-plugin-updates

delombok: clear
	./mvnw lombok:delombok

# delombok code from module with "A" parameter name, so write name (artifactId) to it
# Usage:
# make module-delombok A=<module-name>
module-delombok: clear
	mkdir -p ./target/generated-sources/delombok
	java -cp `./mvnw dependency:build-classpath | grep -A1 'Dependencies classpath' | tail -1` \
		lombok.launch.Main delombok $(A)/src/main/java \
		-d $(A)/target/generated-sources/delombok

test-delombok: delombok
	./mvnw lombok:testDelombok

# delombok code of tests from module with "A" parameter name, so write name (artifactId) to it
# Usage:
# make module-test-delombok A=<module-name>
module-test-delombok: module-delombok
	mkdir -p ./target/generated-test-sources/delombok
	java -cp `./mvnw dependency:build-classpath | grep -A1 'Dependencies classpath' | tail -1`:$(A)/target/generated-sources/delombok \
		lombok.launch.Main delombok $(A)/src/test/java \
		-d $(A)/target/generated-test-sources/delombok

.DEFAULT_GOAL := build-run
build-run: build run
