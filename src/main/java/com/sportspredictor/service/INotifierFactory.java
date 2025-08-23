package com.sportspredictor.service;

public interface INotifierFactory {
    INotifier crearEmailNotifier();
    INotifier crearSMSNotifier();
    INotifier crearPushNotifier();
}
