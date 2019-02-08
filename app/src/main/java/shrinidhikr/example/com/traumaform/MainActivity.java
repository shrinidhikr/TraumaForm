package shrinidhikr.example.com.traumaform;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import shrinidhikr.example.com.traumaform.share;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

      Button sb1,sb2;
      EditText st1,st2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sb1=(Button) findViewById(R.id.shributton);

        sb2=(Button) findViewById(R.id.shributton2);


        st1=(EditText) findViewById(R.id.shri);
        st2=(EditText) findViewById(R.id.shri2);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home Page");


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        sb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!st1.getText().toString().equals("") || !(st1.getText().toString() == null) && !st1.getText().toString().isEmpty()) {
                    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("Partial Reg");
                    DatabaseReference userNameRef = rootRef.child(st1.getText().toString());

                    Log.d("Textst1", st1.getText().toString());
                    ValueEventListener eventListener = new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                Toast.makeText(getApplicationContext(), "Partial form found",
                                        Toast.LENGTH_LONG).show();
                               // FetchPartial.FetchP(st1.getText().toString());
                                Intent i = new Intent(getApplicationContext(), BasicDetails.class);
                                i.putExtra("Reg_id", st1.getText().toString());
                                i.putExtra("Parent", "P");
                                startActivity(i);
                            } else
                                Toast.makeText(getApplicationContext(), "Not found",
                                        Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.d("Ta", databaseError.getMessage()); //Don't ignore errors!
                        }
                    };
                    userNameRef.addListenerForSingleValueEvent(eventListener);
                }
                else Toast.makeText(getApplicationContext(), "Enter value",
                        Toast.LENGTH_LONG).show();
            }

        });

        sb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!st2.getText().toString().equals("") ||!( st2.getText().toString() == null) && !st2.getText().toString().isEmpty()) {

                    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("Complete Reg");
                    DatabaseReference userNameRef = rootRef.child(st2.getText().toString());

                    ValueEventListener eventListener = new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                Toast.makeText(getApplicationContext(), "Complete form found",
                                        Toast.LENGTH_LONG).show();
                             //   FetchComplete.FetchC(st2.getText().toString());
                                Intent i = new Intent(getApplicationContext(), BasicDetails.class);
                                i.putExtra("Reg_id", st2.getText().toString());
                                i.putExtra("Parent", "C");
                                startActivity(i);
                            } else
                                Toast.makeText(getApplicationContext(), "Not found",
                                        Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.d("Ta", databaseError.getMessage()); //Don't ignore errors!
                        }
                    };
                    userNameRef.addListenerForSingleValueEvent(eventListener);
                }

                else Toast.makeText(getApplicationContext(), "Enter value",
            Toast.LENGTH_LONG).show();
            }

        });





    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
           int id = item.getItemId();

        if (id == R.id.nav_part) {
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_basic) {
            Intent i = new Intent(getApplicationContext(),BasicDetails.class);
            i.putExtra("Parent","Nav");
            startActivity(i);
        } else if (id == R.id.nav_logout) {
            Intent i = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(i);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}