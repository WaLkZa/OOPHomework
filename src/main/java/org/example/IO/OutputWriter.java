package org.example.IO;

import org.example.constant.Constant;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class OutputWriter {

    public static void writeResult(String result){
        try {
            FileOutputStream file = new FileOutputStream(Constant.OUTPUT_FILE_PATH);
            OutputStreamWriter output = new OutputStreamWriter(file);

            output.write(result);
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}