package com.fixsweb.ccsit1.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fixsweb.ccsit1.R;

public class Animation_fragment extends Fragment{


    public Animation_fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animation, container, false);


        TextView animationMsg = (TextView) view.findViewById(R.id.animationMsg) ;

        return view;
    }
}
