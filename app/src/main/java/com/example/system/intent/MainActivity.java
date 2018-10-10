package com.example.system.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button =(Button)findViewById(R.id.button);
        final EditText editText=(EditText)findViewById(R.id.editText);
        final EditText editText2=(EditText)findViewById(R.id.editText2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                String ph="tel:"+editText.getText().toString();
                intent.setData(Uri.parse(ph));
                startActivity(intent);
            }
        });
        Button msg=(Button)findViewById(R.id.button2);
        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmsManager smsManager = SmsManager.getDefault();
                // smsManager.sendTextMessage("phoneNo",editText.getText().toString(), "sms message", null, null);
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.putExtra("sms_body",editText2.getText().toString());
                sendIntent.setType("vnd.android-dir/mms-sms");
                startActivity(sendIntent);
            }
        });
        Button browser=(Button)findViewById(R.id.button3);
        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http:/"+editText2.getText().toString()+".com"));
                startActivity(browserIntent);
            }
        });
        Button close=(Button)findViewById(R.id.button4);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

    }
}
