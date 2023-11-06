package damo.com.damchat.dto.response;

import java.time.LocalDateTime;

public class ResponseDetails {

    private LocalDateTime createdDate;

    private String message;

    private String status;

    public ResponseDetails(LocalDateTime createdDate, String message, String status) {
        this.createdDate = createdDate;
        this.message = message;
        this.status = status;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
