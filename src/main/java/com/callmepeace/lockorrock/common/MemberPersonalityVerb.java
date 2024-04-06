package com.callmepeace.lockorrock.common;

public enum MemberPersonalityVerb {

    AND("(으)로 뽑았고,"),
    END("(이)라고 뽑은")
    ;


    private String text;

    MemberPersonalityVerb(String text) {
        this.text = text;
    }
}
