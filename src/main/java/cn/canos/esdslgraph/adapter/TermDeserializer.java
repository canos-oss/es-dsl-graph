package cn.canos.esdslgraph.adapter;

import cn.canos.esdslgraph.elasticsearch.Term;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author harriszhang@live.cn
 * @date 2020/7/4.
 */
public class TermDeserializer implements JsonDeserializer<Term> {

    private Gson gson = new Gson();

    @Override
    public Term deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        if (jsonObject.size() <= 0) {
            return null;
        }

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {

            Term tempTerm = gson.fromJson(entry.getValue(), Term.class);
            tempTerm.Name = entry.getKey();

            return tempTerm;
        }

        return null;
    }
}