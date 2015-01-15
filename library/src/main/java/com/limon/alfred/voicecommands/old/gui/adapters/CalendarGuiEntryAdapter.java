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
//package com.limon.alfred.voicecommands.old.gui.adapters;
//
//import java.util.List;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import com.nebulosa.secretarius.R;
//import com.limon.alfred.voicecommands.old.calendar.CalendarUtils;
//import com.nebulosa.secretarius.gui.objects.RowDataGuiEntry;
//import com.limon.alfred.voicecommands.old.objects.CalendarEntry;
//
//*/
///**
// * @author estebanflores
// *
// *//*
//
//public class CalendarGuiEntryAdapter extends ArrayAdapter<RowDataGuiEntry>
//{
//
//    int resource;
//    String lastHeader = "";
//
//    */
///**
//     * @param context
//     * @param resourceId
//     * @param objects
//     *//*
//
//    public CalendarGuiEntryAdapter(Context context, int resourceId, List<RowDataGuiEntry> objects)
//    {
//	super(context, resourceId, objects);
//	resource = resourceId;
//    }
//
//    */
///*
//     * (non-Javadoc)
//     *
//     * @see android.widget.ArrayAdapter#getView(int, android.view.View,
//     * android.view.ViewGroup)
//     *//*
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent)
//    {
//	LinearLayout eventView;
//
//	if (convertView == null)
//	{
//	    eventView = new LinearLayout(getContext());
//	    String inflater = Context.LAYOUT_INFLATER_SERVICE;
//	    LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(inflater);
//
//	    convertView = layoutInflater.inflate(resource, eventView, true);
//	    convertView.setTag(eventView);
//	} else
//	{
//	    eventView = (LinearLayout) convertView.getTag();
//	}
//
//	// obtain the entry to show
//	RowDataGuiEntry rowDataGuiEntry = getItem(position);
//
//	TextView fromView = (TextView) eventView.findViewById(R.id.event_from);
//	TextView toView = (TextView) eventView.findViewById(R.id.event_to);
//	TextView messageView = (TextView) eventView.findViewById(R.id.event_message);
//
//	RelativeLayout layout = (RelativeLayout) eventView.findViewById(R.id.calendar_entry_layout);
//
//	TextView headerView = (TextView) eventView.findViewById(R.id.headerText);
//
//	CalendarEntry calendarEntry = rowDataGuiEntry.getCalendarEntry();
//
//	if (calendarEntry != null)
//	{
//	    String from = CalendarUtils.getDateTimeToTimeStr(calendarEntry.getBegin());
//	    String to = CalendarUtils.getDateTimeToTimeStr(calendarEntry.getEnd());
//
//	    headerView.setVisibility(View.GONE);
//
//	    fromView.setVisibility(View.VISIBLE);
//	    toView.setVisibility(View.VISIBLE);
//	    messageView.setVisibility(View.VISIBLE);
//
//	    if (!calendarEntry.getAllDay())
//	    {
//		fromView.setText(from);
//		toView.setText(to);
//		fromView.setVisibility(View.VISIBLE);
//		toView.setVisibility(View.VISIBLE);
//		layout.setBackgroundColor(getContext().getResources().getColor(R.color.task_back));
//	    } else
//	    {
//		layout.setBackgroundColor(getContext().getResources().getColor(R.color.all_day_task_back));
//		fromView.setVisibility(View.INVISIBLE);
//		toView.setVisibility(View.INVISIBLE);
//	    }
//
//	    messageView.setText(calendarEntry.getTitle());
//	}
//	if (rowDataGuiEntry.getHeader() != null)
//	{
//	    headerView.setVisibility(View.VISIBLE);
//
//	    fromView.setVisibility(View.GONE);
//	    toView.setVisibility(View.GONE);
//	    messageView.setVisibility(View.GONE);
//
//	    headerView.setText(rowDataGuiEntry.getHeader());
//	}
//
//	return eventView;
//    }
//}
//*/
