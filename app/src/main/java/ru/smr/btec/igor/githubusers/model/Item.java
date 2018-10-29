package ru.smr.btec.igor.githubusers.model;


import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Item extends RealmObject {

    private static final String TAG = "Item";
    @PrimaryKey
    private int id;
    private String login;
    private String avatar_url;

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatar() {
        return avatar_url;
    }

    static void create(Realm realm, List<ItemRest> itemRests) {
        Parent parent = realm.where(Parent.class).findFirst();
        RealmList<Item> items = parent.getItemList();
        for (ItemRest curItem : itemRests) {
            Item counter = realm.createObject(Item.class, curItem.getId());
            counter.avatar_url = curItem.getAvatar();
            counter.login = curItem.getLogin();
            items.add(counter);
        }
    }


}
