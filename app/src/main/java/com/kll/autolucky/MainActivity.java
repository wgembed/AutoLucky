package com.kll.autolucky;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bt_start;

    private String string_banner_id = null;
    private int int_banner_qty = 0;
    private String string_interstital_id = null;
    private int int_interstital_qty = 0;
    private int int_delay_time = 0;

    final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences sp = MainActivity.this.getSharedPreferences( "config", Context.MODE_PRIVATE );

        bt_start = (Button) findViewById(R.id.start);
        bt_start.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //banner  interstital  timer
            EditText et_banner_id = (EditText) findViewById( R.id.banner_id );
            EditText et_banner_qty = (EditText) findViewById( R.id.banner_qty );
            EditText et_interstital_id = (EditText) findViewById( R.id.interstitial_id);
            EditText et_interstital_qty = (EditText) findViewById( R.id.interstitial_qty);
            EditText et_delay_timer = (EditText) findViewById( R.id.delay_timer );

            if (TextUtils.isEmpty(et_banner_id.getText()) ||
                TextUtils.isEmpty(et_banner_qty.getText()) ||
                TextUtils.isEmpty(et_interstital_id.getText()) ||
                TextUtils.isEmpty(et_interstital_qty.getText()) ||
                TextUtils.isEmpty(et_delay_timer.getText())) {
                Toast.makeText( MainActivity.this, "输入不能留空", Toast.LENGTH_SHORT ).show();
            } else {
                string_banner_id = et_banner_id.getText().toString();
                int_banner_qty = Integer.parseInt( et_banner_qty.getText().toString() );
                string_interstital_id = et_interstital_id.getText().toString();
                int_interstital_qty = Integer.parseInt( et_interstital_qty.getText().toString() );
                int_delay_time = Integer.parseInt( et_delay_timer.getText().toString() );

                Log.i( TAG, "onClick: string_banner_id: " + string_banner_id );
                Log.i( TAG, "onClick: int_banner_qty: "+ int_banner_qty );
                Log.i( TAG, "onClick: string_interstital_id: "+ string_interstital_id );
                Log.i( TAG, "onClick: int_interstital_qty: "+ int_interstital_qty );
                Log.i( TAG, "onClick: int_delay_time: "+ int_delay_time );

                //先将输入的参数存起来(banner id/qty  interstitial id/qty  timer)
                SharedPreferences.Editor editor = sp.edit();

                editor.putString( "banner_id", string_banner_id );
                editor.putInt( "banner_qty", int_banner_qty );
                editor.putString( "interstital_id", string_interstital_id );
                editor.putInt( "interstital_qty", int_interstital_qty );
                editor.putInt( "delay_timer", int_delay_time );

                editor.commit();

                Toast.makeText(MainActivity.this, R.string.app_name, Toast.LENGTH_SHORT).show();
//               startActivity(new Intent(MainActivity.this, FirstActivity.class));
            }
            }
        });
    }
}
