/*
 * Copyright 2017 Kieren Hinch
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package org.khinch.netbeansdoxygenplugin;

/**
 *
 * @author kieren
 */
public class Constants {
    public static final String OSNAME = System.getProperty("os.name");
    public static final String OSARCH = System.getProperty("os.arch");
    public static final String OSVERSION = System.getProperty("os.version");
    public static final String FILESEPARATOR = System.getProperty("file.separator");
    public static final String PATHSEPARATOR = System.getProperty("path.separator");
    public static final String LINESEPARATOR = System.lineSeparator();
    public static final String USERHOME = System.getProperty("user.home");
    public static final String DOXYGENDOWNLOADURL = "https://www.stack.nl/~dimitri/doxygen/download.html";
    public static final String HELPURL = "https://github.com/khinch/NetbeansDoxygenPlugin/wiki";
}
