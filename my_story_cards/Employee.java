package my_story_cards;

public class Employee {
    public int gEmployeeId;
    public String gEmployeeName;
    public String gSkills; 
    public int gPerformanceRating; 
    public String gPerformanceFeedback;

    public Employee(int lEmployeeId, String lEmployeeName, String lSkills) {
        this.gEmployeeId = lEmployeeId;
        this.gEmployeeName = lEmployeeName;
        this.gSkills = lSkills;
        this.gPerformanceRating = 0; 
        this.gPerformanceFeedback = "No feedback provided yet.";
    }
}
