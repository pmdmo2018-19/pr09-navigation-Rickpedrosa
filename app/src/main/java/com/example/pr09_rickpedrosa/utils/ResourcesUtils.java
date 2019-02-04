package com.example.pr09_rickpedrosa.utils;

import android.content.Context;
import android.util.TypedValue;

import androidx.annotation.DimenRes;

// DO NOT TOUCH

public class ResourcesUtils {

    private ResourcesUtils() {
    }

    public static float getFloat(Context context, @DimenRes int resId) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(resId, typedValue, true);
        return typedValue.getFloat();
    }

}
