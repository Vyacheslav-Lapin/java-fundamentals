<?xml version="1.0" encoding="UTF-8"?>
<xslt:stylesheet version="1.0"
                 exclude-result-prefixes="pom xslt xsi"
                 xmlns="http://maven.apache.org/POM/4.0.0"
                 xmlns:pom="http://maven.apache.org/POM/4.0.0"
                 xmlns:xslt="http://www.w3.org/1999/XSL/Transform"
                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="
              http://maven.apache.org/POM/4.0.0
              http://maven.apache.org/xsd/maven-4.0.0.xsd">

  <xslt:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>

  <xslt:param name="artifactId"/>

  <xslt:variable name="groupId" select="/pom:project/pom:groupId"/>
  <xslt:variable name="parentArtifactId" select="/pom:project/pom:artifactId"/>

  <xslt:template match="@*|node()">
    <xslt:copy>
      <xslt:apply-templates select="@*|node()"/>
    </xslt:copy>
  </xslt:template>

  <xslt:template match="/">
    <project xmlns="http://maven.apache.org/POM/4.0.0">

      <modelVersion>4.0.0</modelVersion>

      <parent>
        <groupId>
          <xslt:value-of select="$groupId"/>
        </groupId>
        <artifactId>
          <xslt:value-of select="$parentArtifactId"/>
        </artifactId>
        <version>${revision}</version>
      </parent>

      <artifactId><xslt:value-of select="$artifactId"/></artifactId>

      <properties>
        <xslt:comment>&lt;maven-assembly-plugin.mainClass&gt;ru.vlapin.courses.java.fundamentals.intro.Hello&lt;/maven-assembly-plugin.mainClass&gt;</xslt:comment>
        <xslt:comment>&lt;assembly.skipAssembly&gt;false&lt;/assembly.skipAssembly&gt;</xslt:comment>
      </properties>
    </project>
  </xslt:template>

</xslt:stylesheet>
