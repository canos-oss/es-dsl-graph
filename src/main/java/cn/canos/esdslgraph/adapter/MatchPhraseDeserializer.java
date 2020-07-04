package cn.canos.esdslgraph.adapter;

import cn.canos.esdslgraph.elasticsearch.MatchPhrase;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author harriszhang@live.cn
 * @date 2020/7/4.
 */
public class MatchPhraseDeserializer implements JsonDeserializer<MatchPhrase> {

    private Gson gson = new Gson();

    @Override
    public MatchPhrase deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        if (jsonObject.size() <= 0) {
            return null;
        }

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {

            MatchPhrase matchPhrase = gson.fromJson(entry.getValue(), MatchPhrase.class);
            matchPhrase.Name = entry.getKey();

            return matchPhrase;
        }

        return null;
    }
}