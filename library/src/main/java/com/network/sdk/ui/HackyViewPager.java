package com.network.sdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
/**
 * according to https://github.com/chrisbanes/PhotoView
 * There are some ViewGroups (ones that utilize onInterceptTouchEvent) that throw exceptions when a PhotoView
 * is placed within them, most notably ViewPager and DrawerLayout. This is a framework issue that has not been resolved.
 * In order to prevent this exception (which typically occurs when you zoom out),
 * take a look at HackyDrawerLayout and you can see the solution is to simply catch the exception.
 * Any ViewGroup which uses onInterceptTouchEvent will also need to be extended and exceptions caught.
 * Use the HackyDrawerLayout as a template of how to do so. The basic implementation is:
 *
 * public class HackyProblematicViewGroup extends ProblematicViewGroup {
 *
 *     public HackyProblematicViewGroup(Context context) {
 *         super(context);
 *     }
 *
 *     public boolean onInterceptTouchEvent(MotionEvent ev) {
 *         try {
 *             return super.onInterceptTouchEvent(ev);
 *         } catch (IllegalArgumentException e) {
 * 						//uncomment if you really want to see these errors
 *             //e.printStackTrace();
 *             return false;
 *         }
 *     }
 * }
 * */
public class HackyViewPager extends ViewPager {
    public HackyViewPager(@NonNull Context context) {
        super(context);
    }

    public HackyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
