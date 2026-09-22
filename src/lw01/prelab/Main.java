package lw01.prelab;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
   public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(Main.class.getResourceAsStream("jobs.txt"));
      List<PrintJob> jobs = new ArrayList<>();

      while(sc.hasNext()) {
         String type = sc.next();
         String id = sc.next();
         int pages = sc.nextInt();

         // PrintJob job;
         // if (type.equals("MONO")) {
         //    job = new MonoPrint(id, pages);
         // } else if (type.equals("COLOUR")) {
         //    job = new ColourPrint(id, pages);
         // }

         // jobs.add(job);

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
