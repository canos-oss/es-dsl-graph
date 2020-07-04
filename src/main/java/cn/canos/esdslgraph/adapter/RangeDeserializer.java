package cn.canos.esdslgraph.adapter;

import cn.canos.esdslgraph.elasticsearch.Range;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author harriszhang@live.cn
 * @date 2020/7/4.
 */
public class RangeDeserializer implements JsonDeserializer<Range> {

    private Gson gson = new Gson();

    @Override
    public Range deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();
        if (jsonObject.size() <= 0) {
            return null;
        }

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {

            Range range = gson.fromJson(entry.getValue(), Range.class);
            range.Name = entry.getKey();

            return range;
        }

        return null;
    }
}