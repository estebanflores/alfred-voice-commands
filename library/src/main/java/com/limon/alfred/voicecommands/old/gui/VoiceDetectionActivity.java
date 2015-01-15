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
//package com.limon.alfred.voicecommands.old.gui;
//
//import java.util.List;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.content.pm.ResolveInfo;
//import android.speech.RecognizerIntent;
//
//
//
///**
// * @author estebanflores
// *
// */
//public class VoiceDetectionActivity extends Activity {
//
//	protected Boolean isVoiceDetectionPresent() {
//		// Check to see if a recognition activity is present
//		PackageManager pm = getPackageManager();
//		List<ResolveInfo> activities = pm.queryIntentActivities(new Intent(
//				RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
//
//		return activities.size() != 0;
//	}
//
//	/**
//	 * Fire an intent to start the speech recognition activity.
//	 */
//	public void startVoiceRecognition(final int VoiceRecognitionCode) {
//		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
//				RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
//		intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
//				getString(R.string.SpeechRecognition));
//		startActivityForResult(intent, VoiceRecognitionCode);
//	}
//
//}
