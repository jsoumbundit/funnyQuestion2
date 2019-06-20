package thailand.soumbundit.jirawat.funnyquestion.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import thailand.soumbundit.jirawat.funnyquestion.R;

public class ReportFragment extends Fragment {


    public static ReportFragment reportFragment(String uidString) {
        ReportFragment reportFragment = new ReportFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Uid", uidString);
        reportFragment.setArguments(bundle);
        return reportFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
//    Create all Units report as  child
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Fragment childFragment = new Unit2ReportFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.child_fragment_container, childFragment).commit();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report, container, false);
        return view;
    }
}
