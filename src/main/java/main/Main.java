package main;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.*;
import java.lang.reflect.Array;


public class Main {

    private static final String v1 = "C:\\photo\\0_pages-to-jpg-000";
    private static final String v2 = "C:\\photo\\0_pages-to-jpg-00";
    private static final String v3 = "C:\\photo\\0_pages-to-jpg-0";

    private static String rm1 = ">";
    private static String rm2 = "<";
    private static String rm3 = "|";
    private static String rm4 = "^";
    private static String rm5 = "Ё";
    private static String rm6 = "%";
    private static String rm7 = "_";
    private static String rm8 = "’";
    private static String rm9 = "/";
    private static String rm10 = "©";


    private static final String pathNameResultFile = "C:\\info\\save.txt";

    public static void main(String[] args) throws IOException {

        Tesseract tesseract = new Tesseract();
        FileWriter writer = new FileWriter(pathNameResultFile,true);
        try {
            tesseract.setLanguage("rus");
            tesseract.setDatapath("C:\\Tess4J-3.4.8-src\\Tess4J\\tessdata");

            File file = new File("C:\\photo");
            File[] files = file.listFiles();

            for(File fi: files) {
                String result;
                String names = fi.getName();
                String newNames2 = names.replaceAll("0_pages-to-jpg-0", "");
                String string = newNames2.replaceAll(".jpg", "");
                int count = Integer.parseInt(string);
                String text;
                if (count<10) {
                    text = tesseract.doOCR(new File(v1 + count + ".jpg"));
                    result = removeCharacters(text);
                    writer.write(result+"\n\r");
                    writer.write("------------------------------------------------------------------"+"\n\r");
                }else if(count>10 && count<100){
                    text = tesseract.doOCR(new File(v2 + count + ".jpg"));
                    result = removeCharacters(text);
                    writer.write(result+"\n\r");
                    writer.write("------------------------------------------------------------------"+"\n\r");
                    System.out.println("--------------------------------------------------------------");
                }else if(count>=100){
                    text = tesseract.doOCR(new File(v3 + count + ".jpg"));
                    result = removeCharacters(text);
                    writer.write(result+"\n\r");
                    writer.write("------------------------------------------------------------------"+"\n\r");
                    System.out.println("--------------------------------------------------------------");
                }
                System.out.print(count+"\n\r");
            }
            writer.close();
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }

    private static String removeCharacters(String string) throws IOException {

        if(string.contains(rm1)){
            string = string.replaceAll(rm1,"");
        }
        if(string.contains(rm2)){
            string = string.replaceAll(rm2,"");
        }
        if(string.contains(rm3)){
            string = string.replaceAll(rm3,"");
        }
        if(string.contains(rm4)){
            string = string.replaceAll(rm4,"");
        }
        if(string.contains(rm5)){
            string = string.replaceAll(rm5,"");
        }
        if(string.contains(rm6)){
            string = string.replaceAll(rm6,"");
        }
        if(string.contains(rm7)){
            string = string.replaceAll(rm7,"");
        }
        if(string.contains(rm8)){
            string = string.replaceAll(rm8,"");
        }
        if(string.contains(rm9)){
            string = string.replaceAll(rm9,"");
        }
        if(string.contains(rm10)){
            string = string.replaceAll(rm10,"");
        }
        if(string.contains("#")){
            string = string.replaceAll("#","");
        }
        if(string.contains("$")){
            string = string.replaceAll("\\$","");
        }
        if(string.contains("@")){
            string = string.replaceAll("@","");
        }
        if(string.contains("\"")){
            string = string.replaceAll("\"","");
        }
        if(string.contains("|")){
            string = string.replaceAll("\\|","");
        }
        return string;
    }
    }

