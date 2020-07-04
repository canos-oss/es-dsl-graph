package cn.canos.esdslgraph.adapter;

import cn.canos.esdslgraph.elasticsearch.Term;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

public class TermDeserializerTest {

    @Test
    public void deserialize() {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Term.class, new TermDeserializer());
        Gson gson = gsonBuilder.create();

        String json = "{\n" +
                "  \"term\": {\n" +
                "    \"sale_status\": {\n" +
                "      \"value\": 1,\n" +
                "      \"boost\": 1\n" +
                "    }\n" +
                "  }\n" +
                "}";
        TermWrapper wrapper = gson.fromJson(json, TermWrapper.class);

        String newJson = new Gson().toJson(wrapper);
        System.out.println(newJson);
    }
}