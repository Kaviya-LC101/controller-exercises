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
//  @RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
//
//   public String helloWithQueryParam(@RequestParam String name){
//      return "Hello, "+name+" !";
//    }  ** commented above code for adding helloPost() method for exercise



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
                "<select name='language'><br>" +
                "<option value='English'>English</option>" +
                "<option value='French'>French</option>"+
                "<option value='Italian'>Italian</option>"+
                "<option value='Spanish'>Spanish</option>"+
                "<option value='German'>German</option>"+
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }



    @RequestMapping(method = RequestMethod.POST)
    public String helloPost(@RequestParam String name, @RequestParam String language) {



        return createMessage(name, language);

        // For a bonus mission, students can change this response text to look nicer.
        // This is subjective, but students should be modifying the HTML of the response string.
    }


    public static String createMessage(String n, String l) {
        String greeting = "";


        if (l.equals("English")) {
            greeting = "Hello";
        }
        else if (l.equals("French")) {
            greeting = "Bonjour";
        }
        else if (l.equals("Italian")) {
            greeting = "Bonjourno";
        }
        else if (l.equals("Spanish")) {
            greeting = "Hola";
        }
        else if (l.equals("German")) {
            greeting = "Hallo";
        }

        return greeting + " " + n;
    }



}
