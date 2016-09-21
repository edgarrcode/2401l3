/*
Author: Edgar E. Rodriguez
TAs: Anthony M Ortiz Cepeda and Khandoker A Rahad
Professor: Mahmud Hossain
LMD: 09/15/16
Goals: Read the widht, height, and length of packages from file, and calculate the following:
*/

import java.util.*;
import java.io.*;

public class Runner {

    public static BoxLL readFile(String fileName) throws IOException {
        String line;
        FileReader reader = new FileReader(fileName);
        BufferedReader buffer = new BufferedReader(reader);
        buffer.mark(1000); //here we assume that the file won't be longer than 1000 lines
        int numOfLines = 0;
        String[] eachLine;

        line = buffer.readLine();
        //check if file is empty
        if (line == null) {
            try {
                throw new IOException("The file is empty!");
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }

        //create new ll (head)
        eachLine = line.split(" ");
        // check if file data is in correct format
        if (eachLine.length != 3) {
            try {
                throw new IOException("There should be 3 values per line in the file.");
            } catch(IOException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
        Box firstBox = new Box(Double.parseDouble(eachLine[0]),Double.parseDouble(eachLine[1]),Double.parseDouble(eachLine[2]));        
        BoxLL head = new BoxLL(firstBox, null);
        BoxLL tempLL = head;

        //read next line
        //eachLine = buffer.readLine().split(" ");
        line = buffer.readLine();

        while(line != null) {
            eachLine = line.split(" ");
            Box eachLineBox = new Box(Double.parseDouble(eachLine[0]),Double.parseDouble(eachLine[1]),Double.parseDouble(eachLine[2]));
            tempLL.next = new BoxLL(eachLineBox, null);
            tempLL = tempLL.next;
            line = buffer.readLine();
        }

        return head;

    }


    //Find the smallest box. Report position, dimensions, and volume of the smallest object.
    public static int smallestBoxPos (BoxLL head) {
        // set smallestBoxPos to first item of list and smallestVolume to volume of first item of the list
        int smallestBoxPos = 0;
        double smallestVolume = head.getTheBox().getVolume();;

        //get values of next LL
        BoxLL tempLL = new BoxLL();
        tempLL = head.next;
        int counter = 1;

        while(tempLL != null) {
            if ((tempLL.getTheBox().getVolume()) < smallestVolume) {
                smallestVolume = tempLL.getTheBox().getVolume();
                smallestBoxPos = counter;
            }
            tempLL = tempLL.next;
            counter++;
        }

        return smallestBoxPos;
    }

    public static void main (String[] args) throws IOException {
        // ask for file name to build LL
        String fileName = "";
        Scanner scnr = new Scanner(System.in);
        System.out.println("What is the file name?");
        BoxLL head = new BoxLL();
        try {
            fileName = scnr.nextLine();
            //call readFile method with the filename as parameter
            head = readFile(fileName);
        } catch (FileNotFoundException e) {
            System.err.println("File not found! " + e.getMessage());
            System.exit(1);
        } catch (NumberFormatException e) {
            System.err.println("The file should only contain numbers of double precision and single spaces (example: \"1.0 2.3 1.3\"). " + e.getMessage());
            System.exit(1);
        }

        //--- Find the smallest box. Report position, dimensions, and volume of the smallest object.
        int smallestBoxPos = smallestBoxPos(head); //get the index position
        BoxLL tempLL = new BoxLL();
        tempLL = head;
        //iterate to correct position
        for (int i = 0; i < smallestBoxPos; i++) {
            tempLL = tempLL.next;
        }
        System.out.println("The position of the smallest package is: " + smallestBoxPos);
        System.out.println("The width of the smallest package is: " + tempLL.getTheBox().getWidth());
        System.out.println("The height of the smallest package is: " + tempLL.getTheBox().getHeight());
        System.out.println("The length of the smallest package is: " + tempLL.getTheBox().getLength());
        System.out.println("The volume of the smallest package is: " + tempLL.getTheBox().getVolume());

    }

}