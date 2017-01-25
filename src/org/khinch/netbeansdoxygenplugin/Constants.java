/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
