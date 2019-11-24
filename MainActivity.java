package com.senai.yuri.basicdialogfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String FRAGMENT_TAG_MAIN_DIALOG = MainDialogFragment.class.getSimpleName();

    DialogFragment newFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    void showDialog(){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_MAIN_DIALOG);

        if(fragment != null){
            ft.remove(fragment);
        }

        newFragment = MainDialogFragment.newInstance("LUCAS","CUIDADO COM OS GAMES...");
        newFragment.show(ft,FRAGMENT_TAG_MAIN_DIALOG);
    }

}
