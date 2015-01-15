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



/**
 * @author estebanflores
 *
 */
public class CalendarQuery extends OutputObject
{
    private static final long serialVersionUID = -1372607101279250680L;
    
    private int lapsusCode;
    private long from;
    private long to;
    private String originalCommand;
    private boolean toRead;
    
    
    /**
     * @param lapsusCode
     * @param from
     * @param to
     * @param toRead 
     * @param testInputString 
     */
    public CalendarQuery(int lapsusCode, long from, long to, String originalCommand, boolean toRead)
    {
	super();
	this.lapsusCode = lapsusCode;
	this.from = from;
	this.to = to;
	this.originalCommand = originalCommand;
	this.toRead = toRead;
    }
    
    /**
     * @return the toRead
     */
    public boolean isToRead()
    {
	return toRead;
    }
    
    /**
     * @param toRead the toRead to set
     */
    public void setToRead(boolean toRead)
    {
	this.toRead = toRead;
    }

    /**
     * @return the originalCommand
     */
    public String getOriginalCommand()
    {
	return originalCommand;
    }
    
    /**
     * @return the from
     */
    public long getFrom()
    {
	return from;
    }
    
    /**
     * @return the lapsusCode
     */
    public int getLapsusCode()
    {
	return lapsusCode;
    }
    
    /**
     * @return the to
     */
    public long getTo()
    {
	return to;
    }
    
    /**
     * @param from the from to set
     */
    public void setFrom(long from)
    {
	this.from = from;
    }
    
    /**
     * @param lapsusCode the lapsusCode to set
     */
    public void setLapsusCode(int lapsusCode)
    {
	this.lapsusCode = lapsusCode;
    }
    
    /**
     * @param originalCommand the originalCommand to set
     */
    public void setOriginalCommand(String originalCommand)
    {
	this.originalCommand = originalCommand;
    }
    
    /**
     * @param to the to to set
     */
    public void setTo(long to)
    {
	this.to = to;
    }
    
}
