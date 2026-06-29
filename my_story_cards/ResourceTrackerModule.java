package my_story_cards;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ResourceTrackerModule {

    public void searchEmployeeBySkill(Employee[] gEmployeeList, int gEmployeeCount, Scanner lScanner) {
        try {
            System.out.print("\nEnter skill to search for (e.g., Java): ");
            String lSearchSkill = lScanner.next().trim().toLowerCase();
            boolean lFoundFlag = false;

            if (lSearchSkill.isEmpty()) {
                System.out.println("Error: Skill cannot be empty.");
                return;
            }

            System.out.println("\n--- Search Results ---");
            for (int lIdx = 0; lIdx < gEmployeeCount; lIdx++) {
                if (gEmployeeList[lIdx].gSkills.toLowerCase().contains(lSearchSkill)) {
                    System.out.println("ID: " + gEmployeeList[lIdx].gEmployeeId +
                                       " | Name: " + gEmployeeList[lIdx].gEmployeeName +
                                       " | Skills: " + gEmployeeList[lIdx].gSkills);
                    lFoundFlag = true;
                }
            }

            if (!lFoundFlag) {
                System.out.println("No employees found possessing the skill: " + lSearchSkill);
            }
        } catch (Exception lEx) {
            System.out.println("Error during skill search: " + lEx.getMessage());
            lScanner.nextLine();
        }
    }

    public void updateProjectStatus(Project[] gProjectList, int gProjectCount, Scanner lScanner) {
        try {
            System.out.print("\nEnter Project ID to update status: ");
            int lTargetProjectId = lScanner.nextInt();
            boolean lProjectFound = false;

            for (int lIdx = 0; lIdx < gProjectCount; lIdx++) {
                if (gProjectList[lIdx].gProjectId == lTargetProjectId) {
                    lProjectFound = true;
                    System.out.println("Current Status of '" + gProjectList[lIdx].gProjectName + "' is: " + gProjectList[lIdx].gProjectStatus);
                    System.out.print("Enter New Status (e.g., In Progress, Completed): ");
                    lScanner.nextLine();
                    String lNewStatus = lScanner.nextLine().trim();

                    if (lNewStatus.isEmpty()) {
                        System.out.println("Error: Status cannot be empty.");
                        return;
                    }

                    gProjectList[lIdx].gProjectStatus = lNewStatus;
                    System.out.println("Project status successfully updated!");
                    break;
                }
            }

            if (!lProjectFound) {
                System.out.println("Project ID not found.");
            }
        } catch (InputMismatchException lEx) {
            System.out.println("Error: Invalid Project ID. Please enter a valid number.");
            lScanner.nextLine();
        } catch (Exception lEx) {
            System.out.println("Error during project update: " + lEx.getMessage());
            lScanner.nextLine();
        }
    }

    public void reviewEmployeePerformance(Employee[] gEmployeeList, int gEmployeeCount, Scanner lScanner) {
        try {
            System.out.print("\nEnter Employee ID to evaluate performance: ");
            int lTargetEmployeeId = lScanner.nextInt();
            boolean lEmployeeFound = false;

            for (int lIdx = 0; lIdx < gEmployeeCount; lIdx++) {
                if (gEmployeeList[lIdx].gEmployeeId == lTargetEmployeeId) {
                    lEmployeeFound = true;
                    System.out.println("Reviewing Performance for: " + gEmployeeList[lIdx].gEmployeeName);

                    System.out.print("Assign Rating (1 to 5): ");
                    int lRating = lScanner.nextInt();
                    lScanner.nextLine();

                    if (lRating < 1 || lRating > 5) {
                        System.out.println("Error: Rating must be between 1 and 5.");
                        return;
                    }

                    System.out.print("Provide Performance Feedback: ");
                    String lFeedback = lScanner.nextLine().trim();

                    if (lFeedback.isEmpty()) {
                        System.out.println("Error: Feedback cannot be empty.");
                        return;
                    }

                    gEmployeeList[lIdx].gPerformanceRating = lRating;
                    gEmployeeList[lIdx].gPerformanceFeedback = lFeedback;
                    System.out.println("Performance record saved successfully!");
                    break;
                }
            }

            if (!lEmployeeFound) {
                System.out.println("Employee ID not found.");
            }
        } catch (InputMismatchException lEx) {
            System.out.println("Error: Invalid input. Please enter valid numeric values.");
            lScanner.nextLine();
        } catch (Exception lEx) {
            System.out.println("Error during performance review: " + lEx.getMessage());
            lScanner.nextLine();
        }
    }
}
