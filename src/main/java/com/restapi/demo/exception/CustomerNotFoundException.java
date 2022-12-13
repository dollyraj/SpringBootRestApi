package com.restapi.demo.exception;

//@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {

   // String msg;
    public CustomerNotFoundException(String message) {
        super(message);
    }

   /* public void setMessage(String message) {
        this.msg = message;
    }*/

  /*  @Override
    public String getMessage() {
        return msg;
    }
*/

}
