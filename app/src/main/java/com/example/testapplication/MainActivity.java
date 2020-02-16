package com.example.testapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testapplication.Entity.User;
import com.example.testapplication.Utils.HttpUtil;
import com.example.testapplication.Utils.ResponseClass;
import com.example.testapplication.Utils.UrlString;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
     EditText account;
     EditText password;
     Gson gson= new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login=(Button) findViewById(R.id.button2);
        Button addAcount = findViewById(R.id.button3);
        account=(EditText)findViewById(R.id.edit_account);
        password=(EditText)findViewById(R.id.edit_password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           sendRequset();
            }
        });
        addAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
    private void sendRequset(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                User login=new User();
                login.setAccountCode(account.getText().toString());
                login.setPassword(password.getText().toString());
                login.setType(0);
                RequestBody requestBody=RequestBody.create(UrlString.JSON,gson.toJson(login));
//                Request request = new Request.Builder().url("http://192.168.43.50:8088/restaurant/user/login").post(requestBody).build();
                try{
//                    Response response = client.newCall(request).execute();
//                    showResponse(response);
                    HttpUtil.sendRequest(UrlString.systemUrl+"user/login", new Callback() {
                        @Override
                        public void onFailure(@NotNull Call call, @NotNull IOException e) {
                            Log.d("访问异常","登录异常");
                        }

                        @Override
                        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                            String str=response.body().string();
                            Type jsonType = new TypeToken<ResponseClass<User>>() {
                            }.getType();
                            ResponseClass responseClass=gson.fromJson(str,jsonType);
                            showResponse(responseClass);
                            Log.d(str,str);
                        }
                    },requestBody);
                }catch (Exception e){
                    Log.d("访问异常","响应异常");
                    e.printStackTrace();
                }
                finally {
                    Log.d("响应结束","响应结束");
                }

            }
        }).start();
    }

    private void showResponse(final ResponseClass responseClass){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
            try {
                if (responseClass.getCode()==0){
                    User user=(User) responseClass.getData();
                    account.setText(user.getName());
                }else {
                    Toast.makeText(MainActivity.this,responseClass.getMsg(),Toast.LENGTH_LONG).show();
                }

//               ResponseClass responseClass=gson.fromJson(str,ResponseClass.class);
//               Log.d("json转换",responseClass.getMsg());
            }catch (Exception e){
                e.printStackTrace();
            }
            }
        });
    }
}
