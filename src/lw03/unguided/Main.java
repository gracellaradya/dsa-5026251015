package lw03.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("registrations.txt"));
        Set<String> regist = new LinkedHashSet<>();
       
        while(sc.hasNextLine()) {
            String id = sc.next();
            regist.add(id);
        }

        Scanner input = new Scanner(Main.class.getResourceAsStream("checkins.txt"));
        List<String> checkin = new LinkedList<>();

        int success = 0;
        int rejected = 0;

        System.out.println("===== Event Check-In Results =====");
        while(input.hasNextLine()) {
            String check = input.next();
            if(!regist.contains(check)) {
                System.out.println(check + ": Rejected (not registered)");
                rejected++;
            } else if(checkin.contains(check)) {
                System.out.println(check + ": Rejected (already checked in)");
                rejected++;
            } else {
                checkin.add(check);
                System.out.println(check + ": Checked In");
                success++;
            }
        }
        
        int absent = regist.size() - checkin.size();

        System.out.println();
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + regist.size());
        System.out.println("Successful check-ins: " + success);
        System.out.println("Absent students: " + absent);
        System.out.println("Rejected attempts: " + rejected);

    }
}

