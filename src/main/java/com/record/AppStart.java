package com.record;

import com.record.controller.RecordController;
import com.record.view.View;

import java.io.UnsupportedEncodingException;

public class AppStart {
    public static void main(String[] args) throws UnsupportedEncodingException {
        View view = new View();
        RecordController controller = new RecordController(System.in, view);
        controller.executeChoice();


    }
}
