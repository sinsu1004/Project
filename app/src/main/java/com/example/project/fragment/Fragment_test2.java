package com.example.project.fragment;

import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.project.R;
import com.example.project.settings;

public class Fragment_test2 extends Fragment {
    public Fragment_test2() {}
    private Button settingbutton;
    private Button count_bt;
    private Button passcount_bt;
    private EditText count;
    private EditText passcount;
    private TextView nowcount;
    private TextView nowpass;
    private TextView textView5;

    public static Fragment_test2 newInstance() {
        Fragment_test2 calendarFragment= new Fragment_test2();
        Bundle bundle = new Bundle();
        return calendarFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println("설정");
        View view = inflater.inflate(R.layout.fragment_test2, container, false);



        count=view.findViewById(R.id.countdowntime);
        passcount=view.findViewById(R.id.passnumber);
        nowcount=view.findViewById(R.id.nowcount);
        nowpass=view.findViewById(R.id.nowpass);
        count_bt=view.findViewById(R.id.countdowntime_bt);
        passcount_bt=view.findViewById(R.id.passnumber_bt);
        textView5=view.findViewById(R.id.textView5);


        textView5.setText(((settings)getActivity().getApplication()).getNickname()+"님");
        nowcount.setText("카운트 시간 : " +Integer.toString(((settings)getActivity().getApplication()).getCount()));
        nowpass.setText("PASS 개수 : " +Integer.toString(((settings)getActivity().getApplication()).getPasscount()));

        count_bt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(count_bt.getText().equals("수정")){
                    count.setEnabled(true);
                    count.setText(null);
                    count_bt.setText("저장");
                }
                else if(count_bt.getText().equals("저장")) {
                    ((settings) getActivity().getApplication()).setCount(Integer.parseInt(count.getText().toString()));
                    nowcount.setText("카운트 시간 : " + ((settings) getActivity().getApplication()).getCount());
                    count.setEnabled(false);
                    count_bt.setText("수정");
                }
            }
        });

        passcount_bt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                if(passcount_bt.getText().equals("수정")){
                    passcount.setEnabled(true);
                    passcount.setText(null);
                    passcount_bt.setText("저장");
                }
                else if(passcount_bt.getText().equals("저장")) {
                    ((settings) getActivity().getApplication()).setPasscount(Integer.parseInt(passcount.getText().toString()));
                    nowpass.setText("PASS 개수 : " + passcount.getText().toString());
                    passcount.setEnabled(false);
                    passcount_bt.setText("수정");
                }
            }
        });






















        return view;
    }

}

