package org.kc.judge.codesendbox;

import org.kc.judge.model.vo.QuestionSubmitVO;

public interface JudgeService {
    /**
     * 判题服务
     * @param questionSubmitId
     * @return
     */
    QuestionSubmitVO doJudge(long questionSubmitId);

}
