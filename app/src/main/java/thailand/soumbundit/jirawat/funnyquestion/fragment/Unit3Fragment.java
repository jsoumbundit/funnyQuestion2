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
import java.sql.Ref;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import thailand.soumbundit.jirawat.funnyquestion.R;
import thailand.soumbundit.jirawat.funnyquestion.utility.MyConstant;
import thailand.soumbundit.jirawat.funnyquestion.utility.MyConstantUnit3;
import thailand.soumbundit.jirawat.funnyquestion.utility.ScoreTestModel;

public class Unit3Fragment extends Fragment {
    MyConstant myConstant = new MyConstant();
    MyConstantUnit3 myConstantUnit3 = new MyConstantUnit3();
    private MediaPlayer mediaPlayer1;
    private String uidString, nameUnitString, timeTestString, warmUpString, practiseString, listeningString, languageString;
    Integer[] positionPractice1Ints = {0, 0, 0, 0};
    Integer[] positionPractice2Ints = {0, 0, 0, 0, 0, 0};
    Integer[] positionPractice3Ints = {0, 0, 0, 0, 0, 0};
    Integer[] positionPractice4Ints = {0, 0, 0, 0, 0, 0};
    Integer[] positionPractice5Ints = {0, 0, 0, 0, 0, 0};
    int[] scoreListening1Ints = {0, 0, 0, 0};


    private String tag = "11NovV1";
    private String tag2 = "11NovV2";

    public static Unit3Fragment unit3Instance(String uidString) {
        Unit3Fragment unit3Fragment = new Unit3Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("Uid", uidString);
        unit3Fragment.setArguments(bundle);
        return unit3Fragment;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        findUidNameUnit();


        choiceSpinnerPractice1();
        choiceSpinnerPractice2();
        choiceSpinnerPractice3();
        choiceSpinnerPractice4();

        choiceSpinnerPractice5();
        choiceSpinnerPractice6();
        choiceSpinnerPractice7();
        choiceSpinnerPractice8();
        choiceSpinnerPractice9();
        //choiceSpinnerPractice10();

        choiceSpinnerPractice11();
        choiceSpinnerPractice12();
        choiceSpinnerPractice13();
        choiceSpinnerPractice14();
        choiceSpinnerPractice15();
        //choiceSpinnerPractice16();

        choiceSpinnerPractice17();
        choiceSpinnerPractice18();
        choiceSpinnerPractice19();
        choiceSpinnerPractice20();
        choiceSpinnerPractice21();
        //choiceSpinnerPractice22();

        choiceSpinnerPractice23();
        choiceSpinnerPractice24();
        choiceSpinnerPractice25();
        choiceSpinnerPractice26();
        choiceSpinnerPractice27();
        //choiceSpinnerPractice28();

        choiceSpinnerListening1();
        choiceSpinnerListening2();
        choiceSpinnerListening3();
        choiceSpinnerListening4();

        playMedia1();

        checkFloating();

    }//Main Method


