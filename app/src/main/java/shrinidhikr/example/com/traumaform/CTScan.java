package shrinidhikr.example.com.traumaform;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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

public class CTScan extends AppCompatActivity {
    public static EditText D45_5_2,D45_5_3,D45_6_3,D45_6_2,D45_4_2,D45_4_3,D45_7_3,D45_7_2,D45_8_2,D45_8_3;
    String id="";
    String name="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctscan);
        getSupportActionBar().setTitle("CT Scan");


        D45_4_2 = (EditText)findViewById(R.id.D45_4_2);
        D45_4_3 = (EditText)findViewById(R.id.D45_4_3);
        D45_5_2 = (EditText)findViewById(R.id.D45_5_2);
        D45_5_3 = (EditText)findViewById(R.id.D45_5_3);
        D45_6_2 = (EditText)findViewById(R.id.D45_6_2);
        D45_6_3 = (EditText)findViewById(R.id.D45_6_3);
        D45_7_2 = (EditText)findViewById(R.id.D45_7_2);
        D45_7_3 = (EditText)findViewById(R.id.D45_7_3);
        D45_8_2 = (EditText)findViewById(R.id.D45_8_2);
        D45_8_3 = (EditText)findViewById(R.id.D45_8_3);



        final Spinner spinner45_4_1 = (Spinner) findViewById(R.id.spinner45_4_1);
        final Spinner spinner45_5_1 = (Spinner) findViewById(R.id.spinner45_5_1);
        final Spinner spinner45_6_1 = (Spinner) findViewById(R.id.spinner45_6_1);
        final Spinner spinner45_7_1 = (Spinner) findViewById(R.id.spinner45_7_1);
        final Spinner spinner45_8_1 = (Spinner) findViewById(R.id.spinner45_8_1);

        String[] items = new String[]{"Not Selected","1. Done", "2. Not Done","3. Done But Not Recorded","4. Not Availabel","5. Not Required","-1. Not Applicable","-2. Unknown or not available","-3. Not recorded or inadequately described"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        spinner45_5_1.setAdapter(adapter);

        spinner45_5_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String anyvariable=String.valueOf(spinner45_5_1.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] items1 = new String[]{"Not Selected","1. Done", "2. Not Done","3. Done But Not Recorded","4. Not Availabel","5. Not Required","-1. Not Applicable","-2. Unknown or not available","-3. Not recorded or inadequately described"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);

        spinner45_4_1.setAdapter(adapter1);

        spinner45_4_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String anyvariable=String.valueOf(spinner45_4_1.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] items2 = new String[]{"Not Selected","1. Done", "2. Not Done","3. Done But Not Recorded","4. Not Availabel","5. Not Required","-1. Not Applicable","-2. Unknown or not available","-3. Not recorded or inadequately described"};

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);

        spinner45_6_1.setAdapter(adapter2);

        spinner45_6_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String anyvariable=String.valueOf(spinner45_6_1.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] items3 = new String[]{"Not Selected","1. Done", "2. Not Done","3. Done But Not Recorded","4. Not Availabel","5. Not Required","-1. Not Applicable","-2. Unknown or not available","-3. Not recorded or inadequately described"};

        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items3);

        spinner45_7_1.setAdapter(adapter3);

        spinner45_7_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String anyvariable=String.valueOf(spinner45_7_1.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] items4 = new String[]{"Not Selected","1. Done", "2. Not Done","3. Done But Not Recorded","4. Not Availabel","5. Not Required","-1. Not Applicable","-2. Unknown or not available","-3. Not recorded or inadequately described"};

        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items4);

        spinner45_8_1.setAdapter(adapter4);

        spinner45_8_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String anyvariable=String.valueOf(spinner45_8_1.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button b = (Button) findViewById(R.id.next6);

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
                    int i = 0, q = 58;
                    String fp[] = new String[200];
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String link = ds.getValue(String.class);
                        Log.e("TAG", link);
                        fp[i++] = link;

                    }

                    spinner45_4_1.setSelection(SpinnerValue.getIndex(spinner45_4_1,fp[q++]));
                    D45_4_2.setText(fp[q++]);
                    D45_4_3.setText(fp[q++]);
                    spinner45_5_1.setSelection(SpinnerValue.getIndex(spinner45_5_1,fp[q++]));
                    D45_5_2.setText(fp[q++]);
                    D45_5_3.setText(fp[q++]);
                    spinner45_6_1.setSelection(SpinnerValue.getIndex(spinner45_6_1,fp[q++]));
                    D45_6_2.setText(fp[q++]);
                    D45_6_3.setText(fp[q++]);
                    spinner45_7_1.setSelection(SpinnerValue.getIndex(spinner45_7_1,fp[q++]));
                    D45_7_2.setText(fp[q++]);
                    D45_7_3.setText(fp[q++]);
                    spinner45_8_1.setSelection(SpinnerValue.getIndex(spinner45_8_1,fp[q++]));
                    D45_8_2.setText(fp[q++]);
                    D45_8_3.setText(fp[q++]);

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
                    int i = 0, q = 58;
                    String fc[] = new String[200];
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String link = ds.getValue(String.class);
                        Log.e("TAG", link);
                        fc[i++] = link;

                    }

                    spinner45_4_1.setSelection(SpinnerValue.getIndex(spinner45_4_1,fc[q++]));
                    D45_4_2.setText(fc[q++]);
                    D45_4_3.setText(fc[q++]);
                    spinner45_5_1.setSelection(SpinnerValue.getIndex(spinner45_5_1,fc[q++]));
                    D45_5_2.setText(fc[q++]);
                    D45_5_3.setText(fc[q++]);
                    spinner45_6_1.setSelection(SpinnerValue.getIndex(spinner45_6_1,fc[q++]));
                    D45_6_2.setText(fc[q++]);
                    D45_6_3.setText(fc[q++]);
                    spinner45_7_1.setSelection(SpinnerValue.getIndex(spinner45_7_1,fc[q++]));
                    D45_7_2.setText(fc[q++]);
                    D45_7_3.setText(fc[q++]);
                    spinner45_8_1.setSelection(SpinnerValue.getIndex(spinner45_8_1,fc[q++]));
                    D45_8_2.setText(fc[q++]);
                    D45_8_3.setText(fc[q++]);
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
                share.editor.putString("59",spinner45_4_1.getSelectedItem().toString());
                share.editor.putString("60",D45_4_2.getText().toString());
                share.editor.putString("61",D45_4_3.getText().toString());
                share.editor.putString("62",spinner45_5_1.getSelectedItem().toString());
                share.editor.putString("63",D45_5_2.getText().toString());
                share.editor.putString("64",D45_5_3.getText().toString());
                share.editor.putString("65",spinner45_6_1.getSelectedItem().toString());
                share.editor.putString("66",D45_6_2.getText().toString());
                share.editor.putString("67",D45_6_3.getText().toString());
                share.editor.putString("68",spinner45_7_1.getSelectedItem().toString());
                share.editor.putString("69",D45_7_2.getText().toString());
                share.editor.putString("70",D45_7_3.getText().toString());
                share.editor.putString("71",spinner45_8_1.getSelectedItem().toString());
                share.editor.putString("72",D45_8_2.getText().toString());
                share.editor.putString("73",D45_8_3.getText().toString());

                share.editor.apply();

                Intent i = new Intent(getApplicationContext(), CriticalEDProcedure.class);
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
