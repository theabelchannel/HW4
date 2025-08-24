package com.sportspredictor.service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
public class NotifierFactory implements INotifierFactory {

  private final Map<String, Supplier<INotifier>> registry = new HashMap<>();

  public NotifierFactory() {
    // Registro inicial de notifiers soportados
    registry.put("email", EmailNotifier::new);
    registry.put("sms", SMSNotifier::new);
    registry.put("push", PushNotifier::new);
  }

  public INotifier create(String tipo) {
    return registry.getOrDefault(
        tipo == null ? "" : tipo.toLowerCase(),
        EmailNotifier::new
    ).get();
  }
  @Override
  public INotifier crearEmailNotifier() {
    return create("email");
  }

  @Override
  public INotifier crearSMSNotifier() {
    return create("sms");
  }

  @Override
  public INotifier crearPushNotifier() {
    return create("push");
  }
}

