package com.example.subramanyam.reciep;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class RecipList extends AppCompatActivity {
int pos,position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recip_list);
        position=getIntent().getIntExtra("id",pos);
        Bundle bundle=new Bundle();
        bundle.putInt("id",position);
        //set Fragmentclass Arguments
        ingredients ingredients=new ingredients();
        ingredients.setArguments(bundle);


init(ingredients);

    }
    public void init(android.support.v4.app.Fragment fragment)
    {
        android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ingrediantsList,fragment);
        fragmentTransaction.commit();
    }
}
