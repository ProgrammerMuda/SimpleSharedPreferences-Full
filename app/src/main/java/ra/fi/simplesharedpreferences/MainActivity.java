package ra.fi.simplesharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, btnClear;
    EditText edtUser, edtPass;
    public static final String KEYPREF = "Key Preferences";
    public static final String KEYUSERNAME = "Key Username";
    public static final String KEYPASSWORD = "Key Password";
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnlogin);
        btnClear = findViewById(R.id.btnclear);
        edtUser = findViewById(R.id.username);
        edtPass = findViewById(R.id.pass);

        preferences = getSharedPreferences(KEYPREF, Context.MODE_PRIVATE);
        if (preferences.contains(KEYUSERNAME) && (preferences.contains(KEYPASSWORD))){
            edtUser.setText(preferences.getString(KEYUSERNAME, ""));
            edtPass.setText(preferences.getString(KEYPASSWORD, ""));

        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString();
                String pass = edtPass.getText().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(KEYUSERNAME, user);
                editor.putString(KEYPASSWORD, pass);
                editor.apply();
                Toast.makeText(MainActivity.this, "UserName dan Password disimpan", Toast.LENGTH_SHORT).show();
            }
            
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtUser.setText("");
                edtPass.setText("");
            }
        });

    }
}
