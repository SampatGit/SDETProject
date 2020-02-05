package utils;

public class JsonPojo
{
    private String success;

    private String httpStatus;

    private String message;

    private Body[] body;

    private String error;

    private String httpStatusCode;

    public String getSuccess ()
    {
        return success;
    }

    public void setSuccess (String success)
    {
        this.success = success;
    }

    public String getHttpStatus ()
    {
        return httpStatus;
    }

    public void setHttpStatus (String httpStatus)
    {
        this.httpStatus = httpStatus;
    }

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public Body[] getBody ()
    {
        return body;
    }

    public void setBody (Body[] body)
    {
        this.body = body;
    }

    public String getError ()
    {
        return error;
    }

    public void setError (String error)
    {
        this.error = error;
    }

    public String getHttpStatusCode ()
    {
        return httpStatusCode;
    }

    public void setHttpStatusCode (String httpStatusCode)
    {
        this.httpStatusCode = httpStatusCode;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [success = "+success+", httpStatus = "+httpStatus+", message = "+message+", body = "+body+", error = "+error+", httpStatusCode = "+httpStatusCode+"]";
    }
}