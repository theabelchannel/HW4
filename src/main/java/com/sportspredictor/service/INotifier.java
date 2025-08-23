package com.sportspredictor.service;

import com.sportspredictor.model.Cuenta;

public interface INotifier {
    void enviar(Cuenta destinatario, String mensaje);
} 