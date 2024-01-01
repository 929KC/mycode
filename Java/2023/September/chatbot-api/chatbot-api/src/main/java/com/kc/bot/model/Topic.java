public class Topic{
	private boolean silenced;
	private int readingCount;
	private Question question;
	private boolean answered;
	private String createTime;
	private UserSpecific userSpecific;
	private int rewardsCount;
	private String type;
	private boolean digested;
	private int likesCount;
	private Answer answer;
	private int commentsCount;
	private boolean sticky;
	private long topicId;
	private int readersCount;
	private Group group;

	public void setSilenced(boolean silenced){
		this.silenced = silenced;
	}

	public boolean isSilenced(){
		return silenced;
	}

	public void setReadingCount(int readingCount){
		this.readingCount = readingCount;
	}

	public int getReadingCount(){
		return readingCount;
	}

	public void setQuestion(Question question){
		this.question = question;
	}

	public Question getQuestion(){
		return question;
	}

	public void setAnswered(boolean answered){
		this.answered = answered;
	}

	public boolean isAnswered(){
		return answered;
	}

	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}

	public String getCreateTime(){
		return createTime;
	}

	public void setUserSpecific(UserSpecific userSpecific){
		this.userSpecific = userSpecific;
	}

	public UserSpecific getUserSpecific(){
		return userSpecific;
	}

	public void setRewardsCount(int rewardsCount){
		this.rewardsCount = rewardsCount;
	}

	public int getRewardsCount(){
		return rewardsCount;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setDigested(boolean digested){
		this.digested = digested;
	}

	public boolean isDigested(){
		return digested;
	}

	public void setLikesCount(int likesCount){
		this.likesCount = likesCount;
	}

	public int getLikesCount(){
		return likesCount;
	}

	public void setAnswer(Answer answer){
		this.answer = answer;
	}

	public Answer getAnswer(){
		return answer;
	}

	public void setCommentsCount(int commentsCount){
		this.commentsCount = commentsCount;
	}

	public int getCommentsCount(){
		return commentsCount;
	}

	public void setSticky(boolean sticky){
		this.sticky = sticky;
	}

	public boolean isSticky(){
		return sticky;
	}

	public void setTopicId(long topicId){
		this.topicId = topicId;
	}

	public long getTopicId(){
		return topicId;
	}

	public void setReadersCount(int readersCount){
		this.readersCount = readersCount;
	}

	public int getReadersCount(){
		return readersCount;
	}

	public void setGroup(Group group){
		this.group = group;
	}

	public Group getGroup(){
		return group;
	}

	@Override
 	public String toString(){
		return 
			"Topic{" + 
			"silenced = '" + silenced + '\'' + 
			",reading_count = '" + readingCount + '\'' + 
			",question = '" + question + '\'' + 
			",answered = '" + answered + '\'' + 
			",create_time = '" + createTime + '\'' + 
			",user_specific = '" + userSpecific + '\'' + 
			",rewards_count = '" + rewardsCount + '\'' + 
			",type = '" + type + '\'' + 
			",digested = '" + digested + '\'' + 
			",likes_count = '" + likesCount + '\'' + 
			",answer = '" + answer + '\'' + 
			",comments_count = '" + commentsCount + '\'' + 
			",sticky = '" + sticky + '\'' + 
			",topic_id = '" + topicId + '\'' + 
			",readers_count = '" + readersCount + '\'' + 
			",group = '" + group + '\'' + 
			"}";
		}
}
