package com.starenkysoftware.spreadsafe.ui.share;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.starenkysoftware.spreadsafe.R;

public class ShareFragment extends Fragment {

    private ShareViewModel shareViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.fragment_support, container, false);



        TextView[] textViews = {
                root.findViewById(R.id.conTitle),
                root.findViewById(R.id.conVal),
                root.findViewById(R.id.conChange),
                root.findViewById(R.id.libTitle),
                root.findViewById(R.id.libVal),
                root.findViewById(R.id.libChange),
                root.findViewById(R.id.ndpTitle),
                root.findViewById(R.id.ndpVal),
                root.findViewById(R.id.ndpChange),
                root.findViewById(R.id.blocTitle),
                root.findViewById(R.id.blocVal),
                root.findViewById(R.id.blocChange),
                root.findViewById(R.id.greenTitle),
                root.findViewById(R.id.greenVal),
                root.findViewById(R.id.greenChange),
                root.findViewById(R.id.ppcTitle),
                root.findViewById(R.id.ppcVal),
                root.findViewById(R.id.ppcChange)
        };

        Typeface custom_font1 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Poppins_Light.ttf");

        for (TextView x : textViews){
            x.setTypeface(custom_font1);
        }

        return root;
    }
}