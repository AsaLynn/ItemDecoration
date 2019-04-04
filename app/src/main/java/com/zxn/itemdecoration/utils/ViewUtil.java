package com.zxn.itemdecoration.utils;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;

/**
 * 控件工具类
 * 
 * @author YouTu
 * 
 */
public class ViewUtil {

	/**
	 * 右边图片textview
	 * 
	 * @param resources
	 * @param drawble
	 * @param target
	 */
	public static final void setDrawLeftBitmap(Resources resources, int drawble, TextView target) {
		Drawable drawable = resources.getDrawable(drawble);
		// / 这一步必须要做,否则不会显示.
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		target.setCompoundDrawables(drawable, null, null, null);
	}

	/**
	 * 左边图片textview
	 * 
	 * @param resources
	 * @param drawble
	 * @param target
	 */
	public static final void setDrawRightBitmap(Resources resources, int drawble, TextView target) {
		Drawable drawable = resources.getDrawable(drawble);
		// / 这一步必须要做,否则不会显示.
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		target.setCompoundDrawables(null, null, drawable, null);
	}

	/**
	 * 左边图片textview
	 * 
	 * @param resources
	 * @param target
	 */
	public static final void setDrawRightBitmap(Resources resources, Drawable drawable, TextView target) {
		// / 这一步必须要做,否则不会显示.
		if (drawable != null)
			drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		target.setCompoundDrawables(null, null, drawable, null);
	}

	/**
	 * 上面图片textview
	 * 
	 * @param resources
	 * @param drawble
	 * @param target
	 */
	public static final void setDrawTopBitmap(Resources resources, int drawble, TextView target) {
		Drawable drawable = resources.getDrawable(drawble);
		// / 这一步必须要做,否则不会显示.
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		target.setCompoundDrawables(null, drawable, null, null);
	}

	/**
	 * 上面图片textview
	 * 
	 * @param target
	 */
	public static final void setDrawTopBitmap(Drawable drawable, TextView target) {
		// / 这一步必须要做,否则不会显示.
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		target.setCompoundDrawables(null, drawable, null, null);
	}

	/**
	 * 下面图片textview
	 * 
	 * @param resources
	 * @param drawble
	 * @param target
	 */
	public static final void setDrawBottomBitmap(Resources resources, int drawble, TextView target) {
		Drawable drawable = resources.getDrawable(drawble);
		// / 这一步必须要做,否则不会显示.
		drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
		target.setCompoundDrawables(null, null, null, drawable);
	}

	public static final void setDrawRightClick(final TextView target, final OnClickListener listener) {
		final int drawablePadding = target.getCompoundDrawablePadding();
		Drawable[] drawables = target.getCompoundDrawables();
		final Drawable drawableTop = drawables[2];
		target.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				float x = event.getX();
				if (x > target.getWidth() - (drawableTop.getIntrinsicWidth() + drawablePadding * 2) && x < target.getWidth()) {
					// 认为点击了右侧的删除按钮
					listener.onClick(target);
				}
				return false;
			}
		});
	}




	// 设置中划线并加清晰
	public static final void setTextMidLine(TextView textView) {
		textView.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
	}

	/**
	 * 设置textview的hit字体大小
	 * 
	 * @param textView
	 * @param size
	 * @param content
	 */
	public static void setHintTextSize(TextView textView, int size, String content) {
		// 新建一个可以添加属性的文本对象
		SpannableString ss = new SpannableString(content);
		// 新建一个属性对象,设置文字的大小
		AbsoluteSizeSpan ass = new AbsoluteSizeSpan(size, true);
		// 附加属性到文本
		ss.setSpan(ass, 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		// 设置hint
		textView.setHint(new SpannedString(ss)); // 一定要进行转换,否则属性会消失
	}

}
