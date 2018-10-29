package ru.smr.btec.igor.githubusers.rest;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.smr.btec.igor.githubusers.model.ItemRest;


public class NetApiClient {

    private static final NetApiClient ourInstance = new NetApiClient();

    public static NetApiClient getInstance() {
        return ourInstance;
    }

    private Endpoints netApi = new ServiceGenerator().createService(Endpoints.class);

    private NetApiClient() {
    }

    public io.reactivex.Observable<ItemRest> getUser(String user) {
        return netApi.getUser(user)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    public Flowable<List<ItemRest>> getUsers(long since, int per_page) {
        return netApi.getUsers(since, per_page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

//    public Flowable<List<RepsModel>> getReps() {
//        return netApi.getRepos()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io());
//    }
}
