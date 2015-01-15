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
//import java.util.List;
//import java.util.SortedSet;
//
//import android.graphics.Color;
//import android.os.Bundle;
//import android.speech.tts.TextToSpeech;
//import android.util.Log;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.ListView;
//
//import com.nebulosa.secretarius.R;
//import com.limon.alfred.voicecommands.old.calendar.CalendarAccess;
//import com.limon.alfred.voicecommands.old.calendar.CalendarUtils;
//import com.limon.alfred.voicecommands.old.gui.adapters.CalendarGuiEntryAdapter;
//import com.nebulosa.secretarius.gui.objects.RowDataGuiEntry;
//import com.limon.alfred.voicecommands.old.objects.CalendarEntry;
//import com.limon.alfred.voicecommands.old.objects.CalendarQuery;
//
//*/
///**
// * @author estebanflores
// *
// *//*
//
//public class CalendarActivity extends SpeakActivity implements OnItemClickListener
//{
//
//    public static final String CALENDAR_QUERY = "CALENDAR_QUERY";
//
//    private ListView calendarListView;
//    private Boolean wasReaded = false;
//    private CalendarQuery calendarQuery;
//    private CalendarGuiEntryAdapter calendarEntryAdapter;
//    private List<RowDataGuiEntry> calendarGuiEntries;
//
//    */
///*
//     * (non-Javadoc)
//     *
//     * @see android.app.Activity#onCreate(android.os.Bundle)
//     *//*
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//
//	super.onCreate(savedInstanceState);
//
//	// FIXME: Android recommend doesnt pass objects
//	calendarQuery = (CalendarQuery) getIntent().getExtras().get(CALENDAR_QUERY);
//
//	// inflate Layout
//	setContentView(R.layout.event_list);
//	// locate ListView
//	calendarListView = (ListView) findViewById(R.id.ListView);
//	calendarListView.setOnItemClickListener(this);
//
//	// setTitle(getString(R.string.app_name) + " - " +
//	// getString(R.string.WeekEvents));
//
//	// show in title last commandPattern received
//	setTitle("Secretarius - " + calendarQuery.getOriginalCommand());
//	setTitleColor(Color.GREEN);
//
//	calendarGuiEntries = new ArrayList<RowDataGuiEntry>();
//
//	// preapre calendar row Adaptor
//	int resId = R.layout.calendar_entry_item;
//	calendarEntryAdapter = new CalendarGuiEntryAdapter(this, resId, calendarGuiEntries);
//	calendarListView.setAdapter(calendarEntryAdapter);
//    }
//
//    */
///**
//     * @param guiEntryList
//     * @param calendarEntryList
//     *//*
//
//    private void adaptList(List<RowDataGuiEntry> guiEntryList, SortedSet<CalendarEntry> calendarEntryList)
//    {
//	String lastDate = "";
//
//	guiEntryList.clear();
//
//	Log.d("Secretarius", "adapted list readed");
//	for (CalendarEntry calendarEntry : calendarEntryList)
//	{
//	    RowDataGuiEntry newRow;
//
//	    String dateString = CalendarUtils.getDateTimeToLongDateStr(this, calendarEntry.getBegin());
//	    if (lastDate.equals("") || !lastDate.equals(dateString))
//	    {
//		lastDate = dateString;
//		newRow = new RowDataGuiEntry(dateString);
//		guiEntryList.add(newRow);
//
//	    }
//
//	    newRow = new RowDataGuiEntry(calendarEntry);
//	    guiEntryList.add(newRow);
//	}
//
//
//    }
//
//    // private void loadCalendarEntries(int calendarlapsusCode)
//    // {
//    // try
//    // {
//    // if (calendarEntryList != null) calendarEntryList.clear();
//    //
//    // calendarEntryList.addAll(CalendarAccess.getEventList(this,
//    // calendarlapsusCode));
//    //
//    // } catch (Exception e)
//    // {
//    // // showDialog(0);
//    // }
//    // }
//
//    */
///*
//     * (non-Javadoc)
//     *
//     * @see android.app.Activity#onResume()
//     *//*
//
//    @Override
//    protected void onResume()
//    {
//	try
//	{
//	    adaptList(calendarGuiEntries, CalendarAccess.getEventList(this, calendarQuery.getLapsusCode()));
//	} catch (Exception e)
//	{
//	    e.printStackTrace();
//	}
//	// loadCalendarEntries(calendarQuery.getLapsusCode());
//	// populateList(eventList, adapter);
//		super.onResume();
//    }
//
//    */
///*
//     * (non-Javadoc)
//     *
//     * @see com.nebulosa.secretarius.gui.SpeakActivity#onInit(int)
//     *//*
//
//    @Override
//    public void onInit(int status)
//    {
//    	super.onInit(status);
//		if (!wasReaded)
//		{
//		    readActivity();
//		}
//    }
//
//    */
///**
//     * @param calendarGuiEntries2
//     *//*
//
//    private void readEvents(List<RowDataGuiEntry> rowDataList)
//    {
//		for (RowDataGuiEntry dataGuiEntry : rowDataList)
//		{
//		    dataGuiEntry.read(this.getApplicationContext(), voice, TextToSpeech.QUEUE_ADD);
//		}
//    }
//
//    */
///*
//     * (non-Javadoc)
//     *
//     * @see
//     * android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget
//     * .AdapterView, android.view.View, int, long)
//     *//*
//
//    public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long id)
//    {
//    	calendarGuiEntries.get(pos).read(this.getApplicationContext(), voice, TextToSpeech.QUEUE_FLUSH);
//
//	// Intent intent = new Intent(Intent.ACTION_EDIT);
//	// intent.setType("vnd.android.cursor.item/event");
//	// intent.putExtra("event_id", calendarEntry.getEventId());
//	// intent.putExtra("calendar_id", calendarEntry.getCalendarId());
//	//
//	// startActivity(intent);
//    }
//
//    */
///*
//     * (non-Javadoc)
//     *
//     * @see com.nebulosa.secretarius.gui.SpeakActivity#ReadActivity()
//     *//*
//
//    @Override
//    public void readActivity()
//    {
//    	wasReaded = true;
//    	readEvents(calendarGuiEntries);
//    }
//
//    */
///* (non-Javadoc)
//     * @see com.nebulosa.secretarius.gui.SpeakActivity#onPause()
//     *//*
//
//    @Override
//    protected void onPause()
//    {
//		voice.stop();
//		super.onPause();
//    }
//
//    */
///* (non-Javadoc)
//     * @see android.app.Activity#onStop()
//     *//*
//
//    @Override
//    protected void onStop()
//    {
//    	voice.stop();
//        super.onStop();
//    }
//
//}
//*/
