package ru.smr.btec.igor.githubusers.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;


import java.util.List;

import io.realm.RealmList;
import ru.smr.btec.igor.githubusers.model.DbRealm;
import ru.smr.btec.igor.githubusers.model.Item;
import ru.smr.btec.igor.githubusers.model.ItemRest;
import ru.smr.btec.igor.githubusers.model.Parent;
import ru.smr.btec.igor.githubusers.rest.NetApiClient;

@InjectViewState
public class UsersPresenter extends MvpPresenter<UsersView> implements Subscriber<List<ItemRest>> {
    private static final String TAG = "UsersPresenter";
    private long since = 0;
    public DbRealm dbRealm = new DbRealm();


    public RealmList<Item> getItemList() {
        return dbRealm.realm.where(Parent.class).findFirst().getItemList();
    }

    public void getData(long since, int per_page) {
        NetApiClient.getInstance().getUsers(since, per_page).subscribe(this);
    }

    public void getData(int per_page) {
        getData(this.since, per_page);
    }

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
        Log.e(TAG, " onSubscribe");
    }

    @Override
    public void onNext(List<ItemRest> itemRests) {
        dbRealm.addItemAsync(itemRests);
        this.since = itemRests.get(itemRests.size() - 1).getId();
        Log.e(TAG, " onNext size =" + itemRests.size());
    }

    @Override
    public void onError(Throwable t) {
        Log.e(TAG, " onError");
    }

    @Override
    public void onComplete() {
        Log.e(TAG, " onComplete");
    }
}
