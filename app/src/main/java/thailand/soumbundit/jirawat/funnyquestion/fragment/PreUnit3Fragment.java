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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import thailand.soumbundit.jirawat.funnyquestion.R;
import thailand.soumbundit.jirawat.funnyquestion.utility.MyConstant;

public class PreUnit3Fragment extends Fragment {
    private MyConstant myConstant = new MyConstant();
    private String uidString, nameUnitString, timeTestString, pretestScoreString;
    private String tag = "11NovV1";
    private String tag2 = "11NovV2";

    public static PreUnit3Fragment preUnit3Fragment(String uidString) {
        PreUnit3Fragment preUnit3Fragment = new PreUnit3Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("Uid", uidString);
        preUnit3Fragment.setArguments(bundle);
        return preUnit3Fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        findTimeTest();
        findUidNameUnit();
        checkFloating();
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
        builder.setTitle("Pre-test Unit2 Score");

        strings[0] = "You got: " + pretestScoreString + "/10";
        builder.setItems(strings, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        //builder.setMessage("You got: " + pretestScoreString +"/10");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void processCheckScore() {
        int scoreInt = 0;
        scoreInt += 0;
        calculatePreTest();
        pretestScoreString = Integer.toString(scoreInt);
    }

    private void calculatePreTest() {
        int sumScore = 0;
        RadioButton radioButton1 = getView().findViewById(R.id.preunit3RbPractice1a);
        RadioButton radioButton2 = getView().findViewById(R.id.preunit3RbPractice2b);
        RadioButton radioButton3 = getView().findViewById(R.id.preunit3RbPractice3b);
        RadioButton radioButton4 = getView().findViewById(R.id.preunit3RbPractice4c);
        RadioButton radioButton5 = getView().findViewById(R.id.preunit3RbPractice5d);
        RadioButton radioButton6 = getView().findViewById(R.id.preunit3RbPractice6a);
        RadioButton radioButton7 = getView().findViewById(R.id.preunit3RbPractice7c);
        RadioButton radioButton8 = getView().findViewById(R.id.preunit3RbPractice8b);
        RadioButton radioButton9 = getView().findViewById(R.id.preunit3RbPractice9d);
        RadioButton radioButton10 = getView().findViewById(R.id.preunit3RbPractice10a);

        if (radioButton1.isChecked()) { sumScore += 1; }
        if (radioButton2.isChecked()) { sumScore += 1; }
        if (radioButton3.isChecked()) { sumScore += 1; }
        if (radioButton4.isChecked()) { sumScore += 1; }
        if (radioButton5.isChecked()) { sumScore += 1; }
        if (radioButton6.isChecked()) { sumScore += 1; }
        if (radioButton7.isChecked()) { sumScore += 1; }
        if (radioButton8.isChecked()) { sumScore += 1; }
        if (radioButton9.isChecked()) { sumScore += 1; }
        if (radioButton10.isChecked()) { sumScore += 1; }

        Log.d(tag2, "sumScorePretest==>" + sumScore);


    }

    public void findTimeTest() {
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        timeTestString = dateFormat.format(calendar.getTime());
        Log.d(tag, "TimeTestString ==> " + timeTestString);
    }

    public void findUidNameUnit() {
        uidString = getArguments().getString("Uid");
        Log.d(tag, "uidSting ==> " + uidString);
// find UnitID, Name Unit
        String[] strings = myConstant.getUnitTitleStrings();
        nameUnitString = strings[0];
        Log.d(tag, "nameUnitStirng ==> " + nameUnitString);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_preunit3, container, false);
        return view;
    }


}
