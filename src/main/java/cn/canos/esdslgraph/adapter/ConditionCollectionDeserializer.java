package cn.canos.esdslgraph.adapter;

import cn.canos.esdslgraph.elasticsearch.Condition;
import cn.canos.esdslgraph.elasticsearch.ConditionCollection;
import com.google.common.collect.Lists;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author harriszhang@live.cn
 */
public class ConditionCollectionDeserializer implements JsonDeserializer<ConditionCollection> {

    @Override
    public ConditionCollection deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonArray jsonArray = json.getAsJsonArray();
        if (jsonArray != null) {

            List<Condition> conditionList = Lists.newArrayListWithCapacity(jsonArray.size());
            for (JsonElement jsonElement : jsonArray) {
                Condition condition = context.deserialize(jsonElement, Condition.class);
                conditionList.add(condition);
            }

            ConditionCollection conditionCollection = new ConditionCollection();
            conditionCollection.ConditionList = conditionList;
            return conditionCollection;
        }

        JsonObject jsonObject = json.getAsJsonObject();
        if (jsonObject != null) {
            List<Condition> conditionList = Lists.newArrayListWithCapacity(1);

            Condition condition = context.deserialize(jsonObject, Condition.class);
            conditionList.add(condition);

            ConditionCollection conditionCollection = new ConditionCollection();
            conditionCollection.ConditionList = conditionList;
            return conditionCollection;
        }

        return null;
    }
}