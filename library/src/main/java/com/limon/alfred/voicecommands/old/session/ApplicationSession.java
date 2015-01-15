/**
 * Limon Solutions - 2014 - Esteban Flores <esteban.flores@gmail.com>
 *
 * This file is part of Alfred Voice Command project.
 *
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.limon.alfred.voicecommands.old.session;

import java.util.HashMap;
import java.util.Map;

import com.limon.alfred.voicecommands.old.modules.Module;

/**
 * @author estebanflores
 * 
 */
public class ApplicationSession extends Session {

	private Map<String, ModuleSession> sessions;

	public ModuleSession getModuleSession(Module module) {
		return sessions.get(module.getName());
	}

	public void addModuleSession(Module module) {
		// avoid double creation
		if (sessions.get(module.getName()) == null)
			sessions.put(module.getName(), new ModuleSession());
	}

	public void clearModuleSession(Module module) {
		sessions.remove(module.getName());
	}

	public void clearAll(Module module) {

		sessions.clear();
	}

	/**
	 * 
	 */
	public ApplicationSession() {
		this.sessions = new HashMap<String, ModuleSession>();
	}
}
