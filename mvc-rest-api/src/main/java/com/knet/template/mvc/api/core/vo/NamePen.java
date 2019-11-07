package com.knet.template.mvc.api.core.vo;

public class NamePen {
    private String colorCode;
    private boolean isCover;
    
    NamePen(boolean isCover){
        colorCode = "black";
        this.isCover = isCover;
    }
    String getColor(){
        return colorCode;
    }
    boolean onCover(){
        isCover = !isCover;
        return isCover;
    }
}