package com.hasan.challengepapbuas;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import static com.hasan.challengepapbuas.R.id.spin_start;
import static com.hasan.challengepapbuas.R.id.textView;

public class fragment_main extends Fragment{
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private Button btnStart;
    private  Button btnStop;

    private int count = 0;

    private View myView;

    private Random rand = new Random();
    private Random rand2 = new Random();
    private Random rand3 = new Random();

    private int counter = 0;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_main, container, false);

        btnStart = (Button) myView.findViewById(spin_start);
        btnStop = (Button) myView.findViewById(R.id.spin_stop);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case spin_start:
                        //counterText();
                        tv1 = (TextView) myView.findViewById(textView);
                        tv1.setTextColor(Color.parseColor("#808080"));
                        tv2 = (TextView) myView.findViewById(R.id.textView2);
                        tv2.setTextColor(Color.parseColor("#808080"));
                        tv3 = (TextView) myView.findViewById(R.id.textView3);
                        tv3.setTextColor(Color.parseColor("#808080"));
                        tv1.post(new Roller(100));
                        tv2.post(new Roller2(100));
                        tv3.post(new Roller3(100));
                        count = 1;
                        btnStart.setEnabled(false);
                        break;
                }
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.spin_stop:
                        //counterText();
                        if(count == 1){
                            tv1.setTextColor(Color.parseColor("#0b4ae6"));
                            tv1 = null;
                            count++;
                        }
                        else if(count == 2){
                            tv2.setTextColor(Color.parseColor("#0b4ae6"));
                            tv2 = null;
                            count++;
                        }
                        else if(count == 3){
                            tv3.setTextColor(Color.parseColor("#0b4ae6"));
                            tv3 = null;

                            btnStart.setEnabled(true);
                            count = 0;
                        }
                        break;
                }
            }
        });

        return myView;
    }

    private class Roller implements Runnable{
        private long delayMillis;

        public Roller(long delayMillis)
        {
            this.delayMillis = delayMillis;
        }

        @Override
        public void run()
        {
            if (tv1 != null)
            {
                int n = rand.nextInt(9) + 1;
                String roll = String.valueOf(n);
                tv1.setText(roll);
                tv1.postDelayed(this, delayMillis);
                //numTimes--;

//                if (numTimes > 0)
//                {
//                    textRoll.postDelayed(this, delayMillis);
//                }
            }
        }
    }

    private class Roller2 implements Runnable{
        private long delayMillis;

        public Roller2(long delayMillis)
        {
            this.delayMillis = delayMillis;
        }

        @Override
        public void run()
        {
            if (tv2 != null)
            {
                int n = rand2.nextInt(9) + 1;
                String roll = String.valueOf(n);
                tv2.setText(roll);
                tv2.postDelayed(this, delayMillis);
                //numTimes--;

//                if (numTimes > 0)
//                {
//                    textRoll.postDelayed(this, delayMillis);
//                }
            }
        }
    }

    private class Roller3 implements Runnable{
        private long delayMillis;

        public Roller3(long delayMillis)
        {
            this.delayMillis = delayMillis;
        }

        @Override
        public void run()
        {
            if (tv3 != null)
            {
                int n = rand3.nextInt(9) + 1;
                String roll = String.valueOf(n);
                tv3.setText(roll);
                tv3.postDelayed(this, delayMillis);
                //numTimes--;

//                if (numTimes > 0)
//                {
//                    textRoll.postDelayed(this, delayMillis);
//                }
            }
        }
    }

//    public void counterText(){
//        if(counter == 0){
//            tv1.setText("1");
//            counter++;
//        }
//        else if (counter == 1){
//            tv2.setText("2");
//            counter++;
//        }
//        else if (counter == 2){
//            tv3.setText("3");
//        }
//    }
}