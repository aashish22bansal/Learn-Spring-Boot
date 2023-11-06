# Thymeleaf

## Introduction
<div>
    <p>When Spring MVC was introduced for Web Application Development, then the default to develop the view in MVC was a Java Server Page (JSP). But over the time, it was found that these JSPs are very cluttered with the Java code in between HTML making it hard to read the HTML Page. Also, each JSP has to be translated into Java code first and then that entire Java code has to be executed, and then the output is taken and sent to the web browser. This is where the templating engines like Thymeleaf are used instead of using JSP (which are outdated now (even in Java EE Standard)). In this, we will create a <code>.html</code> page with all the dynamic code (along with some static code) inside it as well. These templating engines provide a special syntax to do that which is a lot more readable.</p>
    <p>To use the dynamic code, we will be using a special syntax (<code>${name}</code>). Within this syntax, Spring will pull the <code>name</code> from the modal. The Spring Controller will send a variable named <code>name</code> that can be directly used in the <code>.html</code> page. At runtime, the Thymeleaf engine will take this <code>.html</code> page and will convert only the dynamic portions to Java code, then compiled and executed by the Thymeleaf container. For the output received, the static content and the dynamic content will be taken and merged, and the final output will go back in the client response. As a result, we will see that out <code>.html</code> pages are a lot more easier to read than JSPs and also the entire process of development is much quicker.</p>
</div>

## Thymeleaf in Action
<div>
    <p>We will first create a project with the required dependencies. In this, we will create the controller class that will handle the incoming client requests and then this controller will send the response to a HTML template that will handle it.</p>
    <p>The key dependency for this is <code>spring-boot-starter-thymeleaf</code> dependency.</p>
    <p>Within this project, we will create a new controller within which we will specify the Template Name (without the <code>.html</code> extension) on the appropriate request URLs. Then, in the <code>/src/main/resources/templates</code> folder, we will create a new template file with the same template name and write the required code in it. So, now upon execution of the project, we will see the same template name when we move to that particular URL.</p>
</div>