package ru.metaprofile.app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.metaprofile.app.MetaCache.TokenCache;

public class TestGetMe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_get_me);

        TextView metaIdTextView = findViewById(R.id.test_meta_id_text);
        TextView metaEmailTextView = findViewById(R.id.test_meta_email_text);

        TokenCache tokenCache = new TokenCache();
        String token = tokenCache.getToken();

        System.out.println(token);

    }
}