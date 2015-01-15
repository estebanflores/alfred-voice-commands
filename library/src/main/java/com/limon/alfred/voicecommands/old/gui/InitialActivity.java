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
// *//*
//
//package com.limon.alfred.voicecommands.old.gui;
//
//import java.util.ArrayList;
//import java.util.Timer;
//import java.util.TimerTask;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.speech.RecognizerIntent;
//import android.util.Log;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.ImageButton;
//import android.widget.Spinner;
//import android.widget.AdapterView.OnItemSelectedListener;
//
//import com.nebulosa.secretarius.R;
//import com.limon.alfred.voicecommands.old.commands.CommandCreator;
//import com.limon.alfred.voicecommands.old.commands.ICommand;
//
//*/
///**
// * @author estebanflores
// *
// *//*
//
//public class InitialActivity extends VoiceDetectionActivity implements OnClickListener,
//		OnItemSelectedListener {
//	private static final int VOICE_RECOGNITION_REQUEST_CODE = 1234;
//	private CommandCreator commandCreator;
//	private Spinner testSpinner;
//	private boolean loaded = false;
//	private Timer closeTimer;
//	private boolean close = true;
//
//	*/
///*
//	 * (non-Javadoc)
//	 *
//	 * @see android.app.Activity#onCreate(android.os.Bundle)
//	 *//*
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//
//		commandCreator = new CommandCreator(this);
//
//		// Inflate our UI from its XML layout description.
//		setContentView(R.layout.initial);
//
//		// Get display items for later interaction
//		ImageButton speakButton = (ImageButton) findViewById(R.id.SpeakButton);
//
//		if (isVoiceDetectionPresent()) {
//			speakButton.setOnClickListener(this);
//		} else {
//			speakButton.setEnabled(false);
//			// TODO: show dialog
//			// showDialog("Recognizer not present");
//		}
//
//		if (getString(R.string.debug).equals("1")) {
//			loadTestCombo();
//		}
//		// startCloseTimer();
//		close = true;
//	}
//
//	*/
///**
//     *
//     *//*
//
//	private void startCloseTimer() {
//		// close = true;
//		closeTimer = new Timer("close");
//		closeTimer.schedule(new TimerTask() {
//
//			@Override
//			public void run() {
//				if (close)
//					InitialActivity.this.finish();
//
//			}
//		}, 5000);
//
//	}
//
//	*/
///*
//	 * (non-Javadoc)
//	 *
//	 * @see android.app.Activity#onResume()
//	 *//*
//
//	@Override
//	protected void onResume() {
//		startCloseTimer();
//		super.onResume();
//	}
//
//	*/
///**
//     *
//     *//*
//
//	private void loadTestCombo() {
//		// Get display items for later interaction
//		testSpinner = (Spinner) findViewById(R.id.TestCombo);
//
//		testSpinner.setVisibility(Spinner.VISIBLE);
//
//		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//				R.array.TestSpeechs, android.R.layout.simple_spinner_item);
//		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//		testSpinner.setAdapter(adapter);
//
//		// testSpinner.setSelection(-1);
//
//		testSpinner.setOnItemSelectedListener(this);
//	}
//
//	*/
///*
//	 * (non-Javadoc)
//	 *
//	 * @see android.app.Activity#onActivityResult(int, int,
//	 * android.content.Intent)
//	 *//*
//
//	@Override
//	protected void onActivityResult(int requestCode, int resultCode, Intent resultList) {
//
//		if (requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode == RESULT_OK) {
//			// Fill the list view with the strings the recognizer thought it
//			// could have heard
//			ArrayList<String> matches = resultList
//					.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
//
//			for (String string : matches) {
//				Log.d("detected", string);
//				// TODO: define LANG code
//				ICommand commandPattern = commandCreator.createCommand(string, "");
//				commandPattern.execute(this);
//				// TODO: we need the first match ?!?
//				break;
//			}
//		} else {
//			close = true;
//
//		}
//
//		super.onActivityResult(requestCode, resultCode, resultList);
//	}
//
//	public void onClick(View v) {
//		if (v.getId() == R.id.SpeakButton) {
//			close = false;
//			startVoiceRecognition(VOICE_RECOGNITION_REQUEST_CODE);
//		}
//	}
//
//	*/
///*
//	 * (non-Javadoc)
//	 *
//	 * @see
//	 * android.widget.AdapterView.OnItemSelectedListener#onItemSelected(android
//	 * .widget.AdapterView, android.view.View, int, long)
//	 *//*
//
//	public void onItemSelected(AdapterView<?> arg0, View arg1, int pos, long id) {
//		// FIXME: avoid first run
//		if (pos != -1 && loaded) {
//			close = false;
//			ICommand commandPattern = commandCreator.createCommand(testSpinner.getItemAtPosition(pos)
//					.toString(), "");
//			commandPattern.execute(this);
//		}
//		loaded = true;
//	}
//
//	*/
///*
//	 * (non-Javadoc)
//	 *
//	 * @see
//	 * android.widget.AdapterView.OnItemSelectedListener#onNothingSelected(android
//	 * .widget.AdapterView)
//	 *//*
//
//	public void onNothingSelected(AdapterView<?> arg0) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
//*/
