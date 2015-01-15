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

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static com.limon.alfred.voicecommands.utils.Utils.hasText;
import static com.limon.alfred.voicecommands.utils.Utils.isMultiple;
import static com.limon.alfred.voicecommands.utils.Utils.multiple;

public class ColorAction extends CommandAction<Integer> {

    Map<Integer, Integer> colorResourceMap = new HashMap<Integer, Integer>();
    Map<String, Integer> colorStringMap = new HashMap<String, Integer>();

    public ColorAction(String command, Locale locale, ColorActionListener actionListener) {
        super(command, locale, actionListener);
    }

    public ColorAction(final Context context, int stringArray, ColorActionListener actionListener) {
        super(context, stringArray, actionListener);
    }


    @Override
    protected boolean isValidValue(String value) {
        return value != null && !value.equals("");
    }

    public void addColorMap(Map<Integer, Integer> colorMap) {
        colorResourceMap.putAll(colorMap);
    }

    @Override
    protected Integer convertValue(String valueAsString) throws NotValidValueException {

        updateColorStringMap();

        Integer color = colorStringMap.get(valueAsString.trim());

        if (color != null) {
            return color;
        }

        throw new NotValidValueException(valueAsString);
    }

    private void updateColorStringMap() {
        if (colorStringMap.size() == 0) {
            for (Integer resource : colorResourceMap.keySet()) {
                String colorValue = getContext().getString(resource);
                if (hasText(colorValue)) {
                    if (isMultiple(colorValue)) {
                        for (String value : multiple(colorValue)) {
                            colorStringMap.put(value, colorResourceMap.get(resource));
                        }
                    } else {
                        colorStringMap.put(colorValue, colorResourceMap.get(resource));
                    }
                }
            }
        }

    }
}
