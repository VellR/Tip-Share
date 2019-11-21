package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;

public class zzags {
    private final List<List<String>> aQK;
    private final List<String> aQL;

    public zzags(List<List<String>> list, List<String> list2) {
        if (list.size() != list2.size() - 1) {
            throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
        }
        this.aQK = list;
        this.aQL = list2;
    }

    public List<List<String>> zzcny() {
        return Collections.unmodifiableList(this.aQK);
    }

    public List<String> zzcnz() {
        return Collections.unmodifiableList(this.aQL);
    }
}
