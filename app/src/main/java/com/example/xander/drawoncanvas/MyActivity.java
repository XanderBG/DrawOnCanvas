package com.example.xander.drawoncanvas;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


public class MyActivity extends Activity {

    private BitmapDrawable selectedBrush;
    private CanvasView canvasView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        ImageButton leftButton = (ImageButton) findViewById(R.id.leftButton);
        ImageButton centerButton = (ImageButton) findViewById(R.id.centerButton);
        ImageButton rightButton = (ImageButton) findViewById(R.id.rightButton);

        ImageDrawListener imageDrawListener = new ImageDrawListener();

        leftButton.setOnClickListener(imageDrawListener);
        centerButton.setOnClickListener(imageDrawListener);
        rightButton.setOnClickListener(imageDrawListener);

        canvasView = (CanvasView) findViewById(R.id.canvas);
    }


    public class ImageDrawListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            ImageButton view = (ImageButton) v;
            selectedBrush = (BitmapDrawable) view.getDrawable();
            canvasView.setImageBitmap(selectedBrush.getBitmap());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
