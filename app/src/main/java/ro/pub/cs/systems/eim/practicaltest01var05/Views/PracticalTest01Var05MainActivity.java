package ro.pub.cs.systems.eim.practicaltest01var05.Views;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ro.pub.cs.systems.eim.practicaltest01var05.R;
import ro.pub.cs.systems.eim.practicaltest01var05.General.Constants;

public class PracticalTest01Var05MainActivity extends AppCompatActivity {

    private Button nextActivity,topLeft, topRight, center, bottomLeft, bottomRight;
    private EditText editText;
    private Integer nrOfClicks = 0;

    //define event listner
    private ButtonCLickListener buttonClickListener = new ButtonCLickListener();
    private class ButtonCLickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {


            if(v.getId() != R.id.navigate_to_secondary_activity_button) {

                //Increase number of clicks
                nrOfClicks++;

                //Get button text
                Button b = (Button)v;
                String buttonText = b.getText().toString();

                //Get EditText Text

                String currentText = editText.getText().toString();

//                Concat current string with button text

                String result;
                if(!currentText.isEmpty()) {
                    result = currentText + ", " + buttonText;
                } else {
                    result = buttonText;
                }

                editText.setText(result);

            } else {
                //Navigate to secondary activity

                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var05SecondaryActivity.class);

                intent.putExtra("TEXT", editText.getText().toString());
                startActivityForResult(intent, 1);
            }



        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var05_main);


        //Get elements by id
        nextActivity = (Button)findViewById(R.id.navigate_to_secondary_activity_button);

        topLeft = (Button)findViewById(R.id.top_left_button);
        topRight = (Button)findViewById(R.id.top_right_button);

        center = (Button)findViewById(R.id.center_button);

        bottomLeft = (Button)findViewById(R.id.bottom_left_button);
        bottomRight = (Button)findViewById(R.id.bottom_right_button);

        editText = (EditText)findViewById(R.id.edit_text);

        //Add event listners to buttons

        nextActivity.setOnClickListener(buttonClickListener);

        topLeft.setOnClickListener(buttonClickListener);
        topRight.setOnClickListener(buttonClickListener);

        center.setOnClickListener(buttonClickListener);

        bottomLeft.setOnClickListener(buttonClickListener);
        bottomRight.setOnClickListener(buttonClickListener);


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("NR_CLICKS", String.valueOf(nrOfClicks));
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        nrOfClicks = Integer.parseInt(savedInstanceState.getString("NR_CLICKS"));

        Toast.makeText(getApplicationContext(), "Number of clicks: " + nrOfClicks, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            Toast.makeText(getApplicationContext(), "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();

            editText.setText(null);
            nrOfClicks = 0;
        }
    }
}