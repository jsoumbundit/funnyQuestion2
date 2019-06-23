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

import java.util.ArrayList;
import java.util.Collections;

import thailand.soumbundit.jirawat.funnyquestion.R;
import thailand.soumbundit.jirawat.funnyquestion.utility.MyConstantReport;
import thailand.soumbundit.jirawat.funnyquestion.utility.ScoreTestModel;
import thailand.soumbundit.jirawat.funnyquestion.utility.ShowScoreAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreUnitReportFragment extends Fragment {


    public PreUnitReportFragment() {
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
        createRecycleView();
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
                } else {
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
        String[] strings = myConstantReport.getReportChoiceSpinner2();
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                positionSelect = position;
                //  Log.d("16JunV1", "Position select==>" + positionSelect);
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

        final String[] stringsUnit = myConstantReport.getReportPreTest();

//        Process Read FireBase
        final ArrayList<String> languageStringArrayList = new ArrayList<>();
        final ArrayList<String> listeningStringArrayList = new ArrayList<>();
        final ArrayList<String> timeTestStringArrayList = new ArrayList<>();
        final ArrayList<String> practiceStringArrayList1 = new ArrayList<>();
        final ArrayList<String> practiceStringArrayList2 = new ArrayList<>();
        final ArrayList<String> practiceStringArrayList3 = new ArrayList<>();
        final ArrayList<String> practiceStringArrayList4 = new ArrayList<>();
        final ArrayList<String> practiceStringArrayList5 = new ArrayList<>();
        final ArrayList<String> practiceStringArrayList6 = new ArrayList<>();
        final ArrayList<String> warmUpStringArrayList = new ArrayList<>();
        final ArrayList<String> showDateStringArrayList1 = new ArrayList<>();


        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        String uidLogin = firebaseUser.getUid();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference().child("ScoreTest").child(uidLogin);

        //Block1
        final TextView textView1 = getView().findViewById(R.id.txtBlock11);
        final TextView textView2 = getView().findViewById(R.id.txtBlock12);
        //Block2
        final TextView textView3 = getView().findViewById(R.id.txtBlock21);
        final TextView textView4 = getView().findViewById(R.id.txtBlock22);
        //Block3
        final TextView textView5 = getView().findViewById(R.id.txtBlock31);
        final TextView textView6 = getView().findViewById(R.id.txtBlock32);
        //Block4
        final TextView textView7 = getView().findViewById(R.id.txtBlock41);
        final TextView textView8 = getView().findViewById(R.id.txtBlock42);
        //Block5
        final TextView textView9 = getView().findViewById(R.id.txtBlock51);
        final TextView textView10 = getView().findViewById(R.id.txtBlock52);
        //Block6
        final TextView textView11 = getView().findViewById(R.id.txtBlock61);
        final TextView textView12 = getView().findViewById(R.id.txtBlock62);


        final int[] ints = new int[]{0};

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    ScoreTestModel scoreTestModel = dataSnapshot1.getValue(ScoreTestModel.class);

                    timeTestStringArrayList.add(dataSnapshot1.getKey());

//                    Log.d("16JunV1", "Time Test ==>" + timeTestStringArrayList.get(ints[0]));

                    String[] strings = timeTestStringArrayList.get(ints[0]).split("_");
                    //****Example****
                    //timeTestStringArrayList = "PreUnit1_23-06-19_10:37"
                    // String[0] = "PreUnit1"
                    // String[1] = "23-06-19"
                    // String[2] = "10:37"
                    String s = strings[0].substring(0, strings[0].length() - 1);

                    //Check name units
                    if (s.trim().equals("PreUnit")) {
                        if (strings[0].equals("PreUnit1")) {
                            practiceStringArrayList1.add(scoreTestModel.getPractice());
                            showDateStringArrayList1.add(strings[1] + " " + strings[2]);
                        }
                    }


                    // Log.d("16JunV1", "positionSelect==>" + positionSelect);
                    ints[0] += 1;

                }//for loop
//                set Text on Top Block
                textView1.setText("Pre-test Unit1");



//                Find Max scores each groups
                if (showDateStringArrayList1.isEmpty()) {
                    textView2.setText("0.0%");
                } else {
                    textView2.setText(findMaxScore(practiceStringArrayList1) + "%");
                }
            }

            private String findMaxScore(ArrayList<String> stringArrayList) {
                ArrayList<Float> floatArrayList = new ArrayList<>();
                float v = 0.0f;
                for (String s : stringArrayList) {
                    floatArrayList.add(Float.parseFloat(s));
                }
                v = Collections.max(floatArrayList, null);
                return Float.toString(v);
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
        return inflater.inflate(R.layout.fragment_pre_unit_report, container, false);
    }

}
