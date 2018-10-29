package ru.smr.btec.igor.githubusers.model;

import io.realm.RealmList;
import io.realm.RealmObject;


public class Parent extends RealmObject {
    @SuppressWarnings("unused")
    private RealmList<Item> itemList;

    public RealmList<Item> getItemList() {
        return itemList;
    }
}
