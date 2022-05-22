package com.company;

import java.io.*;
import java.util.ArrayList;

public class Benchmarks {
    public void writeToFile(int[] array, String filePathName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePathName,true))) {
            for (int i = 0; i < array.length; i++) {
                writer.write(String.valueOf(array[i]));
                writer.write(" ");
                writer.write("\r\n");
            }
            try {
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] readFromFile(String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String str= null;

        ArrayList<String> list = new ArrayList<>();

        while (true) {
            try {
                if (!((str = reader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!str.isEmpty()) {
                list.add(str);
            }
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size() ; i++) {
            array[i] = Integer.parseInt(list.get(i).trim());
        }
        return array;
    }
}
