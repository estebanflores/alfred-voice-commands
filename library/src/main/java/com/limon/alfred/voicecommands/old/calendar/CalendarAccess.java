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
package com.limon.alfred.voicecommands.old.calendar;

import java.util.Calendar;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;

import com.limon.alfred.voicecommands.old.objects.CalendarEntry;
import com.limon.alfred.voicecommands.old.processing.Lapsus;

/**
 * @author estebanflores
 * 
 */
public class CalendarAccess {

	public static void addNewEvent(CalendarEntry calendarEntry) {

	}

	public static SortedSet<CalendarEntry> getEventList(Activity activity,
			int timeLapsusCode) throws Exception {
		long from;
		long to;
		Calendar calendar;

		switch (timeLapsusCode) {
		// TODO: complete codes
		// TODO: look to avoid while in code --> use Math with Calendar.DAYs
		// constants
		case Lapsus.THIS_WEEK:
			calendar = Calendar.getInstance();

			// early on the morning of monday
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			from = getMillisecondsEarlyAtMorning(calendar);

			while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				calendar.add(Calendar.DAY_OF_YEAR, 1);
			}

			// late at night on sunday
			to = getMillisecondsLateAtNight(calendar);
			break;
		case Lapsus.THIS_WEEK_FROM_NOW:
			calendar = Calendar.getInstance();

			// early on the moring
			from = getMillisecondsEarlyAtMorning(calendar);

			while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				calendar.add(Calendar.DAY_OF_YEAR, 1);
			}

			// late at night
			to = getMillisecondsLateAtNight(calendar);
			break;
		case Lapsus.NEXT_WEEK:
			calendar = Calendar.getInstance();

