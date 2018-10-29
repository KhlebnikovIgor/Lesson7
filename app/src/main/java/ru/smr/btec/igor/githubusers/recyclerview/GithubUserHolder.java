package ru.smr.btec.igor.githubusers.recyclerview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import ru.smr.btec.igor.githubusers.R;
import ru.smr.btec.igor.githubusers.interfaces.OnGithubuserListItemSelectedListener;
import ru.smr.btec.igor.githubusers.model.Item;


public class GithubUserHolder extends RecyclerView.ViewHolder {
    private OnGithubuserListItemSelectedListener callbackActivity;
    private TextView titleTextView;
    private ImageView imageView;
    private CardView listItemCardView;

    private GithubUserHolder(View itemView) {
        super(itemView);
        //this.callbackActivity = (OnGithubuserListItemSelectedListener) itemView.getContext();
        titleTextView = (TextView) itemView.findViewById(R.id.title);
        imageView = (ImageView) itemView.findViewById(R.id.avatar);
        listItemCardView = (CardView) itemView.findViewById(R.id.list_item_card_view);
    }

    public void bind(Item item) {
        titleTextView.setText(Html.fromHtml("<font color=#639EFD>Id: </font>" + item.getId() + "<br><font color=#639EFD>Login: </font>" + item.getLogin()));
        Glide.with(listItemCardView.getContext())
                .load(item.getAvatar())
                .into(imageView);
      //  listItemCardView.setOnClickListener((v)->callbackActivity.onWorkoutListItemSelected(getAdapterPosition()));
    }

    static GithubUserHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new GithubUserHolder(view);
    }


}