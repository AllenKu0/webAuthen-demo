package com.example.fido_j;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;



public class ShareKeyHandle {
    private Context context;
    private String keyHandle;
    public ShareKeyHandle(Context context){
        this.context = context;
    }

    public void saveKeyHandle(byte[] keyHandle){
        Log.e("TAG", "context: "+context );
        Log.e("TAG", "loadKeyHandle: "+keyHandle );
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("keyHandle", Base64.encodeToString(keyHandle, Base64.DEFAULT)).commit();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            editor.putString("keyHandle", Base64.encodeToString(keyHandle, Base64.DEFAULT));
            Log.e("TAG", "loadKeyHandle decode: "+ Base64.encodeToString(keyHandle, Base64.DEFAULT));
        }
    }
    public byte[] loadKeyHandle(){
        Log.e("TAG", "context: "+context );
//        SharedPreferences store = context.getSharedPreferences("SAVE", Context.MODE_PRIVATE);
        keyHandle=PreferenceManager.getDefaultSharedPreferences(context).getString("keyHandle","");
        Log.e("TAG", "loadKeyHandle: "+keyHandle );
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return Base64.decode(keyHandle, Base64.DEFAULT);
        }
        else{
            return null;
        }
    }

}
