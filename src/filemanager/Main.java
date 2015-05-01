/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import filecontroller.FileMangerLoader;
import filecontroller.FileMangerSaver;
import java.util.Scanner;
import memory.ContegeousMemory;
import memory.IndexedMemory;

/**
 *
 * @author Ahmed Abdelrheem
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FileManager fm = null;
        String mangerName;
        int mangerSize;

        String choice1; //for string input
        int choice2; //for integer input
        System.out.println("Enter New / Exist");
        choice1 = input.next();
        while (true) {
            if (choice1.equals("New")) {
                System.out.println("Enter File Manger Name");
                mangerName = input.next();

                System.out.println("Enter File Manger Size");
                mangerSize = input.nextInt();

                choice2 = 0;
                while (choice2 != 1 && choice2 != 2 && choice2 != 3) {
                    System.out.println("For Contegeous Memory Allocation enter 1");
                    System.out.println("For Indexed Memory Allocation enter 2");
                    System.out.println("For Exit enter 3");
                    choice2 = input.nextInt();
                    if (choice2 == 1) {
                        fm = new FileManager(mangerName, new ContegeousMemory(mangerSize));
                    } else if (choice2 == 2) {
                        fm = new FileManager(mangerName, new IndexedMemory(mangerSize));
                    } else if (choice2 == 3) {
                        fm = null;
                    }
                }
                break;
            } else if (choice1.equals("Exist")) {
                System.out.println("Enter File Name ");
                mangerName = input.next();
                fm = FileMangerLoader.load(mangerName);
                break;
            } else {
                System.out.println("Choose New / Exist");
                choice1 = input.next();
            }
        }

        if (fm == null) //user choose exist
            return;
        

        System.out.println("+++++++++++++++++++++++++");
        System.out.println("DisplayDiskStatus");
        System.out.println("DisplayDiskStructure");
        System.out.println("CreateFile <file path> <file size>");
        System.out.println("CreateFolder <directory path>");
        System.out.println("DeleteFile <file path> ");
        System.out.println("DeleteFolder <directory path> ");
        System.out.println("exit");
        System.out.println("+++++++++++++++++++++++++");
        String command;

        command = input.nextLine();

        while (command != "exit") {
            String cmd[] = command.split("\\s+");

            if (cmd[0].equals("DisplayDiskStatus")) {
                fm.displayDiskStatus();

            } else if (command.equals("DisplayDiskStructure")) {
                fm.displayDiskStructure();

            } else if (cmd[0].equals("CreateFile")) {
                if (cmd.length == 3) {
                    if (fm.createFile(cmd[1], Integer.parseInt(cmd[2])) == true) {
                        System.out.println("Created Successfuly");
                    } else {
                        System.out.println("Failed");
                    }

                }
            } else if (cmd[0].equals("CreateFolder")) {

                if (cmd.length == 2) {

                    if (fm.createDirectory(cmd[1]) == true) {
                        System.out.println("Created Successfuly");
                    } else {
                        System.out.println("Failed");
                    }
                }
            } else if (cmd[0].equals("DeleteFile")) {
                if (cmd.length == 2) {
                    if (fm.deleteFile(cmd[1])) {
                        System.out.println("Deleted Successfuly");
                    } else {
                        System.out.println("Failed");
                    }
                }

            } else if (cmd[0].equals("DeleteFolder")) {
                if (cmd.length == 2) {
                    if (fm.deleteDirectory(cmd[1]) == true) {
                        System.out.println("Deleted Successfuly");
                    } else {
                        System.out.println("Failed");
                    }
                }
            } else if (cmd[0].equals("exit")) {
                break;
            } else {
                System.out.println("Enter valid command");

            }
            FileMangerSaver.save(fm);
            command = input.nextLine();
        }
    }
}
