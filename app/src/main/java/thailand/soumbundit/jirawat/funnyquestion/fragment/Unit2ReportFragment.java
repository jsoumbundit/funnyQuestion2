package thailand.soumbundit.jirawat.funnyquestion.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import thailand.soumbundit.jirawat.funnyquestion.R;
import thailand.soumbundit.jirawat.funnyquestion.utility.MyConstantReport;
import thailand.soumbundit.jirawat.funnyquestion.utility.ScoreTestModel;
import thailand.soumbundit.jirawat.funnyquestion.utility.ShowScoreAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Unit2ReportFragment extends Fragment {


    public Unit2ReportFragment() {
        // Required empty public constructor
    }

    private MyConstantReport myConstantReport = new MyConstantReport();

    private int positionSelect = 0;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        itemSpinner();

//        Show Name User
        showName();

        tableSlideUpDown();

    }

    private void tableSlideUpDown() {
        final LinearLayout linearLayout = getView().findViewById(R.id.tableLayout);
        final TextView textView = getView().findViewById(R.id.txtOpenTable);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (linearLayout.isShown()) {
                    linearLayout.setVisibility(View.GONE);
                    textView.setText("Show all score records");
                    textView.setTextColor(0xFFE91E63);
                }
                else{
                    linearLayout.setVisibility(View.VISIBLE);
                    textView.setText("Hide all score records");
                    textView.setTextColor(0xFF3F51B5);
                }
            }
        });
    }




    private void showName() {
        TextView textView = getView().findViewById(R.id.txtShowNameLogin);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        String name = firebaseUser.getDisplayName();
        textView.setText(name);
    }

    private void itemSpinner() {
        Spinner spinner = getView().findViewById(R.id.reportSpinner);
        String[] strings = myConstantReport.getReportChoiceSpinner();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                positionSelect = position;
                //        Create RecycleView
                createRecycleView();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void createRecycleView() {
        final RecyclerView recyclerView = getView().findViewById(R.id.recycleScoreUnit1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        final String[] stringsUnit = myConstantReport.getReportChoiceSpinner();
        String[] strings;

//        Process Read FireBase
        final ArrayList<String> languageStringArrayList = new ArrayList<>();
        final ArrayList<String> listeningStringArrayList = new ArrayList<>();
        final ArrayList<String> timeTestStringArrayList = new ArrayList<>();
        final ArrayList<String> practiceStringArrayList = new ArrayList<>();
        final ArrayList<String> warmUpStringArrayList = new ArrayList<>();
        final ArrayList<String> showDateStringArrayList = new ArrayList<>();


        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        String uidLogin = firebaseUser.getUid();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference().child("ScoreTest").child(uidLogin);

        final TextView textView1 = getView().findViewById(R.id.txtWarmUpMax);
        final TextView textView2 = getView().findViewById(R.id.txtPracticeMax);
        final TextView textView3 = getView().findViewById(R.id.txtListeningMax);
        final TextView textView4 = getView().findViewById(R.id.txtLanguageMax);

        final int[] ints = new int[]{0};



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    ScoreTestModel scoreTestModel = dataSnapshot1.getValue(ScoreTestModel.class);

                    timeTestStringArrayList.add(dataSnapshot1.getKey());

                    Log.d("16JunV1", "Time Test ==>" + timeTestStringArrayList.get(ints[0]));

                    String[] strings = timeTestStringArrayList.get(ints[0]).split("_");

                    //Check name units

                    if (strings[0].trim().equals(stringsUnit[positionSelect])) {
                        languageStringArrayList.add(scoreTestModel.getLanguage());
                        listeningStringArrayList.add(scoreTestModel.getListening());
                        practiceStringArrayList.add(scoreTestModel.getPractice());
                        warmUpStringArrayList.add(scoreTestModel.getWarmUp());
                        showDateStringArrayList.add(strings[1] + " " + strings[2]);
                        Log.d("16JunV1", "Work");
                    }

                    ints[0] += 1;

                }//for loop

//                Find Max scores each groups
                if(showDateStringArrayList.isEmpty()){
                    textView1.setText("0.0%");
                    textView2.setText("0.0%");
                    textView3.setText("0.0%");
                    textView4.setText("0.0%");
                }
                else {
                    textView1.setText(findMaxScore(warmUpStringArrayList) + "%");
                    textView2.setText(findMaxScore(practiceStringArrayList) + "%");
                    textView3.setText(findMaxScore(listeningStringArrayList) + "%");
                    textView4.setText(findMaxScore(languageStringArrayList) + "%");
                }

                ShowScoreAdapter showScoreAdapter = new ShowScoreAdapter(getActivity(),
                        languageStringArrayList, listeningStringArrayList,
                        showDateStringArrayList, practiceStringArrayList, warmUpStringArrayList);

                recyclerView.setAdapter(showScoreAdapter);

            }

            private String findMaxScore(ArrayList<String> stringArrayList) {
                ArrayList<Float> floatArrayList = new ArrayList<>();
                float v = 0.0f;
                for (String s : stringArrayList) {
                    floatArrayList.add(Float.parseFloat(s));
                }
                v = Collections.max(floatArrayList, null);
                return Float.toString(v) ;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_unit2_report, container, false);
    }

}
