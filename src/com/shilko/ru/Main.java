package com.shilko.ru;

import java.io.*;
import java.util.*;

import javafx.util.Pair;

import java.sql.*;
import java.util.concurrent.Executor;

class Binary {
    public static String binary(int n, int size) {
        StringBuilder s = new StringBuilder();
        while (size > 0) {
            s.append(" ");
            s.append(n % 2);
            n /= 2;
            --size;
        }
        return s.reverse().toString();
    }
}

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new FileReader("Словарь.txt"));
             Scanner surname = new Scanner(new FileReader("Фамилии.txt"));
             Scanner town = new Scanner(new FileReader("Города.txt"));
             PrintWriter out = new PrintWriter(new FileWriter("5РЕЛИГИИ.txt"));) {
            List<String> list = new ArrayList<>();
            List<String> surnames = new ArrayList<>();
            List<String> towns = new ArrayList<>();
            for (int i = 0; i < 125000; ++i)
                list.add(in.nextLine());
            for (int i = 0; i < 247000; ++i)
                surnames.add(surname.nextLine());
            for (int i = 0; i < 162000; ++i) {
                String temp = town.nextLine();
                towns.add(temp.substring(0, temp.indexOf(" ")));
            }
            for (int i = 0; i < 250000; ++i) {
                Random random = new Random();
                String name = list.get(random.nextInt(125000)) + " " + list.get(random.nextInt(125000));
                out.println("INSERT INTO РЕЛИГИИ(НАЗВАНИЕ_РЕЛИГИИ,ИД_РЕЛИГИИ_ПРЕДКА) VALUES ('"+name+"',"+(random.nextInt(i+1)+1)+");");
                //int temp = random.nextInt(1020);
                //int country = (random.nextInt(250000)+1);
                //String start = temp +"-"+String.format("%02d",random.nextInt(12)+1)+"-"+String.format("%02d",random.nextInt(28)+1)+" "+String.format("%02d",random.nextInt(23)+1)+":"+String.format("%02d",random.nextInt(59)+1)+":"+String.format("%02d",random.nextInt(59)+1);
                //String end = (temp+random.nextInt(100)+1) +"-"+String.format("%02d",random.nextInt(12)+1)+"-"+String.format("%02d",random.nextInt(28)+1)+" "+String.format("%02d",random.nextInt(23)+1)+":"+String.format("%02d",random.nextInt(59)+1)+":"+String.format("%02d",random.nextInt(59)+1);
                //String describing = list.get(random.nextInt(125000)) + " " + list.get(random.nextInt(125000)) + " " + list.get(random.nextInt(125000)) + " " + list.get(random.nextInt(125000)) + " " + list.get(random.nextInt(125000));
                //out.println("SELECT копировать_в_историю("+country+",'"+start+"','"+end+"','"+describing+"');");
                //out.println("\t('" + name + "'," + random.nextInt(250000) + "," + random.nextInt(250000) + ","+ random.nextInt(250000) + ","+ random.nextInt(250000) + "),");
                /*if (i == 249999)
                out.println("\t("+(random.nextInt(250000)+1)+","+(random.nextInt(250000)+1)+"),");
                else
                    out.println("\t("+(random.nextInt(250000)+1)+","+(random.nextInt(250000)+1)+");");*/
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
