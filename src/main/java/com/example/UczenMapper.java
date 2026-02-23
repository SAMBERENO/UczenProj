package com.example;

public class UczenMapper {
    public static UczenResponse toResponse(Uczen uczen){
        return new UczenResponse(uczen.getImie(), uczen.getWiek(), uczen.getOceny(), uczen.obliczSrednia());
    }
}
