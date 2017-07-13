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
import android.support.annotation.UiThread;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;
import com.example.dzdezeed.aun_form.DataManager;
import com.example.dzdezeed.aun_form.R;

import butterknife.Bind;

public class PassDataBetweenStepsFirstStepFragment extends ButterKnifeFragment implements BlockingStep {
    String a;
    public static PassDataBetweenStepsFirstStepFragment newInstance() {
        return new PassDataBetweenStepsFirstStepFragment();
    }

    @Bind(R.id.editText100)
    EditText editText100;
    @Bind(R.id.editText102)
    EditText editText102;


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
        return checkValue() ? null : new VerificationError("Click more times!");
    }
    private boolean checkValue(){
        a = editText100.getText().toString();
        if(a.equals("aa")){
            Log.e("AA", a.toString());
            return false;
        }
        else{
            Log.e("Other", a.toString());
            return true;
        }
    }
    @Override
    public void onSelected() {
        if(dataManager.getData() != null){
            editText100.setText(dataManager.getData());
        }
        if(dataManager.getData1() != null){
            editText102.setText(dataManager.getData1());
        }
    }

    @Override
    public void onError(@NonNull VerificationError error) {
        Log.e("Error", "Errorrrrrrrrrrrrrrrrrrrrr");
    }

    @Override
    @UiThread
    public void onNextClicked(final StepperLayout.OnNextClickedCallback callback) {
        //String enteredText = editText100.getText().toString();
        dataManager.saveData(a);
        dataManager.saveData1(editText102.getText().toString());
        callback.goToNextStep();
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
       callback.complete();
    }

    @Override
    @UiThread
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {
        callback.goToPrevStep();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_step;
    }
}
