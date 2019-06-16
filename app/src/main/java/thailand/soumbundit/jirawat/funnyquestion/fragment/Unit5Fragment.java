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
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import thailand.soumbundit.jirawat.funnyquestion.R;
import thailand.soumbundit.jirawat.funnyquestion.utility.MyConstant;
import thailand.soumbundit.jirawat.funnyquestion.utility.MyConstantUnit5;
import thailand.soumbundit.jirawat.funnyquestion.utility.ScoreTestModel;


public class Unit5Fragment extends Fragment {

    private MyConstant myConstant = new MyConstant();
    private MyConstantUnit5 myConstantUnit5 = new MyConstantUnit5();
    private MediaPlayer mediaPlayer1;
    private String uidString, nameUnitString, timeTestString, warmUpString, practiseString, listeningString, languageString;
    private String tag = "11NovV1";
    private String tag2 = "11NovV2";
    private int[] scoreListeningSpinner = new int[]{0, 0, 0, 0};


    public static Unit5Fragment unit5Instance(String uidString) {
        Unit5Fragment unit5Fragment = new Unit5Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("Uid", uidString);
        unit5Fragment.setArguments(bundle);
        return unit5Fragment;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        findUidNameUnit();

        playMedia1();
        choiceSpinnerListen1();
        choiceSpinnerListen2();
        choiceSpinnerListen3();
        choiceSpinnerListen4();


        checkFloating();
    }

    private void playMedia1() {
        mediaPlayer1 = MediaPlayer.create(Unit5Fragment.this.getActivity(), R.raw.unit5);

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
        String[] strings = new String[8];
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_action_alert);
        builder.setTitle("Summary Unit5 Score");

        strings[0] = "Warm-up section";
        strings[1] = "You got: " + warmUpString + "% of Score\n";
        strings[2] = "Practice section";
        strings[3] = "You got: " + practiseString + "% of Score\n";
        strings[4] = "Listening section";
        strings[5] = "You got: " + listeningString + "% of Score\n";
        strings[6] = "Language section";
        strings[7] = "You got: " + languageString + "% of Score\n";

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
        String dateString = "Unit5_" + strings[0] + "_" + strings[1].trim();
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
        scorePractice = calculatePractice1();
        scorePractice += calculatePractice2();
        scoreListening = calculateListening();
        scoreLanguage = calculateLanguage();

