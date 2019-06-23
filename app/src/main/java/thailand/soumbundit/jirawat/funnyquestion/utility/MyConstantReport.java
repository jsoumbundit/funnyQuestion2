package thailand.soumbundit.jirawat.funnyquestion.utility;

public class MyConstantReport {

    private  int positionSelect =0;

    private String[] reportChoiceSpinner = new String[]{
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



    private String[] reportPreTest = new String[]{
            "...",
            "PreUnit",
            "PostUnit"
    };


    //    Getter
    public String[] getReportChoiceSpinner() {
        return reportChoiceSpinner;
    }

    public String[] getReportChoiceSpinner2() {
        return reportChoiceSpinner2;
    }

    public String[] getReportPreTest() {
        return reportPreTest;
    }



}

