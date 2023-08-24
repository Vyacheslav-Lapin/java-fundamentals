package pro.vlapin.courses.java.fundamentals.integration.json.jackson;

public class Events {

  //region Insert events in Kafka for RPO with TP
  public static final String EVENTS_FOR_RPO_WITH_TP =
      "{\n" +
          "  \"events\": [\n" +
          "    {\n" +
          "      \"shipmentId\": \"%s\",\n" +
          "      \"operDate\": \"%s\",\n" +
          "      \"operType\": 1,\n" +
          "      \"operAttr\": 1,\n" +
          "      \"indexOper\": \"644007\",\n" +
          "      \"zoneOffsetSeconds\": 10800,\n" +
          "      \"countryFrom\": 156,\n" +
          "        \"phoneRecipient\" : \"9095843777\",\n" +
          "      \"countryOper\": 156,\n" +
          "      \"mailDirect\": 643,\n" +
          "      \"dataProviderType\": \"SM\",\n" +
          "      \"softwareVersion\": \"I2.5.8.15\",\n" +
          "      \"incomeDate\": 1540384022000,\n" +
          "      \"indexTo\": \"153996\",\n" +
          "      \"customDuty\": %d,\n" +
          "      \"mailCtg\": 2,\n" +
          "      \"mailKind\": 0,\n" +
          "      \"mailRank\": 0,\n" +
          "      \"mailType\": 4,\n" +
          "      \"rcpn\": \"Получателев Иван Иванович\",\n" +
          "      \"sndr\": \"Отправителев Петр Петрович\"\n" +
          "    },\n" +
          "    {\n" +
          "      \"shipmentId\": \"%s\",\n" +
          "      \"operDate\": \"%s\",\n" +
          "      \"operType\": 9,\n" +
          "      \"operAttr\": 1,\n" +
          "      \"indexOper\": \"644007\",\n" +
          "      \"zoneOffsetSeconds\": 10800,\n" +
          "      \"countryFrom\": 156,\n" +
          "      \"countryOper\": 156,\n" +
          "      \"mailDirect\": 643,\n" +
          "      \"dataProviderType\": \"SM\",\n" +
          "      \"softwareVersion\": \"I2.5.8.15\",\n" +
          "      \"incomeDate\": 1540385022000,\n" +
          "      \"indexTo\": \"153996\",\n" +
          "      \"customDuty\": %d,\n" +
          "      \"mailCtg\": 2,\n" +
          "      \"mailKind\": 0,\n" +
          "      \"mailRank\": 0,\n" +
          "      \"mailType\": 4,\n" +
          "      \"rcpn\": \"Получателев Иван Иванович\",\n" +
          "      \"sndr\": \"Отправителев Петр Петрович\"\n" +
          "    },\n" +
          "    {\n" +
          "      \"shipmentId\": \"%s\",\n" +
          "      \"operDate\": \"%s\",\n" +
          "      \"operType\": 11,\n" +
          "      \"operAttr\": 1,\n" +
          "      \"indexOper\": \"644007\",\n" +
          "      \"zoneOffsetSeconds\": 10800,\n" +
          "      \"countryFrom\": 156,\n" +
          "      \"countryOper\": 156,\n" +
          "      \"mailDirect\": 643,\n" +
          "      \"dataProviderType\": \"SM\",\n" +
          "      \"softwareVersion\": \"I2.5.8.15\",\n" +
          "      \"incomeDate\": 1540386022000,\n" +
          "      \"indexTo\": \"153996\",\n" +
          "      \"customDuty\": %d,\n" +
          "      \"mailCtg\": 2,\n" +
          "      \"mailKind\": 0,\n" +
          "      \"mailRank\": 0,\n" +
          "      \"mailType\": 4,\n" +
          "      \"rcpn\": \"Получателев Иван Иванович\",\n" +
          "      \"sndr\": \"Отправителев Петр Петрович\"\n" +
          "    },\n" +
          "    {\n" +
          "      \"shipmentId\": \"%s\",\n" +
          "      \"operDate\": \"%s\",\n" +
          "      \"operType\": 14,\n" +
          "      \"operAttr\": 16,\n" +
          "      \"indexOper\": \"644007\",\n" +
          "      \"zoneOffsetSeconds\": 10800,\n" +
          "      \"countryFrom\": 156,\n" +
          "      \"countryOper\": 156,\n" +
          "      \"mailDirect\": 643,\n" +
          "      \"dataProviderType\": \"SM\",\n" +
          "      \"softwareVersion\": \"I2.5.8.15\",\n" +
          "      \"incomeDate\": 1540387022000,\n" +
          "      \"indexTo\": \"153996\",\n" +
          "      \"customDuty\": %d,\n" +
          "      \"mailCtg\": 2,\n" +
          "      \"mailKind\": 0,\n" +
          "      \"mailRank\": 0,\n" +
          "      \"mailType\": 4,\n" +
          "      \"rcpn\": \"Получателев Иван Иванович\",\n" +
          "      \"sndr\": \"Отправителев Петр Петрович\"\n" +
          "    },\n" +
          "    {\n" +
          "      \"shipmentId\": \"%s\",\n" +
          "      \"operDate\": \"%s\",\n" +
          "      \"operType\": 41,\n" +
          "      \"operAttr\": 3,\n" +
          "      \"indexOper\": \"644007\",\n" +
          "      \"zoneOffsetSeconds\": 10800,\n" +
          "      \"countryFrom\": 156,\n" +
          "      \"countryOper\": 156,\n" +
          "      \"mailDirect\": 643,\n" +
          "      \"dataProviderType\": \"SM\",\n" +
          "      \"softwareVersion\": \"I2.5.8.15\",\n" +
          "      \"incomeDate\": 1540388022000,\n" +
          "      \"indexTo\": \"153996\",\n" +
          "      \"customDuty\": %d,\n" +
          "      \"mailCtg\": 2,\n" +
          "      \"mailKind\": 0,\n" +
          "      \"mailRank\": 0,\n" +
          "      \"mailType\": 4,\n" +
          "      \"rcpn\": \"Получателев Иван Иванович\",\n" +
          "        \"phoneRecipient\" : \"9095843777\",\n" +
          "      \"sndr\": \"Отправителев Петр Петрович\"\n" +
          "    }    \n" +
          "  ]\n" +
          "}";
  //endregion
}