        warmUpString = calculatePercent(scoreWarmUp, 1);
        practiseString = calculatePercent(scorePractice, 16);
        listeningString = calculatePercent(scoreListening, 4);
        languageString = calculatePercent(scoreLanguage, 10);
    }

    private String calculatePercent(int score, int hiScore) {
        float calPercent;
        calPercent = (float) score * 100 / hiScore;
        BigDecimal bd = new BigDecimal(calPercent);
        BigDecimal bdSetScale = bd.setScale(1, BigDecimal.ROUND_HALF_UP);
        return bdSetScale.toString();
    }


    private int calculateLanguage() {
        int sumScore = 0;
        String[] strings = new String[10];
        String[] trueAnswerStrings = myConstantUnit5.getAnswerLanguageStrings();

        EditText editText1 = getView().findViewById(R.id.unit5EdtLanguage1);
        EditText editText2 = getView().findViewById(R.id.unit5EdtLanguage2);
        EditText editText3 = getView().findViewById(R.id.unit5EdtLanguage3);
        EditText editText4 = getView().findViewById(R.id.unit5EdtLanguage4);
        EditText editText5 = getView().findViewById(R.id.unit5EdtLanguage5);
        EditText editText6 = getView().findViewById(R.id.unit5EdtLanguage6);
        EditText editText7 = getView().findViewById(R.id.unit5EdtLanguage7);
        EditText editText8 = getView().findViewById(R.id.unit5EdtLanguage8);
        EditText editText9 = getView().findViewById(R.id.unit5EdtLanguage9);
        EditText editText10 = getView().findViewById(R.id.unit5EdtLanguage10);

        strings[0] = editText1.getText().toString().toLowerCase().trim();
        strings[1] = editText2.getText().toString().toLowerCase().trim();
        strings[2] = editText3.getText().toString().toLowerCase().trim();
        strings[3] = editText4.getText().toString().toLowerCase().trim();
        strings[4] = editText5.getText().toString().toLowerCase().trim();
        strings[5] = editText6.getText().toString().toLowerCase().trim();
        strings[6] = editText7.getText().toString().toLowerCase().trim();
        strings[7] = editText8.getText().toString().toLowerCase().trim();
        strings[8] = editText9.getText().toString().toLowerCase().trim();
        strings[9] = editText10.getText().toString().toLowerCase().trim();


        for (int i = 0; i < strings.length; i += 1) {
            if (strings[i].equals(trueAnswerStrings[i])) {
                sumScore += 1;
            }
        }

        Log.d(tag2, "sumScoreLanguage:==>" + sumScore);

        return sumScore;
    }

    private int calculateListening() {
        int sumScore = 0;
        for (int i = 0; i < scoreListeningSpinner.length; i += 1) {
            sumScore += scoreListeningSpinner[i];
        }
        Log.d(tag2, "sumScoreListening:==>" + sumScore);
        return sumScore;
    }

    private void checkChoiceSpinnerListening(int indexSpinner, int position) {
        int[] answerTrueInts = myConstantUnit5.getAnswerListeningInts();
        if (answerTrueInts[indexSpinner] == position) {
            scoreListeningSpinner[indexSpinner] = 1;
        } else {
            scoreListeningSpinner[indexSpinner] = 0;
        }

    }


    private void choiceSpinnerListen1() {
        String[] strings = myConstantUnit5.getChoiceSpinnerListening();
        Spinner spinner = getView().findViewById(R.id.unit5SpinnerListening1);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkChoiceSpinnerListening(0, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void choiceSpinnerListen2() {
        String[] strings = myConstantUnit5.getChoiceSpinnerListening();
        Spinner spinner = getView().findViewById(R.id.unit5SpinnerListening2);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkChoiceSpinnerListening(1, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void choiceSpinnerListen3() {
        String[] strings = myConstantUnit5.getChoiceSpinnerListening();
        Spinner spinner = getView().findViewById(R.id.unit5SpinnerListening3);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkChoiceSpinnerListening(2, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void choiceSpinnerListen4() {
        String[] strings = myConstantUnit5.getChoiceSpinnerListening();
        Spinner spinner = getView().findViewById(R.id.unit5SpinnerListening4);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkChoiceSpinnerListening(3, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private int calculatePractice2() {
        int sumScore = 0;
        RadioButton radioButton11 = getView().findViewById(R.id.unit5RbPractice11c);
        RadioButton radioButton12 = getView().findViewById(R.id.unit5RbPractice12c);
        RadioButton radioButton13 = getView().findViewById(R.id.unit5RbPractice13a);
        RadioButton radioButton14 = getView().findViewById(R.id.unit5RbPractice14d);
        RadioButton radioButton15 = getView().findViewById(R.id.unit5RbPractice15b);
        RadioButton radioButton16 = getView().findViewById(R.id.unit5RbPractice16a);

        if (radioButton11.isChecked()) {
            sumScore += 1;
        }
        if (radioButton12.isChecked()) {
            sumScore += 1;
        }
        if (radioButton13.isChecked()) {
            sumScore += 1;
        }
        if (radioButton14.isChecked()) {
            sumScore += 1;
        }
        if (radioButton15.isChecked()) {
            sumScore += 1;
        }
        if (radioButton16.isChecked()) {
            sumScore += 1;
        }

        Log.d(tag2, "sumScorePractice2:==>" + sumScore);
        return sumScore;

    }

    private int calculatePractice1() {
        int sumScore = 0;
        RadioButton radioButton1 = getView().findViewById(R.id.unit5RbPractice1True);
        RadioButton radioButton2 = getView().findViewById(R.id.unit5RbPractice2False);
        RadioButton radioButton3 = getView().findViewById(R.id.unit5RbPractice3True);
        RadioButton radioButton4 = getView().findViewById(R.id.unit5RbPractice4False);
        RadioButton radioButton5 = getView().findViewById(R.id.unit5RbPractice5True);
        RadioButton radioButton6 = getView().findViewById(R.id.unit5RbPractice6True);
        RadioButton radioButton7 = getView().findViewById(R.id.unit5RbPractice7False);
        RadioButton radioButton8 = getView().findViewById(R.id.unit5RbPractice8True);
        RadioButton radioButton9 = getView().findViewById(R.id.unit5RbPractice9False);
        RadioButton radioButton10 = getView().findViewById(R.id.unit5RbPractice10True);

        if (radioButton1.isChecked()) {
            sumScore += 1;
        }
        if (radioButton2.isChecked()) {
            sumScore += 1;
        }
        if (radioButton3.isChecked()) {
            sumScore += 1;
        }
        if (radioButton4.isChecked()) {
            sumScore += 1;
        }
        if (radioButton5.isChecked()) {
            sumScore += 1;
        }
        if (radioButton6.isChecked()) {
            sumScore += 1;
        }
        if (radioButton7.isChecked()) {
            sumScore += 1;
        }
        if (radioButton8.isChecked()) {
            sumScore += 1;
        }
        if (radioButton9.isChecked()) {
            sumScore += 1;
        }
        if (radioButton10.isChecked()) {
            sumScore += 1;
        }

        Log.d(tag2, "sumScorePractice1:==>" + sumScore);
        return sumScore;
    }

    private int calculateWarmUp() {
        int sumScore = 0;
        RadioButton radioButton = getView().findViewById(R.id.unit5RbWarmUp1A);
        if (radioButton.isChecked()) {
            sumScore += 1;
        }
        Log.d(tag2, "sumScoreWarmUp:==>" + sumScore);
        return sumScore;
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
        nameUnitString = strings[4];
        Log.d(tag, "nameUnitStirng ==> " + nameUnitString);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_unit5, container, false);
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        mediaPlayer1.stop();
    }


}
