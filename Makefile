# @author Vyacheslav Lapin aka "C'est la vie". 2020 (c) http://vlapin.ru
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

#--------------------------
#Variables:

# Project GroupId
PG=`cat pom.xml | xml sel -N pom=http://maven.apache.org/POM/4.0.0 -t -v /pom:project/pom:groupId`

# Main package
MP=`cat pom.xml | xml sel -N pom=http://maven.apache.org/POM/4.0.0 -t -v /pom:project/pom:groupId | tr '.' '/'`

# Project Artifact id
PA=`cat pom.xml | xml sel -N pom=http://maven.apache.org/POM/4.0.0 -t -v /pom:project/pom:artifactId`

# Maven Version
MV=3.6.3

# Java Version
JV=`cat pom.xml | xml sel -N pom=http://maven.apache.org/POM/4.0.0 -t -v /pom:project/pom:properties/pom:java.version`
ifeq ($(JV), 11)
J=11.0
else ifeq ($(JV), 13)
J=13.0
else ifeq ($(JV), 14)
J=14-ea
else ifeq ($(JV),12)
J=12.0
else
J=1.8
endif

# Lombok Version
LV=`cat pom.xml | xml sel -N pom=http://maven.apache.org/POM/4.0.0 -t -v /pom:project/pom:properties/pom:lombok.version`

#--------------------------
#Tasks:

init:
	git init
	touch .git/info/exclude

#	maven-wrapper
	mvn -N io.takari:maven:wrapper -Dmaven=3.6.3
	rm mvnw.cmd
	chmod +x ./mvnw
	echo "\n/.mvn\n/mvnw*\n" >> .git/info/exclude

#	jenv
	jenv local $(J)
	echo "\n/.java-version\n" >> .git/info/exclude

#	checkstyler
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

uninit-full: clear uninit
	rm -rf .idea $(PA).iml .git

reboot-full: uninit-full init
	echo "\n/.idea/\n/$(PA).iml\n/out/\n/classes/\n" >> .git/info/exclude
	git add src .editorconfig .gitignore Makefile pom.xml README.md
	idea pom.xml

jshell:
	jshell --enable-preview --start PRINTING --start JAVASE --class-path `mvn dependency:build-classpath | grep -A1 'Dependencies classpath' | tail -1`

# usage: $ make module-jshell A=module-name
module-jshell: module-delombok
	jshell --enable-preview --start PRINTING --start JAVASE --class-path `mvn dependency:build-classpath | grep -m2 -A1 'Dependencies classpath' | head -n2 | tail -1`:$(A)/target/generated-sources/delombok

build:
	./mvnw verify
	chmod +x ./target/$(PA)-0.0.1-SNAPSHOT.jar

run:
	./mvnw spring-boot:start -Dspring.profiles.active=local
#	./target/$(PA)-0.0.1-SNAPSHOT.jar
#	java -jar --enable-preview ./target/$(PA)-0.0.1-SNAPSHOT-jar-with-dependencies.jar

effective-pom:
	./mvnw help:effective-pom

clear:
	./mvnw clean

test: clear
	./mvnw test

update:
	./mvnw versions:update-parent versions:update-properties versions:display-plugin-updates

delombok: clear
	./mvnw lombok:delombok
#	mkdir -p ./target/generated-sources/delombok
#	java -cp `./mvnw dependency:build-classpath | grep -A1 'Dependencies classpath' | tail -1` \
#		lombok.launch.Main delombok ./src/main/java \
#		-d ./target/generated-sources/delombok

# delombok code from module with "A" parameter name, so write name (artifactId) to it
# Usage:
# make module-delombok A=<module-name>
module-delombok: clear
	mkdir -p $(A)/target/generated-sources/delombok
	java -cp `./mvnw dependency:build-classpath | grep -A1 'Dependencies classpath' | tail -1` \
		lombok.launch.Main delombok $(A)/src/main/java \
		-d $(A)/target/generated-sources/delombok

test-delombok: delombok
	./mvnw lombok:testDelombok
#	mkdir -p ./target/generated-test-sources/delombok
#	java -cp `./mvnw dependency:build-classpath | grep -A1 'Dependencies classpath' | tail -1`:./target/generated-sources/delombok \
#		lombok.launch.Main delombok ./src/test/java \
#		-d ./target/generated-test-sources/delombok

# delombok code of tests from module with "A" parameter name, so write name (artifactId) to it
# Usage:
# make module-test-delombok A=<module-name>
module-test-delombok: module-delombok
	mkdir -p $(A)/target/generated-test-sources/delombok
	java -cp `./mvnw dependency:build-classpath | grep -A1 'Dependencies classpath' | tail -1`:$(A)/target/generated-sources/delombok \
		lombok.launch.Main delombok $(A)/src/test/java \
		-d $(A)/target/generated-test-sources/delombok

git-fork-init: init
	git remote add upstream git://github.com/Vyacheslav-Lapin/$(PA).git
	git fetch upstream

#branch name
B=feature
git-branch:
	git checkout -b $(B)
	git push -u origin $(B)

.DEFAULT_GOAL := build-run
build-run: update build run

#archetype: clear uninit
#	./mvnw archetype:create-from-project -Darchetype.properties=archetype.properties
#	cd target/generated-sources/archetype/.idea && rm workspace.xml usage.statistics.xml tasks.xml
#	make init
##	idea ./target/generated-sources/archetype/pom.xml
#	cd target/generated-sources/archetype && ./../../../mvnw clean install
#
#clone: archetype
#	cd .. && mvn archetype:generate \
#		-DarchetypeGroupId=ru.vlapin.projects \
#		-DarchetypeArtifactId=monolith-archetype \
#		-DartifactId=monolith-example \
#		-DarchetypeVersion=0.0.1-SNAPSHOT \
#		-DgroupId=ru.vlapin.projects \
#		-Dpackage=ru.vlapin.projects.monolith \
#		-Dversion=0.0.1-SNAPSHOT \
#		-DinteractiveMode=false
#
#	idea ./../monolith-example/pom.xml
