package com.epam.courses.java.fundamentals.strings.practice.task2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ResourceManagerTest {

  private static ResourceManager resourceManager_1;
  private static ResourceManager resourceManager_2;
  private static ResourceManager resourceManager_3;

  private static ByteArrayOutputStream output = new ByteArrayOutputStream();

  @BeforeAll
  public static void init() {
    resourceManager_1 = new ResourceManager(1);
    resourceManager_2 = new ResourceManager(2);
    resourceManager_3 = new ResourceManager(6);

    System.setOut(new PrintStream(output));
  }

  @Test
  @DisplayName("setLocale method works correctly")
  public void testSetLocale() {
    assertThat(resourceManager_1.getLocale()).isEqualTo("ru_RU");
    assertThat(resourceManager_2.getLocale()).isEqualTo("en_US");
    assertThat(resourceManager_3.getLocale()).isEqualTo("ru_RU");
  }

  @Test
  @DisplayName("getAnswer method works correctly")
  public void testGetAnswer() {
    resourceManager_1.getAnswer(3);
    assertEquals("Java Development Kit\n", output.toString());
  }

  @After
  public void cleanUpStreams() {
    System.setOut(null);
  }
}
