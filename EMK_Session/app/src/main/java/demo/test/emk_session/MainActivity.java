package demo.test.emk_session;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    //Explicit Intent
    public void sendIntent(View view) {

        Intent ExplicitIntent = new Intent(MainActivity.this,NewActivity.class);
        startActivity(ExplicitIntent);
    }
//Implicit Intent
    public void sendImplicitIntent(View view) {
        Intent intentImp = new Intent(Intent.ACTION_SEND);
        intentImp.setType("Text/Plain");
        intentImp.putExtra(Intent.EXTRA_TEXT,"Hello world");
        startActivity(intentImp.createChooser(intentImp,"Share Message Using"));
    }

    public void NotificationClick(View view) {
        Intent intent = new Intent(MainActivity.this,Notification.class);
        startActivity(intent);
    }
}
