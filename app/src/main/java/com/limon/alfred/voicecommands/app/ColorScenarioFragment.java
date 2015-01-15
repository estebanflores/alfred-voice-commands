/*
 * Limon Solutions - 2014 - Esteban Flores <esteban.flores@gmail.com>
 *
 * This file is part of Alfred Voice Command project.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.limon.alfred.voicecommands.app;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.limon.alfred.voicecommands.Alfred;
import com.limon.alfred.voicecommands.action.ActionEvent;
import com.limon.alfred.voicecommands.action.BrightnessAction;
import com.limon.alfred.voicecommands.action.BrightnessActionListener;
import com.limon.alfred.voicecommands.action.ColorAction;
import com.limon.alfred.voicecommands.action.ColorActionListener;

import java.util.HashMap;
import java.util.Map;

public class ColorScenarioFragment extends BaseScenarioFragment {

    private static final long TRANSITION_TIME = 2000;
    private static final String LAST_COLOR = "lastColor";
    private static final java.lang.String LAST_ACTION_BAR_COLOR = "lastBarColor";
    private Integer lastColor = Color.WHITE;
//    private Integer lastActionBarColor = getResources().getColor(android.R.color.holo_green_dark);

    private void communicateColorActionsToAlfred(final View rootView, int stringArrayId, Map<Integer, Integer> colorMap) {

        ColorAction action = new ColorAction(getActivity(), stringArrayId, new ColorActionListener() {
            @Override
            public void onAction(ActionEvent<Integer> actionEvent) {
                changeBackgroundColor(actionEvent, rootView);
            }
        });
        action.addColorMap(colorMap);

        Alfred.rememberThisAction(action);
    }

    private void changeBackgroundColor(ActionEvent<Integer> actionEvent, final View rootView) {
        Integer color = actionEvent.getValue();
        changeColor(color, rootView);
    }

    private void changeColor(Integer color, final View rootView) {
        Integer colorFrom = lastColor;
        Integer colorTo = color;
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(TRANSITION_TIME);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                rootView.setBackgroundColor((Integer) animator.getAnimatedValue());
            }
        });

        colorAnimation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if (lastColor == Color.BLACK) {
                    // FUN HERE!!!!
                    Toast.makeText(getActivity(), getString(R.string.i_dont_see_you_sir), Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            changeColor(Color.WHITE, rootView);
                        }
                    }, 2000);

                } else {
                    Toast.makeText(getActivity(), getString(R.string.color_changed_message), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        colorAnimation.start();
        lastColor = color;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(LAST_COLOR, lastColor);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        Map<Integer, Integer> colorMap = new HashMap<Integer, Integer>();
        colorMap.put(R.string.color_grey, getResources().getColor(R.color.gray));
        colorMap.put(R.string.color_red, getResources().getColor(R.color.red));
        colorMap.put(R.string.color_yellow, getResources().getColor(R.color.yellow));
        colorMap.put(R.string.color_green, getResources().getColor(R.color.green));
        colorMap.put(R.string.color_white, getResources().getColor(R.color.white));
        colorMap.put(R.string.color_black, getResources().getColor(R.color.black));
        colorMap.put(R.string.color_orange, getResources().getColor(R.color.orange));
        colorMap.put(R.string.color_violet, getResources().getColor(R.color.violet));
        colorMap.put(R.string.color_blue, getResources().getColor(R.color.blue));

        communicateColorActionsToAlfred(rootView, R.array.changeColorCommand, colorMap);
//        communicateColorActionsToAlfred(rootView, R.array.changeActionbarColorCommand, colorMap);

        communicateBrightnessActionToAlfred(rootView, R.array.changeBrightness);

        if (savedInstanceState != null) {
            lastColor = savedInstanceState.getInt(LAST_COLOR, Color.WHITE);
            rootView.setBackgroundColor(lastColor);
//            lastActionBarColor = savedInstanceState.getInt(LAST_ACTION_BAR_COLOR, Color.WHITE);
//            getMainActivity().getActionBar().setBackgroundDrawable(new ColorDrawable(lastColor));
        }
        return rootView;
    }

    private void communicateBrightnessActionToAlfred(final View rootView, int actionArrayId) {

        BrightnessAction action = new BrightnessAction(getActivity(), actionArrayId, new BrightnessActionListener() {
            @Override
            public void onAction(ActionEvent<Integer> actionEvent) {

                Integer value = actionEvent.getValue();
                value = actionEvent.getValueParameter().equals("-") ? value * -1 : value;

                int newColor = changeBrightness(lastColor, actionEvent.getValue());
                changeColor(newColor, rootView);
            }
        });

        Alfred.rememberThisAction(action);
    }

    private int changeBrightness(Integer lastColor, Integer value) {
        float[] hsv = new float[3];
        Color.colorToHSV(lastColor, hsv);




        hsv[1] = hsv[1] - (value / 100f);

        if (hsv[1] > 1) {
            hsv[1] = 1;
        } else if (hsv[1] < 0) {
            hsv[1] = 0;
        }
        return Color.HSVToColor(hsv);
    }
}
