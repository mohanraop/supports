package support.training.spring;


public class SetterMessage {
	private String message = null;
	
	private ConstructorMessage conMessage;

   
    public ConstructorMessage getConMessage() {
		return conMessage;
	}

	public void setConMessage(ConstructorMessage conMessage) {
		this.conMessage = conMessage;
	}

	/**
     * Gets message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
