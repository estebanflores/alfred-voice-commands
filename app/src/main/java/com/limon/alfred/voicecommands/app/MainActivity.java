package com.limon.alfred.voicecommands.app;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.limon.alfred.voicecommands.Alfred;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class MainActivity extends ActionBarActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;
    private SpeechRecognizer speechRecognizer;
    private String TAG = "AlfredApp";
    private BaseScenarioFragment currentFragment;
    private SearchView searchView;
    private MenuItem speakMenuItem;
    private boolean isListening;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_activity_main);

        handleIntent(getIntent());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        currentFragment = (BaseScenarioFragment) mSectionsPagerAdapter.getItem(0);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
            }

            @Override
            public void onPageSelected(int i) {
                currentFragment = (BaseScenarioFragment) mSectionsPagerAdapter.getItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });


        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            public void onReadyForSpeech(Bundle params) {
                Log.d(TAG, "onReadyForSpeech");
                speakMenuItem.setIcon(R.drawable.ic_action_speak_prepared);
                isListening = true;
            }

            public void onBeginningOfSpeech() {
                Log.d(TAG, "onBeginningOfSpeech");
                speakMenuItem.setIcon(R.drawable.ic_action_speaking);
            }

            public void onRmsChanged(float rmsdB) {
                Log.d(TAG, "onRmsChanged");
            }

            public void onBufferReceived(byte[] buffer) {
                Log.d(TAG, "onBufferReceived");
            }

            public void onEndOfSpeech() {
                Log.d(TAG, "onEndOfSpeech");
                speakMenuItem.setIcon(android.R.drawable.ic_btn_speak_now);
                isListening = false;
            }

            public void onError(int error) {
                Log.d(TAG, "error " + error);
            }

            public void onResults(Bundle results) {
                String str = new String();
                Log.d(TAG, "onResults " + results);
                ArrayList<String> data = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                for (int i = 0; i < data.size(); i++) {
                    Log.d(TAG, "result " + data.get(i));
                    str += data.get(i);
                }
                currentFragment.callAlfred(data.get(0));
//                Toast.makeText(getApplicationContext(), "results: " + String.valueOf(data.size()), Toast.LENGTH_LONG).show();
            }

            public void onPartialResults(Bundle partialResults) {
                Log.d(TAG, "onPartialResults");
            }

            public void onEvent(int eventType, Bundle params) {
                Log.d(TAG, "onEvent " + eventType);
            }
        });
    }

    public SpeechRecognizer getSpeechRecognizer() {
        return speechRecognizer;
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onDestroy() {
        speechRecognizer.destroy();
        Alfred.forgetAll();
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.speak) {
            startSpeaking();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        // Associate searchable configuration with the SearchView
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        speakMenuItem = menu.findItem(R.id.speak);

        return true;
    }

    public void startSpeaking() {
        if (!isListening) {
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, Locale.getDefault().getLanguage());
            intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
            intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getPackageName());
            speechRecognizer.startListening(intent);
        } else {
            stopListening();
        }
    }

    private void stopListening() {
        speechRecognizer.stopListening();
        speakMenuItem.setIcon(android.R.drawable.ic_btn_speak_now);
        isListening = false;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            currentFragment.callAlfred(query);
            searchView.onActionViewCollapsed();
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        //TODO: change this class!!!
        List<BaseScenarioFragment> fragments;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
            fragments = new ArrayList<BaseScenarioFragment>(3);
        }

        @Override
        public Fragment getItem(int position) {

            BaseScenarioFragment fragment = null;
            switch (position) {
                case 0:
                    if (fragments.size() <= position) {
                        fragments.add(position, new ColorScenarioFragment());
                    }
                    return fragments.get(position);
                case 1:
                    if (fragments.size() <= position) {
                        fragments.add(position, new Scenario2());
                    }
                    return fragments.get(position);
                case 2:
                    if (fragments.size() <= position) {
                        fragments.add(position, new Scenario3());
                    }
                    return fragments.get(position);
                default:
                    return fragments.get(0);
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }
}
