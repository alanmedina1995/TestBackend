package com.mobydigital.alanmedina.testBackend.models.enums;

public enum ETecnologia {

    JAVA("java"),
    PYTHON("python"),
    MAVEN("maven"),
    HIBERNATE("hibernate"),
    SPRING("spring");

    private final String string;

    ETecnologia(final String string){
        this.string = string;
    }

    public String obtener(){
        return string;
    }

}
