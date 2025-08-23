package com.sportspredictor.service;

import com.sportspredictor.model.Cuenta;

public class SMSNotifier implements INotifier {
    @Override
    public void enviar(Cuenta destinatario, String mensaje) {
        System.out.println("Enviando SMS a: " + destinatario.getTelefono());
        System.out.println("Mensaje: " + mensaje);
        // Lógica para conectarse a un servicio SMS y enviar el mensaje
    }
}
