package cn.canos.esdslgraph.adapter;

import cn.canos.esdslgraph.elasticsearch.MatchPhrase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

public class MatchPhraseDeserializerTest {

    @Test
    public void deserialize() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MatchPhrase.class, new MatchPhraseDeserializer());
        Gson gson = gsonBuilder.create();

        String json = "{\n" +
                "  \"matchPhrase\": {\n" +
                "      \"hahaha\": {\n" +
                "      \"query\": \"北海道\",\n" +
                "      \"analyzer\": \"edge_ngram_5\",\n" +
                "      \"slop\": 3,\n" +
                "      \"boost\": 15\n" +
                "      }\n" +
                "  }\n" +
                "}";
        MatchPhraseWrapper wrapper = gson.fromJson(json, MatchPhraseWrapper.class);

        String newJson = new Gson().toJson(wrapper);
        System.out.println(newJson);
    }
}