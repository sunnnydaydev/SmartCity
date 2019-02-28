package com.example.administrator.smartcity.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.smartcity.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Create by SunnyDay on 2019/02/27
 * <p>
 * 设置界面的通用view    （自定义实现）
 * <p>
 * 功能：快速搭建设置界面
 * 1 左侧文字的代码设置实现       定义xml属性实现
 * 2 右侧的圆头像代码设置实现     自定义xml属性实现
 * 3 右侧文本的代码设置实现       自定义xml属性实现
 * 4 头像的显示隐藏   （代码实现，xml自定义实现）
 * 5 文本的显示隐藏    （代码实现，xml自定义实现）
 */
public class SettingView extends LinearLayout {
    // 命名空间  所有自定义控件都可以使用这个特定字符串，AS自动帮你找。
    private static final String NAME_SPACE = "http://schemas.android.com/apk/res-auto";

    private TextView leftText;
    private CircleImageView headPortrait;
    private TextView rightText;

    @RequiresApi(api = Build.VERSION_CODES.P)
    public SettingView(Context context) {
        this(context, null);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public SettingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public SettingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.view_setting_page, null);

        leftText = view.findViewById(R.id.text);
        headPortrait = view.findViewById(R.id.img);
        rightText = view.findViewById(R.id.right_text);

        initSelfAttrs(attrs, context);

        this.addView(view);
    }

    /**
     * 自定义属性初始化工作
     *
     * @param attrs 属性集合
     */
    private void initSelfAttrs(AttributeSet attrs, Context context) {
        // 1 左侧text的xml设置
        String leftText = attrs.getAttributeValue(NAME_SPACE, "leftText");
        setLeftText(leftText);

        // 获得xml中设置 showRightPic 属性值 默认 false
        boolean showRightPic = attrs.getAttributeBooleanValue(NAME_SPACE, "showRightPic", false);
        boolean showRightText = attrs.getAttributeBooleanValue(NAME_SPACE, "showRightText", false);

        // 3 右面text的设置
        if (showRightText){
            rightText.setVisibility(VISIBLE);
            String rightText = attrs.getAttributeValue(NAME_SPACE, "rightText");
            setRightText(rightText);
        }
        // 图片的设置还是使用TypeArray 获取设置
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SettingView);//参见你的attrs中定义<declare-styleable name="SettingView">
        for (int i = 0; i < typedArray.getIndexCount(); i++) {
            int index = typedArray.getIndex(i);
            switch (index) {
                //1  左侧文本的xml设置（使用这种方式也行）
//                case R.styleable.SettingView_leftText:
//                    String leftText  = typedArray.getString(index);
//                    setLeftText(leftText);
//                    break;
                case R.styleable.SettingView_rightPic:
                    // 2 右侧图片的显示
                    if (showRightPic) {
                        headPortrait.setVisibility(VISIBLE);
                        Drawable drawable = typedArray.getDrawable(index);
                        setHeadPortrait(drawable);
                    }

                    break;
            }
        }
        typedArray.recycle();//回收
    }

    /**
     * 设置左侧文字的内容
     * @param text  要设置的字符串
     */
    public void setLeftText(String text) {
        leftText.setText(text);
    }

    /**
     * 设置右面侧文字的内容
     * @param text  要设置的字符串
     *
     * 注意使用时要控件显示，由于xml属性原因默认隐藏的
     */
    public void setRightText(String text){
        rightText.setText(text);
    }

    /**
     * 设置头像
     *
     * @param imgType 图片的类型
     *
     *                注意使用时要控件显示，由于xml属性原因默认隐藏的
     */
    public void setHeadPortrait(Object imgType) {
        if (imgType instanceof Drawable) {
            headPortrait.setImageDrawable((Drawable) imgType);
        } else if (imgType instanceof Integer) {
            headPortrait.setImageResource((Integer) imgType);
        } else if (imgType instanceof Bitmap) {
            headPortrait.setImageBitmap((Bitmap) imgType);
        } else if (imgType instanceof Uri) {
            headPortrait.setImageURI((Uri) imgType);
        } else {
            throw new IllegalArgumentException("imgType just can be type:Drawable or recourceId or Bitmap or Uri");
        }

    }

}
