package com.lumato.inout;

import java.io.*;
import java.util.Scanner;

public class WriteReadFile {

    /** get n-th line of file as String */
    public static String readNthLine(String path, int n) {
        String line = "";
        if (n<=0) return "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            int currentLine = 1;
            while (currentLine < n) {
                reader.readLine();
                currentLine++;
            }
            line = reader.readLine();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    //Zapis danych do txt lub csv (; jako separator kolumn w CSV)
    public static void writeText(String whatToWrite, boolean toAppned, String path) {
        try {
            FileWriter pw = new FileWriter(path, toAppned); // zmienić ściezkę do pliku, obecnie plik txt
            StringBuilder sb = new StringBuilder();
            //jeśli plik istnieje lub jest pusty to nie dodajemy nowej linii
            if (!isFileEmptyOrNonExisting(path)) {
                sb.append("\n");
            }
            sb.append(whatToWrite);
            pw.write(sb.toString());
            pw.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    //Metoda czytające dane z poszczególnej kolumny, można użyć do obliczania danych średnich dodaj
    public static void readCsv(int columnToPrint) {
        File file = new File(FilePaths.getCsvDataLocation());
        try {
            Scanner inputStream = new Scanner(file);
            inputStream.nextLine(); //Ignoruje pierwszą linię np hagłówek)
//            double sum = 0;
//            double numberOfrecords = 0;
            while (inputStream.hasNextLine()) {
                String data = inputStream.nextLine();
                String[] array = data.split(";"); //Tworzy tablice stringów i dzieli linie w miejscu ';'
//                double value = Double.parseDouble(array[columnToPrint]);
//                sum += value;
//                numberOfrecords++;
                System.out.println(array[columnToPrint]);
            }
//            double averageValue = sum / numberOfrecords;
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }

    /** fast data save to file (does NOT append! erases current file if exists) */
    public static void saveSimpleText(String text, String path) throws IOException {
        try {
            FileOutputStream out = new FileOutputStream(path);
            DataOutputStream save = new DataOutputStream(out);
            save.writeBytes(text);
            save.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Metoda czyta plik i zwraca StringBuilder sb.
    public static StringBuilder readFromFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(FilePaths.getCsvDataLocation()));
            while ((line = fileReader.readLine()) != null) {
                sb.append(line);
            }
            line = fileReader.readLine();
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        return sb;
    }


    public static boolean isFileEmptyOrNonExisting(String path){
        File file = new File(path);
        if (!file.exists()) return true;
        if (file.length()==0) return true;
        return false;
    }
}