    private void playMedia1() {
        mediaPlayer1 = MediaPlayer.create(Unit3Fragment.this.getActivity(), R.raw.unit3);

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

    public void checkScoreListening1(int indexSpinner, int position) {
        int[] answerListening1Ints = myConstantUnit3.getAnswerListening1Ints();
        if (position == answerListening1Ints[indexSpinner]) {
            scoreListening1Ints[indexSpinner] = 1;
        } else {
            scoreListening1Ints[indexSpinner] = 0;
        }

    }

    public void choiceSpinnerListening1() {
        String[] strings = myConstantUnit3.getListeningChoiceSpinner1();
        Spinner spinner = getView().findViewById(R.id.unit3SpinListening1);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreListening1(0, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void choiceSpinnerListening2() {
        String[] strings = myConstantUnit3.getListeningChoiceSpinner1();
        Spinner spinner = getView().findViewById(R.id.unit3SpinListening2);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreListening1(1, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void choiceSpinnerListening3() {
        String[] strings = myConstantUnit3.getListeningChoiceSpinner1();
        Spinner spinner = getView().findViewById(R.id.unit3SpinListening3);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreListening1(2, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void choiceSpinnerListening4() {
        String[] strings = myConstantUnit3.getListeningChoiceSpinner1();
        Spinner spinner = getView().findViewById(R.id.unit3SpinListening4);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                checkScoreListening1(3, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public void getPositionPractice5(int indexSpinner, int position) {
        positionPractice5Ints[indexSpinner] = position;
    }

    public void choiceSpinnerPractice23() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice23);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice5(0, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void choiceSpinnerPractice24() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice24);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice5(1, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void choiceSpinnerPractice25() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice25);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice5(2, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void choiceSpinnerPractice26() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice26);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice5(3, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void choiceSpinnerPractice27() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice27);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice5(4, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
/*
    public  void  choiceSpinnerPractice28() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice28);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice5(5,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }*/

    public void getPositionPractice4(int indexSpinner, int position) {
        positionPractice4Ints[indexSpinner] = position;
    }

    public void choiceSpinnerPractice17() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice17);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice4(0, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void choiceSpinnerPractice18() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice18);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice4(1, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void choiceSpinnerPractice19() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice19);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice4(2, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void choiceSpinnerPractice20() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice20);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice4(3, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void choiceSpinnerPractice21() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice21);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice4(4, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    /*
        public  void  choiceSpinnerPractice22() {
            String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
            Spinner spinner = getView().findViewById(R.id.unit3SpinPractice22);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
            spinner.setAdapter(arrayAdapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                    getPositionPractice4(5,position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

        }
    */
    public void getPositionPractice3(int indexSpinner, int position) {
        positionPractice3Ints[indexSpinner] = position;
    }

    public void choiceSpinnerPractice11() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice11);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice3(0, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void choiceSpinnerPractice12() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice12);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice3(1, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void choiceSpinnerPractice13() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice13);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice3(2, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void choiceSpinnerPractice14() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice14);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice3(3, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void choiceSpinnerPractice15() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice15);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice3(4, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    /*
    public  void  choiceSpinnerPractice16() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice16);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice3(5,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    */
    public void getPositionPractice2(int indexSpinner, int position) {
        positionPractice2Ints[indexSpinner] = position;
    }

    public void choiceSpinnerPractice5() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice5);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice2(0, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void choiceSpinnerPractice6() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice6);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice2(1, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void choiceSpinnerPractice7() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice7);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice2(2, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void choiceSpinnerPractice8() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice8);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice2(3, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void choiceSpinnerPractice9() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice9);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice2(4, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

   /*
    public void choiceSpinnerPractice10() {
        String[] strings = myConstantUnit3.getPracticeChoiceSpinner2();
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice10);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice2(5,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    */

    public void getPositionPractice1(int indexSpinner, int position) {
        positionPractice1Ints[indexSpinner] = position;
        // Log.d(tag2, "positionPractice1Ints[" + indexSpinner + "] = " + position);
    }

    public void choiceSpinnerPractice1() {
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice1);
        String[] strings = myConstantUnit3.getPracticeChioceSpinner1();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice1(0, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void choiceSpinnerPractice2() {
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice2);
        String[] strings = myConstantUnit3.getPracticeChioceSpinner1();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice1(1, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void choiceSpinnerPractice3() {
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice3);
        String[] strings = myConstantUnit3.getPracticeChioceSpinner1();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice1(2, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void choiceSpinnerPractice4() {
        Spinner spinner = getView().findViewById(R.id.unit3SpinPractice4);
        String[] strings = myConstantUnit3.getPracticeChioceSpinner1();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getPositionPractice1(3, position);
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
        String[] strings = new String[8];
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_action_alert);
        builder.setTitle("Summary Unit3 Score");

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
        String dateString = "Unit3_" + strings[0] + "_" + strings[1].trim();
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
        int scoreWarmUp = 0, scorePractice = 0, scoreListening = 0, scoreLanguage = 0;


        findTimeTest();
        scoreWarmUp = calculateWarmUp();

        scorePractice = calculatePractice1();

        scorePractice += calculatePractice2();
        scorePractice += calculatePractice3();
        scorePractice += calculatePractice4();
        scorePractice += calculatePractice5();

        scorePractice += calculatePractice6();

        scorePractice += calculatePractice7();

        scoreListening = calculateListening1();

        scoreLanguage = calculateLanguage();

        warmUpString = calculatePercent(scoreWarmUp, 4);
        practiseString = calculatePercent(scorePractice, 36);
        listeningString = calculatePercent(scoreListening, 4);
        languageString = calculatePercent(scoreLanguage, 20);

    }

    private String calculatePercent(int score, int hiScore) {
        float calPercent;
        calPercent = (float) score * 100 / hiScore;
        BigDecimal bd = new BigDecimal(calPercent);
        BigDecimal bdSetScale = bd.setScale(1, BigDecimal.ROUND_HALF_UP);
        return bdSetScale.toString();
    }


    private int checkAnswerCalculateLanguage(String strEditText, String[] answerStrings) {
        int score = 0;
        for (int i = 0; i < answerStrings.length; i += 1) {
            if (strEditText.equals(answerStrings[i])) {
                score += 1;
            }
        }
        return score;
    }


    private int calculateLanguage() {
        int sumScore = 0;
        String[] strings = new String[20];


        EditText editText1 = getView().findViewById(R.id.unit3EdtPractice1);
        EditText editText2 = getView().findViewById(R.id.unit3EdtPractice2);
        EditText editText3 = getView().findViewById(R.id.unit3EdtPractice3);
        EditText editText4 = getView().findViewById(R.id.unit3EdtPractice4);
        EditText editText5 = getView().findViewById(R.id.unit3EdtPractice5);
        EditText editText6 = getView().findViewById(R.id.unit3EdtPractice6);
        EditText editText7 = getView().findViewById(R.id.unit3EdtPractice7);
        EditText editText8 = getView().findViewById(R.id.unit3EdtPractice8);
        EditText editText9 = getView().findViewById(R.id.unit3EdtPractice9);
        EditText editText10 = getView().findViewById(R.id.unit3EdtPractice10);
        EditText editText11 = getView().findViewById(R.id.unit3EdtPractice11);
        EditText editText12 = getView().findViewById(R.id.unit3EdtPractice12);
        EditText editText13 = getView().findViewById(R.id.unit3EdtPractice13);
        EditText editText14 = getView().findViewById(R.id.unit3EdtPractice14);
        EditText editText15 = getView().findViewById(R.id.unit3EdtPractice15);
        EditText editText16 = getView().findViewById(R.id.unit3EdtPractice16);
        EditText editText17 = getView().findViewById(R.id.unit3EdtPractice17);
        EditText editText18 = getView().findViewById(R.id.unit3EdtPractice18);
        EditText editText19 = getView().findViewById(R.id.unit3EdtPractice19);
        EditText editText20 = getView().findViewById(R.id.unit3EdtPractice20);

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
        strings[10] = editText11.getText().toString().toLowerCase().trim();
        strings[11] = editText12.getText().toString().toLowerCase().trim();
        strings[12] = editText13.getText().toString().toLowerCase().trim();
        strings[13] = editText14.getText().toString().toLowerCase().trim();
        strings[14] = editText15.getText().toString().toLowerCase().trim();
        strings[15] = editText16.getText().toString().toLowerCase().trim();
        strings[16] = editText17.getText().toString().toLowerCase().trim();
        strings[17] = editText18.getText().toString().toLowerCase().trim();
        strings[18] = editText19.getText().toString().toLowerCase().trim();
        strings[19] = editText20.getText().toString().toLowerCase().trim();

        sumScore += checkAnswerCalculateLanguage(strings[0], myConstantUnit3.getAnswerPractice1Strings());
        sumScore += checkAnswerCalculateLanguage(strings[1], myConstantUnit3.getAnswerPractice2Strings());
        sumScore += checkAnswerCalculateLanguage(strings[2], myConstantUnit3.getAnswerPractice3Strings());
        sumScore += checkAnswerCalculateLanguage(strings[3], myConstantUnit3.getAnswerPractice4Strings());
        sumScore += checkAnswerCalculateLanguage(strings[4], myConstantUnit3.getAnswerPractice5Strings());
        sumScore += checkAnswerCalculateLanguage(strings[5], myConstantUnit3.getAnswerPractice6Strings());
        sumScore += checkAnswerCalculateLanguage(strings[6], myConstantUnit3.getAnswerPractice7Strings());
        sumScore += checkAnswerCalculateLanguage(strings[7], myConstantUnit3.getAnswerPractice8Strings());
        sumScore += checkAnswerCalculateLanguage(strings[8], myConstantUnit3.getAnswerPractice9Strings());
        sumScore += checkAnswerCalculateLanguage(strings[9], myConstantUnit3.getAnswerPractice10Strings());
        sumScore += checkAnswerCalculateLanguage(strings[10], myConstantUnit3.getAnswerPractice11Strings());
        sumScore += checkAnswerCalculateLanguage(strings[11], myConstantUnit3.getAnswerPractice12Strings());
        sumScore += checkAnswerCalculateLanguage(strings[12], myConstantUnit3.getAnswerPractice13Strings());
        sumScore += checkAnswerCalculateLanguage(strings[13], myConstantUnit3.getAnswerPractice14Strings());
        sumScore += checkAnswerCalculateLanguage(strings[14], myConstantUnit3.getAnswerPractice15Strings());
        sumScore += checkAnswerCalculateLanguage(strings[15], myConstantUnit3.getAnswerPractice16Strings());
        sumScore += checkAnswerCalculateLanguage(strings[16], myConstantUnit3.getAnswerPractice17Strings());
        sumScore += checkAnswerCalculateLanguage(strings[17], myConstantUnit3.getAnswerPractice18Strings());
        sumScore += checkAnswerCalculateLanguage(strings[18], myConstantUnit3.getAnswerPractice19Strings());
        sumScore += checkAnswerCalculateLanguage(strings[19], myConstantUnit3.getAnswerPractice20Strings());


        Log.d(tag2, "scorePractice8==>" + sumScore);
        return sumScore;

    }

    private int calculateListening1() {
        int sumScore = 0;
        for (int i = 0; i < scoreListening1Ints.length; i += 1) {
            sumScore += scoreListening1Ints[i];
        }
        Log.d(tag2, "scoreListening1==>" + sumScore);
        return sumScore;
    }

    private int calculatePractice7() {
        int sumScore = 0;

        RadioButton radioButton1 = getView().findViewById(R.id.unit3RbPractice6d);
        RadioButton radioButton2 = getView().findViewById(R.id.unit3RbPractice7b);
        RadioButton radioButton3 = getView().findViewById(R.id.unit3RbPractice8c);
        RadioButton radioButton4 = getView().findViewById(R.id.unit3RbPractice9b);
        RadioButton radioButton5 = getView().findViewById(R.id.unit3RbPractice10a);
        RadioButton radioButton6 = getView().findViewById(R.id.unit3RbPractice11b);
        RadioButton radioButton7 = getView().findViewById(R.id.unit3RbPractice12c);
        RadioButton radioButton8 = getView().findViewById(R.id.unit3RbPractice13b);

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

        Log.d(tag2, "scorePractice7==>" + sumScore);
        return sumScore;
    }


    private int calculatePractice6() {
        int sumScore = 0;

        RadioButton radioButton1 = getView().findViewById(R.id.unit3RbPractice1False);
        RadioButton radioButton2 = getView().findViewById(R.id.unit3RbPractice2True);
        RadioButton radioButton3 = getView().findViewById(R.id.unit3RbPractice3True);
        RadioButton radioButton4 = getView().findViewById(R.id.unit3RbPractice4True);
        RadioButton radioButton5 = getView().findViewById(R.id.unit3RbPractice5False);

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

        Log.d(tag2, "scorePractice6==>" + sumScore);
        return sumScore;
    }

    private int calculatePractice5() {
        int sumScore = 0;
        Integer intA;
        int[] trueAnswerInts = myConstantUnit3.getAnswerPractice5ints();

        Collection<Integer> list;
        List<Integer> newList;

        list = Arrays.asList(positionPractice5Ints);
        newList = new ArrayList<>(new HashSet<>(list));

        for (int i = 0; i < newList.size(); i += 1) {
            intA = newList.get(i);
            for (int i1 = 0; i1 < trueAnswerInts.length; i1 += 1) {
                if (intA.equals(trueAnswerInts[i1])) {
                    sumScore += 1;
                }
            }
        }
        Log.d(tag2, "scorePractice5==>" + sumScore);
        return sumScore;

    }

    private int calculatePractice4() {
        int sumScore = 0;
        Integer intA;
        int[] trueAnswerInts = myConstantUnit3.getAnswerPractice4ints();

        Collection<Integer> list;
        List<Integer> newList;

        list = Arrays.asList(positionPractice4Ints);
        newList = new ArrayList<>(new HashSet<>(list));

        for (int i = 0; i < newList.size(); i += 1) {
            intA = newList.get(i);
            for (int i1 = 0; i1 < trueAnswerInts.length; i1 += 1) {
                if (intA.equals(trueAnswerInts[i1])) {
                    sumScore += 1;
                }
            }
        }
        Log.d(tag2, "scorePractice4==>" + sumScore);
        return sumScore;

    }

    private int calculatePractice3() {
        int sumScore = 0;
        Integer intA;
        int[] trueAnswerInts = myConstantUnit3.getAnswerPractice3Ints();

        Collection<Integer> list;
        List<Integer> newList;

        list = Arrays.asList(positionPractice3Ints);
        newList = new ArrayList<>(new HashSet<>(list));

        for (int i = 0; i < newList.size(); i += 1) {
            intA = newList.get(i);
            for (int i1 = 0; i1 < trueAnswerInts.length; i1 += 1) {
                if (intA.equals(trueAnswerInts[i1])) {
                    sumScore += 1;
                }
            }
        }
        Log.d(tag2, "scorePractice3==>" + sumScore);
        return sumScore;

    }

    private int calculatePractice2() {
        int sumScore = 0;
        Integer intA;
        int[] trueAnswerInts = myConstantUnit3.getAnswerPractice2Ints();

        Collection<Integer> list;
        List<Integer> newList;

        list = Arrays.asList(positionPractice2Ints);
        newList = new ArrayList<>(new HashSet<>(list));

        for (int i = 0; i < newList.size(); i += 1) {
            intA = newList.get(i);
            for (int i1 = 0; i1 < trueAnswerInts.length; i1 += 1) {
                if (intA.equals(trueAnswerInts[i1])) {
                    sumScore += 1;
                }
            }
        }
        Log.d(tag2, "scorePractice2==>" + sumScore);
        return sumScore;

    }

    private int calculatePractice1() {
        int sumScore = 0;
        Integer intA;
        int[] trueAnswerInts = myConstantUnit3.getAnswerPractice1Ints();

        Collection<Integer> list;
        List<Integer> newList;

        list = Arrays.asList(positionPractice1Ints);
        newList = new ArrayList<>(new HashSet<>(list));

        for (int i = 0; i < newList.size(); i += 1) {
            intA = newList.get(i);
            for (int i1 = 0; i1 < trueAnswerInts.length; i1 += 1) {
                if (intA.equals(trueAnswerInts[i1])) {
                    sumScore += 1;
                }
            }
        }
        Log.d(tag2, "scorePractice1==>" + sumScore);
        return sumScore;

    }

    private int calculateWarmUp() {
        int sumScore = 0;
        String[] strings = new String[4];
        String[] trueAnswerStrings1 = myConstantUnit3.getAnswerWarmUpString();
        String s;
        Collection<String> list;
        List<String> newList;

        EditText editText1 = getView().findViewById(R.id.unit3EdtWarmUp1);
        EditText editText2 = getView().findViewById(R.id.unit3EdtWarmUp2);
        EditText editText3 = getView().findViewById(R.id.unit3EdtWarmUp3);
        EditText editText4 = getView().findViewById(R.id.unit3EdtWarmUp4);


        strings[0] = editText1.getText().toString().toLowerCase().replaceAll("\\s", "");
        strings[1] = editText2.getText().toString().toLowerCase().replaceAll("\\s", "");
        strings[2] = editText3.getText().toString().toLowerCase().replaceAll("\\s", "");
        strings[3] = editText4.getText().toString().toLowerCase().replaceAll("\\s", "");

        list = Arrays.asList(strings);
        newList = new ArrayList<>(new HashSet<>(list));
        for (int i = 0; i < newList.size(); i += 1) {
            s = newList.get(i);
            for (int i1 = 0; i1 < trueAnswerStrings1.length; i1 += 1) {
                if (s.equals(trueAnswerStrings1[i1])) {
                    sumScore += 1;
                }
            }
        }

        Log.d(tag2, "scoreWarmUp==>" + sumScore);
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
        nameUnitString = strings[2];
        Log.d(tag, "nameUnitStirng ==> " + nameUnitString);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_unit3, container, false);
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        mediaPlayer1.stop();
    }
}
