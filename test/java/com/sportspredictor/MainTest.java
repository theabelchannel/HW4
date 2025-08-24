package com.sportspredictor;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  void main_noLanzaExcepcion() {
    assertDoesNotThrow(() -> Main.main(new String[0]));
  }
}
