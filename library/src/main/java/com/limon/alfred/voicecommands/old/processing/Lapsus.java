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
package com.limon.alfred.voicecommands.old.processing;

/**
 * @author estebanflores
 *
 */
public interface Lapsus
{
    final int CUSTOM = -1;
    final int TODAY = 1;
    final int TODAY_FROM_NOW = 11;
    final int TOMORROW = 2;
    final int THIS_WEEK = 3; 
    final int THIS_WEEK_FROM_NOW = 33; // up today 
    final int NEXT_WEEK = 4;
    final int THIS_MONTH = 5;
    final int THIS_MONTH_FROM_NOW = 51;
    final int DAY_AFTER_TOMORROW = 6;
}