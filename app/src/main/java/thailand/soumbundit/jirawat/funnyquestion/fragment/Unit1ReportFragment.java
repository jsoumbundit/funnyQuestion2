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
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import thailand.soumbundit.jirawat.funnyquestion.R;
import thailand.soumbundit.jirawat.funnyquestion.utility.ScoreTestModel;
import thailand.soumbundit.jirawat.funnyquestion.utility.ShowScoreAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Unit1ReportFragment extends Fragment {

    private String nameUnit = "Unit1";

    public Unit1ReportFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Show Name User
        showName();

//        Create RecycleView
        createRecycleView();


    }

    private void showName() {
        TextView textView = getView().findViewById(R.id.txtShowNameLogin);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        String name = firebaseUser.getDisplayName();
        textView.setText(name);

    }

    private void createRecycleView() {
        final RecyclerView recyclerView = getView().findViewById(R.id.recycleScoreUnit1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

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

        final int[] ints = new int[]{0};

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    ScoreTestModel scoreTestModel = dataSnapshot1.getValue(ScoreTestModel.class);

                    timeTestStringArrayList.add(dataSnapshot1.getKey());

                    Log.d("16JunV1", "Time Test ==>" + timeTestStringArrayList.get(ints[0]));

                    String[] strings = timeTestStringArrayList.get(ints[0]).split("_");



                    if (strings[0].trim().equals(nameUnit)) {
                        languageStringArrayList.add(scoreTestModel.getLanguage());
                        listeningStringArrayList.add(scoreTestModel.getListening());
                        practiceStringArrayList.add(scoreTestModel.getPractice());
                        warmUpStringArrayList.add(scoreTestModel.getWarmUp());
                        showDateStringArrayList.add(strings[1] + " " + strings[2]);
                        Log.d("16JunV1", "Work");
                    }

                    ints[0] +=1;

                }//for loop

                ShowScoreAdapter showScoreAdapter = new ShowScoreAdapter(getActivity(),
                        languageStringArrayList, listeningStringArrayList,
                        showDateStringArrayList, practiceStringArrayList, warmUpStringArrayList);

                recyclerView.setAdapter(showScoreAdapter);

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
        return inflater.inflate(R.layout.fragment_unit1_report, container, false);
    }

}
