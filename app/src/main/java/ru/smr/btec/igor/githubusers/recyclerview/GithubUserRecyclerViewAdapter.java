package ru.smr.btec.igor.githubusers.recyclerview;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;
import ru.smr.btec.igor.githubusers.model.Item;
import ru.smr.btec.igor.githubusers.presenters.UsersPresenter;


class GithubUserRecyclerViewAdapter extends RealmRecyclerViewAdapter<Item, GithubUserHolder> {
    private UsersPresenter usersPresenter;


    GithubUserRecyclerViewAdapter(OrderedRealmCollection<Item> data, UsersPresenter usersPresenter) {
        super(data, true);
        this.usersPresenter = usersPresenter;
        setHasStableIds(true);
        this.usersPresenter.getData(30);
    }

    @Override
    public void onViewRecycled(@NonNull GithubUserHolder holder) {
        super.onViewRecycled(holder);
        if (getItemCount() - holder.getAdapterPosition() == 30)
            this.usersPresenter.getData(30);
    }


    @Override
    public GithubUserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return GithubUserHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(GithubUserHolder holder, int position) {
        holder.bind( getItem(position));
    }

    @Override
    public long getItemId(int index) {
        return getItem(index).getId();
    }

}
