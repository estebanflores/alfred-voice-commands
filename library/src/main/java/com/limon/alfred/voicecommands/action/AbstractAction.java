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
package com.limon.alfred.voicecommands.action;

import android.content.Context;

import com.limon.alfred.voicecommands.exception.NotValidValueException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public abstract class AbstractAction<T> implements Action {

    protected final ActionListener listener;
    private final List<String> commandPatternList;
    private final Locale locale;
    private int commandResourceArray = Integer.MIN_VALUE;
    private Context context;

    public AbstractAction(String commandPattern, Locale locale, ActionListener listener) {

        this.commandPatternList = new ArrayList<String>();
        commandPatternList.add(commandPattern);
        this.locale = locale;
        this.listener = listener;
    }

    public AbstractAction(List<String> commandPattern, Locale locale, ActionListener listener) {
        this.commandPatternList = commandPattern;
        this.locale = locale;
        this.listener = listener;
    }

    public AbstractAction(Context context, int stringArrayId, ActionListener actionListener) {
        this.commandResourceArray = stringArrayId;
        this.listener = actionListener;
        this.context = context;
        commandPatternList = null;
        locale = null;
    }

    protected List<String> getCommandPatterns() {
        if (commandPatternList == null && commandResourceArray != Integer.MIN_VALUE) {
            return Arrays.asList(context.getResources().getStringArray(commandResourceArray));
        } else {
            return commandPatternList;
        }
    }

    @Override
    public void executeAction(String command, String value, String valueParameter) throws NotValidValueException {
        if (isValidValue(value)) {
            T extractedValue = convertValue(value);
            listener.onAction(new ActionEvent(value, extractedValue, valueParameter));
        }
    }

    protected abstract T convertValue(String valueAsString) throws NotValidValueException;

    protected abstract boolean isValidValue(String value);

    public Context getContext() {
        return context;
    }
}