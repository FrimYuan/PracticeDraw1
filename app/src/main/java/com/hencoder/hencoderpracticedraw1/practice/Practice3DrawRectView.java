package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice3DrawRectView extends View {
    Paint paint;

    public Practice3DrawRectView(Context context) {
        super(context);
        init();
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("YGG", "aaa"+(canvas.getWidth() / 2 - 200));
        Log.d("YGG", "bbb"+(canvas.getWidth() / 2 + 200));
//        练习内容：使用 canvas.drawRect() 方法画矩形
        canvas.drawRect(canvas.getWidth() / 2 - 200, 200, canvas.getWidth() / 2 + 200, 600, paint);
    }
}
