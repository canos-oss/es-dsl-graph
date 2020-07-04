package cn.canos.esdslgraph.adapter;

import cn.canos.esdslgraph.elasticsearch.NodeNames;
import cn.canos.esdslgraph.elasticsearch.Terms;
import com.google.common.collect.Lists;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author harriszhang@live.cn
 * @date 2020/7/4.
 */
public class TermsDeserializer implements JsonDeserializer<Terms> {

    private Gson gson = new Gson();

    @Override
    public Terms deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();
        if (jsonObject.size() <= 0) {
            return null;
        }

        Terms terms = new Terms();

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            switch (entry.getKey()) {
                case NodeNames.Boost:
                    terms.Boost = entry.getValue().getAsFloat();
                    break;
                default: {
                    terms.Name = entry.getKey();
                    List<Object> values = Lists.newArrayListWithCapacity(1);
                    JsonArray jsonArray = entry.getValue().getAsJsonArray();
                    if (jsonArray != null) {
                        for (JsonElement jsonElement : jsonArray) {
                            values.add(jsonElement.getAsJsonPrimitive());
                        }
                    }
                    terms.Values = values;
                }
                break;
            }
        }

        return terms;
    }
}