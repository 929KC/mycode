public class Group{
	private long groupId;
	private String backgroundUrl;
	private String name;
	private String type;

	public void setGroupId(long groupId){
		this.groupId = groupId;
	}

	public long getGroupId(){
		return groupId;
	}

	public void setBackgroundUrl(String backgroundUrl){
		this.backgroundUrl = backgroundUrl;
	}

	public String getBackgroundUrl(){
		return backgroundUrl;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"Group{" + 
			"group_id = '" + groupId + '\'' + 
			",background_url = '" + backgroundUrl + '\'' + 
			",name = '" + name + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}
