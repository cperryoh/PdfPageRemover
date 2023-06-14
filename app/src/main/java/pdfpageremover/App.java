/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package pdfpageremover;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;

public class App {

    public static void main(String[] args) throws IOException {
        
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the path of the pdf file:");
        String path = scn.nextLine() + ".pdf";
        System.out.print("Enter the path of the output file:");
        String output =scn.nextLine()+".pdf";
        System.out.print("Enter the start of the page range to keep: ");
        int start = scn.nextInt()-1;
        System.out.print("Enter the end of the page range to keep: ");
        int end = scn.nextInt()-1;
        scn.close();
        try {
            PDDocument document = PDDocument.load(new File(path));
            PDDocument outputDoc = new PDDocument();
            for (int i = start; i <= end; i++) {
                if ((i >= start && i <= end)) {
                    outputDoc.addPage(document.getPage(i));
                }
            }
            outputDoc.save(output);
            outputDoc.close();
            document.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        


    }
}
