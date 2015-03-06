package com.madisp.pretty.samples;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.TypedValue;
import android.widget.ImageView;

import com.madisp.pretty.AttrsDecor;

import org.jetbrains.annotations.NotNull;

/**
 * Created by cheikhna on 06/03/2015.
 */
public class CircularImageDecor extends AttrsDecor<ImageView> {

    @NotNull
    @Override
    protected int[] attrs() {
        return new int[] {R.attr.circular};
    }

    @NotNull
    @Override
    protected Class<ImageView> clazz() {
        return ImageView.class;
    }

    @Override
    protected void apply(ImageView view, int attr, TypedValue value) {

        Bitmap bitmap = ((BitmapDrawable) view.getDrawable()).getBitmap();
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(
                                            view.getContext().getResources(), bitmap);
        roundedBitmapDrawable.setCornerRadius(Math.min(roundedBitmapDrawable.getMinimumWidth(),
                                        roundedBitmapDrawable.getMinimumHeight()) / 2.0F);
        view.setImageDrawable(roundedBitmapDrawable);
    }

}