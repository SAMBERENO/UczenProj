package com.example;

import java.util.List;

public class UczenFormatter {

    public String zbudujListeOcen(List<Integer> oceny){
        StringBuilder sb = new StringBuilder();
        for(int ocena : oceny){
            if(sb.length() > 0){
                sb.append(",");
            }
            sb.append(ocena);
        }
        return sb.toString();
    }

    public String format (Uczen uczen){
        List<Integer> oceny = uczen.getOceny();
        if (uczen.getOceny().isEmpty()){
            return "Uczeń: " + uczen.getImie() + ", wiek: " + uczen.getWiek() + ", oceny: Brak";
        } else {
            return "Uczeń: " + uczen.getImie() + ", wiek: " + uczen.getWiek() + ", oceny: " + zbudujListeOcen(oceny) + " średnia: " + String.format("%.2f", uczen.obliczSrednia());
        }
    }
}
