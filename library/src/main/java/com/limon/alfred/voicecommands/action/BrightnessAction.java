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

import java.util.Locale;

public class BrightnessAction extends CommandAction<Integer> {

    public BrightnessAction(String command, Locale locale, BrightnessActionListener listener) {
        super(command, locale, listener);
    }

    public BrightnessAction(final Context context, int commandArrayId, BrightnessActionListener listener) {
        super(context, commandArrayId, listener);
    }

    @Override
    protected Integer convertValue(String valueAsString) throws NotValidValueException {
        return Integer.parseInt(valueAsString);
    }

    @Override
    protected boolean isValidValue(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
