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
package com.limon.alfred.voicecommands.old.objects;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarEntry extends OutputObject implements
		Comparable<CalendarEntry> {

	private static final long serialVersionUID = -7576113422430156366L;

	private String title;
	private long begin;
	private long end;
	private Boolean allDay;
	private String eventId;
	private String calendarId;

	/**
     * 
     */
	public CalendarEntry() {
	}

	/**
	 * @param title
	 * @param begin
	 * @param end
	 * @param allDay
	 * @param calendarId
	 * @param eventId
	 */
	public CalendarEntry(String title, long begin, long end, Boolean allDay,
			String eventId, String calendarId) {
		this.title = title;
		this.begin = begin;
		this.end = end;
		this.allDay = allDay;
		this.eventId = eventId;
		this.calendarId = calendarId;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param begin
	 *            the begin to set
	 */
	public void setBegin(long begin) {
		this.begin = begin;
	}

	/**
	 * @return the begin
	 */
	public long getBegin() {
		return begin;
	}

	/**
	 * @param end
	 *            the end to set
	 */
	public void setEnd(long end) {
		this.end = end;
	}

	/**
	 * @return the end
	 */
	public long getEnd() {
		return end;
	}

	/**
	 * @param allDay
	 *            the allDay to set
	 */
	public void setAllDay(Boolean allDay) {
		this.allDay = allDay;
	}

	/**
	 * @return the allDay
	 */
	public Boolean getAllDay() {
		return allDay;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(begin);

		return "a las " + dateFormat.format(calendar.getTime()) + " " + title;
	}

	/**
	 * @return
	 */
	public String getEventId() {
		return this.eventId;
	}

	/**
	 * @param eventId
	 *            the eventId to set
	 */
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return
	 */
	public String getCalendarId() {
		return this.calendarId;
	}

	/**
	 * @param calendarId
	 *            the calendarId to set
	 */
	public void setCalendarId(String calendarId) {
		this.calendarId = calendarId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(CalendarEntry another) {

		return (int) (this.getBegin() - another.getBegin());
	}

}
