package com.example.xander.drawoncanvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by xander on 14-10-25.
 */
public class CanvasView extends ImageView {

    private Bitmap bufferBitmap;
    private Canvas buffer;
    private Bitmap imageBitmap;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(new CanvasListner());
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        bufferBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        buffer = new Canvas(bufferBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

          canvas.drawBitmap(bufferBitmap, 0, 0, new Paint( ));
    }

    private class CanvasListner implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            CanvasView canvasView = (CanvasView) v;
            int action = event.getAction();
            float x = event.getX();
            float y = event.getY();
            Paint paint = new Paint();
            paint.setAlpha(150);
            switch (action) {
                case MotionEvent.ACTION_UP:
                    buffer.drawBitmap(imageBitmap, x, y, paint);
                case MotionEvent.ACTION_MOVE:
                    buffer.drawBitmap(imageBitmap, x, y, paint);
            }
            v.invalidate();
            return true;
        }
    }
}
