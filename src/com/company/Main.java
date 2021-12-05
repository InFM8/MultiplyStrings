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
// To store the multiplication result of each digit of secondNumber with firstNumber.
        int rez = sk1.length() + sk2.length();
        StringBuilder ats = new StringBuilder();
        for(int i = 0; i < rez; ++i) {
            ats.append(0);
        }
        for(int i = 0; i < sk2.length(); i++) {
            int skaitmuo2 = sk2.charAt(i) - '0';
//kiekviena skaitmeni antro skaiciaus dauginame visus skaitmenis pirmo skaiciaus
// For each digit in secondNumber multiply the digit by all digits in firstNumber.

            for (int j = 0; j < sk1.length(); j++) {
                int skaitmuo1 = sk1.charAt(j) - '0';

                // Nuliniai skaiciai priklauso nuo vietos antro skaitmens, antro skaiciaus ir
                // pirmo skaitmens, pirmo skaiciaus.
                int dabartinePozicija = j + i;

                // Skaitmens "dabartinePozicija" pozicija siuo metu Stringo "ats"
                // inicijuojame dabartinePozicija - 'saugoti' ir sumuojame su esamu rezultatu
                int saugoti = ats.charAt(dabartinePozicija) - '0';
                int daugyba = skaitmuo1 * skaitmuo2 + saugoti;

                //Nustatome kiekvieno sudauginto skaitmens vieta daugybos rezultate.

                ats.setCharAt(dabartinePozicija, (char)(daugyba % 10 + '0'));

                // Issaugome daugybos rezultata "desimtainiu skaiciu abeceleje"
                int reiksme = (ats.charAt(dabartinePozicija + 1) - '0') + daugyba / 10;

                // kiekviena gauta reiksme pridedame i kita pozicija
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
