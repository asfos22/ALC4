/**
 * Author: Asante Foster
 * Email: asantefoster22@gmail.com
 * Phone:+2332459644406
 */

package com.andela.challenge.app;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class ActivityC extends AppCompatActivity {
    /**
     * init
     */

    private LinearLayout emailLinearLayout, callLinearLayout;
    private Button followMeButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_profile);

        /** XML */

        emailLinearLayout = findViewById(R.id.emailLinearLayout);
        callLinearLayout = findViewById(R.id.callLinearLayout);
        followMeButton = findViewById(R.id.followMeButton);

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

        /** OnClick Listener fellow me*/


        followMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // call twitter intent

                fellowMeIntent();
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

    /*** Follow me */

    void fellowMeIntent() {

        Intent intent;
        try {
            /** twitter app if user has it  */
            this.getPackageManager().getPackageInfo("com.twitter.android", 0); /**'com.twitter.android' is package name to check for twitter app**/
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/Andela?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();

            /** use doest not have twitter app installed therefore browser **/
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/Andela"));
        }

        /** this start intent*/
        this.startActivity(intent);
    }

}
