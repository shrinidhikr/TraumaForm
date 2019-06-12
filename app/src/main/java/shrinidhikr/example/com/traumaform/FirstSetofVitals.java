package shrinidhikr.example.com.traumaform;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirstSetofVitals extends AppCompatActivity {
    public static EditText D34,D35,D36,D37,D38,D39,D40,D41,D42,D43;
    String id="";
    String name="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_setof_vitals);
        getSupportActionBar().setTitle("First Set of Vitals");

        D34 = (EditText)findViewById(R.id.D34);
        D35 = (EditText)findViewById(R.id.D35);
        D36 = (EditText)findViewById(R.id.D36);
        D37 = (EditText)findViewById(R.id.D37);
        D38 = (EditText)findViewById(R.id.D38);
        D39 = (EditText)findViewById(R.id.D39);
        D40 = (EditText)findViewById(R.id.D40);
        D41 = (EditText)findViewById(R.id.D41);
        D42 = (EditText)findViewById(R.id.D42);
        D43 = (EditText)findViewById(R.id.D43);

        Intent intent = getIntent();
        id= intent.getStringExtra("Parent");
        name = intent.getStringExtra("Reg_id");

        Toast.makeText(getApplicationContext(), id+name,
                Toast.LENGTH_LONG).show();
        Button b = (Button) findViewById(R.id.next4);

        if(id.equals("P")||id=="P")
        {

            DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("Partial Database");
            DatabaseReference itemsRef = rootRef.child("R"+name);
            ValueEventListener eventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Log.e("kess", dataSnapshot.toString());
                    int i = 0, q = 35;
                    String fp[] = new String[200];
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String link = ds.getValue(String.class);
                        Log.e("TAG", link);
                        fp[i++] = link;

                    }

                    D34.setText(fp[q++]);
                    D35.setText(fp[q++]);
                    D36.setText(fp[q++]);
                    D37.setText(fp[q++]);
                    D38.setText(fp[q++]);
                    D39.setText(fp[q++]);
                    D40.setText(fp[q++]);
                    D41.setText(fp[q++]);
                    D42.setText(fp[q++]);
                    D43.setText(fp[q++]);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {}
            };
            itemsRef.addListenerForSingleValueEvent(eventListener);




        }


        else if(id.equals("C")||id=="C")
        {
            DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("Complete Database");
            DatabaseReference itemsRef = rootRef.child("R"+name);
            ValueEventListener eventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Log.e("kess", dataSnapshot.toString());
                    int i = 0, q = 35;
                    String fc[] = new String[200];
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String link = ds.getValue(String.class);
                        Log.e("TAG", link);
                        fc[i++] = link;

                    }

                    D34.setText(fc[q++]);
                    D35.setText(fc[q++]);
                    D36.setText(fc[q++]);
                    D37.setText(fc[q++]);
                    D38.setText(fc[q++]);
                    D39.setText(fc[q++]);
                    D40.setText(fc[q++]);
                    D41.setText(fc[q++]);
                    D42.setText(fc[q++]);
                    D43.setText(fc[q++]);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {}
            };
            itemsRef.addListenerForSingleValueEvent(eventListener);


        }

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                share.auth = getApplicationContext().getSharedPreferences("0001", Context.MODE_PRIVATE);
                share.editor.putString("36",D34.getText().toString());
                share.editor.putString("37",D35.getText().toString());
                share.editor.putString("38",D36.getText().toString());
                share.editor.putString("39",D37.getText().toString());
                share.editor.putString("40",D38.getText().toString());
                share.editor.putString("41",D39.getText().toString());
                share.editor.putString("42",D40.getText().toString());
                share.editor.putString("43",D41.getText().toString());
                share.editor.putString("44",D42.getText().toString());
                share.editor.putString("45",D43.getText().toString());
                share.editor.apply();
                Intent i = new Intent(getApplicationContext(), EDInvestigations.class);
                if(id.equals("P")||(id=="P"))
                {
                    i.putExtra("Reg_id", name);
                    i.putExtra("Parent", "P");
                }
                else if(id.equals("C")||id=="C")
                {
                    i.putExtra("Reg_id", name);
                    i.putExtra("Parent", "C");
                }
                else
                {
                    i.putExtra("Parent", "Nav");
                }
                startActivity(i);
            }
        });
    }
}
