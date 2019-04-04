package com.zxn.itemdecoration.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * drawableLeft与文本一起居中显示
 * 
 * @author 农民伯伯
 * @see http://www.cnblogs.com/over140/p/3464348.html
 */
public class DrawableTopTextView extends TextView {

	public DrawableTopTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public DrawableTopTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public DrawableTopTextView(Context context) {
		super(context);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		super.onLayout(changed, left, top, right, bottom);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Drawable[] drawables = getCompoundDrawables();
		if (drawables != null) {
			Drawable drawableTop = drawables[1];
			if (drawableTop != null) {

				int color = getTextColors().getColorForState(getDrawableState(), 0);
				getPaint().setColor(color);
				getPaint().setTextSize(getTextSize());

				float textWidth = getPaint().measureText(getText(), 0, getText().length());
				float textHeight = getPaint().descent() - getPaint().ascent();

				canvas.save();

				float height = textHeight + getCompoundDrawablePadding() + drawableTop.getIntrinsicHeight();
				canvas.translate((getWidth() - drawableTop.getIntrinsicWidth()) / 2, (getHeight() - height) / 2);
				drawableTop.draw(canvas);

				canvas.translate((drawableTop.getIntrinsicWidth() - textWidth) / 2, 0);
				canvas.drawText(getText().toString(), 0, height - getPaint().descent(), getPaint());

				canvas.restore();

			} else {
				super.onDraw(canvas);
			}

		} else {
			super.onDraw(canvas);
		}

	}

	@Override
	public void setSelected(boolean selected) {
		// 这里是为了解决当同一个布局中的控件显示隐藏导致重绘
		// GridView的setupChild方法会调用此方法
		// 这里做一下判断
		// 业务问题 没有显示隐藏的逻辑可以干掉
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		for (int i = 0; i < stack.length; i++) {
			StackTraceElement element = stack[i];
			if (element.getMethodName().equals("setupChild"))
				return;
		}
		super.setSelected(selected);
	}

	// private static final String KEY_SUPER_DATA = "key_super_data";
	// private static final String KEY_SAVE_DATA = "key_save_data";
	//
	// @Override
	// public Parcelable onSaveInstanceState() {
	// Bundle bundle = new Bundle();
	// Parcelable superData = super.onSaveInstanceState();
	// bundle.putParcelable(KEY_SUPER_DATA, superData);
	// bundle.putBoolean(KEY_SAVE_DATA, selected);
	// return bundle;
	// }
	//
	// @Override
	// public void onRestoreInstanceState(Parcelable state) {
	// Bundle bundle = (Bundle) state;
	// Parcelable superData = bundle.getParcelable(KEY_SUPER_DATA);
	// super.onRestoreInstanceState(superData);
	// selected = bundle.getBoolean(KEY_SAVE_DATA);
	// }

}