package thailand.soumbundit.jirawat.funnyquestion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import thailand.soumbundit.jirawat.funnyquestion.fragment.MainFragment;
import thailand.soumbundit.jirawat.funnyquestion.fragment.MainFragment2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Add Fragment to Activity
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentMainFragment,new MainFragment())
                    .commit();

        }


    }
}
