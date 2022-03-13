package ru.metaprofile.app;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.Objects;

import ru.metaprofile.app.APIUtils.Api.APIUtils;
import ru.metaprofile.app.MetaCache.TokenCache;

public class MainActivity extends AppCompatActivity {

    String tokenMeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        } catch (NullPointerException ignored) {
        }
        setContentView(R.layout.activity_main);

        EditText mp_id_input = findViewById(R.id.mp_id_input);
        EditText mp_password_input = findViewById(R.id.mp_password_input);
        Button mp_login_button = findViewById(R.id.mp_login_button);


        mp_login_button.setOnClickListener(new View.OnClickListener() {
            final APIUtils ApiUtils = new APIUtils();
            @Override
            public void onClick(View view) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            tokenMeta = ApiUtils.signIn(mp_id_input.getText().toString(), mp_password_input.getText().toString()).getToken();
                            TokenCache cacheToken = new TokenCache();
                            cacheToken.setToken(tokenMeta);

                            if(tokenMeta != null){
                                goToActivity(TestGetMe.class);
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    public void goToActivity(Class clazz){
        if(tokenMeta != null){
            Intent intent = new Intent(this, clazz);
            intent.putExtra("token", tokenMeta);
            startActivity(intent);
        }
    }
}