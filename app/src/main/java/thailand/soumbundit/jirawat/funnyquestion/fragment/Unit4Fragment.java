package thailand.soumbundit.jirawat.funnyquestion.fragment;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import thailand.soumbundit.jirawat.funnyquestion.R;
import thailand.soumbundit.jirawat.funnyquestion.utility.MyConstant;
import thailand.soumbundit.jirawat.funnyquestion.utility.MyConstantUnit4;
import thailand.soumbundit.jirawat.funnyquestion.utility.ScoreTestModel;

public class Unit4Fragment extends Fragment {

    private MyConstant myConstant = new MyConstant();
    private MyConstantUnit4 myConstantUnit4 = new MyConstantUnit4();
    private MediaPlayer mediaPlayer1;
    private String uidString, nameUnitString, timeTestString, warmUpString,  practiseString, listeningString,languageString;
    private String tag = "11NovV1";
    private String tag2 = "11NovV2";
    private String tag3 = "14Apr";
    private int[] scorePractice4Ints = {0, 0, 0};
    private int[] scoreListeningInts = {0, 0, 0, 0};


    public static Unit4Fragment unit4Instance(String uidString) {
        Unit4Fragment unit4Fragment = new Unit4Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("Uid", uidString);
        unit4Fragment.setArguments(bundle);
        return unit4Fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        findUidNameUnit();

        Choice1spinner();
        Choice2spinner();
        Choice3spinner();
        Choice4spinner();
        Choice5spinner();
        Choice6spinner();
        Choice7spinner();
        Choice8spinner();
        Choice9spinner();
        Choice10spinner();
        Choice11spinner();
        Choice12spinner();
        Choice13spinner();
        Choice14spinner();
        Choice15spinner();

        practice1Spinner();
        practice2Spinner();
        practice3Spinner();

        playMedia1();

        listening1Spinner();
        listening2Spinner();
        listening3Spinner();
        listening4Spinner();

        checkFloating();

    }//Main Method

