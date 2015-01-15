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

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.limon.alfred.voicecommands.Alfred;
import com.limon.alfred.voicecommands.exception.NotValidValueException;

public class BaseScenarioFragment extends Fragment {

//    private EditText commandText;

    public BaseScenarioFragment() {

    }

    public void callAlfred(String command) {

        try {
            Alfred.pleaseDoNow(command);
        } catch (NotValidValueException e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

//    public void clear(View view) {
//        commandText.setText("");
//    }

    public MainActivity getMainActivity() {
        return (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//        commandText = (EditText) rootView.findViewById(R.id.commandText);
//
//        Button clearButton = (Button) rootView.findViewById(R.id.clearButton);
//        clearButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                clear(view);
//            }
//        });
//
//        Button okButton = (Button) rootView.findViewById(R.id.okButton);
//        okButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                callAlfred();
//            }
//        });

        return rootView;
    }

    @Override
    public void onDestroy() {
        Alfred.forgetAll();
        super.onDestroy();
    }

//    private void AddActionToAlfred(final View rootView, String commandPattern) {
//
//        ColorAction action = new ColorAction(commandPattern, Locale.ENGLISH, new ColorActionListener() {
//            @Override
//            public void onAction(ActionEvent<Integer> actionEvent) {
//                setBackgroundColor(actionEvent, rootView);
//            }
//        });
//
//        Alfred.rememberThisAction(action);
//    }

}
