package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")// This will make all of the method path lives at /hello
public class HelloController {
    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring";
//    }
    // lives at hello/goodbye
    @GetMapping("goodbye")
     public String goodbye(){
        return "Goodbye, Spring";
    }
    //Handles request of the form /hello?name=LaunchCode
   //@GetMapping("hello")
  // @PostMapping("hello") both and GetMapping and PostMapping dont work together
    //@RequestMapping(method={RequestMethod.GET, RequestMethod.POST},value="hello")
    //since we added RequestMapping at the top of the class with 'hello' we can remove value=hello
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST})

    public String helloWithQueryParam(@RequestParam String name){
      return "Hello, "+name+" !";
    }
   //Handles request of the form /hello/LaunchCode
   // @GetMapping("hello/{name}")
    //RequestMapping('hello')declared at top of the class
    @GetMapping("{name}")

    public String helloWithPathParameter(@PathVariable String name){
        return "Hello, "+name+" !";
    }

    @GetMapping("form")

    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='/hello' method='post'>" +//submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }






}
