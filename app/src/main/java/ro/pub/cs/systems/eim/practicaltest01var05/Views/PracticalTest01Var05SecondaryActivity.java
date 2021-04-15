package ro.pub.cs.systems.eim.practicaltest01var05.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ro.pub.cs.systems.eim.practicaltest01var05.R;

public class PracticalTest01Var05SecondaryActivity extends AppCompatActivity {

    private TextView textView;
    private Button okButton, cancelButton;

    private PracticalTest01Var05SecondaryActivity.ButtonCLickListener buttonClickListener = new PracticalTest01Var05SecondaryActivity.ButtonCLickListener();
    private class ButtonCLickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.ok_button) {
                setResult(RESULT_OK, null);
            } else if(v.getId() == R.id.cancel_button) {
                setResult(RESULT_CANCELED, null);
            }

            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_secondary);


        textView = (TextView)findViewById(R.id.text);

        Intent intent = getIntent();

        if (intent != null && intent.getExtras().containsKey("TEXT")) {
            String text = intent.getStringExtra("TEXT");
            textView.setText(text);
        }

        okButton = (Button)findViewById(R.id.ok_button);
        cancelButton = (Button)findViewById(R.id.cancel_button);

        okButton.setOnClickListener(buttonClickListener);
        cancelButton.setOnClickListener(buttonClickListener);

    }
}