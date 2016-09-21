package bree.com.customview;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by bree on 2016/9/21.
 */

public class TitleLayout extends LinearLayout {
    private OnFunctionClickListener onFunctionClickListener;
    private Button titleEdit;


    public TitleLayout(Context context) {
        super(context);
    }

    /**
     * 在布局中引用TitleLayout就会调用这个构造函数
     *
     * @param context
     * @param attrs
     */
    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        /**
         * 对标=标题栏的布局进行动态加载
         * 参数1：加载布局文件的id
         * 参数2:给加载好的布局添加一个父布局
         */
        LayoutInflater.from(context).inflate(R.layout.title, this);

        //找到控件
        Button titleBack = (Button) findViewById(R.id.title_back);
        titleEdit = (Button) findViewById(R.id.title_edit);
        TextView titleText = (TextView) findViewById(R.id.title_text);
        LinearLayout titleBac = (LinearLayout) findViewById(R.id.title_linear);

        //获得自定义属性的值
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.titleLayout);

        String titleTextStr = typedArray.getString(R.styleable.titleLayout_title_text);
        String titleBackStr = typedArray.getString(R.styleable.titleLayout_title_back);

        titleText.setText(titleTextStr);
        titleBack.setText(titleBackStr);

        int color = typedArray.getColor(R.styleable.titleLayout_title_text_color, Color.WHITE);
        titleBack.setTextColor(color);
        titleEdit.setTextColor(color);
        titleText.setTextColor(color);
        int colorBac = typedArray.getColor(R.styleable.titleLayout_title_bac_color, Color.WHITE);
        titleBac.setBackgroundColor(colorBac);

        float dimension = typedArray.getDimension(R.styleable.titleLayout_title_text_size, 22);
//        titleText.setTextSize(dimension);

        titleText.setTextSize(TypedValue.COMPLEX_UNIT_PX, dimension);


        //给标题栏中的按钮注册点击事件

        titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();
            }
        });


    }

    public TitleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public void setOnFunctionClickListener(final OnFunctionClickListener onFunctionClickListener) {
        this.onFunctionClickListener = onFunctionClickListener;
        titleEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onFunctionClickListener.onClick();
            }
        });

    }


    interface OnFunctionClickListener {
        void onClick();
    }
}
