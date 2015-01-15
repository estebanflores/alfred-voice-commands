/**
* Limon Solutions - 2014 - Esteban Flores <esteban.flores@gmail.com>
*
* This file is part of Alfred Voice Command project.
*
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
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package com.limon.alfred.voicecommands.old.gui;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;


/**
 * @author estebanflores
 *
 */
public abstract class SpeakActivity extends Activity implements TextToSpeech.OnInitListener
{
    
    public abstract void readActivity();
    
    
    protected TextToSpeech voice;
    private static final String TAG = "SpeechActivity";

    protected void speak(String text)
    {
	if (voice.isSpeaking())
	{
	    voice.speak(text, TextToSpeech.QUEUE_ADD, null);
	}
	else
	{
	    voice.speak(text, TextToSpeech.QUEUE_FLUSH, null);   
	}
	
    }
    
    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
	voice = new TextToSpeech(this, this);
        super.onCreate(savedInstanceState);
    }

    /* (non-Javadoc)
     * @see android.speech.tts.TextToSpeech.OnInitListener#onInit(int)
     */
    public void onInit(int status)
    {
	// status can be either TextToSpeech.SUCCESS or TextToSpeech.ERROR.
	if (status == TextToSpeech.SUCCESS) {
	    // Set preferred language to US english.
	    // Note that a language may not be available, and the result will
	    // indicate this.
	    int result = voice.setLanguage(new Locale("es"));
	    // Try this someday for some interesting results.
	    // int result mTts.setLanguage(Locale.FRANCE);
	    if (result == TextToSpeech.LANG_MISSING_DATA
		    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
		// Lanuage data is missing or the language is not supported.
		Log.e(TAG, "Language is not available.");
	    } else {
		// Check the documentation for other possible result codes.
		// For example, the language may be available for the locale,
		// but not for the specified country and variant.

		// The TTS engine has been successfully initialized.
		// Allow the user to press the button for the app to speak
		// again.
		// mAgainButton.setEnabled(true);
		// Greet the user.
		// saySomething();
	    }
	} else {
	    // Initialization failed.
//	    Log.e(TAG, "Could not initialize TextToSpeech.");
	}

	
    }
    
    /* (non-Javadoc)
     * @see android.app.Activity#onPause()
     */
    @Override
    protected void onPause()
    {
//        voice.stop();
        super.onPause();
    }
    
    
    /* (non-Javadoc)
     * @see android.app.Activity#onDestroy()
     */
    @Override
    protected void onDestroy()
    {
	if (voice != null) {
	    voice.stop();
	    voice.shutdown();
	}

	super.onDestroy();
    }

}
