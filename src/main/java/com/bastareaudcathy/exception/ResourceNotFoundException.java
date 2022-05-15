package com.bastareaudcathy.exception;

public class ResourceNotFoundException extends RuntimeException{

  private String resourceName;
  private String fieldName;
  private String fieldValue;

  public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) // post not found with id 1/
   {
    super(String.format("%s not found with %s : '%s'"));
    this.resourceName = resourceName;
    this.fieldName = fieldName;
    this.fieldValue = fieldValue;
  }

  public String getResourceName() {
    return resourceName;
  }

  public String getFieldName() {
    return fieldName;
  }

  public String getFieldValue() {
    return fieldValue;
  }
}