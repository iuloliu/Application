package com.example.myapplication.viewGroup;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myapplication.R;

public class MyViewGroup extends ViewGroup {
    private TextView textView;
    //    Button button;
    private Context mContext;

    public MyViewGroup(Context context) {
        super(context);
        this.mContext = context;
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;

    }


    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        setBackgroundColor(mContext.getResources().getColor(R.color.light_blue_200));
        textView = new TextView(mContext);
        textView.setText("hhhhhhh");
        textView.setTextColor(mContext.getResources().getColor(R.color.black));
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
//        button=new Button(mContext);
        LayoutParams layoutParams =new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        addView(textView, layoutParams);
//        addView(button,layoutParams);
//        textView.layout(0,0,0,0);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        textView = new TextView(mContext);
//        textView.setText("hhhhhhh");
//        textView.setTextColor(mContext.getResources().getColor(R.color.black));
//        textView.setTextSize(20);
//        textView.setGravity(Gravity.CENTER);
////        button=new Button(mContext);
//        LayoutParams layoutParams =getLayoutParams();
//        layoutParams.height=100;
//        layoutParams.width=200;
//        //new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//        addView(textView);
//        canvas.drawText();
    }
}
