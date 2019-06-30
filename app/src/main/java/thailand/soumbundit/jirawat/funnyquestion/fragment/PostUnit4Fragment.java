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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import thailand.soumbundit.jirawat.funnyquestion.R;
import thailand.soumbundit.jirawat.funnyquestion.utility.MyConstant;
import thailand.soumbundit.jirawat.funnyquestion.utility.ScoreTestModel;


public class PostUnit4Fragment extends Fragment {
    private MyConstant myConstant = new MyConstant();
    private ConstantPostUnit4 constantPostUnit4 = new ConstantPostUnit4();
    private String uidString, nameUnitString, timeTestString, postTestScoreString,practiceString;
    private String tag = "11NovV1";
    private String tag2 = "11NovV2";
    private int[] spinnerAnswerInts = new int[]{0,0,0};

    public static PostUnit4Fragment postUnit4Instance(String uidString) {
        PostUnit4Fragment postUnit4Fragment = new PostUnit4Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("Uid", uidString);
        postUnit4Fragment.setArguments(bundle);
        return postUnit4Fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        findUidNameUnit();


        PretestUnit4Spinner1();
        PretestUnit4Spinner2();
        PretestUnit4Spinner3();

        checkFloating();
    }


    private void keepAnswerSpinner(int indexSpinner, int position) {
        int [] trueAnswerInts = constantPostUnit4.getPostUnit4Answer();
        if (trueAnswerInts[indexSpinner] == position) {
            spinnerAnswerInts[indexSpinner] = 1;
        }
        else{
            spinnerAnswerInts[indexSpinner] = 0;
        }
    }


    private void PretestUnit4Spinner1() {
        String[] strings = constantPostUnit4.getPostUnit4True();
        Spinner spinner = getView().findViewById(R.id.preunit4Choice1spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long ld) {
                keepAnswerSpinner(0,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void PretestUnit4Spinner2() {
        String[] strings = constantPostUnit4.getPostUnit4True();
        Spinner spinner = getView().findViewById(R.id.preunit4Choice2spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long ld) {
                keepAnswerSpinner(1,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void PretestUnit4Spinner3() {
        String[] strings = constantPostUnit4.getPostUnit4True();
        Spinner spinner = getView().findViewById(R.id.preunit4Choice3spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long ld) {
                keepAnswerSpinner(2,position);
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
        builder.setTitle("Post-test Unit4 Score");

        strings[0] = "You got: " + practiceString+ "% of Score";
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
        String dateString = "PostUnit4_" + strings[0] + "_" + strings[1].trim();
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

        scoreInt += checkScoreChoice();
        scoreInt += checkScoreSpinner();

        scoreInt = scoreInt*10;

        practiceString = Integer.toString(scoreInt);
    }

    private int checkScoreSpinner() {
        int sumScore = 0;
        for (int i = 0; i < spinnerAnswerInts.length; i += 1) {
            sumScore += spinnerAnswerInts[i];
        }
        Log.d(tag2, "sumScoreSpinner==>" + sumScore);
        return sumScore;
    }

    private int checkScoreChoice() {
        int sumScore = 0;
        RadioButton radioButton1 = getView().findViewById(R.id.preunit4RbPractice1b);
        RadioButton radioButton2 = getView().findViewById(R.id.preunit4RbPractice2b);
        RadioButton radioButton3 = getView().findViewById(R.id.preunit4RbPractice3b);
        RadioButton radioButton4 = getView().findViewById(R.id.preunit4RbPractice4a);
        RadioButton radioButton5 = getView().findViewById(R.id.preunit4RbPractice5a);
        RadioButton radioButton6 = getView().findViewById(R.id.preunit4RbPractice6b);
        RadioButton radioButton7 = getView().findViewById(R.id.preunit4RbPractice7b);

        if (radioButton1.isChecked()) { sumScore += 1;}
        if (radioButton2.isChecked()) { sumScore += 1;}
        if (radioButton3.isChecked()) { sumScore += 1;}
        if (radioButton4.isChecked()) { sumScore += 1;}
        if (radioButton5.isChecked()) { sumScore += 1;}
        if (radioButton6.isChecked()) { sumScore += 1;}
        if (radioButton7.isChecked()) { sumScore += 1;}

        Log.d(tag2, "sumScoreChioce==>" + sumScore);
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
        nameUnitString = strings[15];
        Log.d(tag, "nameUnitStirng ==> " + nameUnitString);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_postunit4, container, false);
        return view;
    }





}

class ConstantPostUnit4 {
    private String[] postUnit4True = new String[]{
            ".........",
            "a",
            "b",
            "c",
            "d",
            "e"

    };

    private int[] postUnit4Answer = new int[]{5,1,4 };

    //getter
    public int[] getPostUnit4Answer() {
        return postUnit4Answer;
    }
    public String[] getPostUnit4True() {
        return postUnit4True;
    }

}