package ktminithteam.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import ktminithteam.BookplatformApplication;
import lombok.Data;

@Entity
@Table(name = "Book_table")
@Data
//<<< DDD / Aggregate Root
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long publishId;

    private Long subscribeCount;

    private Boolean isBestseller;

    public static BookRepository repository() {
        BookRepository bookRepository = BookplatformApplication.applicationContext.getBean(
            BookRepository.class
        );
        return bookRepository;
    }

    //<<< Clean Arch / Port Method
    public static void publish(BookPublished bookPublished) {
        //implement business logic here:

        /** Example 1:  new item 
        Book book = new Book();
        repository().save(book);

        */

        /** Example 2:  finding and process
        
        // if bookPublished.aiId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<, Object> publishMap = mapper.convertValue(bookPublished.getAiId(), Map.class);

        repository().findById(bookPublished.get???()).ifPresent(book->{
            
            book // do something
            repository().save(book);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseSubscribeCount(
        SubscribeSucceed subscribeSucceed
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Book book = new Book();
        repository().save(book);

        */

        /** Example 2:  finding and process
        

        repository().findById(subscribeSucceed.get???()).ifPresent(book->{
            
            book // do something
            repository().save(book);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
