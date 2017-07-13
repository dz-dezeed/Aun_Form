package com.example.dzdezeed.aun_form.adapter;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.example.dzdezeed.aun_form.step.PassDataBetweenStepThirdStepFragment;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.example.dzdezeed.aun_form.step.PassDataBetweenStepsFirstStepFragment;
import com.example.dzdezeed.aun_form.step.PassDataBetweenStepsSecondStepFragment;
import com.stepstone.stepper.viewmodel.StepViewModel;

public class PassDataBetweenStepsFragmentStepAdapter extends AbstractFragmentStepAdapter {

    public PassDataBetweenStepsFragmentStepAdapter(@NonNull FragmentManager fm, @NonNull Context context) {
        super(fm, context);
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        CharSequence[] itemTopic = {"ข้อมูลทั่วไป","ที่อยู่","กรณีฉุกเฉิน","Disease","Disorder","Material"};
        return new StepViewModel.Builder(context)
                .setTitle(itemTopic[position])
                .create();
    }

    @Override
    public Step createStep(int position) {
        switch (position) {
            case 0:
                return PassDataBetweenStepsFirstStepFragment.newInstance();
            case 1:
                return PassDataBetweenStepsSecondStepFragment.newInstance();
            case 2:
                return PassDataBetweenStepThirdStepFragment.newInstance();
            default:
                throw new IllegalArgumentException("Unsupported position: " + position);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}