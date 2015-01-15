///**
//* Limon Solutions - 2014 - Esteban Flores <esteban.flores@gmail.com>
//*
//* This file is part of Alfred Voice Command project.
//*
//*
//* Licensed to the Apache Software Foundation (ASF) under one
//* or more contributor license agreements.  See the NOTICE file
//* distributed with this work for additional information
//* regarding copyright ownership.  The ASF licenses this file
//* to you under the Apache License, Version 2.0 (the
//* "License"); you may not use this file except in compliance
//* with the License.  You may obtain a copy of the License at
//*
//*    http://www.apache.org/licenses/LICENSE-2.0
//*
//* Unless required by applicable law or agreed to in writing,
//* software distributed under the License is distributed on an
//* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
//* KIND, either express or implied.  See the License for the
//* specific language governing permissions and limitations
//* under the License.
//*/
//package com.limon.alfred.voicecommands.old.commands;
//
//import android.app.Activity;
//
//import com.limon.alfred.voicecommands.old.objects.CalendarQuery;
//import com.limon.alfred.voicecommands.old.objects.OutputObject;
//import com.limon.alfred.voicecommands.old.processing.InputTextProcessor;
//
///**
// * Implemantation Factory Method for the creation of commands
// * @author estebanflores
// *
// */
//public class CommandCreator extends AbstractCommandCreator
//{
//    private InputTextProcessor textProcessor;
//
//    /**
//     *  Constructs a new instance of CommandCreator
//     */
//    public CommandCreator(Activity activity)
//    {
//	textProcessor = new InputTextProcessor(activity);
//    }
//
//    /* (non-Javadoc)
//     * @see com.nebulosa.Secretarius.commands.AbstractCommandCreator#CreateCommand()
//     */
//    @Override
//    public ICommand createCommand(String text, String lang)
//    {
//	OutputObject outputObject = interpretateInputText(text, lang);
//
//	if (outputObject.getClass().equals(CalendarQuery.class))
//	{
//	    return new CalendarReader(outputObject);
//	}
//
//	return new VoidCommand();
//    }
//
//    /**
//     * This method give as result an OutputObject through the interpretation of the parametrized inputtext
//     * @param inputtext received from google voice service
//     * @return an OutputObject
//     */
//    private OutputObject interpretateInputText(String text, String lang)
//    {
//	textProcessor.process(text, lang);
//	return textProcessor.getOutputObject();
//    }
//
//}