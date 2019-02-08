package shrinidhikr.example.com.traumaform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class CriticalEDProcedure extends AppCompatActivity {
    String id="";
    String name="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_critical_edprocedure);
        getSupportActionBar().setTitle("Critical ED Procedure");


        final Spinner spinner46_1 = (Spinner) findViewById(R.id.spinner46_1);
        final Spinner spinner46_2 = (Spinner) findViewById(R.id.spinner46_2);
        final Spinner spinner46_3= (Spinner) findViewById(R.id.spinner46_3);
        final Spinner spinner46_4 = (Spinner) findViewById(R.id.spinner46_4);
        final Spinner spinner46_5 = (Spinner) findViewById(R.id.spinner46_5);

        Intent intent = getIntent();
        id= intent.getStringExtra("Parent");
        name = intent.getStringExtra("Reg_id");

        Toast.makeText(getApplicationContext(), id+name,
                Toast.LENGTH_LONG).show();
        String[] items = new String[]{"Not Selected","1. Yes", "2. No","3. Outside","-1. Not Applicable","-2. Unknown or not available","-3. Not recorded or inadequately described"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        spinner46_1.setAdapter(adapter);

        spinner46_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String anyvariable=String.valueOf(spinner46_1.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] items1 = new String[]{"Not Selected","1. Yes", "2. No","3. Outside","-1. Not Applicable","-2. Unknown or not available","-3. Not recorded or inadequately described"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);

        spinner46_2.setAdapter(adapter1);

        spinner46_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String anyvariable=String.valueOf(spinner46_2.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] items2 = new String[]{"Not Selected","1. Yes", "2. No","3. Outside","-1. Not Applicable","-2. Unknown or not available","-3. Not recorded or inadequately described"};

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);

        spinner46_3.setAdapter(adapter2);

        spinner46_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String anyvariable=String.valueOf(spinner46_3.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] items3 = new String[]{"Not Selected","1. Yes", "2. No","3. Outside","-1. Not Applicable","-2. Unknown or not available","-3. Not recorded or inadequately described"};

        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items3);

        spinner46_4.setAdapter(adapter3);

        spinner46_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String anyvariable=String.valueOf(spinner46_4.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        String[] items4 = new String[]{"Not Selected","1. Yes", "2. No","3. Outside","-1. Not Applicable","-2. Unknown or not available","-3. Not recorded or inadequately described"};

        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items4);

        spinner46_5.setAdapter(adapter4);

        spinner46_5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String anyvariable=String.valueOf(spinner46_5.getSelectedItem());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button b = (Button) findViewById(R.id.next7);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                share.editor.putString("74",spinner46_1.getSelectedItem().toString());
                share.editor.putString("75",spinner46_2.getSelectedItem().toString());
               share.editor.putString("76",spinner46_3.getSelectedItem().toString());
                share.editor.putString("77",spinner46_4.getSelectedItem().toString());
               share.editor.putString("78",spinner46_5.getSelectedItem().toString());

                Intent i = new Intent(getApplicationContext(), PostAdmission.class);
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
