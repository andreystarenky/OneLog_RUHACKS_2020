package com.starenkysoftware.spreadsafe.ui.home;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.starenkysoftware.spreadsafe.MainActivity;
import com.starenkysoftware.spreadsafe.R;

import java.util.Calendar;
import java.util.Date;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        TextView[] textViews = {root.findViewById(R.id.home_recent_cases),
                root.findViewById(R.id.home_total_cases),
                root.findViewById(R.id.home_new_cases),
                root.findViewById(R.id.home_total_cases_value),
                root.findViewById(R.id.home_new_cases_value),
                root.findViewById(R.id.home_last_5_days),
                root.findViewById(R.id.label1),
                root.findViewById(R.id.label2),
                        root.findViewById(R.id.label3),
                        root.findViewById(R.id.sublabel1),
                        root.findViewById(R.id.sublabel2),
                        root.findViewById(R.id.sublabel3)};

        Typeface custom_font1 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Poppins_Light.ttf");
        Typeface custom_font2 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Poppins_Thin.ttf");

        for (TextView t : textViews){
            t.setTypeface(custom_font1);
        }

        ((TextView)root.findViewById(R.id.home_total_cases_value)).setTypeface(custom_font2);
        ((TextView)root.findViewById(R.id.home_new_cases_value)).setTypeface(custom_font2);


        // GRAPH SETUP
        final GraphView graph = (GraphView) root.findViewById(R.id.home_graph);
        graph.setVisibility(View.VISIBLE);

        try {
            LineGraphSeries <DataPoint> series = new LineGraphSeries< >(new DataPoint[] {
                    new DataPoint(1, 750),
                    new DataPoint(2, 800),
                    new DataPoint(3, 950),
                    new DataPoint(4, 900),
                    new DataPoint(5, 1050),
            });

            series.setColor(R.color.colorPrimaryDark);

            graph.addSeries(series);
        } catch (IllegalArgumentException e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }


        Calendar calendar = Calendar.getInstance();

        String debugString = calendar.getTime().toString();

        Log.d("GRAPH_TESTING",debugString);

        /*
        // GRAPH2 SETUP
        final GraphView graph2 = (GraphView) root.findViewById(R.id.home_graph2);
        graph2.setVisibility(View.VISIBLE);

        try {
            LineGraphSeries <DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                    new DataPoint(1, 90),
                    new DataPoint(2, 100),
                    new DataPoint(3, 105),
                    new DataPoint(4, 130),
                    new DataPoint(5, 115)
            });

            LineGraphSeries <DataPoint> series2 = new LineGraphSeries<>(new DataPoint[] {
                    new DataPoint(1, 120),
                    new DataPoint(2, 125),
                    new DataPoint(3, 95),
                    new DataPoint(4, 100),
                    new DataPoint(5, 105)
            });

            graph2.addSeries(series);
            graph2.addSeries(series2);

            series.setColor(Color.BLUE);
            series2.setColor(Color.RED);

            graph2.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
                @Override
                public String formatLabel(double value, boolean isValueX) {
                    if (isValueX) {
                        // show normal x values
                        if(value==1)
                            return "May 7";
                        if(value==2)
                            return "May 8";
                        if(value==3)
                            return "May 9";
                        if(value==4)
                            return "May 10";
                        if(value==5)
                            return "May 11";
                        return null;
                    } else {
                        // show currency for y values
                        return super.formatLabel(value, isValueX);
                    }
                }
            });

        } catch (IllegalArgumentException e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        */

        return root;
    }
}