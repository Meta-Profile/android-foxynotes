package ru.metaprofile.app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import ru.metaprofile.app.APIUtils.Api.APIUtils;
import ru.metaprofile.app.APIUtils.Models.GetMe.GetMeResponse;

public class TestGetMe extends AppCompatActivity {

    String tokenMeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_get_me);

        TextView metaIdTextView = findViewById(R.id.test_meta_id_text);
        TextView metaEmailTextView = findViewById(R.id.test_meta_email_text);

        Bundle arguments = getIntent().getExtras();

        if(arguments!=null){
            tokenMeta = arguments.get("token").toString();
        }

        APIUtils ApiUtils = new APIUtils();

        try {
            GetMeResponse metaUserMe = ApiUtils.getUserMe(tokenMeta);
            metaIdTextView.setText(metaUserMe.getMetaId());
            metaEmailTextView.setText(metaUserMe.getEmail());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}