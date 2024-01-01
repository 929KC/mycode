public class OwnerDetail{
	private int questionsCount;
	private String joinTime;
	private String status;

	public void setQuestionsCount(int questionsCount){
		this.questionsCount = questionsCount;
	}

	public int getQuestionsCount(){
		return questionsCount;
	}

	public void setJoinTime(String joinTime){
		this.joinTime = joinTime;
	}

	public String getJoinTime(){
		return joinTime;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"OwnerDetail{" + 
			"questions_count = '" + questionsCount + '\'' + 
			",join_time = '" + joinTime + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}
