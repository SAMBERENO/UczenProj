package com.example;

import java.util.ArrayList;
import java.util.List;

public class UczenMapper {

    public static List<UczenResponse> topResponse(List<Uczen> uczniowie){
        List<UczenResponse> topthree = new ArrayList<>();
        List<Uczen> top = new ArrayList<>();

        for (Uczen uczen : uczniowie){
            if (uczen.maOceny()){
                top.add(uczen);
            }
        }

        top.sort((a, b) -> Double.compare(b.obliczSrednia(), a.obliczSrednia()));

        int limit = Math.min(3, top.size());

        for(int i = 0; i < limit; i++){
            topthree.add(toResponse(top.get(i)));
        }
        return topthree;
    }

    public static List<UczenResponse> topResponseStream(List<Uczen> uczniowie){
        return uczniowie.stream()
                .filter(e -> e.maOceny())
                .sorted((a, b) -> Double.compare(b.obliczSrednia(), a.obliczSrednia()))
                .limit(3)
                .map(UczenMapper::toResponse)
                .toList();
    }

    public static UczenResponse toResponse(Uczen uczen){
        return new UczenResponse(uczen.getImie(), uczen.getWiek(), uczen.getOceny(), uczen.obliczSrednia());
    }
}
