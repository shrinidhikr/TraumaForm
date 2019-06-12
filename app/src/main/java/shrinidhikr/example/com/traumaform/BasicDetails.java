package shrinidhikr.example.com.traumaform;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BasicDetails extends Activity {


    Button button;
    public static EditText D1,D2,D3,D4,D6,D7,D8,D9,D10;
    String id="";
    String name="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_details);

        D1 = (EditText)findViewById(R.id.D1);
        D2 = (EditText)findViewById(R.id.D2);
        D3 = (EditText)findViewById(R.id.D3);
        D4 = (EditText)findViewById(R.id.D4);
        D6 = (EditText)findViewById(R.id.D6);
        D7 = (EditText)findViewById(R.id.D7);
        D8 = (EditText)findViewById(R.id.D8);
        D9 = (EditText)findViewById(R.id.D9);
        D10 = (EditText)findViewById(R.id.D10);
        button =(Button)findViewById(R.id.submit);

       final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final Spinner spinner11 = (Spinner) findViewById(R.id.spinner11);



        String[] items = new String[]{"Not Selected", "1. Yes","2. No","-1. Not Applicable","-2. Unknown or not available","-3. Not recorded or inadequately described"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String anyvariable=String.valueOf(spinner.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] items1 = new String[]{"Not Selected", "1. Unconcious","2. Semi-Concious","3. Alert","-1. Not Applicable","-2. Unknown or not available","-3. Not recorded or inadequately described"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);

        spinner11.setAdapter(adapter1);

        spinner11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String anyvariable=String.valueOf(spinner11.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        Intent intent = getIntent();
       id= intent.getStringExtra("Parent");
       name = intent.getStringExtra("Reg_id");


        Toast.makeText(getApplicationContext(), id+name,
                Toast.LENGTH_LONG).show();

        if(id.equals("P")||id=="P")
        {

            DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("Partial Database");
            DatabaseReference itemsRef = rootRef.child("R"+name);
            ValueEventListener eventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Log.e("kess", dataSnapshot.toString());
                    int i = 0, q=0;
                    String fp[] = new String[200];
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String link = ds.getValue(String.class);
                        Log.e("TAG", link);
                        fp[i++] = link;

                    }

                    D1.setText(fp[q++]);
                    D2.setText(fp[q++]);
                    D3.setText(fp[q++]);
                    D4.setText(fp[q++]);
                    spinner.setSelection(SpinnerValue.getIndex(spinner,fp[q++]));
                    D6.setText(fp[q++]);
                    D7.setText(fp[q++]);
                    D8.setText(fp[q++]);
                    D9.setText(fp[q++]);
                    D10.setText(fp[q++]);
                    spinner11.setSelection(SpinnerValue.getIndex(spinner11, fp[q++]));

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
                    int i = 0, q=0;
                    String fc[] = new String[200];
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String link = ds.getValue(String.class);
                        Log.e("TAG", link);
                        fc[i++] = link;

                    }

                    D1.setText(fc[q++]);
                    D2.setText(fc[q++]);
                    D3.setText(fc[q++]);
                    D4.setText(fc[q++]);
                    spinner.setSelection(SpinnerValue.getIndex(spinner, fc[q++]));
                    D6.setText(fc[q++]);
                    D7.setText(fc[q++]);
                    D8.setText(fc[q++]);
                    D9.setText(fc[q++]);
                    D10.setText(fc[q++]);
                    spinner11.setSelection(SpinnerValue.getIndex(spinner, fc[q++]));

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {}
            };
            itemsRef.addListenerForSingleValueEvent(eventListener);


        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                share.auth = getApplicationContext().getSharedPreferences("0001", Context.MODE_PRIVATE);
                share.editor = share.auth.edit();

                share.editor.putString("1",D1.getText().toString());
                share.editor.putString("2",D2.getText().toString());
                share.editor.putString("3",D3.getText().toString());
                share.editor.putString("4",D4.getText().toString());
                share.editor.putString("5",spinner.getSelectedItem().toString());
                share.editor.putString("6",D6.getText().toString());
                share.editor.putString("7",D7.getText().toString());
                share.editor.putString("8",D8.getText().toString());
                share.editor.putString("9",D9.getText().toString());
                share.editor.putString("10",D10.getText().toString());
                share.editor.putString("11",spinner11.getSelectedItem().toString());
                share.editor.apply();

                Log.e("Authcheck1",D1.getText().toString()+D2.getText().toString()+D3.getText().toString());


                Intent i=new Intent(getApplicationContext(),InjuryEventData.class);
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