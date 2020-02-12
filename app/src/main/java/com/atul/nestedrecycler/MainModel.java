package com.atul.nestedrecycler;

import java.util.List;

public class MainModel {
    List<HoriModel>horiModels;
    int type;
   static final int HORI=0;

    public MainModel(List<HoriModel> horiModels,int type) {
        this.horiModels = horiModels;
        this.type=type;

    }

    public List<HoriModel> getHoriModels() {
        return horiModels;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setHoriModels(List<HoriModel> horiModels) {
        this.horiModels = horiModels;
    }
}
