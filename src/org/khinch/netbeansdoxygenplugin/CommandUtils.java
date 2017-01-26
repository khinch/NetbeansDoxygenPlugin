/*
 *  
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
 * \todo class description here
 * @author kieren
 */
public class CommandUtils {
    
    /**
     * \ todo method description here
     * 
     * @param binaryPath
     * @param args
     * @param inStream
     * @throws IOException 
     */
    public static void runCommand(String binaryPath, String args, String inStream) throws IOException
    {
        // Set up the process with the path to the binary and its arguments
        ProcessBuilder processBuilder = new ProcessBuilder(binaryPath, args);
        Process process = processBuilder.start();

        // Set up the input so we can write to the process
        OutputStream stdin = process.getOutputStream();
        OutputStreamWriter outStreamWriter = new OutputStreamWriter(stdin);
        BufferedWriter writer = new BufferedWriter(outStreamWriter); 
        
        // Set up the output so we can log the result
        InputStream stdout = process.getInputStream();
        InputStreamReader inStreamReader = new InputStreamReader(stdout);
        BufferedReader reader = new BufferedReader(inStreamReader);

        // Send the content and flush the buffers
        writer.write(inStream);
        writer.flush();
        writer.close();

        // Cross fingers and check the output
        Scanner scanner = new Scanner(stdout);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
}
