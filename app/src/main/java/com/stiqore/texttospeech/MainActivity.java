package com.stiqore.texttospeech;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText txtfield;
    Button btnsubmit;
    String capturedText;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtfield=findViewById(R.id.textMultiLine);
        btnsubmit=findViewById(R.id.submitButton);

        textToSpeech=new TextToSpeech(this,status->{
            if( status== TextToSpeech.SUCCESS){
                textToSpeech.setLanguage(Locale.CHINESE);
            }
        });

        btnsubmit.setOnClickListener(v->{
            capturedText=txtfield.getText().toString();

            textToSpeech.speak(capturedText,TextToSpeech.QUEUE_FLUSH,null,null);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}