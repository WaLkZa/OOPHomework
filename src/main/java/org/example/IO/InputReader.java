package org.example.IO;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.constant.Constant;
import org.example.model.impl.Chicken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class InputReader {

    private static final Gson gson = new Gson();
    private static final Type listType = new TypeToken<List<Chicken>>() {}.getType();

    public static List<Chicken> readInput() {
        try (Reader reader = new FileReader(Constant.INPUT_FILE_PATH)) {
            List<Chicken> chickens = gson.fromJson(reader, listType);
            return chickens;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
