package com.co.ias.aves.shared.models;

import lombok.Getter;

@Getter
public class MensajeError {
    private final String estado;
    private final String mensaje;

    public MensajeError(String estado, String mensaje) {
        this.estado = estado;
        this.mensaje = mensaje;
    }
}
