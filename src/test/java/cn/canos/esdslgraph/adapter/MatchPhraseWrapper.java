package cn.canos.esdslgraph.adapter;

import cn.canos.esdslgraph.elasticsearch.MatchPhrase;

public class MatchPhraseWrapper {

    private MatchPhrase matchPhrase;

    public MatchPhrase getMatchPhrase() {
        return matchPhrase;
    }

    public void setMatchPhrase(MatchPhrase matchPhrase) {
        this.matchPhrase = matchPhrase;
    }
}