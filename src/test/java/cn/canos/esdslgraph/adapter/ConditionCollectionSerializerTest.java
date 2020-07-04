package cn.canos.esdslgraph.adapter;

import cn.canos.esdslgraph.elasticsearch.Condition;
import cn.canos.esdslgraph.elasticsearch.ConditionCollection;
import cn.canos.esdslgraph.elasticsearch.Term;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.List;

public class ConditionCollectionSerializerTest {

    @Test
    public void serialize() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ConditionCollection.class, new ConditionCollectionSerializer());
        Gson gson = gsonBuilder.create();

        ConditionCollectionWrapper wrapper = new ConditionCollectionWrapper();

        ConditionCollection conditionCollection = new ConditionCollection();
        wrapper.setConditionCollection(conditionCollection);

        List<Condition> conditionList = Lists.newArrayListWithCapacity(3);
        conditionCollection.ConditionList = conditionList;
        for (int i = 1; i < 3; i++) {
            Condition condition = new Condition();
            conditionList.add(condition);

            Term term = new Term();
            condition.Term = term;

            term.Name = "term" + i;
            term.Value = i;
        }

        String newJson = gson.toJson(wrapper);
        System.out.println(newJson);
    }
}