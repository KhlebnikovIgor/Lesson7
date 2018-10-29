package ru.smr.btec.igor.githubusers.recyclerview;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import ru.smr.btec.igor.githubusers.R;
import ru.smr.btec.igor.githubusers.model.ItemRest;
import ru.smr.btec.igor.githubusers.presenters.UsersPresenter;
import ru.smr.btec.igor.githubusers.presenters.UsersView;

public class RecyclerViewExampleActivity extends MvpAppCompatActivity implements UsersView {
    @InjectPresenter
    public UsersPresenter usersPresenter;

    private RecyclerView recyclerView;
    private GithubUserRecyclerViewAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        recyclerView = findViewById(R.id.recycler_view);
        setUpRecyclerView();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



    private void setUpRecyclerView() {
        adapter = new GithubUserRecyclerViewAdapter(usersPresenter.getItemList(), usersPresenter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    public void setUserList(List<ItemRest> userList) {

    }

    @Override
    public void showError(Throwable e) {

    }

    @Override
    public void startLoad() {

    }

    @Override
    public void finishLoad() {

    }
}
