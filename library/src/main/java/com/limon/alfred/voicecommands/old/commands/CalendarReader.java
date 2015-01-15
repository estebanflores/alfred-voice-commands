///**
// * Limon Solutions - 2014 - Esteban Flores <esteban.flores@gmail.com>
// *
// * This file is part of Alfred Voice Command project.
// *
// *
// * Licensed to the Apache Software Foundation (ASF) under one
// * or more contributor license agreements.  See the NOTICE file
// * distributed with this work for additional information
// * regarding copyright ownership.  The ASF licenses this file
// * to you under the Apache License, Version 2.0 (the
// * "License"); you may not use this file except in compliance
// * with the License.  You may obtain a copy of the License at
// *
// *    http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing,
// * software distributed under the License is distributed on an
// * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// * KIND, either express or implied.  See the License for the
// * specific language governing permissions and limitations
// * under the License.
// */
//package com.limon.alfred.voicecommands.old.commands;
//
//import android.app.Activity;
//import android.content.Intent;
//
//import com.limon.alfred.voicecommands.old.gui.CalendarActivity;
//import com.limon.alfred.voicecommands.old.objects.OutputObject;
//
///**
// * @author estebanflores
// *
// */
//public class CalendarReader extends ActivityCommand implements ICommand {
//	/**
//	 * @param outputObject
//	 */
//	public CalendarReader(OutputObject outputObject) {
//		super(outputObject);
//	}
//
//	public void execute(Activity previousActivity) {
//		Intent intent = new Intent(previousActivity, CalendarActivity.class);
//
//		parseValues(intent, object);
//
//		previousActivity.startActivity(intent);
//	}
//
//	/*
//	 * (non-Javadoc)
//	 *
//	 * @see
//	 * com.nebulosa.secretarius.commands.ActivityCommand#parseValues(android
//	 * .content.Intent, com.nebulosa.secretarius.objects.OutputObject)
//	 */
//	@Override
//	protected void parseValues(Intent intent, OutputObject object) {
//		intent.putExtra(CalendarActivity.CALENDAR_QUERY, object);
//	}
//
//}