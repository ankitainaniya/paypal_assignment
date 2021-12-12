package com.paypal.bfs.test.bookingserv.exception;

public class BookingException extends RuntimeException{
  private String status;
  private String errorMsg;
  public BookingException(String status, String errorMsg)
  {
      this.status=status;
      this.errorMsg=errorMsg;
  }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
