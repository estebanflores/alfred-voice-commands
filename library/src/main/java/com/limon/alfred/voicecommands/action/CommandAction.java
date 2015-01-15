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
import android.util.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.limon.alfred.voicecommands.utils.Utils.hasText;

public abstract class CommandAction<T> extends AbstractAction<T> {

    /* http://regex101.com/r/fL1rX8/1 */
    private static final String COMMAND_REG_EXP = "\\((.+)\\)(.*)\\[(.+)\\](.*)\\{(.*)\\}";
    private static final String IGNORE_PREFIX = ".*";
    private static final String SUFFIX = IGNORE_PREFIX;
    private Map<String, String> validationPatternList;
    private String validatedPattern;
    private String validateParameter;

    public CommandAction(String command, Locale locale, ActionListener listener) {
        super(command, locale, listener);
        validationPatternList = new HashMap<String, String>();
        generateValidationPattern(command);
    }

    public CommandAction(final Context context, final int stringArray, final ActionListener actionListener) {
        super(context, stringArray, actionListener);
        validationPatternList = new HashMap<String, String>();
        List<String> patternList = getCommandPatterns();
        for (String commandPattern : patternList) {
            generateValidationPattern(commandPattern);
        }
    }

    protected void generateValidationPattern(final String command) {
        Pattern pattern = Pattern.compile(COMMAND_REG_EXP);
        Matcher matcher = pattern.matcher(command);

        if (matcher.matches()) {
            String verb = matcher.group(1);
            String extra = matcher.group(2);
            String object = matcher.group(3);
            String extra2 = matcher.group(4);
            String value = matcher.group(5);
            validationPatternList.put(buildValidationPattern(verb, extra, object, extra2), value);
        }
    }

    protected String buildValidationPattern(String verb, String extra, String object, String extra2) {

        return IGNORE_PREFIX + group(verb) + handleExtra(extra) + group(object) + handleExtra(extra2) + "(\\w+)" + SUFFIX;

    }

    protected String handleExtra(String extra) {
        if (!hasText(extra.trim())) {
            return "\\s";
        } else {
            return new StringBuilder().append("\\s").append(extra.trim()).append("\\s").toString();
        }
    }

    protected String group(String element) {
        return new StringBuilder().append("(").append(element).append(")").toString();
    }

    @Override
    public String getPattern() {
        return COMMAND_REG_EXP;
    }

    @Override
    public boolean validate(String introducedCommand) {

        for (String pattern : validationPatternList.keySet()) {
            if (validateSinglePattern(pattern, introducedCommand)) {
                validatedPattern = pattern;
                validateParameter = validationPatternList.get(pattern);
                return true;
            }
        }

        return false;
    }

    private boolean validateSinglePattern(String validationPattern, String introducedCommand) {
        Pattern pattern = Pattern.compile(validationPattern);
        Matcher matcher = pattern.matcher(introducedCommand);
        Log.d("Alfred", "Introduced text: " + introducedCommand);
        Log.d("Alfred", "validation Pattern: " + validationPattern);
        Log.d("Alfred", "match?: " + matcher.matches());
        return matcher.matches();
    }

    public String getValueFromText(String introducedCommand) {
        Pattern pattern = Pattern.compile(validatedPattern);
        Matcher matcher = pattern.matcher(introducedCommand);

        Log.d("Alfred", "Introduced text: " + introducedCommand);
        Log.d("Alfred", "validation Pattern: " + validatedPattern);
        Log.d("Alfred", "match?: " + matcher.matches());

        if (matcher.matches()) {
            Log.d("Alfred", "valor: " + matcher.group(3));
            return matcher.group(3);
        }

        return null;
    }

    public String getParameterValue() {
        return validateParameter;
    }

}
