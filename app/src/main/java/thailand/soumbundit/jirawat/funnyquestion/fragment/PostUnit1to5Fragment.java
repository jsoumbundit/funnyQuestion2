package thailand.soumbundit.jirawat.funnyquestion.fragment;

import android.content.DialogInterface;
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
import thailand.soumbundit.jirawat.funnyquestion.utility.ScoreTestModel;

public class PostUnit1to5Fragment extends Fragment {
    private MyConstant myConstant = new MyConstant();
    private ConstantPostUnit1to5 constantPreUnit1to5 = new ConstantPostUnit1to5();
    private String uidString, nameUnitString, timeTestString, postTestScoreString,practiceString;
    private String tag = "11NovV1";
    private String tag2 = "11NovV2";
    private int[] scorePracticeSpinner = new int[]{0,0,0,0,0,0,0,0,0};
    public static PostUnit1to5Fragment postUnit1to5Instance(String uidString) {
        PostUnit1to5Fragment postUnit1to5Fragment = new PostUnit1to5Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("Uid", uidString);
        postUnit1to5Fragment.setArguments(bundle);
        return postUnit1to5Fragment;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        findUidNameUnit();

        practiceSpinner1();
        practiceSpinner2();
        practiceSpinner3();
        practiceSpinner4();
        practiceSpinner5();
        practiceSpinner6();
        practiceSpinner7();
        practiceSpinner8();
        practiceSpinner9();


        checkFloating();
    }

    private void checkScoreSpinner(int indexSpinner, int position) {
        int[] trueAnswerInts = constantPreUnit1to5.getPostUnit1to5Ans();
        if (trueAnswerInts[indexSpinner] == position) {
            scorePracticeSpinner[indexSpinner] = 1;
        } else {
            scorePracticeSpinner[indexSpinner] = 0;
        }
    }

