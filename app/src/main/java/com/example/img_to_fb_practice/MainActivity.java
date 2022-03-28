package com.example.img_to_fb_practice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;

    private Button buttonChooseImage,buttonUploadImage;
    private TextView textViewShowUploads;
    private EditText editTextFileName;
    private ImageView imageView;
    private ProgressBar progressBar;

    private Uri mImageUri;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonChooseImage = findViewById(R.id.button_choose_image);
        buttonUploadImage = findViewById(R.id.button_upload_image);
        textViewShowUploads = findViewById(R.id.text_view_show_uploads);
        editTextFileName = findViewById(R.id.edit_text_file_name);
        imageView = findViewById(R.id.image_view);
        progressBar = findViewById(R.id.progress_bar);

        buttonChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChoose();

            }
        });
        buttonUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        textViewShowUploads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }

    private void openFileChoose() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            mImageUri = data.getData();

            Picasso.with(this).load(mImageUri).into(imageView);
        }
    }
}
