package com.sportspredictor.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NotifierFactoryTest {

  @Test
  void createPorTipo_yMetodosCompatibilidad() {
    NotifierFactory factory = new NotifierFactory();

    INotifier email = factory.create("email");
    INotifier sms = factory.create("sms");
    INotifier push = factory.create("push");
    INotifier defaultEmail = factory.create("desconocido");

    assertAll(
        () -> assertNotNull(email),
        () -> assertNotNull(sms),
        () -> assertNotNull(push),
        () -> assertNotNull(defaultEmail));

    // Tipos correctos
    assertTrue(email instanceof EmailNotifier);
    assertTrue(sms instanceof SMSNotifier);
    assertTrue(push instanceof PushNotifier);
    assertTrue(defaultEmail instanceof EmailNotifier);

    // Métodos “legacy” aún funcionan
    assertTrue(factory.crearEmailNotifier() instanceof EmailNotifier);
    assertTrue(factory.crearSMSNotifier() instanceof SMSNotifier);
    assertTrue(factory.crearPushNotifier() instanceof PushNotifier);
  }
}
