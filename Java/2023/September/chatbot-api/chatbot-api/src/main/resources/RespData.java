public class RespData{
	private Topic topic;

	public void setTopic(Topic topic){
		this.topic = topic;
	}

	public Topic getTopic(){
		return topic;
	}

	@Override
 	public String toString(){
		return 
			"RespData{" + 
			"topic = '" + topic + '\'' + 
			"}";
		}
}
