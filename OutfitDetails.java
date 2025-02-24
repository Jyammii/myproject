package com.example.closetifiy_finalproject;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class OutfitDetails extends AppCompatActivity {

    private ImageView canvasFitsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outfitdetails);

        canvasFitsImageView = findViewById(R.id.canvasfits);

        List<CanvasItem> canvasItems = getIntent().getParcelableArrayListExtra("canvasItems");

        if (canvasItems != null) {
            for (CanvasItem item : canvasItems) {
                ImageView imageView = new ImageView(this);
                imageView.setImageURI(item.getUri());
                ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(item.getWidth(), item.getHeight());
                params.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
                params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
                params.leftMargin = (int) item.getLeft();
                params.topMargin = (int) item.getTop();
                imageView.setLayoutParams(params);

                // Add the ImageView to the parent of canvasFitsImageView
                ((ConstraintLayout) canvasFitsImageView.getParent()).addView(imageView);
            }
        }
    }
}