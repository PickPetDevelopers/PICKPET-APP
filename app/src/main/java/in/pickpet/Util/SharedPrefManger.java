package in.pickpet.Util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;

public class SharedPrefManger {
    private SharedPreferences sharedPreferences;
    Context context;
    private SharedPreferences.Editor editor;

    public SharedPrefManger(Context context) {
        this.context = context;
    }

    public void saveUser(){
        sharedPreferences = context.getSharedPreferences(Constants.USERS,0);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    public boolean isLoggedIn(){
        sharedPreferences = context.getSharedPreferences(Constants.USERS,0);
        return sharedPreferences.getBoolean(Constants.USERS,false);
    }

    public void logout(){
        sharedPreferences = context.getSharedPreferences(Constants.USERS,0);
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
