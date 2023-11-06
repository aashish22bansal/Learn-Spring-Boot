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

## Special Syntax
<div>
    <p>Thymeleaf provides us a special syntax that makes our template (or HTML) pages dynamic.</p>
    <p>The first syntax is the <code>@{url}</code> syntax. Within the curly braces, we can use a URL that is relative to the current base URL. For example, if we are including CSS file, then we will use the HTML <code>link</code> element and inside it we will be providing the path to the CSS file as <code>@{/css/my.css}</code>.</p>
    <p>The second syntax is the <code>${}</code> within which we can use the expression language to read all the data that is coming from the controller. Typically, our controller in Spring MVC will send a Model Map with all the data that we can read using <code>${}</code>. We can use the names of the modal object and their properties.</p>
    <p>The last syntax is <code>*{}</code> which is used in HTML Forms to bind a modal property to the form field. Here, we have the input type as <code>text</code> and we bind the input type <code>text</code> to a field called <code>studentName</code> on the modal object as:</p>
    <center><code>< input type="text" th:field=*{studentName} ></code></center>
    <p>There will be a Model Object called <code>Student.java</code> within which we have <code>studentName</code>. This form field will automatically be bound to it. The data comes from the controller and it will be taken automatically and displayed in the form and when this form is submitted, the data will taken and placed into the Modal Object automatically by Spring.</p>
    <p>In addition to this, Thymeleaf also provide us with some tags that we can use.</p>
</div>

## Sending Data to Template
<div>
    <p>Sending of data from Controller to the Template is known as Dynamic Rendering. Now, for this, the method should return an object of type <code>ModelAndView</code> because we want to send data to a view. To this object, we will add the object with a Key-value pair passed as a parameter and then we will return the <code>ModelAndView</code> Object.</p>
</div>

## Create a Template
<div>
    <p>Within the template file <code>data.html</code>, we will define a new namespace with the <code>html</code> tag as using the <code>xmlns:PREFIX="NAMESPACE_NAME"</code> attribute, where the <code>PREFIX</code> is <code>th</code> (which could be anything) representing Thymeleaf and the <code>NAMESPACE_NAME</code> for Thymeleaf is the website for Thymeleaf, <code>http://www.thymeleaf.org/</code>. So, the complete attribute becomes <code>xmlns:th="http://www.thymeleaf.org/</code>. Now, we can use all the tags that are available within the namespace. The <code>th</code> is the prefix that we will be using inside the <code>html</code> tag.</p>
    <p>Now, suppose we want to take the message that comes from the Controller and render it as text as: <code>th:text="${message}"</code>. This is the model that is coming from the Controller.</p>
</div>

## Disable Cache
<div>
    <p>Thymeleaf dynamically resolves the data that comes from the Controller and it will generate the final HTML file for us. When it does that it does cache the output of that HTML file into cache memory so that the clients can quickly get the responses when they access the page later. But sometimes it could be a problem, for example, if we were to add some static content to the HTML template file, then when we try to refresh the page, we might not see the update page because the page displayed was fetched from the cache memory. Now, to prevent this from happening, we can turn off the caching by adding the property <code>spring.thymeleaf.cache=false</code> in the <code>application.properties</code> file.</p>
</div>

## Sending Object Data
<div>
    <p>For this, we can add a new method to the Controller, named <code>getStudent()</code>. Now, if we do not provide values to the user-defined Object, then it will show the default values for the data members of the object.</p>
</div>

## Rendering Multiple Records
<div>
    <p>We can render multiple records using Thymeleaf's <code>each</code> tag.</p>
</div>

## Create an HTML Form
<div>
    <p>We will gather the student information and process it in the Controller. To associate the form with Thymeleaf, we will use the required tags within the <code>form</code> element.</p>
    <p>Using the <code>object</code> tag, the values sent via the object will automatically be rendered into the form provided we use another tag <code>field</code> along with it. These tags will automatically retrieve and assign values to the respective data members from the object. This is <b>Two-way Binding</b>. If the values are not provided in the Data Member, then the default values would be selected.</p>
</div>