package request.invalidrequests;

import request.Request;

public class InvalidRequest implements Request {
    @Override
    public String getRequestType() {
        return "invalid";
    }
}
