package com.company;

public class MultiplyStrings {

    public static void main(String[] args) {

        String num1 = "123";
        String num2 = "456";

        System.out.println(num1 + " * " + num2 + " = " + multiply(num1, num2));
    }

    /**
     * Funkcija skaiciuojanti pirmo ir antro skaiciaus sandauga
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

        sk1.reverse();
        sk2.reverse();

        int rez = sk1.length() + sk2.length(); // rez = 6;

        StringBuilder ats = new StringBuilder();
        for (int i = 0; i < rez; ++i) {
            ats.append(0);                    // ats = 000000;
        }
        for (int i = 0; i < sk2.length(); i++) {
            int skaitmuo2 = sk2.charAt(i) - '0';

            for (int j = 0; j < sk1.length(); j++) {
                int skaitmuo1 = sk1.charAt(j) - '0';

                int dabartinePozicija = j + i; //0,1,2,1,2,3,2,3,4

                int saugotiMintyje = ats.charAt(dabartinePozicija) - '0'; //000 (9x)
                int daugyba = skaitmuo1 * skaitmuo2 + saugotiMintyje; //18, 12, 6, 15, 10, 5, 12, 8, 4

                //Nustatoma skaitmens vieta rezultate tarp vienetu
                ats.setCharAt(dabartinePozicija, (char) (daugyba % 10 + '0'));

                // Issaugome daugybos rezultata tarp desimciu
                int reiksme = (ats.charAt(dabartinePozicija + 1) - '0') + daugyba / 10; //1, 0, 7, 1, 0, 6, 1, 0

                // kiekviena gauta reiksme pridedame i sekancia pozicija
                ats.setCharAt(dabartinePozicija + 1, (char) (reiksme + '0'));
            }
        }

        if (ats.charAt(ats.length() - 1) == '0') {
            ats.deleteCharAt(ats.length() - 1);
        }
        ats.reverse();
        return ats.toString();
    }
}
