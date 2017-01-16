package com.android.test.adaptor;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.test.R;
import com.android.test.model.Video;

import java.util.ArrayList;

/**
 * Created by Manish on 16/1/17.
 */

public class ViewPagerAdaptor extends PagerAdapter {
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<Video> video;
    private int[] mSSlider;

    public ViewPagerAdaptor(Activity activity, int[] homePageSlider, ArrayList<Video> video) {
        this.context = activity;
        this.mSSlider = homePageSlider;
        this.video = video;
    }


    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.viewpager_row, null, true);
        ImageView icon = (ImageView) view.findViewById(R.id.play_iv);
        ImageView image = (ImageView) view.findViewById(R.id.slide_img);
        TextView title = (TextView) view.findViewById(R.id.title_tv);
        TextView subtitle = (TextView) view.findViewById(R.id.subtitle_tv);
        if (video.get(position).getTitle() != null && !video.get(position).getTitle().equalsIgnoreCase(""))
            title.setText(video.get(position).getTitle());
        else{
            title.setVisibility(View.GONE);
            icon.setVisibility(View.GONE);

        }

        if (video.get(position).getSubtile() != null && !video.get(position).getSubtile().equalsIgnoreCase(""))
            subtitle.setText(video.get(position).getSubtile());
        else{
            subtitle.setVisibility(View.GONE);


        }

        image.setImageResource(mSSlider[position]);

        container.addView(view);
        return view;
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return mSSlider.length;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        container.removeView((FrameLayout) object);
    }
}
