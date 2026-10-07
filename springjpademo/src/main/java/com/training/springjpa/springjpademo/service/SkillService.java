package com.training.springjpa.springjpademo.service;

import com.training.springjpa.springjpademo.dao.SkillRepository;
import com.training.springjpa.springjpademo.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepo;

    public Skill addSkill(Skill skill)
    {
        return skillRepo.save(skill);
    }
    public Skill getskill(int id)
    {
        return skillRepo.findById(id).get();
    }
}
