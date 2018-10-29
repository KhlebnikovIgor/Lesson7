package ru.smr.btec.igor.githubusers.presenters;


import com.arellomobile.mvp.MvpView;

import java.util.List;

import ru.smr.btec.igor.githubusers.model.ItemRest;


public interface UsersView extends MvpView {
    void setUserList(List<ItemRest> userList);
    void showError(Throwable e);

    void startLoad();
    void finishLoad();
}
