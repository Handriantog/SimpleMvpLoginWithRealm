package id.handriantog.latihandepe1;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class ApplicationDepe extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder()
                .name("depe.realm")
                .schemaVersion(0)
                .build();
        Realm.setDefaultConfiguration(realmConfig);
    }
}
