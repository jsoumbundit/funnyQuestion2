package thailand.soumbundit.jirawat.funnyquestion.utility;

public class MyConstantUnit3 {


    //    #########################################################################
//   About Unit3
//    #########################################################################
//    Practice
    private String[] practiceChioceSpinner1 = new String[]{
            "........",
            "Graphics and multimedia software",
            "Home, personal, and educational software",
            "Open source software",
            "Packaged software",
            "Communication software",
            "Business software",
            "Public-domain software"
    };


    private String[] practiceChoiceSpinner2 = new String[]{
            "........",
            "Data base",
            "Blogging",
            "Web Page Authoring",
            "Tax Preparation",
            "Chat room",
            "E-mail",
            "Accounting",
            "Video and Audio Editing",
            "Photo Editing",
            "Paint/ Image Editing",
            "Document Management",
            "Entertainment",
            "Newsgroup/ Message Board",
            "Personal Information Manager(PIM)",
            "Video Conferencing",
            "Project management",
            "Multimedia Authoring",
            "Web Browser",
            "Legal",
            "Computer Aided Design",
            "Personal Finance",
            "Note Taking",
            "Home Design/ landscaping",
            "Software Suite"
    };



    private String[] listeningChoiceSpinner1 = new String[]{
            ".......",
            "First,",
            "Next,",
            "After that,",
            "Finally,"
    };


    //    #########################################################################
//   Key answer Unit2
//    #########################################################################
//    Warm Up
    private String[] answerWarmUpString = new String[]{
            "business",
            "graphicsandmultimedia",  //"graphics and multimedia"
            "home/personal/education",
            "homepersonaleducation", //home personal education
            "communications"
    };
    //  Practice
    private int[] answerPractice1Ints = new int[]{1, 2, 5, 6};

    private int[] answerPractice2Ints = new int[]{1, 7, 11, 14, 16, 22};
    private int[] answerPractice3Ints = new int[]{3, 8, 9, 10, 17, 20};
    private int[] answerPractice4ints = new int[]{4, 12, 19, 21, 23, 24};
    private int[] answerPractice5ints = new int[]{2, 5, 6, 13, 15, 18};

    // listening
    private int[] answerListening1Ints = new int[]{4,2,1,3};


// getter

    public int[] getAnswerListening1Ints() {
        return answerListening1Ints;
    }

    public String[] getListeningChoiceSpinner1() {
        return listeningChoiceSpinner1;
    }

    public int[] getAnswerPractice5ints() {
        return answerPractice5ints;
    }

    public int[] getAnswerPractice4ints() {
        return answerPractice4ints;
    }

    public int[] getAnswerPractice3Ints() {
        return answerPractice3Ints;
    }

    public int[] getAnswerPractice2Ints() {
        return answerPractice2Ints;
    }

    public String[] getPracticeChoiceSpinner2() {
        return practiceChoiceSpinner2;
    }

    public int[] getAnswerPractice1Ints() {
        return answerPractice1Ints;
    }

    public String[] getPracticeChioceSpinner1() {
        return practiceChioceSpinner1;
    }

    public String[] getAnswerWarmUpString() {
        return answerWarmUpString;
    }

}