    private void practiceSpinner1() {
        Spinner spinner = getView().findViewById(R.id.preUnit1to5Spinner32);
        String[] strings = constantPreUnit1to5.getPostUnit1to5True();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreSpinner(0,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void practiceSpinner2() {
        Spinner spinner = getView().findViewById(R.id.preUnit1to5Spinner33);
        String[] strings = constantPreUnit1to5.getPostUnit1to5True();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreSpinner(1,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void practiceSpinner3() {
        Spinner spinner = getView().findViewById(R.id.preUnit1to5Spinner34);
        String[] strings = constantPreUnit1to5.getPostUnit1to5True();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreSpinner(2,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void practiceSpinner4() {
        Spinner spinner = getView().findViewById(R.id.preUnit1to5Spinner35);
        String[] strings = constantPreUnit1to5.getPostUnit1to5True();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreSpinner(3,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void practiceSpinner5() {
        Spinner spinner = getView().findViewById(R.id.preUnit1to5Spinner36);
        String[] strings = constantPreUnit1to5.getPostUnit1to5True();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreSpinner(4,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void practiceSpinner6() {
        Spinner spinner = getView().findViewById(R.id.preUnit1to5Spinner37);
        String[] strings = constantPreUnit1to5.getPostUnit1to5True();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreSpinner(5,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void practiceSpinner7() {
        Spinner spinner = getView().findViewById(R.id.preUnit1to5Spinner38);
        String[] strings = constantPreUnit1to5.getPostUnit1to5True();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreSpinner(6,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void practiceSpinner8() {
        Spinner spinner = getView().findViewById(R.id.preUnit1to5Spinner39);
        String[] strings = constantPreUnit1to5.getPostUnit1to5True();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreSpinner(7,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void practiceSpinner9() {
        Spinner spinner = getView().findViewById(R.id.preUnit1to5Spinner40);
        String[] strings = constantPreUnit1to5.getPostUnit1to5True();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreSpinner(8,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


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
        String[] strings = new String[1];
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_action_alert);
        builder.setTitle("Post-test Unit1-5 Score");

        strings[0] = "You got: " + practiceString + "% of Score";
        builder.setItems(strings, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        //builder.setMessage("You got: " + postTestScoreString +"/10");

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
        String dateString = "PostUnit1to5_" + strings[0] + "_" + strings[1].trim();
        Log.d("16JunV1", "dateString ==>" + dateString);

//      Create Childs on Firebase
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference()
                .child("ScoreTest")
                .child(uidString)
                .child(dateString);

        //Create model
        ScoreTestModel scoreTestModel = new ScoreTestModel(nameUnitString, practiceString);

//        Insert data
        databaseReference.setValue(scoreTestModel).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("16JunV1", "Success Upload");
            }
        });

    }

    public void processCheckScore() {
        int scoreInt = 0;

        findTimeTest();

        scoreInt +=  calculatePractice1();
        scoreInt += calculatePractice2();

        practiceString = calculatePercent(scoreInt,60);
    }

    private String calculatePercent(int score, int hiScore) {
        float calPercent;
        calPercent = (float) score * 100 / hiScore;
        BigDecimal bd = new BigDecimal(calPercent);
        BigDecimal bdSetScale = bd.setScale(1, BigDecimal.ROUND_HALF_UP);
        return bdSetScale.toString();
    }

    private int calculatePractice2() {
        int sumScore = 0;
        for (int i = 0; i < scorePracticeSpinner.length; i += 1) {
            sumScore += scorePracticeSpinner[i];
        }
        return sumScore;
    }

    private int calculatePractice1() {
        int sumScore = 0;

        RadioButton radioButton1 = getView().findViewById(R.id.preUnit1to5Rb1b);
        RadioButton radioButton2 = getView().findViewById(R.id.preUnit1to5Rb2c);
        RadioButton radioButton3 = getView().findViewById(R.id.preUnit1to5Rb3d);
        RadioButton radioButton4 = getView().findViewById(R.id.preUnit1to5Rb4a);
        RadioButton radioButton5 = getView().findViewById(R.id.preUnit1to5Rb5c);
        RadioButton radioButton6 = getView().findViewById(R.id.preUnit1to5Rb6b);
        RadioButton radioButton7 = getView().findViewById(R.id.preUnit1to5Rb7c);
        RadioButton radioButton8 = getView().findViewById(R.id.preUnit1to5Rb8a);
        RadioButton radioButton9 = getView().findViewById(R.id.preUnit1to5Rb9b);
        RadioButton radioButton10 = getView().findViewById(R.id.preUnit1to5Rb10a);

        RadioButton radioButton11 = getView().findViewById(R.id.preUnit1to5Rb11a);
        RadioButton radioButton12 = getView().findViewById(R.id.preUnit1to5Rb12b);
        RadioButton radioButton13 = getView().findViewById(R.id.preUnit1to5Rb13b);
        RadioButton radioButton14 = getView().findViewById(R.id.preUnit1to5Rb14a);
        RadioButton radioButton15 = getView().findViewById(R.id.preUnit1to5Rb15d);
        RadioButton radioButton16 = getView().findViewById(R.id.preUnit1to5Rb16d);
        RadioButton radioButton17 = getView().findViewById(R.id.preUnit1to5Rb17c);
        RadioButton radioButton18 = getView().findViewById(R.id.preUnit1to5Rb18a);
        RadioButton radioButton19 = getView().findViewById(R.id.preUnit1to5Rb19b);
        RadioButton radioButton20 = getView().findViewById(R.id.preUnit1to5Rb20c);

        RadioButton radioButton21 = getView().findViewById(R.id.preUnit1to5Rb21a);
        RadioButton radioButton22 = getView().findViewById(R.id.preUnit1to5Rb22b);
        RadioButton radioButton23 = getView().findViewById(R.id.preUnit1to5Rb23a);
        RadioButton radioButton24 = getView().findViewById(R.id.preUnit1to5Rb24b);
        RadioButton radioButton25 = getView().findViewById(R.id.preUnit1to5Rb25a);
        RadioButton radioButton26 = getView().findViewById(R.id.preUnit1to5Rb26d);
        RadioButton radioButton27 = getView().findViewById(R.id.preUnit1to5Rb27c);
        RadioButton radioButton28 = getView().findViewById(R.id.preUnit1to5Rb28b);
        RadioButton radioButton29 = getView().findViewById(R.id.preUnit1to5Rb29d);
        RadioButton radioButton30 = getView().findViewById(R.id.preUnit1to5Rb30b);

        RadioButton radioButton31 = getView().findViewById(R.id.preUnit1to5Rb31a);

        RadioButton radioButton41 = getView().findViewById(R.id.preUnit1to5Rb41a);
        RadioButton radioButton42 = getView().findViewById(R.id.preUnit1to5Rb42b);
        RadioButton radioButton43 = getView().findViewById(R.id.preUnit1to5Rb43a);
        RadioButton radioButton44 = getView().findViewById(R.id.preUnit1to5Rb44b);
        RadioButton radioButton45 = getView().findViewById(R.id.preUnit1to5Rb45d);
        RadioButton radioButton46 = getView().findViewById(R.id.preUnit1to5Rb46c);
        RadioButton radioButton47 = getView().findViewById(R.id.preUnit1to5Rb47d);
        RadioButton radioButton48 = getView().findViewById(R.id.preUnit1to5Rb48a);
        RadioButton radioButton49 = getView().findViewById(R.id.preUnit1to5Rb49c);
        RadioButton radioButton50 = getView().findViewById(R.id.preUnit1to5Rb50b);

        RadioButton radioButton51 = getView().findViewById(R.id.preUnit1to5Rb51d);
        RadioButton radioButton52 = getView().findViewById(R.id.preUnit1to5Rb52c);
        RadioButton radioButton53 = getView().findViewById(R.id.preUnit1to5Rb53b);
        RadioButton radioButton54 = getView().findViewById(R.id.preUnit1to5Rb54b);
        RadioButton radioButton55 = getView().findViewById(R.id.preUnit1to5Rb55b);
        RadioButton radioButton56 = getView().findViewById(R.id.preUnit1to5Rb56a);
        RadioButton radioButton57 = getView().findViewById(R.id.preUnit1to5Rb57a);
        RadioButton radioButton58 = getView().findViewById(R.id.preUnit1to5Rb58b);
        RadioButton radioButton59 = getView().findViewById(R.id.preUnit1to5Rb59b);
        RadioButton radioButton60 = getView().findViewById(R.id.preUnit1to5Rb60c);

        if (radioButton1.isChecked()) { sumScore +=1; }
        if (radioButton2.isChecked()) { sumScore +=1; }
        if (radioButton3.isChecked()) { sumScore +=1; }
        if (radioButton4.isChecked()) { sumScore +=1; }
        if (radioButton5.isChecked()) { sumScore +=1; }
        if (radioButton6.isChecked()) { sumScore +=1; }
        if (radioButton7.isChecked()) { sumScore +=1; }
        if (radioButton8.isChecked()) { sumScore +=1; }
        if (radioButton9.isChecked()) { sumScore +=1; }
        if (radioButton10.isChecked()) { sumScore +=1; }

        if (radioButton11.isChecked()) { sumScore +=1; }
        if (radioButton12.isChecked()) { sumScore +=1; }
        if (radioButton13.isChecked()) { sumScore +=1; }
        if (radioButton14.isChecked()) { sumScore +=1; }
        if (radioButton15.isChecked()) { sumScore +=1; }
        if (radioButton16.isChecked()) { sumScore +=1; }
        if (radioButton17.isChecked()) { sumScore +=1; }
        if (radioButton18.isChecked()) { sumScore +=1; }
        if (radioButton19.isChecked()) { sumScore +=1; }
        if (radioButton20.isChecked()) { sumScore +=1; }

        if (radioButton21.isChecked()) { sumScore +=1; }
        if (radioButton22.isChecked()) { sumScore +=1; }
        if (radioButton23.isChecked()) { sumScore +=1; }
        if (radioButton24.isChecked()) { sumScore +=1; }
        if (radioButton25.isChecked()) { sumScore +=1; }
        if (radioButton26.isChecked()) { sumScore +=1; }
        if (radioButton27.isChecked()) { sumScore +=1; }
        if (radioButton28.isChecked()) { sumScore +=1; }
        if (radioButton29.isChecked()) { sumScore +=1; }
        if (radioButton30.isChecked()) { sumScore +=1; }

        if (radioButton31.isChecked()) { sumScore +=1; }

        if (radioButton41.isChecked()) { sumScore +=1; }
        if (radioButton42.isChecked()) { sumScore +=1; }
        if (radioButton43.isChecked()) { sumScore +=1; }
        if (radioButton44.isChecked()) { sumScore +=1; }
        if (radioButton45.isChecked()) { sumScore +=1; }
        if (radioButton46.isChecked()) { sumScore +=1; }
        if (radioButton47.isChecked()) { sumScore +=1; }
        if (radioButton48.isChecked()) { sumScore +=1; }
        if (radioButton49.isChecked()) { sumScore +=1; }
        if (radioButton50.isChecked()) { sumScore +=1; }

        if (radioButton51.isChecked()) { sumScore +=1; }
        if (radioButton52.isChecked()) { sumScore +=1; }
        if (radioButton53.isChecked()) { sumScore +=1; }
        if (radioButton54.isChecked()) { sumScore +=1; }
        if (radioButton55.isChecked()) { sumScore +=1; }
        if (radioButton56.isChecked()) { sumScore +=1; }
        if (radioButton57.isChecked()) { sumScore +=1; }
        if (radioButton58.isChecked()) { sumScore +=1; }
        if (radioButton59.isChecked()) { sumScore +=1; }
        if (radioButton60.isChecked()) { sumScore +=1; }

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
        nameUnitString = strings[17];
        Log.d(tag, "nameUnitStirng ==> " + nameUnitString);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_postunit1to5, container, false);
        return view;

    }
}

class ConstantPostUnit1to5 {
    private String[] postUnit1to5True = new String[]{
            ".........",
            "a. CD Rom",
            "b. printer",
            "c. headset",
            "d. tower",
            "e. monitor",
            "f. keyboard",
            "g. mouse",
            "h. speakers",
            "i. scanner"
    };

    private  int[] postUnit1to5Ans = new int[]{4,5,8,2,9,7,6,1,3};

    //getter
    public String[] getPostUnit1to5True() {
        return postUnit1to5True;
    }
    public int[] getPostUnit1to5Ans() {
        return postUnit1to5Ans;
    }
}