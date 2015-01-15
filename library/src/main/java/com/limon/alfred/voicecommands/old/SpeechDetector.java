//package com.limon.alfred.voicecommands;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.content.pm.ResolveInfo;
//import android.os.Bundle;
//import android.speech.RecognizerIntent;
//import android.speech.tts.TextToSpeech;
//import android.util.Log;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.EditText;
//
//@Deprecated
//public class SpeechDetector extends SystemActivity implements OnClickListener,
//	TextToSpeech.OnInitListener
//{
//
//    private static final int VOICE_RECOGNITION_REQUEST_CODE = 1234;
//    private static final String TAG = "TextToSpeechDemo";
//    private TextToSpeech mTts;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState)
//    {
//		super.onCreate(savedInstanceState);
//
////		 Inflate our UI from its XML layout description.
//		setContentView(R.layout.main);
//
////		 Get display items for later interaction
//		Button speakButton = (Button) findViewById(R.id.SpeechButton);
//
//		 mList = (ListView) findViewById(R.id.list);
//
////		 Check to see if a recognition activity is present
//		PackageManager pm = getPackageManager();
//		List<ResolveInfo> activities = pm.queryIntentActivities(new Intent(
//			RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
//		if (activities.size() != 0) {
//		    speakButton.setOnClickListener(this);
//		} else {
//		    speakButton.setEnabled(false);
////		    TODO: show dialog
//		    showDialog("Recognizer not present");
//		}
//
//    }
//
//
//    @Override
//    protected void onResume()
//    {
////         TODO Auto-generated method stub
//        super.onResume();
//    }
//
//    public void onClick(View v)
//    {
//		if (v.getId() == R.id.SpeechButton) {
//		    startVoiceRecognitionActivity();
//		}
//    }
//
//    private void startVoiceRecognitionActivity()
//	    {
//		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
//			RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
//		intent.putExtra(RecognizerIntent.EXTRA_PROMPT, getString(R.string.SpeechRecognition));
//		startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data)
//    {
//		if (requestCode == VOICE_RECOGNITION_REQUEST_CODE
//			&& resultCode == RESULT_OK) {
////		     Fill the list view with the strings the recognizer thought it
////		     could have heard
//		    ArrayList<String> matches = data
//			    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
//
//		    EditText editText = (EditText) findViewById(R.id.EditText);
//
//		    for (String string : matches) {
//			editText.append(string + "\r\n");
//			saySomething(string);
//		    }
//
//		     mList.setAdapter(new ArrayAdapter<String>(this,
//		     android.R.layout.simple_list_item_1, matches));
//		}
//
//		super.onActivityResult(requestCode, resultCode, data);
//    }
//
//
//    public void onInit(int status)
//    {
////		 status can be either TextToSpeech.SUCCESS or TextToSpeech.ERROR.
//		if (status == TextToSpeech.SUCCESS) {
////		     Set preferred language to US english.
////		     Note that a language may not be available, and the result will
////		     indicate this.
//		    int result = mTts.setLanguage(new Locale("es"));
////		     Try this someday for some interesting results.
//		     int result mTts.setLanguage(Locale.FRANCE);
//		    if (result == TextToSpeech.LANG_MISSING_DATA
//			    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
//			 Lanuage data is missing or the language is not supported.
//			Log.e(TAG, "Language is not available.");
//		    } else {
////			 Check the documentation for other possible result codes.
////			 For example, the language may be available for the locale,
////			 but not for the specified country and variant.
////
////			 The TTS engine has been successfully initialized.
////			 Allow the user to press the button for the app to speak
////			 again.
//			 mAgainButton.setEnabled(true);
////			 Greet the user.
//			 saySomething();
//		    }
//		} else {
//		     Initialization failed.
//		    Log.e(TAG, "Could not initialize TextToSpeech.");
//		}
//
//    }
//
//    @Override
//    public void onDestroy()
//    {
////		 Don't forget to shutdown!
//		if (mTts != null) {
//		    mTts.stop();
//		    mTts.shutdown();
//		}
//
//		super.onDestroy();
//    }
//
//    private void saySomething(String text)
//    {
//    	mTts.speak(text, TextToSpeech.QUEUE_FLUSH,  //Drop all pending entries
//						    // in the playback queue.
//		null);
//    }
//
//}
