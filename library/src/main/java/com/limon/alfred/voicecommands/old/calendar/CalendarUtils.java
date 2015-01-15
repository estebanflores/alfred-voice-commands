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
 *//*

package com.limon.alfred.voicecommands.old.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.Activity;

import com.nebulosa.secretarius.R;

*/
/**
 * @author estebanflores
 * 
 *//*

public class CalendarUtils
{

    */
/**
     * Return a system representation of time
     * @param dateTimeInMilliseconds
     * @return
     *//*

    public static String getDateTimeToTimeStr(long dateTimeInMilliseconds)
    {
	SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
	Calendar calendar = Calendar.getInstance();
	calendar.setTimeInMillis(dateTimeInMilliseconds);
	String timeStr = dateFormat.format(calendar.getTime());
	return timeStr;
    }
    
    */
/**
     * Return a system representation of date
     * @param dateTimeInMilliseconds
     * @return
     *//*

    public static String getDateTimeToDateStr(long dateTimeInMilliseconds)
    {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Calendar calendar = Calendar.getInstance();
	calendar.setTimeInMillis(dateTimeInMilliseconds);
	String dateStr = dateFormat.format(calendar.getTime());
	return dateStr;
    }
    
    */
/**
     * Return a system representation of date
     * @param dateTimeInMilliseconds
     * @return
     *//*

    public static String getDateTimeToLongDateStr(Activity activity, long dateTimeInMilliseconds)
    {
	SimpleDateFormat dateFormat = new SimpleDateFormat(activity.getString(R.string.long_date_format));
	Calendar calendar = Calendar.getInstance();
	calendar.setTimeInMillis(dateTimeInMilliseconds);
	String dateStr = dateFormat.format(calendar.getTime());
	return dateStr;
    }
    
    
    */
/**
     * @param title
     * @return
     *//*

    public static String filterLinks(String title)
    {
	// TODO: use bufferedstrings
	while (title.contains("://"))
	{
	    // search beginning
	    int begin = title.indexOf("http://");
	    
	    int end = title.indexOf(" ", begin);
	    
	    // the link is at the end of string
	    if (end == -1) end = title.length() - 1; 
	    
	    // cut link
	    title = title.substring(0, begin) + " " + title.substring(end, title.length() - 1);
	}
	
	return title;
    }
}
*/
