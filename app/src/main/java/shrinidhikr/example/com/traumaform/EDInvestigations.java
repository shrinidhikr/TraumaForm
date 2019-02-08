package shrinidhikr.example.com.traumaform;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EDInvestigations extends AppCompatActivity {
    public static EditText D44_2,D44_3,D45_1_2,D45_1_3,D45_2_2,D45_2_3,D45_3_2,D45_3_3;
    String id="";
    String name="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edinvestigations);
        getSupportActionBar().setTitle("ED Investigation");

        Intent intent = getIntent();
        id= intent.getStringExtra("Parent");
        name = intent.getStringExtra("Reg_id");

        Toast.makeText(getApplicationContext(), id+name,
                Toast.LENGTH_LONG).show();
        D44_2 = (EditText)findViewById(R.id.D44_2);
        D44_3 = (EditText)findViewById(R.id.D44_3);
        D45_1_2 = (EditText)findViewById(R.id.D45_1_2);
        D45_1_3 = (EditText)findViewById(R.id.D45_1_3);
        D45_2_2 = (EditText)findViewById(R.id.D45_2_2);
        D45_2_3 = (EditText)findViewById(R.id.D45_2_3);
        D45_3_2 = (EditText)findViewById(R.id.D45_3_2);
        D45_3_3 = (EditText)findViewById(R.id.D45_3_3);


        final Spinner spinner44_1 = (Spinner) findViewById(R.id.spinner44_1);
        final Spinner spinner45 = (Spinner) findViewById(R.id.spinner45);
        final Spinner spinner45_1_1_ = (Spinner) findViewById(R.id.spinner45_1_1_);
        final Spinner spinner45_2_1 = (Spinner) findViewById(R.id.spinner45_2_1);
        final Spinner spinner45_3_1 = (Spinner) findViewById(R.id.spinner45_3_1);


        Button b = (Button) findViewById(R.id.next5);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                share.auth = getApplicationContext().getSharedPreferences("0001", Context.MODE_PRIVATE);
                share.editor.putString("46",spinner44_1.getSelectedItem().toString());
                share.editor.putString("47",D44_2.getText().toString());
                share.editor.putString("48",D44_3.getText().toString());
                share.editor.putString("49",spinner45.getSelectedItem().toString());
                share.editor.putString("50",spinner45_1_1_.getSelectedItem().toString());
                share.editor.putString("51",D45_1_2.getText().toString());
                share.editor.putString("52",D45_1_3.getText().toString());
                share.editor.putString("53",spinner45_2_1.getSelectedItem().toString());
                share.editor.putString("54",D45_2_2.getText().toString());
                share.editor.putString("55",D45_2_3.getText().toString());
                share.editor.putString("56",spinner45_3_1.getSelectedItem().toString());
                share.editor.putString("57",D45_3_2.getText().toString());
                share.editor.putString("58",D45_3_3.getText().toString());

                share.editor.apply();

                Intent i = new Intent(getApplicationContext(), CTScan.class);
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

        String[] items = new String[]{"Not Selected","1. Male", "2. Female","3. Transgender","-1. Not Applicable","-2. Unknown or not available","-3. Not recorded or inadequately described"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        spinner44_1.setAdapter(adapter);

        spinner44_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String anyvariable=String.valueOf(spinner44_1.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] items1 = new String[]{"Not Selected", "1: Yes","2: No"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);

        spinner45.setAdapter(adapter1);

        spinner45.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String anyvariable=String.valueOf(spinner45.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] items2 = new String[]{"Not Selected", "1: Yes","2: No"};

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);

        spinner45_1_1_.setAdapter(adapter2);

        spinner45_1_1_.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String anyvariable=String.valueOf(spinner45_1_1_.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] items3 = new String[]{"Not Selected", "1: Yes","2: No"};

        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items3);

        spinner45_2_1.setAdapter(adapter3);

        spinner45_2_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String anyvariable=String.valueOf(spinner45_2_1.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] items4 = new String[]{"Not Selected", "1: Yes","2: No"};

        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items4);

        spinner45_3_1.setAdapter(adapter4);

        spinner45_3_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String anyvariable=String.valueOf(spinner45_3_1.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
