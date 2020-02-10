<?xml version="1.0" encoding="UTF-8"?>
<xslt:stylesheet version="1.0"
                 exclude-result-prefixes="javaee xslt xsi"
                 xmlns="http://www.w3.org/2001/XMLSchema"
                 xmlns:javaee="http://xmlns.jcp.org/xml/ns/javaee"
                 xmlns:xslt="http://www.w3.org/1999/XSL/Transform"
                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="
                  http://xmlns.jcp.org/xml/ns/javaee
                  http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd">

  <xslt:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>

  <!--<xslt:template match="@*|node()">-->
  <!--  <xslt:copy>-->
  <!--    <xslt:apply-templates select="@*|node()"/>-->
  <!--  </xslt:copy>-->
  <!--</xslt:template>-->

  <xslt:template match="/">
    <root>
      <xslt:apply-templates select="/javaee:web-app/javaee:mime-mapping/javaee:mime-type"/>
    </root>
  </xslt:template>

  <xslt:template match="/javaee:web-app/javaee:mime-mapping/javaee:mime-type">
    <xslt:element name="enumeration">
      <xslt:attribute name="value">
        <xslt:value-of select="."/>
      </xslt:attribute>
    </xslt:element>
  </xslt:template>

</xslt:stylesheet>
