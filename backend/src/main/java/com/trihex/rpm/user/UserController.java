package com.trihex.rpm.user;

import com.trihex.rpm.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * (c) Trihex Software LLC All Rights Reserved.
 */
@Controller
public class UserController
{
   @Autowired
   UserService service;

   @RequestMapping(path = "/user", method= RequestMethod.GET)
   @CrossOrigin(origins = "http://localhost:4200")
   @ResponseBody
   public ServiceResponse<Iterable<User>> getAllUsers(HttpServletResponse servletResponse)
   {
      ServiceResponse<Iterable<User>> response = new ServiceResponse<>();

      response.setResponseObject(service.getAllUsers());
      response.setSuccess(response.getResponseObject() != null);

      if(!response.isSuccess())
         response.setResponse("Error getting users");

      servletResponse.setStatus(HttpStatus.OK.value());

      return response;
   }

   @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
   @CrossOrigin(origins = "http://localhost:4200")
   @ResponseBody
   public ServiceResponse<User> getUser(@PathVariable int id, HttpServletResponse servletResponse)
   {
      ServiceResponse<User> response = new ServiceResponse<>();
      User user = service.getUser(id);
      response.setSuccess(user != null);
      response.setResponseObject(user);

      if(!response.isSuccess())
         response.setResponse("User not found");

      servletResponse.setStatus(HttpStatus.OK.value());

      return response;
   }

   @RequestMapping(path = "/user/{id}", method = RequestMethod.PUT)
   @CrossOrigin(origins = "http://localhost:4200")
   @ResponseBody
   public ServiceResponse<User> updateUser(@PathVariable int id, @RequestBody User user, HttpServletResponse servletResponse)
   {
      ServiceResponse<User> response = new ServiceResponse<>();

      if(id != user.getId())
      {
         response.setResponse("Id and user object mismatch");
         servletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
      }
      else
      {
         response.setResponseObject(service.updateUser(user));
         response.setSuccess(response.getResponseObject() != null);
         if(!response.isSuccess())
            response.setResponse("Error updating user");
      }

      servletResponse.setStatus(HttpStatus.OK.value());
      return response;
   }

   @RequestMapping(path = "/user", method = RequestMethod.PUT)
   @CrossOrigin(origins = "http://localhost:4200")
   @ResponseBody
   public ServiceResponse<User> login(@RequestBody User user, HttpServletResponse servletResponse)
   {
      ServiceResponse<User> response = new ServiceResponse<>();
      response.setSuccess(true);
      response.setResponseObject(user);
      servletResponse.setStatus(HttpStatus.OK.value());
      return response;
   }

   @RequestMapping(path = "/user", method = RequestMethod.POST)
   @CrossOrigin(origins = "http://localhost:4200")
   @ResponseBody
   public ServiceResponse<User> createUser(@RequestBody User user, HttpServletResponse servletResponse)
   {
      ServiceResponse<User> response = new ServiceResponse<>();

      //Insure we have a username and an email
      if(user.getEmail() == null || user.getEmail().isEmpty() ||
          user.getUsername() == null || user.getUsername().isEmpty())
      {
         servletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
         response.setSuccess(false);
         response.setResponse("Missing username or email");
      }

      response.setResponseObject(service.addUser(user));
      response.setSuccess(response.getResponseObject() != null);

      if(!response.isSuccess())
         response.setResponse("Error creating user");

      servletResponse.setStatus(HttpStatus.OK.value());
      return response;
   }

   @RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
   @CrossOrigin(origins = "http://localhost:4200")
   @ResponseBody
   public ServiceResponse<User> deleteUser(@PathVariable int id, HttpServletResponse servletResponse)
   {
      ServiceResponse<User> response = new ServiceResponse<>();

      response.setSuccess(service.deleteUser(id));

      if(!response.isSuccess())
         response.setResponse("Error deleting user");

      servletResponse.setStatus(HttpStatus.OK.value());
      return response;
   }
}
