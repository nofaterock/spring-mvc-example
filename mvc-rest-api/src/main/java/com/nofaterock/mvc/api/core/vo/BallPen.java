package com.nofaterock.mvc.api.core.vo;

public class BallPen {
    private String colorCode;
    private boolean isButton;
    
    BallPen(String colorCode, boolean isButton){
        this.colorCode = colorCode;
        this.isButton = isButton;
    }
    String getColor(){
        return colorCode;
    }
    boolean onButton() {
        isButton = !isButton;
        return isButton;
    }
}
