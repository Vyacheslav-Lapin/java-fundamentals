init:
	git init
	touch .git/info/exclude

#	maven-wrapper
	mvn -N io.takari:maven:wrapper -Dmaven=3.6.2
	rm mvnw.cmd
	chmod +x ./mvnw
	echo "\n/.mvn\n/mvnw*\n" >> .git/info/exclude

#	jenv
	jenv local `cat pom.xml | xml sel -N pom=http://maven.apache.org/POM/4.0.0 -t -v /pom:project/pom:properties/pom:java.version`.0
	echo "\n/.java-version\n" >> .git/info/exclude

#	checkstyler
	curl -O https://raw.githubusercontent.com/checkstyle/checkstyle/master/src/main/resources/google_checks.xml
	echo "\n/google_checks.xml\n" >> .git/info/exclude

# module artifact id
A=intro
module:
	mkdir -p $(A)/src/main/java/`cat pom.xml | xml sel -N pom=http://maven.apache.org/POM/4.0.0 -t -v /pom:project/pom:groupId | tr '.' '/'`/$(A) $(A)/src/main/resources $(A)/src/test/java $(A)/src/test/resources
	xsltproc --stringparam artifactId $(A) -o $(A)/pom.xml ./../../commons/pom2modulePom.xslt pom.xml
	xsltproc --stringparam artifactId $(A) -o pom.xml ./../../commons/pomModuleAdder.xslt pom.xml
	git add $(A)/pom.xml

uninit:
	rm -rf .mvn mvnw* google_checks.xml .git/info/exclude

reboot: clear uninit init

uninit-full: clear uninit
	rm -rf .idea java-fundamentals-epam.iml

reboot-full: uninit-full init
	echo "\n/.idea/\n/java-fundamentals-epam.iml\n/out/\n/classes/\n" >> .git/info/exclude
	git add src .editorconfig .gitignore Makefile pom.xml README.md
	idea pom.xml

jshell:
	jshell --enable-preview --start PRINTING --start JAVASE --class-path `mvn dependency:build-classpath | grep -A1 'Dependencies classpath' | tail -1`

build:
	./mvnw verify

run:
	java -jar --enable-preview ./target/java-fundamentals-epam-0.0.1-SNAPSHOT.jar

clear:
	./mvnw clean

test: clear
	./mvnw test

update:
	./mvnw versions:update-parent versions:update-properties versions:display-plugin-updates

delombok: clear
	mkdir -p ./target/generated-sources/delombok ./target/generated-test-sources/delombok
	ln -s ./java ./src/main/lombok
	ln -s ./java ./src/test/lombok
	./mvnw lombok:delombok lombok:testDelombok
#	java -cp `mvn dependency:build-classpath | grep -A1 'Dependencies classpath' | tail -1` -jar ~/.m2/repository/org/projectlombok/lombok/1.18.8/lombok-1.18.8.jar delombok ./src/main/lombok -d ./target/generated-sources/delomboked
#	java -cp `mvn dependency:build-classpath | grep -A1 'Dependencies classpath' | tail -1` -jar ~/.m2/repository/org/projectlombok/lombok/1.18.8/lombok-1.18.8.jar delombok ./src/test/lombok -d ./target/generated-sources/test-delomboked
	rm ./src/main/lombok ./src/test/lombok

.DEFAULT_GOAL := build-run
build-run: update build run
