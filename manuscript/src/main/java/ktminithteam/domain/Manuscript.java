package ktminithteam.domain;

import ktminithteam.ManuscriptApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;


@Entity
@Table(name="Manuscript_table")
@Data

//<<< DDD / Aggregate Root
public class Manuscript  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
private Long manuscriptId;    
    
    
private Long authorId;    
    
    
private String title;    
    
    
private String content;    
    
    
private Date createdAt;    
    
    
private Date updatedAt;    
    
    
private BookStatus status;


    public static ManuscriptRepository repository(){
        ManuscriptRepository manuscriptRepository = ManuscriptApplication.applicationContext.getBean(ManuscriptRepository.class);
        return manuscriptRepository;
    }



//<<< Clean Arch / Port Method
    public void requestPublish(){
        
        //implement business logic here:
        

        ktminithteam.external.ManuscriptQuery manuscriptQuery = new ktminithteam.external.ManuscriptQuery();
        // manuscriptQuery.set??()        
          = ManuscriptApplication.applicationContext
            .getBean(ktminithteam.external.Service.class)
            .manuscript(manuscriptQuery);

        PublishRequestedEvent publishRequestedEvent = new PublishRequestedEvent(this);
        publishRequestedEvent.publishAfterCommit();
    }
//>>> Clean Arch / Port Method



}
//>>> DDD / Aggregate Root
