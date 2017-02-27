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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;


/**
 *
 * @author kieren
 */
public class CommandUtils {
    public static void runCommand(String binaryPath, String[] args, String inStream) throws IOException
    {
        // The path to the binary file is the first element in the command array. The rest are arguments. 
        String[] command;
        if(args != null && args.length != 0) {
            command = new String[args.length + 1];
            command[0] = binaryPath;
            int count = 1;
            for(String arg : args) {
                command[count] = arg;
                count++;
            }
        } else {
            command = new String[]{ binaryPath };
        }
        
        // Set up the process with the command array
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process = processBuilder.start();

        // Set up the output so we can log the result
        InputStream stdout = process.getInputStream();
        InputStreamReader inStreamReader = new InputStreamReader(stdout);
        BufferedReader reader = new BufferedReader(inStreamReader);
        
        // If we were passed an input stream, set up the input so we can write to the process
        if (inStream != null) {
            OutputStream stdin = process.getOutputStream();
            OutputStreamWriter outStreamWriter = new OutputStreamWriter(stdin);
            BufferedWriter writer = new BufferedWriter(outStreamWriter);
            // Send the content and flush the buffers
            writer.write(inStream);
            writer.flush();
            writer.close();
        }
        
        // Scan the output
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
}
