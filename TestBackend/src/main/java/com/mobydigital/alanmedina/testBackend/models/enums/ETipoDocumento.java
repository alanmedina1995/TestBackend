package com.mobydigital.alanmedina.testBackend.models.enums;

public enum ETipoDocumento {

    DNI("dni"),
    LE("le"),
    LC("lc");

    private final String string;

    ETipoDocumento(final String string){
        this.string = string;
    }

    public String obtener(){
        return string;
    }



}
