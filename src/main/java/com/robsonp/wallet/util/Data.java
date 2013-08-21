package com.robsonp.wallet.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {

    public static String toString(Date data){
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }
    
    public static Date fromString(String data) {
        try {        
            return new SimpleDateFormat("dd/MM/yyyy").parse(data);
        } catch (ParseException ex) {
            throw new RuntimeException("Erro ao fazer parse de data", ex);
        }
    }
    
}
