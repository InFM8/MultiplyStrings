package com.company;

public class Main {

    public static void main(String[] args) {

        String num1 = "123";
        String num2 = "456";

        System.out.println(num1 + " * " + num2 + " = " + multiply(num1, num2));
    }

    /**
     * Funkcija skaiciuojanti pirmo ir antro skaiciaus sandauga
     *
     * @param num1 pirmas skaicius
     * @param num2 antras skaicius
     * @return grazinamas atsakymas
     */

    public static String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        StringBuilder sk1 = new StringBuilder(num1);
        StringBuilder sk2 = new StringBuilder(num2);

        sk1.reverse(); // 321
        sk2.reverse(); // 654

        int rez = sk1.length() + sk2.length(); // rez = 6;

        StringBuilder ats = new StringBuilder();
        for (int i = 0; i < rez; ++i) {
            ats.append(0);                    // ats = 000000;
        }
        for (int i = 0; i < sk2.length(); i++) {
            int skaitmuo2 = sk2.charAt(i) - '0';     //skaitmuo2 = 6, 5, 4;


            for (int j = 0; j < sk1.length(); j++) {
                int skaitmuo1 = sk1.charAt(j) - '0'; //skaitmuo1 = 3, 2, 1

                int dabartinePozicija = j + i; //0,1,2,1,2,3,2,3,4

                int saugoti = ats.charAt(dabartinePozicija) - '0'; //000 (9x)
                int daugyba = skaitmuo1 * skaitmuo2 + saugoti; //18, 12, 6, 15, 10, 5, 12, 8, 4

                //Nustatoma kiekvieno skaitmens vieta rezultate
                ats.setCharAt(dabartinePozicija, (char) (daugyba % 10 + '0'));
                                                                         //800000, 820000, 826000, 876000,
                                                                         //876000, 876500, 878500, 878300, 878340
                // Issaugome daugybos rezultata tarp desimciu
                int reiksme = (ats.charAt(dabartinePozicija + 1) - '0') + daugyba / 10; //1, 0, 7, 1, 0, 6, 1, 0

                // kiekviena gauta reiksme pridedame i sekancia pozicija
                ats.setCharAt(dabartinePozicija + 1, (char) (reiksme + '0'));
                                                                         //810000, 831000, 837000, 888000,
            }                                                            //888100, 888600, 880800, 880610, 880650
        }
        // Jei skaicius pirmas nuo galo lygus nuliui, pasaliname.
        if (ats.charAt(ats.length() - 1) == '0') {
            ats.deleteCharAt(ats.length() - 1);
        }
        ats.reverse();
        return ats.toString();
    }
}
