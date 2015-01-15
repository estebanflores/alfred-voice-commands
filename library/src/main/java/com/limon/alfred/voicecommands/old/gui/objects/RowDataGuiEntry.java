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
//package com.nebulosa.secretarius.gui.objects;
//
//import java.util.Formatter;
//
//import android.content.Context;
//import android.speech.tts.TextToSpeech;
//
//import com.nebulosa.secretarius.R;
//import com.nebulosa.secretarius.calendar.CalendarUtils;
//import com.nebulosa.secretarius.objects.CalendarEntry;
//import com.nebulosa.secretarius.tts.Readable;
//
///**
// * @author estebanflores
// *
// */
//public class RowDataGuiEntry implements Readable
//{
//    private CalendarEntry calendarEntry;
//    private String header;
//
//    /*
//     * (non-Javadoc)
//     *
//     * @see
//     * com.nebulosa.secretarius.tts.Readable#read(android.speech.tts.TextToSpeech
//     * )
//     */
//    public void read(Context context, TextToSpeech voice, int queueMode)
//    {
//	// Calendar ROW
//	if (calendarEntry != null)
//	{
//	    String timeStr = CalendarUtils.getDateTimeToTimeStr(calendarEntry.getBegin());
//	    String toTimeStr = CalendarUtils.getDateTimeToTimeStr(calendarEntry.getEnd());
//
//	    String filteredTitle = CalendarUtils.filterLinks(calendarEntry.getTitle());
//
//	    if (filteredTitle.length() != calendarEntry.getTitle().length())
//	    {
//		filteredTitle = filteredTitle + context.getString(R.string.view_details);
//	    }
//
//	    if (calendarEntry.getAllDay())
//	    {
//		voice.speak(filteredTitle, queueMode, null);
//	    }
//	    else
//	    {
//		Formatter formatter = new Formatter();
//		formatter.format(context.getString(R.string.read_event_text), timeStr, toTimeStr, filteredTitle);
//		voice.speak(formatter.toString(), queueMode, null);
//	    }
//
//
//	}
//	// Header ROW
//	if (header != null)
//	{
//	    voice.speak(header, queueMode, null);
//	}
//
//    }
//
//    /**
//     * @param calendarEntry
//     */
//    public RowDataGuiEntry(CalendarEntry calendarEntry)
//    {
//	this.calendarEntry = calendarEntry;
//    }
//
//    public RowDataGuiEntry(String header)
//    {
//	this.header = header;
//    }
//
//    /**
//     * @return the calendarEntry
//     */
//    public CalendarEntry getCalendarEntry()
//    {
//	return calendarEntry;
//    }
//
//    /**
//     * @param calendarEntry
//     *            the calendarEntry to set
//     */
//    public void setCalendarEntry(CalendarEntry calendarEntry)
//    {
//	this.calendarEntry = calendarEntry;
//    }
//
//    /**
//     * @return the header
//     */
//    public String getHeader()
//    {
//	return header;
//    }
//
//    /**
//     * @param header
//     *            the header to set
//     */
//    public void setHeader(String header)
//    {
//	this.header = header;
//    }
//
//    /* (non-Javadoc)
//     * @see java.lang.Object#toString()
//     */
//    @Override
//    public String toString()
//    {
//        String text = null;
//        if (header != null) text = "HEADER: " + header;
//        if (calendarEntry != null) text = "CALENDAR ENTRY: " + calendarEntry;
//        return text;
//    }
//}
