﻿<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="xml" encoding="UTF-8"/>

  <!--   文書    -->
  <xsl:template match="/">
    <root>
      <xsl:apply-templates select="cars/car[price &gt;= 200]"/>
    </root>
  </xsl:template>

  <!--   車    -->
  <xsl:template match="car">
    <xsl:copy>
      <xsl:apply-templates select="name"/>
      <xsl:apply-templates select="price"/>
    </xsl:copy>
  </xsl:template>

  <!--   品名   -->
  <xsl:template match="name">
    <xsl:copy-of select="."/>
  </xsl:template>

  <!--   価格   -->
  <xsl:template match="price">
    <xsl:copy-of select="."/>
  </xsl:template>

</xsl:stylesheet>