			// jump to next monday
			if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
				calendar.add(Calendar.DAY_OF_YEAR, 7);
			} else {
				// look up until next week

				while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
					calendar.add(Calendar.DAY_OF_YEAR, 1);
				}
			}

			// early on the morning
			from = getMillisecondsEarlyAtMorning(calendar);

			while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				calendar.add(Calendar.DAY_OF_YEAR, 1);
			}

			// late at night
			to = getMillisecondsLateAtNight(calendar);

			break;
		case Lapsus.TOMORROW:
			calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, 1);

			from = getMillisecondsEarlyAtMorning(calendar);

			to = getMillisecondsLateAtNight(calendar);
			break;
		case Lapsus.THIS_MONTH:
			calendar = Calendar.getInstance();

			calendar.set(Calendar.DAY_OF_MONTH, 1);

			// early on the moring
			from = getMillisecondsEarlyAtMorning(calendar);

			calendar.set(Calendar.DAY_OF_MONTH, calendar
					.getActualMaximum(Calendar.DAY_OF_MONTH));

			// late at night
			to = getMillisecondsLateAtNight(calendar);
			break;
		case Lapsus.THIS_MONTH_FROM_NOW:
			calendar = Calendar.getInstance();

			// early on the moring from today
			from = getMillisecondsEarlyAtMorning(calendar);

			calendar.set(Calendar.DAY_OF_MONTH, calendar
					.getActualMaximum(Calendar.DAY_OF_MONTH));

			// late at night
			to = getMillisecondsLateAtNight(calendar);
			break;
		case Lapsus.TODAY_FROM_NOW:
			calendar = Calendar.getInstance();
			from = calendar.getTimeInMillis();
			to = getMillisecondsLateAtNight(calendar);
			break;
		default:
			// TODAY
			calendar = Calendar.getInstance();
			from = getMillisecondsEarlyAtMorning(calendar);
			to = getMillisecondsLateAtNight(calendar);
			break;
		}

		return getEventList(activity, from, to);
	}

	private static long getMillisecondsLateAtNight(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);

		return calendar.getTimeInMillis();
	}

	private static long getMillisecondsEarlyAtMorning(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTimeInMillis();
	}

	// public static List<String> getEventStringList(Activity activity, long
	// from, long to)
	// throws Exception
	// {
	// List<CalendarEntry> calendarEntries =
	// getInternalEventsList(getCalendarList(activity),
	// activity, from, to);
	// List<String> resultList = new ArrayList<String>();
	//
	// for (CalendarEntry calendarEntry : calendarEntries)
	// {
	// resultList.add(calendarEntry.toString());
	// }
	//
	// return resultList;
	// }

	public static SortedSet<CalendarEntry> getEventList(Activity activity,
			long from, long to) throws Exception {
		return getInternalEventsList(getCalendarList(activity), activity, from,
				to);
	}

	public static SortedSet<CalendarEntry> getInternalEventsList(
			HashSet<String> calendarIds, Activity activity, long from, long to) {

		ContentResolver contentResolver = activity.getContentResolver();
		//
		// // Fetch a list of all calendars synced with the device, their
		// display names and whether the
		// // user has them selected for display.
		//	
		// final Cursor cursor =
		// contentResolver.query(Uri.parse("content://calendar/calendars"),
		// (new String[] { "_id", "displayName", "selected" }), null, null,
		// null);
		// // For a full list of available columns see
		// http://tinyurl.com/yfbg76w
		//
		// HashSet<String> calendarIds = new HashSet<String>();
		//	
		// while (cursor.moveToNext()) {
		//
		// final String _id = cursor.getString(0);
		// final String displayName = cursor.getString(1);
		// final Boolean selected = !cursor.getString(2).equals("0");
		//		
		// System.out.println("Id: " + _id + " Display Name: " + displayName +
		// " Selected: " + selected);
		// calendarIds.add(_id);
		// }

		SortedSet<CalendarEntry> set = new TreeSet<CalendarEntry>();

		// For each calendar, display all the events from the previous week to
		// the end of next week.
		for (String calendarId : calendarIds) {
			Uri.Builder builder = Uri
					.parse("content://calendar/instances/when").buildUpon();

			// ContentUris.appendId(builder, now - DateUtils.WEEK_IN_MILLIS);
			// ContentUris.appendId(builder, now + DateUtils.WEEK_IN_MILLIS);

			ContentUris.appendId(builder, from);
			ContentUris.appendId(builder, to);

			Cursor eventCursor = contentResolver.query(builder.build(),
					new String[] { "title", "begin", "end", "allDay",
							"event_id" }, "Calendars._id=" + calendarId, null,
					"startDay ASC, startMinute ASC");

			// For a full list of available columns see
			// http://tinyurl.com/yfbg76w

			while (eventCursor.moveToNext()) {
				final String title = eventCursor.getString(0);
				final long begin = eventCursor.getLong(1);
				final long end = eventCursor.getLong(2);
				final Boolean allDay = !eventCursor.getString(3).equals("0");
				final String eventId = eventCursor.getString(4);

				CalendarEntry calendarEntry = new CalendarEntry(title, begin,
						end, allDay, eventId, calendarId);

				set.add(calendarEntry);

			}
		}

		return set;
	}

	/**
	 * Retrieve a system calendar list
	 * 
	 * @throws Exception
	 */
	protected static HashSet<String> getCalendarList(Activity activity)
			throws Exception {
		String[] projection = new String[] { "_id", "name" };
		Uri calendars = Uri.parse("content://calendar/calendars");

		// Now, this query will return all calendars, including those that are
		// not in active use.
		// In order to get a list of active calendars only, we need to limit our
		// query to only those with
		// the "selected" field set to true:

		Cursor managedCursor = activity.managedQuery(calendars, projection,
				"selected=1", null, null);
		// We have now retrieved a list of calendars. We could iterate through
		// the results as follows:

		HashSet<String> list = new HashSet<String>();

		if (managedCursor == null) {
			throw new Exception("No Calendar installed on System");
		}

		if (managedCursor.moveToFirst()) {
			String calId;
			int idColumn = managedCursor.getColumnIndex("_id");
			do {
				calId = managedCursor.getString(idColumn);
				list.add(calId);

			} while (managedCursor.moveToNext());
		}

		return list;
	}

}
