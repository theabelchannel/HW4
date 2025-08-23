package com.sportspredictor.service;

import com.sportspredictor.model.Cuenta;

public class EmailNotifier implements INotifier {
    @Override
    public void enviar(Cuenta destinatario, String mensaje) {
        System.out.println("Enviando email a: " + destinatario.getEmail());
        System.out.println("Mensaje: " + mensaje);
        // Lógica para conectarse a un servidor SMTP y enviar el correo
    }
} 