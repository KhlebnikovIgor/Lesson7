package ru.smr.btec.igor.githubusers.model;


import java.util.List;

import io.realm.Realm;

public class DbRealm {
    public Realm realm = Realm.getDefaultInstance();;




    public  void addItemAsync( final List<ItemRest> itemRests) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Item.create(realm, itemRests);
            }
        });
    }


}
