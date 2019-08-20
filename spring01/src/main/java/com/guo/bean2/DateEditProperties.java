package com.guo.bean2;

/*时间类型转换器*/
import com.sun.javafx.binding.StringFormatter;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEditProperties extends PropertyEditorSupport {
    private String formatter = "yyyy-MM-dd";

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("text = "+text);
        SimpleDateFormat sdf = new SimpleDateFormat(formatter);
        try {
            Date date = sdf.parse(text);
            this.setValue(date);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }



}
