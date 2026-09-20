package lw01.prelab;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
   public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(new File("src/lw01/prelab/jobs.txt"));
      List<PrintJob> jobs = new ArrayList<>();

      while(sc.hasNextLine()) {
         String type = sc.next();
         String id = sc.next();
         int pages = sc.nextInt();
         if (type.equals("MONO")) {
            jobs.add(new MonoPrint(id, pages));
         } else if (type.equals("COLOUR")) {
            jobs.add(new ColourPrint(id, pages));
         }
      }

      sc.close();

      for(PrintJob job : jobs) {
         System.out.println(job.summary());
      }
   }

}
