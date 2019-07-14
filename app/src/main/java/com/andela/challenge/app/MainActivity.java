/**
 * Author: Asante Foster
 * Email: asantefoster22@gmail.com
 * Phone:+2332459644406
 */

package com.andela.challenge.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /* init */

    private Button aboutButton, profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // -- Action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.label_action_title));
        actionBar.setDisplayShowHomeEnabled(true);


        /* xml  id */

        aboutButton = findViewById(R.id.aboutButton);
        profileButton = findViewById(R.id.myProfileButton);


        /* event listener */
        /* this listens to about button event */
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // intent

                Intent intent = new Intent(getApplicationContext(), ActivityB.class);
                startActivity(intent);

            }
        });

        /* this listens to my profile button event */
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // intent

                Intent intent = new Intent(getApplicationContext(), ActivityC.class);
                startActivity(intent);

            }
        });
    }
}
