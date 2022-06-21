package com.college.quiz1_question;

import static android.Manifest.permission.CALL_PHONE;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG="MainActivity";
    // EditText view for the website URI
    private EditText mWebsiteEditText;
    // EditText view for the location URI
    private EditText mLocationEditText;
    // EditText view for the share text
    private EditText mShareTextEditText;
    //EditText for Dial action
    private EditText mDialEditText;

    String website_link;
    String location;
    String shared_text;
    String  number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_editext);
        mShareTextEditText = findViewById(R.id.share_edittext);
        mDialEditText = findViewById(R.id.phone_edittext);
    }

    // TODO
    /**
     * Handles the onClick for the "Open Website" button.  Gets the URI
     * from the edit text and sends an implicit intent for that URL.
     *
     * @param view The view (Button) that was clicked.
     */
    public void openWebsite(View view) {
        website_link=mWebsiteEditText.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(website_link));
        startActivity(intent);
    }

    // TODO
    /**
     * Handles the onClick for the "Open Location" button.  Gets the location
     * text from the edit text and sends an implicit intent for that location.
     *
     * The location text can be any searchable geographic location.
     *
     * @param view The view (Button) that was clicked.
     */
    public void openLocation(View view) {
        location=mLocationEditText.getText().toString();
        Uri gmmIntentUri = Uri.parse("google.navigation:q="+location);
        Intent mapintent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
        mapintent.setPackage("com.google.android.apps.maps");
        startActivity(mapintent);
    }

    // TODO
    /**
     * Handles the onClick for the "Share This Text" button.  The
     * implicit intent here is created by the  {@link ShareCompat.IntentBuilder}
     * class.  An app chooser appears with the available options for sharing.
     *
     * ShareCompat.IntentBuilder is from the v4 Support Library.
     *
     * @param view The view (Button) that was clicked.
     */
    public void shareText(View view) {
        shared_text= mShareTextEditText.getText().toString();
        new ShareCompat.IntentBuilder(MainActivity.this)
                .setType("text/plain")
                .setChooserTitle("Share text with: ")
                .setText(shared_text)
                .startChooser();
    }

    // TODO
    /**
     * Handles the onClick for the "View Contacts" button.
     *
     * @param view The view (Button) that was clicked.
     */
    public void viewContact(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI);
        startActivity(intent);
    }

    // TODO
    /**
     * Handles the onClick for the "Dial" button.
     *
     * @param view The view (Button) that was clicked.
     */
    public void dial(View view) {
        Toast.makeText(MainActivity.this,"Test",Toast.LENGTH_SHORT).show();

        number = mDialEditText.getText().toString();
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+number));

        if(ContextCompat.checkSelfPermission(MainActivity.this, CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
            startActivity(intent);
        }else {
            requestPermissions(new String[]{CALL_PHONE}, 1);
        }

    }
}