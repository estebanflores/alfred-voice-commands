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
//package com.limon.alfred.voicecommands;
//
//import android.app.Application;
//
//import com.limon.alfred.voicecommands.old.calendar.CalendarViewerModule;
//import com.limon.alfred.voicecommands.old.modules.Module;
//import com.limon.alfred.voicecommands.old.session.ApplicationSession;
//
//public class Secretarius extends Application {
//
//	private static Secretarius instance;
//	private Module[] modules;
//
//	private static ApplicationSession globalSession;
//
//	private Secretarius() {
//		modules = new Module[1];
//	}
//
//	public Secretarius getInstance() {
//		return instance;
//	}
//
//	public void loadModules() {
//		modules[0] = new CalendarViewerModule();
//	}
//
//	/*
//	 * (non-Javadoc)
//	 *
//	 * @see android.app.Application#onCreate()
//	 */
//	@Override
//	public void onCreate() {
//		super.onCreate();
//		instance = this;
//	}
//
//	/**
//	 * @return the globalSession
//	 */
//	public static ApplicationSession getGlobalSession() {
//		return globalSession;
//	}
//}
