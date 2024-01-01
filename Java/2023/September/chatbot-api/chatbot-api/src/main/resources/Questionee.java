public class Questionee{
	private String avatarUrl;
	private long userId;
	private String name;
	private String location;

	public void setAvatarUrl(String avatarUrl){
		this.avatarUrl = avatarUrl;
	}

	public String getAvatarUrl(){
		return avatarUrl;
	}

	public void setUserId(long userId){
		this.userId = userId;
	}

	public long getUserId(){
		return userId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLocation(String location){
		this.location = location;
	}

	public String getLocation(){
		return location;
	}

	@Override
 	public String toString(){
		return 
			"Questionee{" + 
			"avatar_url = '" + avatarUrl + '\'' + 
			",user_id = '" + userId + '\'' + 
			",name = '" + name + '\'' + 
			",location = '" + location + '\'' + 
			"}";
		}
}
