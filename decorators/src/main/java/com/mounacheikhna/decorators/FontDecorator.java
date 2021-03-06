package com.mounacheikhna.decorators;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.widget.TextView;

import com.mounacheikhna.decor.AttrsDecorator;


public class FontDecorator extends AttrsDecorator<TextView> {

    @Override
    protected int[] styleable() {
        return R.styleable.FontDecorator;
    }

    @Override
    protected Class<TextView> clazz() {
        return TextView.class;
    }

    @Override
    protected void apply(TextView view, TypedArray typedArray) {
        String typefacePath = typedArray.getString(R.styleable.FontDecorator_decorTypefaceAsset);
        if(typefacePath == null) return;
        view.setTypeface(Typeface.createFromAsset(
                view.getResources().getAssets(), typefacePath));
    }
}