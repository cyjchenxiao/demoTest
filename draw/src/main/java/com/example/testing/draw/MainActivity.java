package com.example.testing.draw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testing.draw.colormatrix.ColorMatrixActivity;
import com.example.testing.draw.colormatrix.ColorMatrixApiActivity;
import com.example.testing.draw.colormatrix.ImagePixelsActivity;
import com.example.testing.draw.matrix.MatrixApiActivity;
import com.example.testing.draw.mesh.BitmapMeshActivity;
import com.example.testing.draw.ondraw.panel.PanelActivity;
import com.example.testing.draw.porterDuffXfermode.PorterDuffXfermodeActivity_01;
import com.example.testing.draw.shader.ReflectView;
import com.example.testing.draw.shader.ShaderActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPanel = (Button) findViewById(R.id.btn_draw_panel);
        btnPanel.setOnClickListener(this);

        Button btnLayer = (Button) findViewById(R.id.btn_draw_layer);
        btnLayer.setOnClickListener(this);

        Button btnColorMatrix1 = (Button) findViewById(R.id.btn_color_matrix_api);
        btnColorMatrix1.setOnClickListener(this);

        Button btnColorMatrix2 = (Button) findViewById(R.id.btn_color_matrix);
        btnColorMatrix2.setOnClickListener(this);

        Button btnImgPixels = (Button) findViewById(R.id.btn_image_pixels);
        btnImgPixels.setOnClickListener(this);

        Button btnMatrix = (Button) findViewById(R.id.btn_matrix);
        btnMatrix.setOnClickListener(this);

        Button btnMesh = (Button) findViewById(R.id.btn_mesh);
        btnMesh.setOnClickListener(this);

        Button btnPorterDuffXCircle = (Button) findViewById(R.id.btn_porterduffx01);
        btnPorterDuffXCircle.setOnClickListener(this);

        Button btnReflectView = (Button) findViewById(R.id.btn_reflectview);
        btnReflectView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_draw_panel:
                startActivity(new Intent(this, PanelActivity.class));
                break;

            case R.id.btn_draw_layer:
                startActivity(new Intent(this, PanelActivity.class));
                break;

            case R.id.btn_color_matrix_api:
                startActivity(new Intent(this, ColorMatrixApiActivity.class));
                break;

            case R.id.btn_color_matrix:
                startActivity(new Intent(this, ColorMatrixActivity.class));
                break;

            case R.id.btn_image_pixels:
                startActivity(new Intent(this, ImagePixelsActivity.class));
                break;

            case R.id.btn_matrix:
                startActivity(new Intent(this, MatrixApiActivity.class));
                break;

            case R.id.btn_mesh:
                startActivity(new Intent(this, BitmapMeshActivity.class));
                break;

            case R.id.btn_porterduffx01:
                startActivity(new Intent(this, PorterDuffXfermodeActivity_01.class));
                break;

            case R.id.btn_reflectview:
                startActivity(new Intent(this, ShaderActivity.class));
                break;
        }
    }
}
