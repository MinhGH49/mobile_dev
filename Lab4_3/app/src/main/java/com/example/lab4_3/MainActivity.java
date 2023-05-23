package com.example.lab4_3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button save, cancel, change;
    RadioGroup gender;
    EditText name, email, phone;
    ImageView avatar;
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    private static final String URI_INSTANCE_STATE_KEY = "saved_uri";

    File photoFile = null;
    private Uri mImageCaptureUri;
    private boolean isTakenFromCamera;
    private Bitmap rotatedBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save = (Button) findViewById(R.id.save);
        cancel = (Button) findViewById(R.id.cancel);
        change = (Button) findViewById(R.id.change);
        gender = (RadioGroup) findViewById(R.id.gender);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        avatar = (ImageView) findViewById(R.id.avatar);

        change.setOnClickListener(this::onClick);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        checkPermissions();
        loadAvatar();


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.change) {
            captureAvatar();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }
    protected void captureAvatar() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        try {
            photoFile = createImageFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (photoFile != null) {
            Uri photoURI = FileProvider.getUriForFile(this,
                    BuildConfig.APPLICATION_ID,
                    photoFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
            startActivityIntent.launch(intent);
        }


    }

    protected void onActivityResult(int reqCode, int resCode, Intent intent) {

        super.onActivityResult(reqCode, resCode, intent);
        if (reqCode == pic_id) {
            Bitmap photo = (Bitmap) intent.getExtras().get("data");
            avatar.setImageBitmap(photo);

        }

    }

    private void checkPermissions() {
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_REQUEST_CODE);
        }
    }

    private void loadAvatar() {
        try {
            FileInputStream fileInputStream = openFileInput(getString(R.string.avatar_file_name));
            Bitmap bitmap = BitmapFactory.decodeStream(fileInputStream);
            avatar.setImageBitmap(bitmap);
            fileInputStream.close();
        } catch (IOException e) {
            avatar.setImageResource(R.drawable.myface);
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the image capture uri before the activity goes into background
        outState.putParcelable(URI_INSTANCE_STATE_KEY, mImageCaptureUri);
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
        return image;
    }
    private ActivityResultLauncher<Intent> startActivityIntent = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() != RESULT_OK) return;
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(photoFile);
                        Bitmap bitmap =  result.getData().getExtras().ge
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            });

    private void saveProfile() {
        avatar
    }
}