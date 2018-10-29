package ru.smr.btec.igor.githubusers.rest;


import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.smr.btec.igor.githubusers.model.ItemRest;


public interface Endpoints {

    @GET("/users/{user}")
    Observable<ItemRest> getUser(
            @Path("user") String user);

    @GET("/users")
    Flowable<List<ItemRest>> getUsers(@Query("since") long since, @Query("per_page") int per_page);

    @GET("/search/users")
    Flowable<List<ItemRest>> getSearchUsers(@Query("q") String login, @Query("page") int page);
//    https://api.github.com/search/users?q=tom&page=34

//    @GET("/repositories")
//    Flowable<List<RepsModel>> getRepos();
}
