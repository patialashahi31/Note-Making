package com.patialashahi.mynotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    int noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText editText = (EditText)findViewById(R.id.editText);
        Intent intent =getIntent();
        noteId = intent.getIntExtra("noteId",-1);
        if (noteId!= -1){
            editText.setText(MainActivity.notes.get(noteId));

        }else {
            MainActivity.notes.add("");
            noteId = MainActivity.notes.size() -1;
            MainActivity.arrayAdapter.notifyDataSetChanged();
        }
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                MainActivity.notes.set(noteId,String.valueOf(charSequence));
                MainActivity.arrayAdapter.notifyDataSetChanged();

            }

           @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
