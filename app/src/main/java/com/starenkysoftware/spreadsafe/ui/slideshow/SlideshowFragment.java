package com.starenkysoftware.spreadsafe.ui.slideshow;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.starenkysoftware.spreadsafe.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_live_view, container, false);


        TextView liveViewTitle = root.findViewById(R.id.live_view_title);

        TextView[] textViews = {
                root.findViewById(R.id.badge1_title),
                root.findViewById(R.id.badge1_desc)
        };

        Typeface custom_font1 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Poppins_Light.ttf");
        liveViewTitle.setTypeface(custom_font1);

        return root;
    }
}