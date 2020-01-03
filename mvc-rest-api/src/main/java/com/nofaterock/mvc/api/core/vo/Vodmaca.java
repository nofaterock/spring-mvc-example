package com.nofaterock.mvc.api.core.vo;

public class Vodmaca {
    private String colorCode;
    private boolean isCover;
    
    Vodmaca(String colorCode, boolean isCover){
        this.colorCode = colorCode;
        this.isCover = isCover;
    }
    String getColor(){
        return colorCode;
    }
    boolean onCover() {
        isCover = !isCover;
        return isCover;
    }
}
