package cn.canos.esdslgraph.adapter;

import cn.canos.esdslgraph.elasticsearch.Condition;
import cn.canos.esdslgraph.elasticsearch.ConditionCollection;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author harriszhang@live.cn
 * @date 2020/7/4.
 */
public class ConditionCollectionSerializer implements JsonSerializer<ConditionCollection> {

    @Override
    public JsonElement serialize(ConditionCollection conditionCollection, Type typeOfSrc, JsonSerializationContext context) {

        if (conditionCollection == null) {
            return null;
        }

        List<Condition> conditionList = conditionCollection.ConditionList;
        if (conditionList == null || conditionList.isEmpty()) {
            return null;
        }

        return context.serialize(conditionList);
    }
}
