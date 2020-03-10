package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    private static int zalogowanyA;
    private static int zalogowanyW;
    private static int zalogowanyC;
    static DB bazaDanych = new DB();

    public static void main(String[] args) {
        menuPoczatkowe();
    }

    public static void menuPoczatkowe(){
        System.out.println("Witamy na stronie Banku Niezawodnego!");
        System.out.println("Wybierz operacje, ktora chcesz wykonac.");
        System.out.println("1. Chcialbym zalozyc konto klienta.");
        System.out.println("2. Chcialbym sie zalogowac na istniejace konto klienta.");
        System.out.println("3. Chcialabym sie zalogowac na istniejace konto pracownika.");
        System.out.println("4. Chcialabym sie zalogowac na istniejace konto administartora.");
        System.out.println("5. Chialbym zamknac strone Banku Niezawodnego.");

        int wybor=scanner.nextInt();

        switch (wybor){
            case 1:
                zakladanieKonta();
                break;
            case 2:
                menuLogowaniaClienta();
                break;
            case 3:
                menuLogowaniaWorkera();
                break;
            case 4:
                menuLogowaniaAdministartora();
                break;
            case 5:
                System.out.println("Dziekujemy za odwiedzenie strony Banku Niezawodnego!");
                System.exit(0);
                break;
            default:
                System.out.println("Brak podanej operacji!");
                menuPoczatkowe();
                break;
        }
    }

    public static void zakladanieKonta(){
        String imie;
        String nazwisko;
        String haslo;
        String login;

        System.out.println("Prosze podac swoje imie.");
        imie = scanner.next();
        System.out.println("Prosze podac swoje nazwisko.");
        nazwisko = scanner.next();
        System.out.println("Jaki ma byc login konta?");
        login=scanner.next();
        System.out.println("Jakie ma byc haslo do konta?");
        haslo = scanner.next();
        System.out.println("Twoje konto zostalo zalozone!");

        bazaDanych.listaClientow.add(new Client(imie, nazwisko, haslo, login));
        zapisClientow();
    }

    private static void zapisClientow(){
        try{
            PrintWriter writer =new PrintWriter(new FileWriter(new File("studenci.txt")));
            for(Client cliencik: DB.listaClientow){
                writer.println(cliencik.getImie()+","+cliencik.getNazwisko()+","+cliencik.getIdentyfikator()+","+cliencik.getHaslo()+","+cliencik.getLogin());
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void menuLogowaniaClienta(){
        System.out.println("Prosze wprowadzic login.");

        String login;
        login=scanner.next();

        System.out.println("Prosze wprowadzic haslo.");

        String haslo;
        haslo=scanner.next();

        for (Client client: bazaDanych.listaClientow){
            if (client.getLogin().equals(login)){
                if (client.getHaslo().equals(haslo)){
                    zalogowanyC=client.getIdentyfikator();
                    menuClienta();
                    break;
                }
            }
        }
        System.out.println("Bledne haslo!");
        System.out.println("Wybierz kolejna akcje:");
        System.out.println("1. Sproboj ponownie.");
        System.out.println("2. Wroc na strone glowna.");
        int wyborek;
        wyborek = scanner.nextInt();
        switch (wyborek){
            case 1:
                menuLogowaniaClienta();
                break;
            case 2:
                menuPoczatkowe();
                break;
            default:
                System.out.println("Brak podanej operacji!");
                menuPoczatkowe();
                break;
        }
    }

    public static void menuLogowaniaWorkera(){
        System.out.println("Prosze wprowadzic login.");

        String login;
        login=scanner.next();

        System.out.println("Prosze wprowadzic haslo.");

        String haslo;
        haslo=scanner.next();

        for (Worker worker: bazaDanych.listaWorkerow){
            if (worker.getLogin().equals(login)){
                if (worker.getHaslo().equals(haslo)){
                    zalogowanyW=worker.getIdentyfikator();
                    menuWorkera();
                    break;
                }
            }
        }

        System.out.println("Bledne haslo!");
        System.out.println("Wybierz kolejna akcje:");
        System.out.println("1. Sproboj ponownie.");
        System.out.println("2. Wroc na strone glowna.");
        int wyborek;
        wyborek = scanner.nextInt();
        switch (wyborek){
            case 1:
                menuLogowaniaWorkera();
                break;
            case 2:
                menuPoczatkowe();
                break;
            default:
                System.out.println("Brak podanej operacji!");
                menuPoczatkowe();
                break;
        }
    }

    public static void menuLogowaniaAdministartora(){
        System.out.println("Prosze wprowadzic login.");

        String login;
        login=scanner.next();

        System.out.println("Prosze wprowadzic haslo.");

        String haslo;
        haslo=scanner.next();

        for (Administrator administrator: bazaDanych.listaAdministratorow){
            if (administrator.getLogin().equals(login)){
                if (administrator.getHaslo().equals(haslo)){
                    zalogowanyA=administrator.getIdentyfikator();
                    menuAdministratora();
                    break;
                }
            }
        }
        System.out.println("Bledne haslo!");
        System.out.println("Wybierz kolejna akcje:");
        System.out.println("1. Sproboj ponownie.");
        System.out.println("2. Wroc na strone glowna.");
        int wyborek;
        wyborek = scanner.nextInt();
        switch (wyborek){
            case 1:
                menuLogowaniaAdministartora();
                break;
            case 2:
                menuPoczatkowe();
                break;
            default:
                System.out.println("Brak podanej operacji!");
                menuPoczatkowe();
                break;
        }
    }

    public static void menuClienta(){
        System.out.println("Logowanie przebieglo pomyslnie!");
        System.out.println("Prosze wybrac operacje:");
        System.out.println("1. Wykonaj przelew.");
        System.out.println("2. Wypełnij wniosek kredytowy.");
        System.out.println("3. Wyloguj sie.");
    }

    public static void menuWorkera(){
        System.out.println("Logowanie przebieglo pomyslnie!");
        System.out.println("Prosze wybrac operacje:");
    }

    public static void menuAdministratora(){
        System.out.println("Logowanie przebieglo pomyslnie!");
        System.out.println("Prosze wybrac operacje:");
    }
}
