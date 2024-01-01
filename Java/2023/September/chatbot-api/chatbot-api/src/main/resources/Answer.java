public class Answer{
	private Owner owner;
	private String text;

	public void setOwner(Owner owner){
		this.owner = owner;
	}

	public Owner getOwner(){
		return owner;
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
			"Answer{" + 
			"owner = '" + owner + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}
