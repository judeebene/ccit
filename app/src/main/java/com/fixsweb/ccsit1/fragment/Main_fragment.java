package com.fixsweb.ccsit1.fragment;


        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import com.fixsweb.ccsit1.R;

public class Main_fragment extends Fragment{


    public Main_fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        TextView welcomeMsg = (TextView) view.findViewById(R.id.welcomeMsg) ;

        return view;
    }
}
