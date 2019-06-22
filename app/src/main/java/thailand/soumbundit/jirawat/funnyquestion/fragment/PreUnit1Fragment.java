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

public class PreUnit1Fragment extends Fragment {
    private MyConstant myConstant = new MyConstant();
    private ConstantPreUnit1 constantPreUnit1 = new ConstantPreUnit1();
    private String uidString, nameUnitString, timeTestString,  practiceString;
    private String tag = "11NovV1";
    private String tag2 = "11NovV2";
    private int[] spinnerAnswerInts = new int[]{0,0,0,0,0,0,0,0};

    public static PreUnit1Fragment preUnit1Instance(String uidString) {
        PreUnit1Fragment preUnit1Fragment = new PreUnit1Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("Uid", uidString);
        preUnit1Fragment.setArguments(bundle);
        return preUnit1Fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        findUidNameUnit();


        PreTest1spinnerItem();
        PreTest2spinnerItem();
        PreTest3spinnerItem();
        PreTest4spinnerItem();
        PreTest5spinnerItem();
        PreTest6spinnerItem();
        PreTest7spinnerItem();
        PreTest8spinnerItem();
        checkFloating();
    }


    private void keepAnswerSpinner(int indexSpinner, int position) {
        spinnerAnswerInts[indexSpinner] = position;
    }

    private void PreTest1spinnerItem() {
        String [] strings   = constantPreUnit1.getPreUnit1True();
        Spinner spinner = getView().findViewById(R.id.preunit1spinner1);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                 keepAnswerSpinner(0,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void PreTest2spinnerItem() {
        String [] strings   = constantPreUnit1.getPreUnit1True();
        Spinner spinner = getView().findViewById(R.id.preunit1spinner2);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                keepAnswerSpinner(1,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void PreTest3spinnerItem() {
        String [] strings   = constantPreUnit1.getPreUnit1True();
        Spinner spinner = getView().findViewById(R.id.preunit1spinner3);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                keepAnswerSpinner(2,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void PreTest4spinnerItem() {
        String [] strings   = constantPreUnit1.getPreUnit1True();
        Spinner spinner = getView().findViewById(R.id.preunit1spinner4);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                keepAnswerSpinner(3,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void PreTest5spinnerItem() {
        String [] strings   = constantPreUnit1.getPreUnit1True();
        Spinner spinner = getView().findViewById(R.id.preunit1spinner5);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                keepAnswerSpinner(4,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void PreTest6spinnerItem() {
        String [] strings   = constantPreUnit1.getPreUnit1True();
        Spinner spinner = getView().findViewById(R.id.preunit1spinner6);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                keepAnswerSpinner(5,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void PreTest7spinnerItem() {
        String [] strings   = constantPreUnit1.getPreUnit1True();
        Spinner spinner = getView().findViewById(R.id.preunit1spinner7);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                keepAnswerSpinner(6,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void PreTest8spinnerItem() {
        String [] strings   = constantPreUnit1.getPreUnit1True();
        Spinner spinner = getView().findViewById(R.id.preunit1spinner8);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                keepAnswerSpinner(7,position);
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
        final String[]strings = new String[1];
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_action_alert);
        builder.setTitle("Pre-test Unit1 Score");

        strings[0] = "You got: " + practiceString +"% of Score";
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
        String dateString = "PreUnit1_" + strings[0] + "_" + strings[1].trim();
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

        scoreInt += checkScoreChioce();
        scoreInt += checkScoreSpinner();
        scoreInt = scoreInt*10;

        practiceString = Integer.toString(scoreInt);
    }

    private int checkScoreChioce() {
        int sumScoreInt = 0;

        RadioButton radioButton1 = getView().findViewById(R.id.preunit1RdgPractice1b);
        RadioButton radioButton2 = getView().findViewById(R.id.preunit1RdgPractice2c);
        RadioButton radioButton3 = getView().findViewById(R.id.preunit1RdgPractice3a);
        RadioButton radioButton4 = getView().findViewById(R.id.preunit1RdgPractice4b);
        RadioButton radioButton5 = getView().findViewById(R.id.preunit1RdgPractice5b);
        RadioButton radioButton6 = getView().findViewById(R.id.preunit1RdgPractice6a);
        RadioButton radioButton7 = getView().findViewById(R.id.preunit1RdgPractice7d);
        RadioButton radioButton8 = getView().findViewById(R.id.preunit1RdgPractice8d);
        RadioButton radioButton9 = getView().findViewById(R.id.preunit1RdgPractice9c);

        if(radioButton1.isChecked()){ sumScoreInt += 1; }
        if(radioButton2.isChecked()){ sumScoreInt += 1; }
        if(radioButton3.isChecked()){ sumScoreInt += 1; }
        if(radioButton4.isChecked()){ sumScoreInt += 1; }
        if(radioButton5.isChecked()){ sumScoreInt += 1; }
        if(radioButton6.isChecked()){ sumScoreInt += 1; }
        if(radioButton7.isChecked()){ sumScoreInt += 1; }
        if(radioButton8.isChecked()){ sumScoreInt += 1; }
        if(radioButton9.isChecked()){ sumScoreInt += 1; }

        Log.d(tag2,"scoreChioce==>" + sumScoreInt);
        return sumScoreInt;
    }

    private int checkScoreSpinner() {
        int sumScoreInt = 0;
        int sumScore1 = spinnerAnswerInts[0]+ spinnerAnswerInts[1]+ spinnerAnswerInts[2];
        int sumScore2 = spinnerAnswerInts[3]+ spinnerAnswerInts[4];
        int sumScore3 = spinnerAnswerInts[5]+ spinnerAnswerInts[6]+ spinnerAnswerInts[7];

        if (sumScore1 == 14 && sumScore2 == 7 && sumScore3 == 15) {
            sumScoreInt = 1;
        }
        Log.d(tag2, "scoreSpinner ==>" + sumScoreInt);
        return sumScoreInt;
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
        nameUnitString = strings[6];
        Log.d(tag, "nameUnitStirng ==> " + nameUnitString);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_preunit1, container, false);
        return view;
    }

}


class ConstantPreUnit1 {
        private String[] preUnit1True = new String[]{
                ".........",
                "printer",
                "optical, e.g. DVD",
                "mouse",
                "microphone",
                "flash memory",
                "monitor",
                "keyboard",
                "hard drive"

        };

    //getter
    public String[] getPreUnit1True() {
        return preUnit1True;
    }
}