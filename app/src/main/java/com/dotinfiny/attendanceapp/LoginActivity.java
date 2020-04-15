package com.dotinfiny.attendanceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.dotinfiny.attendanceapp.ApiClient.ApiClient;
import com.dotinfiny.attendanceapp.ApiClient.Apis;
import com.dotinfiny.attendanceapp.ApiResponseModel.Login;
import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ImageView imageView;
    Button loginBtn;

    EditText email, password;

    Apis client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        imageView = findViewById(R.id.logo);
        loginBtn = findViewById(R.id.btn_login);

        email = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);

        client = ApiClient.getClient().create(Apis.class);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailString = email.getText().toString().trim();
                String passwordString = password.getText().toString().trim();
                if (TextUtils.isEmpty(emailString) || TextUtils.isEmpty(passwordString)) {
                    Toast.makeText(LoginActivity.this, "please enter email and password", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if (userValid(emailString, passwordString)) {

                    } else {
                        Toast.makeText(LoginActivity.this, "incorrect email or password", Toast.LENGTH_SHORT).show();
                    }
                }
//
//                startActivity(new Intent(LoginActivity.this, DashBoardActivity.class));
//                finish();
            }
        });
    }

    private boolean userValid(String email, String password) {
        if (email.equalsIgnoreCase("Asher@dotinfiny.com") &&
                password.equalsIgnoreCase("asher")) {
            return true;
        } else if (email.equalsIgnoreCase("Rafay@dotinfiny.com") &&
                password.equalsIgnoreCase("rafay")) {
            return true;
        } else if (email.equalsIgnoreCase("Nabeel@dotinfiny.com") &&
                password.equalsIgnoreCase("nabeel")) {
            return true;
        } else {
            return false;
        }
    }

    private String getuserName(String email) {
        if (email.equalsIgnoreCase("Asher@dotinfiny.com")) {
            return "Muhammad Asher Ansari";
        } else if (email.equalsIgnoreCase("Rafay@dotinfiny.com")) {
            return "Syed Abdul Rafay";
        } else if (email.equalsIgnoreCase("Nabeel@dotinfiny.com")) {
            return "Syed Nabeel Hasnain Zaidi";
        } else {
            return "Some thing wrong";
        }
    }

    private void login(String emailString, String uuid) {
        Call<Login> call = client.userLogin("login", emailString, uuid, getuserName(emailString));
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.body() != null) {
                    if (response.code() == 401) {
                        Toast.makeText(LoginActivity.this, "Your are already loign to oterh device", Toast.LENGTH_SHORT).show();
                    } else if (response.code() == 200) {

                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Some thing wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Some thing wrong please check internet connectivity", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void logoutAlert() {

    }

    private void logoutApi(String userId) {
        Call<JsonElement> call = client.userLogout("logout", userId);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                if (response.body() != null) {
                    if (response.body().getAsJsonObject().get("message") != null) {
                        Toast.makeText(LoginActivity.this, "" + response.body().getAsJsonObject().get("message"), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "logout successful", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Some thing wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Some thing wrong please check internet connectivity", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
