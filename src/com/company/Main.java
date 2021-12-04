package com.company;

public class Main {

    public static void main(String[] args) {

        String num1 = "123";
        String num2 = "456";

        System.out.println(num1 + " * " + num2 + " = " +multiply(num1, num2));

    }

    public static String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder sk1 = new StringBuilder(num1);
        StringBuilder sk2 = new StringBuilder(num2);

        //Abu skaicius pakeiciame i priesinga puse
        sk1.reverse();
        sk2.reverse();

        //Issaugome sandaugos rezultata kiekvieno skaitmens antro ir pirmo skaiciaus.

        int rez = sk1.length() + sk2.length();
        StringBuilder ats = new StringBuilder();
        for(int i = 0; i < rez; ++i) {
            ats.append(0);
        }
        for(int antraVieta = 0; antraVieta < sk2.length(); antraVieta++) {
            int digit2 = sk2.charAt(antraVieta) - '0';

            for (int pirmaVieta = 0; pirmaVieta < sk1.length(); pirmaVieta++) {
                int digit1 = sk1.charAt(pirmaVieta) - '0';

                //
                // Nuliniai skaiciai priklauso nuo vietos antro skaitmens, antro skaiciaus ir
                // pirmo skaitmens, pirmo skaiciaus.

                int dabartinePozicija = pirmaVieta + antraVieta;

                // Skaitmens "dabartinePozicija" pozicija siuo metu Stringo "ats"
                int saugoti = ats.charAt(dabartinePozicija) - '0';
                int daugyba = digit1 * digit2 + saugoti;

                //Nustatome pirma vieta daugybos rezultate.
                ats.setCharAt(dabartinePozicija, (char)(daugyba % 10 + '0'));

                // "saugoti" desimciu daugybos vietu rezultatus pridedant i kita
                // pozicija i atsakymo masyva
                int reiksme = (ats.charAt(dabartinePozicija + 1) - '0') + daugyba / 10;
                ats.setCharAt(dabartinePozicija + 1, (char)(reiksme + '0'));
            }
        }
        // Ismetame 0 is atsakymo galo
        if (ats.charAt(ats.length() - 1) == '0') {
            ats.deleteCharAt(ats.length() - 1);
        }
        ats.reverse();
        return ats.toString();
    }
}