    private void playMedia1() {
        mediaPlayer1 = MediaPlayer.create(Unit4Fragment.this.getActivity(), R.raw.unit4);

        final Button button1 = getView().findViewById(R.id.playMedia1);///*****
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer1.isPlaying()) {
                    mediaPlayer1.pause();
                    button1.setText("Resume");
                } else {
                    mediaPlayer1.start();
                    button1.setText("Pause");
                }
            }
        });
    }//Play Media Clip1




    public void checkFloating() {
        FloatingActionButton floatingActionButton = getView().findViewById(R.id.floatingCheck);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(tag, "You click floating");
                myAlertDialog();
            }
        });
    }

    private void myAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_action_alert);
        builder.setTitle("Warning");
        builder.setMessage("Need to check answers?");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                processCheckScore();
                myAlertDialog2();
            }
        });
        builder.show();
    }

    private void myAlertDialog2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String[]strings = new String[8];
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_action_alert);
        builder.setTitle("Summary Unit4 Score");

        strings[0] = "Warm-up section";
        strings[1] = "You got: " + warmUpString +"% of Score\n";
        strings[2] = "Practice section";
        strings[3] = "You got: " + practiseString +"% of Score\n";
        strings[4] = "Listening section";
        strings[5] = "You got: " + listeningString +"% of Score\n";
        strings[6] = "Language section";
        strings[7] = "You got: " + languageString+"% of Score\n";

        builder.setItems(strings, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        //builder.setMessage("You got: " + pretestScoreString +"/10");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sentValueToFirebase();
                dialog.dismiss();
            }
        });
        builder.show();
    }

    private void sentValueToFirebase() {

        String [] strings = timeTestString.split(" ");
        String dateString = "Unit4_" + strings[0] + "_" + strings[1].trim();
        Log.d("16JunV1", "dateString ==>" + dateString);

//      Create Childs on Firebase
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference()
                .child("ScoreTest")
                .child(uidString)
                .child(dateString);

        //Create model
        ScoreTestModel scoreTestModel = new ScoreTestModel(languageString,listeningString,nameUnitString,practiseString,warmUpString);

//        Insert data
        databaseReference.setValue(scoreTestModel).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("16JunV1", "Success Upload");
            }
        });

    }

    public void processCheckScore() {
        int scoreWarmUp, scorePractice, scoreListening, scoreLanguage, scoreReading = 0;
        findTimeTest();
        scoreWarmUp = calculateWarmUp();
        scorePractice = calculatePractise1();
        scorePractice += calculatePractise2();
        scorePractice += calculatePractise3();
        scoreListening = calculateListening();
        scoreLanguage = calculateLanguage1();
        scoreLanguage += calculateLanguage2();

        warmUpString = calculatePercent(scoreWarmUp, 1);
        practiseString = calculatePercent(scorePractice, 22);
        listeningString = calculatePercent(scoreListening, 4);
        languageString = calculatePercent(scoreLanguage, 11);
    }

    private String calculatePercent(int score, int hiScore) {
        float calPercent;
        calPercent = (float) score * 100 / hiScore;
        BigDecimal bd = new BigDecimal(calPercent);
        BigDecimal bdSetScale = bd.setScale(1, BigDecimal.ROUND_HALF_UP);
        return bdSetScale.toString();
    }


    private int calculateLanguage2() {
        int sumScoreInt = 0;
        String[]strings = new String[5];
        String[] trueAnswerString = myConstantUnit4.getLanguage2True();

        EditText editText1 = getView().findViewById(R.id.unit4EdtLanguage7);
        EditText editText2 = getView().findViewById(R.id.unit4EdtLanguage8);
        EditText editText3 = getView().findViewById(R.id.unit4EdtLanguage9);
        EditText editText4 = getView().findViewById(R.id.unit4EdtLanguage10);
        EditText editText5 = getView().findViewById(R.id.unit4EdtLanguage11);

        strings[0] =editText1.getText().toString().trim();
        strings[1] =editText2.getText().toString().trim();
        strings[2] =editText3.getText().toString().trim();
        strings[3] =editText4.getText().toString().trim();
        strings[4] =editText5.getText().toString().trim();

        for (int i = 0; i < strings.length; i += 1) {
            strings[i]=strings[i].toLowerCase();
            for (int i1 = 0; i1 < trueAnswerString.length; i1 += 1) {
                if (strings[i].equals(trueAnswerString[i1])) {
                    sumScoreInt += 1;
                }
            }//for2
        }//for1

        Log.d(tag2, "scoreLanguage2==>" + sumScoreInt);
        Log.d(tag2, strings[2] + " " + trueAnswerString[4]);
        return sumScoreInt;
    }

    private int calculateLanguage1() {
        int sumScoreInt = 0;
        String[] strings = new String[6];
        String[] trueAnswerString = myConstantUnit4.getLanguage1True();

        EditText editText1 = getView().findViewById(R.id.unit4EdtLanguage1);
        EditText editText2 = getView().findViewById(R.id.unit4EdtLanguage2);
        EditText editText3 = getView().findViewById(R.id.unit4EdtLanguage3);
        EditText editText4 = getView().findViewById(R.id.unit4EdtLanguage4);
        EditText editText5 = getView().findViewById(R.id.unit4EdtLanguage5);
        EditText editText6 = getView().findViewById(R.id.unit4EdtLanguage6);

        strings[0] = editText1.getText().toString().trim();
        strings[1] = editText2.getText().toString().trim();
        strings[2] = editText3.getText().toString().trim();
        strings[3] = editText4.getText().toString().trim();
        strings[4] = editText5.getText().toString().trim();
        strings[5] = editText6.getText().toString().trim();



        for (int i = 0; i < strings.length; i += 1) {
            strings[i]=strings[i].toLowerCase();
            for (int i1 = 0; i1 < trueAnswerString.length; i1 += 1) {
                if (strings[i].equals(trueAnswerString[i1])) {
                    sumScoreInt += 1;
                }
            }//for2
        }//for1
        Log.d(tag2,"scoreLanguage==>" + sumScoreInt);
        return sumScoreInt;
    }

    private int calculateListening() {
        int sumScore = 0;
        for (int i = 0; i < scoreListeningInts.length; i += 1) {
            sumScore += scoreListeningInts[i];
        }
        Log.d(tag2, "scoreListening:==>" + sumScore);
        return sumScore;

    }

    private int calculatePractise3() {
        int sumScoreInt = 0;
        String [] trueAnswerString = myConstantUnit4.getPractice4True2();
        String[] strings = new String[2];

        EditText editText1 = getView().findViewById(R.id.unit4EdtPractise8);
        EditText editText2 = getView().findViewById(R.id.unit4EdtPractise9);

        strings[0] = editText1.getText().toString().trim();
        strings[1] = editText2.getText().toString().trim();

        for (int i = 0; i < scorePractice4Ints.length; i += 1) {
            sumScoreInt += scorePractice4Ints[i];
        }

        for(int i=0; i<strings.length; i+=1){
            strings[i] = strings[i].toLowerCase();
            if(strings[i].equals(trueAnswerString[i])){
                sumScoreInt +=1;
            }
        }

        Log.d(tag2, "scorePractice4 ==>" + sumScoreInt);
        return sumScoreInt;
    }


    private int calculatePractise2() {
        int sumScoreInt = 0;
        RadioButton rb_answer1 = getView().findViewById(R.id.unit4RbPractise1True);
        RadioButton rb_answer2 = getView().findViewById(R.id.unit4RbPractise2True);
        RadioButton rb_answer3 = getView().findViewById(R.id.unit4RbPractise3True);
        RadioButton rb_answer4 = getView().findViewById(R.id.unit4RbPractise4True);
        RadioButton rb_answer5 = getView().findViewById(R.id.unit4RbPractise5True);
        RadioButton rb_answer6 = getView().findViewById(R.id.unit4RbPractise6True);
        RadioButton rb_answer7 = getView().findViewById(R.id.unit4RbPractise7True);
        RadioButton rb_answer8 = getView().findViewById(R.id.unit4RbPractise8True);
        RadioButton rb_answer9 = getView().findViewById(R.id.unit4RbPractise9True);
        RadioButton rb_answer10 = getView().findViewById(R.id.unit4RbPractise10True);

        if(rb_answer1.isChecked()){
            sumScoreInt += 1;
        }
        if(rb_answer2.isChecked()){
            sumScoreInt += 1;
        }
        if(rb_answer3.isChecked()){
            sumScoreInt += 1;
        }
        if(rb_answer4.isChecked()){
            sumScoreInt += 1;
        }
        if(rb_answer5.isChecked()){
            sumScoreInt += 1;
        }
        if(rb_answer6.isChecked()){
            sumScoreInt += 1;
        }
        if(rb_answer7.isChecked()){
            sumScoreInt += 1;
        }
        if(rb_answer8.isChecked()){
            sumScoreInt += 1;
        }
        if(rb_answer9.isChecked()){
            sumScoreInt += 1;
        }
        if(rb_answer10.isChecked()){
            sumScoreInt += 1;
        }

        Log.d(tag2, "scorePractice2==>" + sumScoreInt);
        return sumScoreInt;
    }

    private int calculatePractise1() {
        int sumScoreInt = 0;
        String[] strings = new String[7];
        String[] trueAnswerString = myConstantUnit4.getPractice1True();

        EditText editText1 = getView().findViewById(R.id.unit4EdtPractise1);
        EditText editText2 = getView().findViewById(R.id.unit4EdtPractise2);
        EditText editText3 = getView().findViewById(R.id.unit4EdtPractise3);
        EditText editText4 = getView().findViewById(R.id.unit4EdtPractise4);
        EditText editText5 = getView().findViewById(R.id.unit4EdtPractise5);
        EditText editText6 = getView().findViewById(R.id.unit4EdtPractise6);
        EditText editText7 = getView().findViewById(R.id.unit4EdtPractise7);

        strings[0] = editText1.getText().toString().trim();
        strings[1] = editText2.getText().toString().trim();
        strings[2] = editText3.getText().toString().trim();
        strings[3] = editText4.getText().toString().trim();
        strings[4] = editText5.getText().toString().trim();
        strings[5] = editText6.getText().toString().trim();
        strings[6] = editText7.getText().toString().trim();

        for (int i = 0; i < strings.length; i += 1) {
            strings[i] = strings[i].toLowerCase();
            if (strings[i].equals(trueAnswerString[i])) {
                sumScoreInt += 1;
            }
        }

        Log.d(tag2, "scorePractice1 ==>" + sumScoreInt);

        return sumScoreInt;
    }

    private int calculateWarmUp() {
        int sumScoreInt = 0;
        RadioButton rb_answer = getView().findViewById(R.id.unit4RbWarmUp1B);
        if (rb_answer.isChecked()) {
            sumScoreInt += 1;
        }
        Log.d(tag2, "scoreWarmUp ==>" + sumScoreInt);
        return sumScoreInt;
    }





    private void  checkScoreListening(int indexSpinner, int position) {
        int[] answerTrueInts = myConstantUnit4.getAnswerListeningInt();

        if (position == answerTrueInts[indexSpinner]) {
            scoreListeningInts[indexSpinner] = 1;
        } else {
            scoreListeningInts[indexSpinner] = 0;
        }

    }

    private  void listening1Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit4SpinnerListening1);
        String[] strings = myConstantUnit4.getChoiceSpinnerListeningStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreListening(0, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private  void listening2Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit4SpinnerListening2);
        String[] strings = myConstantUnit4.getChoiceSpinnerListeningStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreListening(1, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private  void listening3Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit4SpinnerListening3);
        String[] strings = myConstantUnit4.getChoiceSpinnerListeningStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreListening(2, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private  void listening4Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit4SpinnerListening4);
        String[] strings = myConstantUnit4.getChoiceSpinnerListeningStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreListening(3, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    private void  checkScorePractice4(int indexSpinner, int position) {
        int[] answerTrueInts = myConstantUnit4.getAnswerPractice4Int();

        if (position == answerTrueInts[indexSpinner]) {
            scorePractice4Ints[indexSpinner] = 1;
        } else {
            scorePractice4Ints[indexSpinner] = 0;
        }

    }

    private  void practice1Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit4SpinnerPractice1);
        String[] strings = myConstantUnit4.getPractice4True();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScorePractice4(0, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private  void practice2Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit4SpinnerPractice2);
        String[] strings = myConstantUnit4.getPractice4True();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScorePractice4(1, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private  void practice3Spinner() {
        Spinner spinner = getView().findViewById(R.id.unit4SpinnerPractice3);
        String[] strings = myConstantUnit4.getPractice4True();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScorePractice4(2, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }





    public void Choice1spinner() {
        Spinner spinner = getView().findViewById(R.id.choice1spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice2spinner() {
        Spinner spinner = getView().findViewById(R.id.choice2spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice3spinner() {
        Spinner spinner = getView().findViewById(R.id.choice3spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice4spinner() {
        Spinner spinner = getView().findViewById(R.id.choice4spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice5spinner() {
        Spinner spinner = getView().findViewById(R.id.choice5spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice6spinner() {
        Spinner spinner = getView().findViewById(R.id.choice6spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice7spinner() {
        Spinner spinner = getView().findViewById(R.id.choice7spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice8spinner() {
        Spinner spinner = getView().findViewById(R.id.choice8spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice9spinner() {
        Spinner spinner = getView().findViewById(R.id.choice9spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice10spinner() {
        Spinner spinner = getView().findViewById(R.id.choice10spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice11spinner() {
        Spinner spinner = getView().findViewById(R.id.choice11spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice12spinner() {
        Spinner spinner = getView().findViewById(R.id.choice12spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice13spinner() {
        Spinner spinner = getView().findViewById(R.id.choice13spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice14spinner() {
        Spinner spinner = getView().findViewById(R.id.choice14spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void Choice15spinner() {
        Spinner spinner = getView().findViewById(R.id.choice15spinner);
        String[] strings = myConstantUnit4.getChoiceSpinnerItemStrings();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
    }

    public void findTimeTest() {
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH:mm");
        timeTestString = dateFormat.format(calendar.getTime());
        Log.d(tag, "TimeTestString ==> " + timeTestString);
    }

    public void findUidNameUnit() {
        uidString = getArguments().getString("Uid");
        Log.d(tag, "uidSting ==> " + uidString);
// find UnitID, Name Unit
        String[] strings = myConstant.getUnitTitleStrings();
        nameUnitString = strings[3];
        Log.d(tag, "nameUnitStirng ==> " + nameUnitString);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_unit4, container, false);
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        mediaPlayer1.stop();
    }
}
