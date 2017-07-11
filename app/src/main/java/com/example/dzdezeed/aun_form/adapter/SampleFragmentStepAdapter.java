package com.example.dzdezeed.aun_form.adapter;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.example.dzdezeed.aun_form.R;
import com.example.dzdezeed.aun_form.step.StepFragmentSample;
import com.stepstone.stepper.viewmodel.StepViewModel;


public class SampleFragmentStepAdapter extends AbstractFragmentStepAdapter {
    public SampleFragmentStepAdapter(@NonNull FragmentManager fm, @NonNull Context context) {
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
                return StepFragmentSample.newInstance(R.layout.fragment_step);
            case 1:
                return StepFragmentSample.newInstance(R.layout.fragment_step2);
            case 2:
                return StepFragmentSample.newInstance(R.layout.fragment_step3);
            case 3:
                return StepFragmentSample.newInstance(R.layout.fragment_step3);
            case 4:
                return StepFragmentSample.newInstance(R.layout.fragment_step3);
            case 5:
                return StepFragmentSample.newInstance(R.layout.fragment_step3);
            default:
                throw new IllegalArgumentException("Unsupported position: " + position);
        }
    }

    @Override
    public int getCount() {
        return 6;
    }
}
