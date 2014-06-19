package saraj.omgandroid;

import android.content.SharedPreferences;

import android.os.Bundle;
import android.content.Context;
/**
 * Created by saraj on 6/19/14.
 */
public class SharedPreferencesHelper {
    private SharedPreferences mSharedPreferences;
    private String s1;
    private Context context;
    private SharedPreferences.Editor e;
    private SharedPreferencesHelper() {

    }
    public void init(Context c,String a){
        s1=a;
        context = c;
        mSharedPreferences = context.getSharedPreferences(s1,Context.MODE_PRIVATE);
        e = mSharedPreferences.edit();
    }

    public String readPreferences(String a,String b)
    {
        return mSharedPreferences.getString(a,b);
    }

    public void writePreferences(String a,String b){
        e.putString(a, b);
        e.commit();
    }


}
