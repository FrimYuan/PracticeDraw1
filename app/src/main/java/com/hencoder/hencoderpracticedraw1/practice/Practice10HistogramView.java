package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.model.Data;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {
    private static final String NAME = "直方图";
    private Paint paint;
    private Path path;
    private Rect rect;
    private List<Data> datas;
    private float max;
    private float space = 20;

    public Practice10HistogramView(Context context) {
        super(context);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        datas = new ArrayList<>();
        Data data = new Data("Froyo", 1.0f, Color.GREEN);
        datas.add(data);
        data = new Data("GB", 5.0f, Color.GREEN);
        datas.add(data);
        data = new Data("ICS", 5.0f, Color.GREEN);
        datas.add(data);
        data = new Data("JB", 30.0f, Color.GREEN);
        datas.add(data);
        data = new Data("KitKat", 50.0f, Color.GREEN);
        datas.add(data);
        data = new Data("L", 60.0f, Color.GREEN);
        datas.add(data);
        data = new Data("M", 28.0f, Color.GREEN);
        datas.add(data);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        for (Data d : datas) {
            max = Math.max(max, d.getNumber());
        }
        path = new Path();
        rect = new Rect();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        paint.setColor(Color.WHITE);
        paint.setTextSize(72);
        canvas.drawText(NAME, (width - paint.measureText(NAME)) / 2, height * 0.9f, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        path.moveTo(width * 0.1f, height * 0.05f);
        path.lineTo(width * 0.1f, height * 0.8f);//画y轴
        path.lineTo(width * 0.9f, height * 0.8f);//画x轴
        canvas.drawPath(path, paint);
        //x轴总长
        float xLong = width * 0.9f - width * 0.1f;
        //y轴总长
        float yLong = height * 0.8f - width * 0.05f;
        Log.d("YGG", xLong + "");
        //每个item的宽度
        float itemSize = (xLong - 30) / datas.size();
        Log.d("YGG", itemSize + "");
        //每次遍历需要增加item的宽度
        float xStart = width * 0.1f;
        paint.reset();
        paint.setTextSize(36);
        for (Data data : datas) {
            paint.setColor(Color.GREEN);
            canvas.drawRect(xStart + space, height * 0.8f - data.getNumber() / max * yLong, xStart + itemSize, height * 0.8f, paint);
            paint.setColor(Color.WHITE);
            paint.getTextBounds(data.getName(), 0, data.getName().length(), rect);
            Log.d("YGG", "" + rect.height());
            canvas.drawText(data.getName(), xStart + space + (itemSize - space) / 2 - paint.measureText(data.getName()) / 2, height * 0.8f + rect.height(), paint);
            xStart += itemSize;
        }
    }
}
