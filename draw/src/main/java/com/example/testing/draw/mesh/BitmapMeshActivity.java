package com.example.testing.draw.mesh;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.testing.draw.R;
import com.example.testing.draw.colormatrix.ImageHelper;

public class BitmapMeshActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_mesh);

        ImageView img = (ImageView) findViewById(R.id.img_mesh_test);
        img.setImageBitmap(ImageHelper.handleBitmapMesh(BitmapFactory.decodeResource(getResources(), R.drawable.color_matrix_test)));
    }


}
