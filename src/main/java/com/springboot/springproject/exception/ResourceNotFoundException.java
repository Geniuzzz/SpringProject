package com.springboot.springproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public ResourceNotFoundException(String resourceName, String fileName, Object fieldValue) {
        super(String.format("%s not found with %s : %s", resourceName, fileName, fieldValue));
        this.resourceName = resourceName;
        this.fileName = fileName;
        this.fieldValue = fieldValue;
    }

    private String resourceName;

    private String fileName;

    private Object fieldValue;

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
    }
}
