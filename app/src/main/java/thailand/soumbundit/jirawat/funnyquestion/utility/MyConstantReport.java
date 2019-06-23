package thailand.soumbundit.jirawat.funnyquestion.utility;

public class MyConstantReport {


    private String[] reportChoiceSpinner = new String[]{
            "...",
            "Unit1 Computer Users", //0
            "Unit2 Computer Architecture",
            "Unit3 Computer Applications",
            "Unit4 The Internet",
            "Unit5 Communication Systems"
    };

    private String[] reportUnitChoice = new String[]{
            "...",
            "Unit1",
            "Unit2",
            "Unit3",
            "Unit4",
            "Unit5",
    };




    private String[] reportChoiceSpinner2 = new String[]{
            "...",
            "Pre-test Unit",
            "Post-test Unit"
    };

    private String[] reportPreTestChoice = new String[]{
            "...",
            "PreUnit",
            "PostUnit"
    };


    //    Getter

    public String[] getReportUnitChoice() {
        return reportUnitChoice;
    }

    public String[] getReportChoiceSpinner() {
        return reportChoiceSpinner;
    }

    public String[] getReportChoiceSpinner2() {
        return reportChoiceSpinner2;
    }

    public String[] getReportPreTestChoice() {
        return reportPreTestChoice;
    }



}

