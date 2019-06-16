package thailand.soumbundit.jirawat.funnyquestion.utility;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import thailand.soumbundit.jirawat.funnyquestion.R;

public class ShowScoreAdapter extends RecyclerView.Adapter<ShowScoreAdapter.ShowScoreViewHolder>{

    private Context context;
    private ArrayList<String> languageStringArrayList, listeningStringArrayList,
            timeTestStringArrayList, practiceStringArrayList, warmUpStringArrayList;
    private LayoutInflater layoutInflater;

    public ShowScoreAdapter(Context context,
                            ArrayList<String> languageStringArrayList,
                            ArrayList<String> listeningStringArrayList,
                            ArrayList<String> timeTestStringArrayList,
                            ArrayList<String> practiceStringArrayList,
                            ArrayList<String> warmUpStringArrayList) {

        this.layoutInflater = LayoutInflater.from(context);
        this.languageStringArrayList = languageStringArrayList;
        this.listeningStringArrayList = listeningStringArrayList;
        this.timeTestStringArrayList = timeTestStringArrayList;
        this.practiceStringArrayList = practiceStringArrayList;
        this.warmUpStringArrayList = warmUpStringArrayList;
    }

    @Override
    public ShowScoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.recycle_show_score, parent, false);
        ShowScoreViewHolder showScoreViewHolder = new ShowScoreViewHolder(view);
        return showScoreViewHolder;
    }

    @Override
    public void onBindViewHolder(ShowScoreViewHolder holder, int position) {

        String language = languageStringArrayList.get(position);
        String listening = listeningStringArrayList.get(position);
        String timeTest = timeTestStringArrayList.get(position);
        String practice = practiceStringArrayList.get(position);
        String warmUp = warmUpStringArrayList.get(position);

        holder.languageTextView.setText(language);
        holder.listeningTextView.setText(listening);
        holder.timeTestTextView.setText(timeTest);
        holder.practiceTextView.setText(practice);
        holder.warmUpTextView.setText(warmUp);

    }

    @Override
    public int getItemCount() {
        return timeTestStringArrayList.size();
    }


    public class ShowScoreViewHolder extends RecyclerView.ViewHolder {

        private TextView languageTextView, listeningTextView, timeTestTextView,
                practiceTextView, warmUpTextView;


        public ShowScoreViewHolder(View itemView) {
            super(itemView);
            languageTextView = itemView.findViewById(R.id.txtLanguage);
            listeningTextView = itemView.findViewById(R.id.txtListening);
            timeTestTextView = itemView.findViewById(R.id.txtTimeTest);
            practiceTextView = itemView.findViewById(R.id.txtPractice);
            warmUpTextView = itemView.findViewById(R.id.txtWarmUp);

        }
    }

}
