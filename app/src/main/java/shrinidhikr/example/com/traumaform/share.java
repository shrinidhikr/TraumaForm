package shrinidhikr.example.com.traumaform;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

public class share extends AppCompatActivity{
   public static SharedPreferences auth;
   public static SharedPreferences.Editor editor;

    public void spref() {
        auth = getApplicationContext().getSharedPreferences("0001", Context.MODE_PRIVATE);
        editor = auth.edit();

        for(int i=0;i<116;i++)
            editor.putString(String.valueOf(i),"");
        editor.apply();
    }
    }
