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

public class FollowUpData extends AppCompatActivity {

    public static EditText D48_1,D48_2,D50,D51,D52,D53_1,D54,D55;
    String id="";
    String name="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_up_data);
        getSupportActionBar().setTitle("Follow Up Data");

        D48_1 = (EditText)findViewById(R.id.D48_1);
        D48_2 = (EditText)findViewById(R.id.D48_2);
        D50 = (EditText)findViewById(R.id.D50);
        D51 = (EditText)findViewById(R.id.D51);
        D52 = (EditText)findViewById(R.id.D52);
        D53_1 = (EditText)findViewById(R.id.D53_1);
        D54 = (EditText)findViewById(R.id.D54);
        D55 = (EditText)findViewById(R.id.D55);

        Intent intent = getIntent();
        id= intent.getStringExtra("Parent");
        name = intent.getStringExtra("Reg_id");

        Toast.makeText(getApplicationContext(), id+name,
                Toast.LENGTH_LONG).show();

        final Spinner spinner48 = (Spinner) findViewById(R.id.spinner48);
        final Spinner spinner49_1 = (Spinner) findViewById(R.id.spinner49_1);
        final Spinner spinner49_2 = (Spinner) findViewById(R.id.spinner49_2);
        final Spinner spinner49_3 = (Spinner) findViewById(R.id.spinner49_3);
        final Spinner spinner53 = (Spinner) findViewById(R.id.spinner53);

        String[] items = new String[]{"Not Selected","1. Yes", "2. No","-1. Not Applicable","-2. Unknown or not available","-3. Not recorded or inadequately described"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        spinner48.setAdapter(adapter);

        spinner48.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String anyvariable=String.valueOf(spinner48.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] items1 = new String[]{"Not Selected","1. Wound Infection", "2. Septic Shock","3. Cradiac Arrest" ,"4. Renal Failure","5. Pneumonia","6. Ulcer/Pressure Sores","7. Other","-1. Not Applicable","-2. Unknown or not available","-3. Not recorded or inadequately described"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);

        spinner49_1.setAdapter(adapter1);

        spinner49_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String anyvariable=String.valueOf(spinner49_1.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] items2 = new String[]{"Not Selected","1. Wound Infection", "2. Septic Shock","3. Cradiac Arrest" ,"4. Renal Failure","5. Pneumonia","6. Ulcer/Pressure Sores","7. Other","-1. Not Applicable","-2. Unknown or not available","-3. Not recorded or inadequately described"};

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);

        spinner49_2.setAdapter(adapter2);

        spinner49_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String anyvariable=String.valueOf(spinner49_2.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] items3 = new String[]{"Not Selected","1. Wound Infection", "2. Septic Shock","3. Cradiac Arrest" ,"4. Renal Failure","5. Pneumonia","6. Ulcer/Pressure Sores","7. Other","-1. Not Applicable","-2. Unknown or not available","-3. Not recorded or inadequately described"};

        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items3);

        spinner49_3.setAdapter(adapter2);

        spinner49_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String anyvariable=String.valueOf(spinner49_3.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] items4 = new String[]{"Not Selected","1. Home", "2. Rehabilitation Hospital","3. Transfer to other hospital for acute care" ,"4. Residential aged care services or nursing home that is not the usual place of residence","5.  Death","6. Absconded","7. Discharged Against Medical Advice - DAMA ","8. LAMA","9. Other","-1. Not Applicable","-2. Unknown or not available","-3. Not recorded or inadequately described"};

        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items4);

        spinner53.setAdapter(adapter4);

        spinner53.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String anyvariable=String.valueOf(spinner53.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button b = (Button) findViewById(R.id.next9);

        if(id.equals("P")||id=="P")
        {

            DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("Partial Database");
            DatabaseReference itemsRef = rootRef.child("R"+name);
            ValueEventListener eventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Log.e("kess", dataSnapshot.toString());
                    int i = 0, q = 103;
                    String fp[] = new String[200];
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String link = ds.getValue(String.class);
                        Log.e("TAG", link);
                        fp[i++] = link;

                    }

                    spinner48.setSelection(SpinnerValue.getIndex(spinner48,fp[q++]));
                    D48_1.setText(fp[q++]);
                    D48_2.setText(fp[q++]);
                    spinner49_1.setSelection(SpinnerValue.getIndex(spinner49_1,fp[q++]));
                    spinner49_2.setSelection(SpinnerValue.getIndex(spinner49_2,fp[q++]));
                    spinner49_3.setSelection(SpinnerValue.getIndex(spinner49_3,fp[q++]));
                    D50.setText(fp[q++]);
                    D51.setText(fp[q++]);
                    D52.setText(fp[q++]);
                    spinner53.setSelection(SpinnerValue.getIndex(spinner53,fp[q++]));
                    D53_1.setText(fp[q++]);
                    D54.setText(fp[q++]);
                    D55.setText(fp[q++]);


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
                    int i = 0, q = 103;
                    String fc[] = new String[200];
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        String link = ds.getValue(String.class);
                        Log.e("TAG", link);
                        fc[i++] = link;

                    }

                    spinner48.setSelection(SpinnerValue.getIndex(spinner48,fc[q++]));
                    D48_1.setText(fc[q++]);
                    D48_2.setText(fc[q++]);
                    spinner49_1.setSelection(SpinnerValue.getIndex(spinner49_1,fc[q++]));
                    spinner49_2.setSelection(SpinnerValue.getIndex(spinner49_2,fc[q++]));
                    spinner49_3.setSelection(SpinnerValue.getIndex(spinner49_3,fc[q++]));
                    D50.setText(fc[q++]);
                    D51.setText(fc[q++]);
                    D52.setText(fc[q++]);
                    spinner53.setSelection(SpinnerValue.getIndex(spinner53,fc[q++]));
                    D53_1.setText(fc[q++]);
                    D54.setText(fc[q++]);
                    D55.setText(fc[q++]);



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
                share.editor = share.auth.edit();

                share.editor.putString("104",spinner48.getSelectedItem().toString());
                share.editor.putString("105",D48_1.getText().toString());
                share.editor.putString("106",D48_2.getText().toString());
                share.editor.putString("107",spinner49_1.getSelectedItem().toString());
                share.editor.putString("108",spinner49_2.getSelectedItem().toString());
                share.editor.putString("109",spinner49_3.getSelectedItem().toString());
                share.editor.putString("110",D50.getText().toString());
                share.editor.putString("111",D51.getText().toString());
                share.editor.putString("112",D52.getText().toString());
                share.editor.putString("113",spinner53.getSelectedItem().toString());
                share.editor.putString("114",D53_1.getText().toString());
                share.editor.putString("115",D54.getText().toString());
                share.editor.putString("116",D55.getText().toString());
                                share.editor.apply();
                Intent i = new Intent(getApplicationContext(),InjuryCodingData.class);
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
