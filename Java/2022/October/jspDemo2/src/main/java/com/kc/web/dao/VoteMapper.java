package com.kc.web.dao;

import com.kc.web.model.Vote;

import java.util.List;

public interface VoteMapper {
    int getNumb(String countries);
    void updateNumb(String countries,int id);
    List<Vote> getVotes();
    int getSumNumb();

}
