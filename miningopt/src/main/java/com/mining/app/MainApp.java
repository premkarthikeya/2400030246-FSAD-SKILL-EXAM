package com.mining.app;

import java.sql.Date;
import java.util.Scanner;

import com.mining.app.*;
import com.mining.app.*;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MainApp dao = new MainApp();

        while (true) {

            System.out.println("\n===== MINE OPS LITE (CRUD) =====");
            System.out.println("1. Register Mine Site");
            System.out.println("2. Update Mine Status");
            System.out.println("3. Register Equipment");
            System.out.println("4. Transfer Equipment Between Mines");
            System.out.println("5. Register Worker");
            System.out.println("6. Create Shift Log");
            System.out.println("7. Record Daily Production");
            System.out.println("8. Record Equipment Usage");
            System.out.println("9. Report Safety Incident");
            System.out.println("10. Close Safety Incident");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {

                // UC-01
                case 1: {
                    MineSite m = new MineSite();
                    System.out.print("Mine ID: ");
                    m.setMineId(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Name: ");
                    m.setName(sc.nextLine());
                    System.out.print("Location: ");
                    m.setLocation(sc.nextLine());
                    System.out.print("Status: ");
                    m.setStatus(sc.nextLine());
                    dao.save(m);
                    System.out.println("Mine registered");
                    break;
                }

                // UC-02
                case 2: {
                    System.out.print("Mine ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Status (ACTIVE/INACTIVE): ");
                    String st = sc.nextLine();
                    dao.updateMineStatus(id, st);
                    System.out.println("Mine status updated");
                    break;
                }

                // UC-03
                case 3: {
                    Equipment e = new Equipment();
                    System.out.print("Equipment ID: ");
                    e.setEquipmentId(sc.nextInt());
                    System.out.print("Mine ID: ");
                    e.setMineId(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Name: ");
                    e.setName(sc.nextLine());
                    System.out.print("Type: ");
                    e.setType(sc.nextLine());
                    System.out.print("Status: ");
                    e.setStatus(sc.nextLine());
                    System.out.print("Purchase Date (yyyy-mm-dd): ");
                    e.setPurchaseDate(Date.valueOf(sc.next()));
                    dao.save(e);
                    System.out.println("Equipment registered");
                    break;
                }

                // UC-04
                case 4: {
                    System.out.print("Equipment ID: ");
                    int eid = sc.nextInt();
                    System.out.print("New Mine ID: ");
                    int mid = sc.nextInt();
                    dao.transferEquipment(eid, mid);
                    System.out.println("Equipment transferred");
                    break;
                }