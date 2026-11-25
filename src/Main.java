import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.next();
        double percentage = sc.nextDouble();
        int backlogs = sc.nextInt();
        int graduationYear = sc.nextInt();

        Candidate candidate = new Candidate(name, percentage, backlogs, graduationYear);
        Job job = new Job("Infosys",
                "Java Developer",
                65.0,
                0,
                2026);

        EligibilityRule rule[] = {
                new PercentageRule(),
                new BacklogRule(),
                new GraduationYearRule()
        };

        System.out.println("==============================================");
        System.out.println("PLACEMENT ELIGIBILITY RESULT");
        System.out.println("==============================================");

        System.out.println();
        System.out.println("Candidate: " + candidate.getName());
        System.out.println("Company: " + job.getCompany());
        System.out.println("Role: " + job.getRole());

        boolean eligible = true;
        for (int i = 0; i < rule.length; i++) {
            boolean pass = rule[i].check(candidate, job);
            if (pass) {
                System.out.println(rule[i].getRuleName() + " : PASS");
            } else {
                System.out.println(rule[i].getRuleName() + " : FAIL");
                eligible = false;
            }
        }

        System.out.println();
        if (eligible) {
            System.out.println("Final Result: Eligible");
        } else {
            System.out.println("Final Result: Not Eligible");
        }
        System.out.println("==============================================");
        sc.close();
    }
}