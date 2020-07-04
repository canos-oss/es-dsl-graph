package cn.canos.esdslgraph;

import cn.canos.esdslgraph.adapter.*;
import cn.canos.esdslgraph.elasticsearch.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;


public class BasicTest {

    @Test
    public void test() {

        GsonBuilder esGsonBuilder = new GsonBuilder();
        esGsonBuilder.registerTypeAdapter(Range.class, new RangeDeserializer());
        esGsonBuilder.registerTypeAdapter(Term.class, new TermDeserializer());
        esGsonBuilder.registerTypeAdapter(Terms.class, new TermsDeserializer());
        esGsonBuilder.registerTypeAdapter(ConditionCollection.class, new ConditionCollectionDeserializer());
        esGsonBuilder.registerTypeAdapter(Match.class, new MatchDeserializer());
        esGsonBuilder.registerTypeAdapter(MatchPhrase.class, new MatchPhraseDeserializer());
        Gson esGson = esGsonBuilder.create();

        String json = "{\n" +
                "  \"query\": {\n" +
                "    \"bool\": {\n" +
                "      \"must\": [\n" +
                "        {\n" +
                "          \"term\": {\n" +
                "            \"deleted\": {\n" +
                "              \"value\": 0,\n" +
                "              \"boost\": 1\n" +
                "            }\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"term\": {\n" +
                "            \"type\": {\n" +
                "              \"value\": 10,\n" +
                "              \"boost\": 1\n" +
                "            }\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"bool\": {\n" +
                "            \"should\": [\n" +
                "              {\n" +
                "                \"term\": {\n" +
                "                  \"name.keyword\": {\n" +
                "                    \"value\": \"北海道\",\n" +
                "                    \"boost\": 100\n" +
                "                  }\n" +
                "                }\n" +
                "              },\n" +
                "              {\n" +
                "                \"term\": {\n" +
                "                  \"pinyin.keyword\": {\n" +
                "                    \"value\": \"北海道\",\n" +
                "                    \"boost\": 100\n" +
                "                  }\n" +
                "                }\n" +
                "              }\n" +
                "            ],\n" +
                "            \"adjust_pure_negative\": true,\n" +
                "            \"boost\": 1\n" +
                "          }\n" +
                "        }\n" +
                "      ],\n" +
                "      \"adjust_pure_negative\": true,\n" +
                "      \"boost\": 1\n" +
                "    }\n" +
                "  }\n" +
                "}";

        Request request = esGson.fromJson(json, Request.class);

        GsonBuilder normalGsonBuilder = new GsonBuilder();
        normalGsonBuilder.registerTypeAdapter(ConditionCollection.class, new ConditionCollectionSerializer());
        Gson normalGson = normalGsonBuilder.create();

        System.out.println(normalGson.toJson(request));

        System.out.println(new Gson().toJson(request));
    }
}