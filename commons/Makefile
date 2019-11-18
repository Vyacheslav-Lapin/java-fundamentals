# Module Artifact id
A=`cat pom.xml | xml sel -N pom=http://maven.apache.org/POM/4.0.0 -t -v /pom:project/pom:artifactId`

# Module Version
V=`cat ../pom.xml | xml sel -N pom=http://maven.apache.org/POM/4.0.0 -t -v /pom:project/pom:properties/pom:revision`

# Dependencies
D=`./../mvnw dependency:build-classpath | grep -A1 'Dependencies classpath' | tail -1`

# Jar name Suffix
JS=`cat pom.xml | xml sel -N pom=http://maven.apache.org/POM/4.0.0 -t -v /pom:project/pom:properties/pom:maven-assembly-plugin.descriptorRef`

# Lombok Version
LV=`cat pom.xml | xml sel -N pom=http://maven.apache.org/POM/4.0.0 -t -v /pom:project/pom:properties/pom:lombok.version`

jshell:
	cd .. && make module-jshell A=$(A)

build:
	./../mvnw verify

run:
	java -jar --enable-preview intro/target/$(A)-$(MV)-$(JS).jar

clear:
	./../mvnw clean

test: clear
	./../mvnw test

update:
	./../mvnw versions:update-parent versions:update-properties versions:display-plugin-updates

delombok: clear
	cd .. && make module-delombok A=$(A)

test-delombok: delombok
	cd .. && make module-test-delombok A=$(A)

.DEFAULT_GOAL := build-run
build-run: build run
