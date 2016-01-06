package me.tbs.zhang.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import me.tbs.zhang.R;

/**
 * Created by dime on 16-1-6.
 */
public class LoginActivity extends Activity {

    EditText aname, pwd;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        aname = (EditText) findViewById(R.id.aname);
        pwd = (EditText) findViewById(R.id.pwd);
        btn = (Button) findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(aname.getText().toString().trim().equals("zhang") &&
                        pwd.getText().toString().trim().equals("123456")){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this, "请确认账号或密码是否正确！", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
