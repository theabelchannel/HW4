package com.sportspredictor.service;

import com.sportspredictor.model.Cuenta;

public class PushNotifier implements INotifier {
    @Override
    public void enviar(Cuenta destinatario, String mensaje) {
        System.out.println("Enviando notificación push a: " + destinatario.getNombreUsuario());
        System.out.println("Mensaje: " + mensaje);
        // Lógica para enviar notificación push a la aplicación móvil
    }
}
