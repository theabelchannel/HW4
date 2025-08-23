package com.sportspredictor.service;

public class NotifierFactory implements INotifierFactory {
    
    @Override
    public INotifier crearEmailNotifier() {
        return new EmailNotifier();
    }
    
    @Override
    public INotifier crearSMSNotifier() {
        return new SMSNotifier();
    }
    
    @Override
    public INotifier crearPushNotifier() {
        return new PushNotifier();
    }
}
