package su.nepom;


import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class JsonFileHandler extends AbstractFileHandler {
    @Override
    protected boolean check(String filename) throws FileNotFoundException {
        try {
            new JSONObject(new JSONTokener(new FileInputStream(filename)));
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "JsonFileHandler";
    }
}
