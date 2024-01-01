public class Response{
	private RespData respData;
	private boolean succeeded;

	public void setRespData(RespData respData){
		this.respData = respData;
	}

	public RespData getRespData(){
		return respData;
	}

	public void setSucceeded(boolean succeeded){
		this.succeeded = succeeded;
	}

	public boolean isSucceeded(){
		return succeeded;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"resp_data = '" + respData + '\'' + 
			",succeeded = '" + succeeded + '\'' + 
			"}";
		}
}
