package com.tibaes.androidpaletteexample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class WidgetActivity extends AppCompatActivity {
    TextView txt;
    ProgressBar process;
    ProgressBar processTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);

        txt = (TextView) findViewById(R.id.txt_example_two);
        process = (ProgressBar) findViewById(R.id.pb_example);
        processTwo = (ProgressBar) findViewById(R.id.pb_example_two);

        // ------  Begin Button  ----------------------------
        Button button = (Button) findViewById(R.id.btn_example);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WidgetActivity.this, "Botão funcionando", Toast.LENGTH_LONG);
            }
        });

        // ------  End Button  ----------------------------

        // ------  Begin CheckedTextView  ----------------------------

        final CheckedTextView checkedTextView = (CheckedTextView) findViewById(R.id.ctv_example);
        checkedTextView.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                if(checkedTextView.isChecked()){
                    checkedTextView.setChecked(false);
                }
                else{
                    checkedTextView.setChecked(true);
                }
            }
        });

        // ------  End CheckedTextView  ----------------------------

        // ------  Begin Spinner  ----------------------------
        Spinner spinner = (Spinner) findViewById(R.id.s_example);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // ------  End Spinner  ----------------------------

        // ------  Begin SeekBar 1  ----------------------------

        SeekBar seekBar = (SeekBar) findViewById(R.id.sb_example);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int value = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                value = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


                txt.setText(Integer.toString(value)); // preenche o TextView com o valor do seek bar
                process.setProgress(value); // altera a posição do ponteiro do progresso para o valor do seek bar
                if (value >= 10)
                    process.setVisibility(View.INVISIBLE);
                else
                    process.setVisibility(View.VISIBLE);
            }
        });

        // ------  End SeekBar 1   ----------------------------

        // ------  Begin SeekBar 2  ----------------------------

        SeekBar seekBarTwo = (SeekBar) findViewById(R.id.sb_example_two);
        seekBarTwo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int value = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                value = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                txt.setText(Integer.toString(value)); // preenche o TextView com o valor do seek bar
                processTwo.setProgress(value); // seta o progresso 2 para o valo do seek bar
            }
        });

        // ------  End SeekBar 2   ----------------------------

        // ------  Begin Ratting Bar - Stars  ----------------------------

        final RatingBar ratingBar = (RatingBar) findViewById(R.id.rating_example);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                txt.setText(Float.toString(ratingBar.getRating())); // preenche o TextView com o valor do rating bar
            }
        });

        // ------  End Ratting Bar - Stars  ----------------------------

        // ------  Begin Helper buttons  ----------------------------

        Button btnOne = (Button) findViewById(R.id.btn_w_one);
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://developer.android.com/reference/android/widget/TextView.html"));
                startActivity(intent);
            }
        });

        Button btnTwo = (Button) findViewById(R.id.btn_w_two);
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://developer.android.com/reference/android/widget/Button.html"));
                startActivity(intent);
            }
        });

        Button btnThee = (Button) findViewById(R.id.btn_w_three);
        btnThee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://developer.android.com/guide/topics/ui/controls/togglebutton.html"));
                startActivity(intent);
            }
        });

        Button btnFour = (Button) findViewById(R.id.btn_w_four);
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://developer.android.com/reference/android/widget/Switch.html"));
                startActivity(intent);
            }
        });

        Button btnFive = (Button) findViewById(R.id.btn_w_five);
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://developer.android.com/guide/topics/ui/controls/checkbox.html"));
                startActivity(intent);
            }
        });

        Button btnSix = (Button) findViewById(R.id.btn_w_six);
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://developer.android.com/guide/topics/ui/controls/radiobutton.html"));
                startActivity(intent);
            }
        });

        Button btnSeven = (Button) findViewById(R.id.btn_w_seven);
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://developer.android.com/reference/android/widget/CheckedTextView.html"));
                startActivity(intent);
            }
        });

        Button btnEight = (Button) findViewById(R.id.btn_w_eight);
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://developer.android.com/guide/topics/ui/controls/spinner.html?hl=pt-br"));
                startActivity(intent);
            }
        });

        Button btnNine = (Button) findViewById(R.id.btn_w_nine);
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://developer.android.com/reference/android/widget/ProgressBar.html"));
                startActivity(intent);
            }
        });

        Button btnTen = (Button) findViewById(R.id.btn_w_ten);
        btnTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://developer.android.com/reference/android/widget/SeekBar.html"));
                startActivity(intent);
            }
        });

        Button btnEleven = (Button) findViewById(R.id.btn_w_eleven);
        btnEleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://developer.android.com/reference/android/widget/RatingBar.html"));
                startActivity(intent);
            }
        });

        // ------  End Helper buttons  ----------------------------

    }
}
