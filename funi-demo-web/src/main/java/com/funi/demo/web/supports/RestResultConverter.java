package com.funi.demo.web.supports;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonValue;

import java.io.IOException;
import java.lang.reflect.Type;

public class RestResultConverter extends MappingJackson2HttpMessageConverter {
    @Override
    protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        if (object instanceof MappingJacksonValue) {
            MappingJacksonValue value = (MappingJacksonValue) object;
            RestResult result;
            if (value.getValue() instanceof RestResult) {
                result = (RestResult) value.getValue();
            } else {
                result = new RestResult(value.getValue());
            }

            value.setValue(result);
        } else {
            RestResult result;

            if (object instanceof RestResult)
                result = (RestResult) object;
            else
                result = new RestResult(object);

            object = result;
        }

        super.writeInternal(object, RestResult.class, outputMessage);
    }
}