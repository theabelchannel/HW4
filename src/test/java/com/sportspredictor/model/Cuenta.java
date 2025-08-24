package com.sportspredictor.model;

public abstract class Cuenta {
    protected String id;
    protected String nombreUsuario;
    protected String email;
    protected String telefono;
    protected String passwordHash;

    public Cuenta(String id, String nombreUsuario, String email) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.telefono = "";
    }

    public boolean login(String email, String password) {
        // Lógica de login simulada
        System.out.println("Iniciando sesión como " + this.nombreUsuario);
        return true;
    }

    public void logout() {
        // Lógica de logout simulada
        System.out.println("Cerrando sesión de " + this.nombreUsuario);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getEmail() {
        return email;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
} 