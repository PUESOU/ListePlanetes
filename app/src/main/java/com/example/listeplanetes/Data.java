package com.example.listeplanetes;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<String> nomPlanetes = installePlanetes();
    public static String[] taillePlanetes = {"4900", "12000", "12800", "6800", "144000", "120000", "52000", "50000", "2300"};

    private static List<String> installePlanetes() {
        List<String> nomPlanetes = new ArrayList<String>();

        nomPlanetes.add("Mercure");
        nomPlanetes.add("Venus");
        nomPlanetes.add("Terre");
        nomPlanetes.add("Mars");
        nomPlanetes.add("Jupiter");
        nomPlanetes.add("Saturne");
        nomPlanetes.add("Uranus");
        nomPlanetes.add("Neptune");
        nomPlanetes.add("Pluton");

        return nomPlanetes;
    }
}
