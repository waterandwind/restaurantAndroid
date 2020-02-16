package com.example.testapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {
EditText account;
EditText password1;
EditText password2;
EditText telephone;
EditText name;
Button addAccount;
boolean flag[] = new boolean[5];
    Gson gson= new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

    }
    void init(){
        flag[3]=true;
        account=findViewById(R.id.edit_account);
        password1=findViewById(R.id.edit_password);
        password2=findViewById(R.id.edit_password2);
        telephone=findViewById(R.id.edit_telephone);
        name=findViewById(R.id.edit_name);
        addAccount=findViewById(R.id.button2);
        addAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag[0]&&flag[1]&&flag[2]&&flag[3]&&flag[4]){
                    sendRequest();
                }else {
                    Toast.makeText(RegisterActivity.this,"未完善信息",Toast.LENGTH_LONG).show();
                }
            }
        });
        account.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String accountText=account.getText().toString();
                if (!accountText.matches("^[\\da-zA-Z]{6,10}$")){
                    account.setError("账号输入错误，6-10位数字或字母");
                    flag[0]=false;
                }else {
                    flag[0]=true;
                }

            }
        });
        telephone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String phone=telephone.getText().toString();
                if (phone.length()!=0&&!phone.matches("^[1][3,4,5,7,8][0-9]{9}$")){
                    telephone.setError("电话号码有误");
                    flag[3]=false;
                }else {
                    flag[3]=true;
                }
            }
        });
        password1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String password1Text=password1.getText().toString();
                if (!password1Text.matches("^[\\da-zA-Z]{4,12}$")){
                    password1.setError("密码有误，4-12位字母或者数字");
                    flag[1]=false;
                }else {
                    flag[1]=true;
                }
            }
        });
        password2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password2Text=password2.getText().toString();
                String password1Text=password1.getText().toString();
                if(!password2Text.equals(password1Text)){
                    password2.setError("密码不一致");
                    flag[2]=false;
                }else {
                    flag[2]=true;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String nameText=name.getText().toString();
                if (nameText==null||nameText.length()==0){
                    name.setError("未输入名字");
                    flag[4]=false;
                }else {
                    flag[4]=true;
                }
            }
        });

    }

    User getUser(){
        User user=new User();
        user.setType(0);
        user.setAccountCode(account.getText().toString());
        user.setName(name.getText().toString());
        user.setPassword(password1.getText().toString());
        user.setPhone(telephone.getText().toString());
        return user;
    }

    private void sendRequest(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();

                RequestBody requestBody=RequestBody.create(UrlString.JSON,gson.toJson(getUser()));
                try{
                    HttpUtil.sendRequest(UrlString.systemUrl+"user", new Callback() {
                        @Override
                        public void onFailure(@NotNull Call call, @NotNull IOException e) {
                            Log.d("访问异常","注册出错");
                        }

                        @Override
                        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                            String str=response.body().string();
                            Type jsonType = new TypeToken<ResponseClass<User>>() {
                            }.getType();
                            ResponseClass responseClass=gson.fromJson(str,jsonType);
                            Log.d(str,str);
                            result(responseClass);
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

    private void result(final ResponseClass responseClass){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (responseClass.getCode()==0){
                    Toast.makeText(RegisterActivity.this,responseClass.getMsg(),Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(RegisterActivity.this,responseClass.getMsg(),Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
