package JsonFiles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class SaveState {
    public void saveState(ConfigState configState){

        Gson gson = new Gson();
        String json = gson.toJson(configState);


        try(FileWriter fileWriter = new FileWriter("config.json")){
            fileWriter.write(json);

        }catch(IOException e){
            e.printStackTrace();
        }


    }


}
