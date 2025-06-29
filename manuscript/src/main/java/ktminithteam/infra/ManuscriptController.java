package ktminithteam.infra;
import ktminithteam.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/manuscripts")
@Transactional
public class ManuscriptController {
    @Autowired
    ManuscriptRepository manuscriptRepository;

    @RequestMapping(value = "/manuscripts/requestpublish",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public Manuscript requestPublish(HttpServletRequest request, HttpServletResponse response, 
        ) throws Exception {
            System.out.println("##### /manuscript/requestPublish  called #####");
            Manuscript manuscript = new Manuscript();
            manuscript.requestPublish();
            manuscriptRepository.save(manuscript);
            return manuscript;
    }
}
//>>> Clean Arch / Inbound Adaptor
