package com.company;

public class Main {

    public static void main(String[] args) {

        String num1 = "123";
        String num2 = "456";

        System.out.println(num1 + " * " + num2 + " = " +multiply(num1, num2));

    }

    /**
     * Funkcija skaiciuojanti pirmo ir antro skaiciaus daugyba
     * @param num1 pirmas skaicius
     * @param num2 antras skaicius
     * @return grazinamas atsakymas
     */
    public static String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder sk1 = new StringBuilder(num1);
        StringBuilder sk2 = new StringBuilder(num2);

        //Abu skaicius apverciame
        sk1.reverse();
        sk2.reverse();

        //Issaugome sandaugos rezultata kiekvieno skaitmens antro ir pirmo skaiciaus.

        int rez = sk1.length() + sk2.length();

        StringBuilder ats = new StringBuilder();
        for(int i = 0; i < rez; ++i) {
            ats.append(0);
        }
        for(int i = 0; i < sk2.length(); i++) {
            int skaitmuo2 = sk2.charAt(i) - '0';

//kiekviena skaitmeni antro skaiciaus dauginame visus skaitmenis pirmo skaiciaus

            for (int j = 0; j < sk1.length(); j++) {
                int skaitmuo1 = sk1.charAt(j) - '0';

                // Nuliniai skaiciai priklauso nuo vietos antro skaitmens, antro skaiciaus ir
                // pirmo skaitmens, pirmo skaiciaus.

                int dabartinePozicija = j + i;

                // Skaitmens "dabartinePozicija" pozicija siuo metu Stringo "ats"
                // inicijuojame dabartinePozicija - 'saugoti' ir sumuojame su esamu rezultatu

                int saugoti = ats.charAt(dabartinePozicija) - '0';
                int daugyba = skaitmuo1 * skaitmuo2 + saugoti;

                //Nustatoma kiekvieno sudauginto skaitmens vieta daugybos rezultate

                ats.setCharAt(dabartinePozicija, (char)(daugyba % 10 + '0'));

                // Issaugome daugybos rezultata "tarp desimtainiu skaiciu"

                int reiksme = (ats.charAt(dabartinePozicija + 1) - '0') + daugyba / 10;

                // kiekviena gauta reiksme pridedame i kita pozicija
                ats.setCharAt(dabartinePozicija + 1, (char)(reiksme + '0'));
            }
        }
        // Pasaliname 0 is atsakymo pabaigos
        if (ats.charAt(ats.length() - 1) == '0') {
            ats.deleteCharAt(ats.length() - 1);
        }
        ats.reverse();
        return ats.toString();
    }
}
