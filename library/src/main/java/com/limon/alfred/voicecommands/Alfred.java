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
package com.limon.alfred.voicecommands;

import android.os.Handler;
import android.util.Log;

import com.limon.alfred.voicecommands.action.Action;
import com.limon.alfred.voicecommands.action.ActionBuilder;
import com.limon.alfred.voicecommands.action.ActionListener;
import com.limon.alfred.voicecommands.action.CommandAction;
import com.limon.alfred.voicecommands.exception.NotValidValueException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Alfred {

    private static final String TAG = "Alfred";
    private static List<Action> actionList = new ArrayList<Action>();

    private Alfred() {
    }

    public static final ActionBuilder buildMyActionFromResources() {
        return new ActionBuilder();
    }

    public static final ActionBuilder buildMyActionFromText(String command, Locale locale, ActionListener actionListener) {
        return new ActionBuilder().addTextCommand(command, locale).addActionListener(actionListener);
    }

    public static void rememberThisAction(Action action) {
        actionList.add(action);
    }

    public static void pleaseDo(final String stringCommand) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                try {
                    executeMatchedActions(stringCommand);
                } catch (NotValidValueException e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });

    }

    public static void pleaseDoNow(final String stringCommand) throws NotValidValueException {
        executeMatchedActions(stringCommand);
    }

    private static synchronized void executeMatchedActions(String stringCommand) throws NotValidValueException {

        for (Action action : actionList) {
            if (action.validate(stringCommand)) {
                String value = null;
                String valueParameter = null;
                if (action instanceof CommandAction) {
                    value = ((CommandAction) action).getValueFromText(stringCommand);
                    valueParameter = ((CommandAction) action).getParameterValue();
                }
                action.executeAction(stringCommand, value, valueParameter);
            }
        }
    }

    public static synchronized void forgetThisAction(Action action) {
        actionList.remove(action);
    }

    public static void forgetAll() {
        actionList.clear();
    }

}
