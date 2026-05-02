package com.mineops.app;

import java.sql.Date;
import java.util.Scanner;

import com.mineops.dao.MineOpsDAO;
import com.mineops.entity.*;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MineOpsDAO dao = new MineOpsDAO();

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
             // UC-05
                case 5: {
                    Worker w = new Worker();
                    System.out.print("Worker ID: ");
                    w.setWorkerId(sc.nextInt());
                    System.out.print("Mine ID: ");
                    w.setMineId(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Name: ");
                    w.setName(sc.nextLine());
                    System.out.print("Role: ");
                    w.setRole(sc.nextLine());
                    System.out.print("Phone: ");
                    w.setPhone(sc.nextLine());
                    dao.save(w);
                    System.out.println("Worker registered");
                    break;
                }

                // UC-06
                case 6: {
                    ShiftLog s = new ShiftLog();
                    System.out.print("Shift ID: ");
                    s.setShiftId(sc.nextInt());
                    System.out.print("Mine ID: ");
                    s.setMineId(sc.nextInt());
                    System.out.print("Supervisor ID: ");
                    s.setSupervisorId(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Shift Type: ");
                    s.setShiftType(sc.nextLine());
                    System.out.print("Shift Date (yyyy-mm-dd): ");
                    s.setShiftDate(Date.valueOf(sc.next()));
                    dao.save(s);
                    System.out.println("Shift created");
                    break;
                }

                // UC-07
                case 7: {
                    ProductionLog p = new ProductionLog();
                    System.out.print("Production ID: ");
                    p.setProdId(sc.nextInt());
                    System.out.print("Mine ID: ");
                    p.setMineId(sc.nextInt());
                    System.out.print("Shift ID (0 if none): ");
                    int sid = sc.nextInt();
                    p.setShiftId(sid == 0 ? null : sid);
                    System.out.print("Date (yyyy-mm-dd): ");
                    p.setLogDate(Date.valueOf(sc.next()));
                    System.out.print("Tonnes: ");
                    p.setTonnes(sc.nextDouble());
                    System.out.print("Grade: ");
                    p.setGrade(sc.nextDouble());
                    dao.save(p);
                    System.out.println("Production logged");
                    break;
                }

                // UC-08
                case 8: {
                    EquipmentUsage u = new EquipmentUsage();
                    System.out.print("Usage ID: ");
                    u.setUsageId(sc.nextInt());
                    System.out.print("Mine ID: ");
                    u.setMineId(sc.nextInt());
                    System.out.print("Equipment ID: ");
                    u.setEquipmentId(sc.nextInt());
                    System.out.print("Date (yyyy-mm-dd): ");
                    u.setUsageDate(Date.valueOf(sc.next()));
                    System.out.print("Running Hours: ");
                    u.setRunningHours(sc.nextDouble());
                    System.out.print("Breakdown (Y/N): ");
                    u.setBreakdown(sc.next().charAt(0));
                    System.out.print("Downtime Hours: ");
                    u.setDowntimeHours(sc.nextDouble());
                    dao.save(u);
                    System.out.println("Equipment usage recorded");
                    break;
                }
             // UC-09
                case 9: {
                    SafetyIncident si = new SafetyIncident();
                    System.out.print("Incident ID: ");
                    si.setIncidentId(sc.nextInt());
                    System.out.print("Mine ID: ");
                    si.setMineId(sc.nextInt());
                    System.out.print("Equipment ID (0 if none): ");
                    int eid = sc.nextInt();
                    si.setEquipmentId(eid == 0 ? null : eid);
                    System.out.print("Worker ID (0 if none): ");
                    int wid = sc.nextInt();
                    si.setWorkerId(wid == 0 ? null : wid);
                    System.out.print("Date (yyyy-mm-dd): ");
                    si.setIncidentDate(Date.valueOf(sc.next()));
                    sc.nextLine();
                    System.out.print("Type: ");
                    si.setType(sc.nextLine());
                    System.out.print("Severity (1-5): ");
                    si.setSeverity(sc.nextInt());
                    System.out.print("Cost: ");
                    si.setCost(sc.nextDouble());
                    si.setStatus("OPEN");
                    dao.save(si);
                    System.out.println("Incident reported");
                    break;
                }

                // UC-10
                case 10: {
                    System.out.print("Incident ID to close: ");
                    int iid = sc.nextInt();
                    dao.closeIncident(iid);
                    System.out.println("Incident closed");
                    break;
                }

                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}