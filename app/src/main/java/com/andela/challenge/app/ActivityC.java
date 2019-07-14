/**
 * Author: Asante Foster
 * Email: asantefoster22@gmail.com
 * Phone:+2332459644406
 */

package com.andela.challenge.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class ActivityC extends AppCompatActivity {
    /**
     * int
     */

    private LinearLayout emailLinearLayout, callLinearLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_profile);

        /** XML */

        emailLinearLayout = findViewById(R.id.emailLinearLayout);
        callLinearLayout = findViewById(R.id.callLinearLayout);

        /** OnClick Listener call */
        emailLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // email intent
                emailIntent();
            }
        });

        /** OnClick Listener phone*/
        callLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // call intent
                callIntent();
            }
        });


    }

    /**
     * call intent
     **/

    public void callIntent() {

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:233245964406"));
        startActivity(intent);
    }

    /*** email intent */

    public void emailIntent() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "asantefoster22@gmail.com"));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Andela job application feedback");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hi Asante, You have qualify  to be employed by Andela.");
        startActivity(Intent.createChooser(emailIntent, "Chooser Title"));
    }

}
