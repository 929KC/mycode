public class Question{
	private Owner owner;
	private boolean expired;
	private Questionee questionee;
	private boolean anonymous;
	private OwnerDetail ownerDetail;
	private String ownerLocation;
	private String text;

	public void setOwner(Owner owner){
		this.owner = owner;
	}

	public Owner getOwner(){
		return owner;
	}

	public void setExpired(boolean expired){
		this.expired = expired;
	}

	public boolean isExpired(){
		return expired;
	}

	public void setQuestionee(Questionee questionee){
		this.questionee = questionee;
	}

	public Questionee getQuestionee(){
		return questionee;
	}

	public void setAnonymous(boolean anonymous){
		this.anonymous = anonymous;
	}

	public boolean isAnonymous(){
		return anonymous;
	}

	public void setOwnerDetail(OwnerDetail ownerDetail){
		this.ownerDetail = ownerDetail;
	}

	public OwnerDetail getOwnerDetail(){
		return ownerDetail;
	}

	public void setOwnerLocation(String ownerLocation){
		this.ownerLocation = ownerLocation;
	}

	public String getOwnerLocation(){
		return ownerLocation;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"Question{" + 
			"owner = '" + owner + '\'' + 
			",expired = '" + expired + '\'' + 
			",questionee = '" + questionee + '\'' + 
			",anonymous = '" + anonymous + '\'' + 
			",owner_detail = '" + ownerDetail + '\'' + 
			",owner_location = '" + ownerLocation + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}
