package saraj.omgandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by saraj on 6/19/14.
 */
public class MainDialogFragment extends DialogFragment {
    EditText input;
    SharedPreferences mSharedPreferences;
    String prefs,pref_name;
    Context context;

    public void setPrefStuff(Context c,String a,String b)
    {
        context = c;
        prefs=a;
        pref_name=b;
        mSharedPreferences = context.getSharedPreferences(prefs,Context.MODE_PRIVATE);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        context = activity;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        input= new EditText(context);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        Log.d("Saraj", "Entered here");
        builder.setMessage(R.string.main_dialog_message)
                .setView(input)
                .setPositiveButton(R.string.main_dialog_positive_button, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        String inputName = input.getText().toString();
                        SharedPreferences.Editor e = mSharedPreferences.edit();
                        e.putString(pref_name, inputName);
                        e.commit();

                        // Welcome the new user
                        Toast.makeText(context, "Welcome, " + inputName + "!", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton(R.string.main_dialog_negative_button, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
