package com.training.springjpa.springjpademo.dao;

import com.training.springjpa.springjpademo.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill,Integer>
{
}
