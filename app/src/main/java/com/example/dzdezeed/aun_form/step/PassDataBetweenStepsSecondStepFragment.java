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

package com.example.dzdezeed.aun_form.step;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.EditText;
import android.widget.TextView;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;
import com.example.dzdezeed.aun_form.DataManager;
import com.example.dzdezeed.aun_form.R;

import butterknife.Bind;

public class PassDataBetweenStepsSecondStepFragment extends ButterKnifeFragment implements BlockingStep {

    public static PassDataBetweenStepsSecondStepFragment newInstance() {
        return new PassDataBetweenStepsSecondStepFragment();
    }
    @Bind(R.id.editText101)
    EditText editText101;
    @Bind(R.id.textView3)
    TextView textView3;

    private DataManager dataManager;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DataManager) {
            dataManager = (DataManager) context;
        } else {
            throw new IllegalStateException("Activity must implement DataManager interface!");
        }
    }

    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {
        textView3.setText("Entered text:\n" + dataManager.getData());
        if(dataManager.getData2() != null){
            editText101.setText(dataManager.getData2());
        }
    }

    @Override
    public void onError(@NonNull VerificationError error) {
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_step2;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        String enteredText = editText101.getText().toString();
        dataManager.saveData2(enteredText);
        callback.goToNextStep();
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {
        callback.goToPrevStep();
    }
}
