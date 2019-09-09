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

  <xslt:template match="@*|node()">
    <xslt:copy>
      <xslt:apply-templates select="@*|node()"/>
    </xslt:copy>
  </xslt:template>

  <xslt:template match="/pom:project/pom:modules">
    <modules>
      <xslt:apply-templates/>
      <module>
        <xslt:value-of select="$artifactId"/>
      </module>
    </modules>
  </xslt:template>

</xslt:stylesheet>
