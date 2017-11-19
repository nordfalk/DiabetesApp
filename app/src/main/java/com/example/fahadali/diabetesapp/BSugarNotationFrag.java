package com.example.fahadali.diabetesapp;


import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BSugarNotationFrag extends Fragment implements View.OnClickListener, TextWatcher{

    Button cancel_BTN, add_BTN;
    EditText firstNum_ET, secondNum_ET, thirdNum_ET, comment_ET;
    TextView comma_TV;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rod = inflater.inflate(R.layout.fragment_bsugar_notation,container,false);

        add_BTN = rod.findViewById(R.id.done_BTN);
        add_BTN.setText("Tilføj");
        add_BTN.setOnClickListener(this);
        cancel_BTN = rod.findViewById(R.id.cancel_BTN);
        cancel_BTN.setText("Annuller");
        cancel_BTN.setOnClickListener(this);

        firstNum_ET = rod.findViewById(R.id.firstNum_ET);
        firstNum_ET.requestFocus();
        firstNum_ET.addTextChangedListener(this);
        secondNum_ET = rod.findViewById(R.id.secondNum_ET);
        secondNum_ET.addTextChangedListener(this);
        thirdNum_ET = rod.findViewById(R.id.thirdNum_ET);
        thirdNum_ET.addTextChangedListener(this);

        comma_TV = rod.findViewById(R.id.comma_TV);
        comment_ET = rod.findViewById(R.id.comment_ET);

        return rod;
    }


    @Override
    public void onClick(View v) {
        if(v == add_BTN){
            // TODO: 02/11/2017: Needs backend to get Userinput and place it in BSoverview
        }
        if(v == cancel_BTN){
            //getActivity().finish();
        }

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {


    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        focusHandler();

    }



    @Override
    public void afterTextChanged(Editable s) {

    }

    public void focusHandler(){

        int maxLength = 1;
        comma_TV.setTextColor(getResources().getColor(R.color.hintColor));
        if(firstNum_ET.getText().toString().length() == maxLength){
            secondNum_ET.requestFocus();
            if(secondNum_ET.getText().toString().length() == maxLength){
                thirdNum_ET.requestFocus();
                if(thirdNum_ET.getText().toString().length() == maxLength){
                    comma_TV.setTextColor(getResources().getColor(R.color.TextOnWhite));
                    comment_ET.requestFocus();

                }
            }
        }
    }

//    public void blinkingEffect(EditText num){
//        ObjectAnimator anim = ObjectAnimator.ofInt(num, "stroke", num.getDrawingCacheBackgroundColor(), Color.RED, num.getDrawingCacheBackgroundColor());
//        anim.setDuration(800);
//        anim.setEvaluator(new ArgbEvaluator());
//        anim.setRepeatMode(ValueAnimator.REVERSE);
//        anim.setRepeatCount(Animation.INFINITE);
//        anim.start();
//
//    }
}
