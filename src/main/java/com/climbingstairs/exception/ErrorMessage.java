package com.climbingstairs.exception;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorMessage {

    private String result_status;

    private Result_body result_body;

    public ErrorMessage(String result_status, Result_body result_body) {
        this.result_status = result_status;
        this.result_body = result_body;
    }

    public Result_body getResult_body() {
        return result_body;
    }

    public void setResult_body(Result_body result_body) {
        this.result_body = result_body;
    }

    static class Result_body {
        private Date timestamp;
        private int statusCode;
        private HttpStatus error;
        private String message;
        private String path;

        public Date getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Date timestamp) {
            this.timestamp = timestamp;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public HttpStatus getError() {
            return error;
        }

        public void setError(HttpStatus error) {
            this.error = error;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }

    public String getResult_status() {
        return result_status;
    }

    public void setResult_status(String result_status) {
        this.result_status = result_status;
    }
}

