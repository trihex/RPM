package com.trihex.rpm.outcome;

import com.trihex.rpm.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class OutcomeController {

   @Autowired
   OutcomeService service;

   @RequestMapping(path = "/outcome", method= RequestMethod.GET)
   @CrossOrigin(origins = "http://localhost:4200")
   @ResponseBody
   public ServiceResponse<Iterable<Outcome>> getAllOutcomes()
   {
      ServiceResponse<Iterable<Outcome>> response = new ServiceResponse<>();

      response.setResponseObject(service.getAllOutcomes());
      response.setSuccess(response.getResponseObject() != null);

      if(!response.isSuccess())
         response.setResponse("Error getting outcome");

      return response;
   }

   @RequestMapping(path = "/outcome/{role}", method = RequestMethod.GET)
   @CrossOrigin(origins = "http://localhost:4200")
   @ResponseBody
   public ServiceResponse<Iterable<Outcome>> getForRole(@PathVariable int role)
   {
      ServiceResponse<Iterable<Outcome>> response = new ServiceResponse<>();

      response.setResponseObject(service.getOutcomesByRoll(role));
      response.setSuccess(response.getResponseObject() != null);

      if(!response.isSuccess())
         response.setResponse("Error getting outcome by role");

      return response;
   }
}
