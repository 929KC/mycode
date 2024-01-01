public class UserSpecific{
	private boolean subscribed;
	private boolean liked;

	public void setSubscribed(boolean subscribed){
		this.subscribed = subscribed;
	}

	public boolean isSubscribed(){
		return subscribed;
	}

	public void setLiked(boolean liked){
		this.liked = liked;
	}

	public boolean isLiked(){
		return liked;
	}

	@Override
 	public String toString(){
		return 
			"UserSpecific{" + 
			"subscribed = '" + subscribed + '\'' + 
			",liked = '" + liked + '\'' + 
			"}";
		}
}
