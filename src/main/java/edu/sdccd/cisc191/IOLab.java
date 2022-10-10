package edu.sdccd.cisc191;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
/**
 *
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 */
public class IOLab
{

    public static String readTestResults(String s) {

        String result = "";

        try{
            File testResult = new File("src/main/resources/" + s);
            Scanner scanner = new Scanner(testResult);
            while (scanner.hasNextLine()){
                result += scanner.nextLine();
            }
            return result;
        }
        catch (FileNotFoundException e) {
            return "";
        }
    }

    public static void appendTestResult(String s, String s1) {
        File inputFile = new File("src/main/resources/" + s);
        try {
            PrintWriter out = new PrintWriter(new FileWriter(inputFile, true), true);
            out.println(s1);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readDateTime(String s) {
        try{
            URL dateTimeURL = new URL(s);
            Scanner download = new Scanner(dateTimeURL.openStream());
            String getInput = download.nextLine();
            int dateTime = getInput.indexOf("datetime");
            return getInput.substring(dateTime+11 , dateTime+43);
        }
        catch (FileNotFoundException e){
            System.out.println("Error: File not found");
        }
        catch(MalformedURLException e){
            System.out.println("Error: Invalid URL");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }
}