package com.example.koc.type;

public class BusinessValidationException extends AbstractException {
    private String detailedMessage;

    public BusinessValidationException(String message) {
        super(message);
    }

    public BusinessValidationException(String message, String detailedMessage) {
        super(message);
        this.detailedMessage = detailedMessage;
    }

    public String getDetailedMessage() {
        return detailedMessage;
    }

    public void setDetailedMessage(String detailedMessage) {
        this.detailedMessage = detailedMessage;
    }

    @Override
    public String toString() {
        return "BusinessValidationException{" +
                "detailedMessage='" + this.detailedMessage + '\'' +
        ",message='" + this.getMessage() + '\'' +
        '}';
    }
}
