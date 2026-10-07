package com.cognizant.training;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class StudentReport {


       @Value("#{${student.mark}}")

       private Map<String,Integer> score;

       public Map<String, Integer> getscore() {
            		return score;
             	}

           	public void setScore(Map<String, Integer> score) {
                    this.score= score;
             	}


            	public int calculateTotal()
   	    {
             		int total=score.get("Java")+score.get("Sql")+score.get("Spring");
             		return total;
             	}
    }


