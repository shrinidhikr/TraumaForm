package shrinidhikr.example.com.traumaform;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

import static shrinidhikr.example.com.traumaform.share.auth;
import static shrinidhikr.example.com.traumaform.share.editor;


class Addinjury extends AppCompatActivity {

	String Body_Region, Diagnosis, AIS_Code, ICD_10;
	
	Addinjury(String Body_Region,String Diagnosis,String AIS_Code,String ICD_10){
		
		this.Body_Region=Body_Region;
		this.Diagnosis=Diagnosis;
		this.AIS_Code=AIS_Code;
		this.ICD_10=ICD_10;
	}
    public String toString()

    {
        return "Body_Region: "+Body_Region+"\n"+"Diagnosis: "+Diagnosis+"\n"+"AIS_Code: "+AIS_Code+"\n"+"ICD-10: "+ICD_10;
    }

} 


public class InjuryCodingData extends AppCompatActivity {

    Button b;
    int flag=0;
    ArrayList<Addinjury> listitems;
    ArrayAdapter<Addinjury> adapter;
    String anyvariable=" ";
    String res=" ";
    ListView list;
    TextView tx;
    String[] items = {"Not Selected", "1. Yes","2. No","-1. Not Applicable","-2. Unknown or not available","-3. Not recorded or inadequately described"};

    DatabaseReference FinalPush,Regpush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_injury_data);
        getSupportActionBar().setTitle("Injury Coding Data");
        listitems = new ArrayList<Addinjury>();
        adapter = new ArrayAdapter<Addinjury>(this,
                R.layout.injurylist, listitems);
        list = (ListView) findViewById(R.id.list1);
        list.setAdapter(adapter);


        b = (Button) findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(InjuryCodingData.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_injury_coding_data, null);
                final EditText aiscode = (EditText) mView.findViewById(R.id.aiscode);
                final EditText icd = (EditText) mView.findViewById(R.id.icd);
                final EditText diagnosis = (EditText) mView.findViewById(R.id.diagnosis);

               final Spinner spinner11 = (Spinner) mView.findViewById(R.id.spinner56);

                ArrayAdapter<String> adapter1 = new ArrayAdapter<>(InjuryCodingData.this, android.R.layout.simple_spinner_dropdown_item, items);

                spinner11.setAdapter(adapter1);

                spinner11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                               long arg3) {
                         anyvariable=String.valueOf(spinner11.getSelectedItem());


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

                Button AddAnInjury = (Button) mView.findViewById(R.id.Add);
                mBuilder.setTitle("Injury Coding Data");
                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();

                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = 1000;
                lp.height = 1500;
                dialog.getWindow().setAttributes(lp);

                AddAnInjury.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if(anyvariable.isEmpty() || diagnosis.getText().toString().isEmpty() || aiscode.getText().toString().isEmpty() || icd.getText().toString().isEmpty())   {

                            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Please fill empty details",Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }

                        else {
                            dialog.dismiss();
                            Addinjury ae = new Addinjury(anyvariable,diagnosis.getText().toString(),aiscode.getText().toString(),icd.getText().toString());
                            listitems.add(ae);
                            adapter.notifyDataSetChanged();
                          
                        }

                    }
                });
            }
        });

        Button FinalSubmitToFirebase = (Button)findViewById(R.id.finalsubmit);

        FinalSubmitToFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                auth = getApplicationContext().getSharedPreferences("0001", Context.MODE_PRIVATE);
                Map<String,?> keys = auth.getAll();
                Log.e("Keys",keys.toString());


               for(Map.Entry<String,?> entry : keys.entrySet()) {
                    String k = (String) entry.getValue();

                    if (k.equals("")||k == null && k.isEmpty()||k.equals("Not Selected")||k=="") {
                        flag = 1;
                        Log.e("Partial1", "True" + entry.getValue()+String.valueOf(flag));
                        break;

                    } else {
                        Log.e("Partial1", "False" + entry.getValue()+String.valueOf(flag));
                    }
                }

                if (flag==1){
                    FinalPush = FirebaseDatabase.getInstance().getReference("Partial Database");

                    for(Map.Entry<String,?> entry : keys.entrySet()) {
                        String K = (String) entry.getKey();
                        String V = (String) entry.getValue();

                        if (K.equals("3") || K == "3") {
                            res = V;
                            Log.e("REG", K + V);
                            Regpush = FirebaseDatabase.getInstance().getReference("Partial Reg");
                            Regpush.child(V).setValue(V);

                        }
                    }
                    for(Map.Entry<String,?> entry : keys.entrySet()) {
                        String K = (String) entry.getKey();
                        String V = (String) entry.getValue();


                        FinalPush.child("R"+res).child(K).setValue(V);
                    }
                }
                else {
                    FinalPush = FirebaseDatabase.getInstance().getReference("Complete Database");
                    for (Map.Entry<String,?> entry : keys.entrySet()) {
                        String K = (String) entry.getKey();
                        String V = (String) entry.getValue();

                        if (K == "3" || K.equals("3")) {
                            res = V;
                            Regpush = FirebaseDatabase.getInstance().getReference("Complete Reg");
                            Regpush.child(V).setValue(V);

                        }
                    }
                    for(Map.Entry<String,?> entry : keys.entrySet()) {
                        String K = (String) entry.getKey();
                        String V = (String) entry.getValue();


                        FinalPush.child("R"+res).child(K).setValue(V);
                    }
                    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("Complete Reg");
                    try {
                        DatabaseReference itemsRef = rootRef.child(res);
                        ValueEventListener eventListener = new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                Log.e("kess", dataSnapshot.toString());
                                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                    String link = ds.getValue(String.class);
                                    Log.e("TAG", link);
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {}
                        };
                        itemsRef.addListenerForSingleValueEvent(eventListener);

                        Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_LONG).show();

                        auth = getApplicationContext().getSharedPreferences("0001", Context.MODE_PRIVATE);
                        editor = auth.edit();

                        for(int i=1;i<=116;i++)
                            editor.putString(String.valueOf(i),"");
                        editor.apply();

                        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Partial Reg");
                        Query applesQuery = ref.child(res).equalTo(res);

                        applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                                    appleSnapshot.getRef().removeValue();
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                                Log.e("TAG", "onCancelled", databaseError.toException());
                            }
                        });

                        DatabaseReference ref1 = FirebaseDatabase.getInstance().getReference("Partial Database");
                        Query applesQuery1 = ref.child("R"+res);

                        applesQuery1.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                                    appleSnapshot.getRef().removeValue();
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                                Log.e("TAG", "onCancelled", databaseError.toException());
                            }
                        });
                    }
                    catch(Exception e) {
                        Toast.makeText(getApplicationContext(),"Unsuccessful",Toast.LENGTH_LONG).show();
                    }
                }
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);

            }
        });

    }
}

