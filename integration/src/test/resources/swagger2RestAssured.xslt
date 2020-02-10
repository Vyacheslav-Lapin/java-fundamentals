<?xml version="1.0" encoding="UTF-8"?>
<stylesheet version="1.0"
            xmlns="http://www.w3.org/1999/XSL/Transform"
            xmlns:t="http://openapis.org/2"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="
                  http://openapis.org/2
                  ./open-api-2.xsd">

  <output method="text" version="1.0" encoding="UTF-8" indent="yes"/>

  <template match="@*|node()">
    <!--<copy>-->
    <!--  <apply-templates select="@*|node()"/>-->
    <!--</copy>-->
  </template>

  <template match="/">package com.epam.courses.java.fundamentals.integration;
<!--import static org.assertj.core.api.Assertions.assertThat;-->
<!--import lombok.SneakyThrows;-->
<!--import lombok.experimental.NonFinal;-->
<!--import lombok.val;-->
<!--import org.junit.jupiter.api.BeforeEach;-->
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class RestTests {

    <!--<apply-templates mode="constant"/>-->

    <apply-templates select="/t:root/t:paths/t:path/*" mode="test"/>
}
  </template>

  <!--translate(substring(./operationId, 1, 2),
                              'ABCDEFGHIJKLMNOPQRSTUVWXYZ',
                              'abcdefghijklmnopqrstuvwxyz'),
                    substring(./operationId, 3)-->
  <template match="/t:root/t:paths/t:path/*" mode="test">
    @<choose>
      <when test="count(./t:parameters/*) &gt; 0">Parameterized</when>
    </choose>Test
    @DisplayName("<value-of select="./t:summary"/>")
    public void <value-of select="concat(local-name(), ./t:operationId)"/>Test() {
      when().
        get("<value-of select="../t:value"/>", 5).
      then().
        statusCode(200).
        body("lotto.lottoId", equalTo(5),
            "lotto.winners.winnerId", hasItems(23, 54));
    }
  </template>

</stylesheet>
