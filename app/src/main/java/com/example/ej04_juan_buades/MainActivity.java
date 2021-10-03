package com.example.ej04_juan_buades;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    ListView menuLateral;
    Web1fragment web1fragment = new Web1fragment();
    Web2fragment web2fragment = new Web2fragment();
    Modifyfragment modifyfragment = new Modifyfragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Mis Webs Favoritas");
        drawerLayout = findViewById(R.id.drawerlayout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        menuLateral = findViewById(R.id.menu_lateral);
        menuLateral.setOnItemClickListener(this );
        changeFirstView(0);
    }

    public void web1Receiver (String urlWeb1ToChange) {
        web1fragment.url1Modified (urlWeb1ToChange);
    }

    public void web2Receiver (String urlWeb2ToChange){
        web2fragment.url2Modified(urlWeb2ToChange);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.close:
                Toast.makeText(this,"Cerrando aplicacion",Toast.LENGTH_SHORT).show();
                break;
        }
        drawerToggle.onOptionsItemSelected(item);
        return true;
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        changeFirstView(i);
    }
    public void changeFirstView(int i) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction= fragmentManager.beginTransaction();
        switch (i) {
            case 0:
                transaction.replace(R.id.options, modifyfragment);
                break;
            case 1:
                transaction.replace(R.id.options, web1fragment);
                break;
            case 2:
                transaction.replace(R.id.options, web2fragment);
                break;
        }
        transaction.commit();
        drawerLayout.closeDrawer(GravityCompat.START);
    }
}
