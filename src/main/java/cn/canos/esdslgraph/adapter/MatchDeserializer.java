package cn.canos.esdslgraph.adapter;

import cn.canos.esdslgraph.elasticsearch.Match;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author harriszhang@live.cn
 * @date 2020/7/4.
 */
public class MatchDeserializer implements JsonDeserializer<Match> {

    private Gson gson = new Gson();

    @Override
    public Match deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        if (jsonObject.size() <= 0) {
            return null;
        }

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {

            Match tempMatch = gson.fromJson(entry.getValue(), Match.class);
            tempMatch.Name = entry.getKey();

            return tempMatch;
        }

        return null;
    }
}