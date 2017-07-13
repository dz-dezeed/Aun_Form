/*
Copyright 2017 StepStone Services

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.example.dzdezeed.aun_form;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.stepstone.stepper.StepperLayout;
import com .example.dzdezeed.aun_form.adapter.PassDataBetweenStepsFragmentStepAdapter;
import com.stepstone.stepper.VerificationError;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PassDataBetweenStepsActivity extends AppCompatActivity implements DataManager {

    private static final String CURRENT_STEP_POSITION_KEY = "position";

    private static final String DATA = "data";

    @Bind(R.id.stepperLayout)
    StepperLayout mStepperLayout;
    private String Object_Data;
    private String mData;
    private String mData2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Stepper sample");

        setContentView(R.layout.activity_styled_tabs);
        ButterKnife.bind(this);
        int startingStepPosition = savedInstanceState != null ? savedInstanceState.getInt(CURRENT_STEP_POSITION_KEY) : 0;
        mData = savedInstanceState != null ? savedInstanceState.getString(DATA) : null;
        mData2 = savedInstanceState != null ? savedInstanceState.getString(DATA) : null;
        Object_Data = getIntent().getStringExtra("person");
        mStepperLayout.setAdapter(new PassDataBetweenStepsFragmentStepAdapter(getSupportFragmentManager(), this), startingStepPosition);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(CURRENT_STEP_POSITION_KEY, mStepperLayout.getCurrentStepPosition());
        outState.putString(DATA, mData);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        final int currentStepPosition = mStepperLayout.getCurrentStepPosition();
        if (currentStepPosition > 0) {
            mStepperLayout.onBackClicked();
        } else {
            finish();
        }
    }

    @Override
    public void saveData(String data) {
        mData = data;
    }

    public String getData() {
        return mData;
    }

    public void saveData2(String data) {
        mData2 = data;
    }

    public String getData2() {
        return mData2;
    }
    public void saveData1(String data){
        Object_Data = data;
    }
    public String getData1(){
        return Object_Data;
    }

}
