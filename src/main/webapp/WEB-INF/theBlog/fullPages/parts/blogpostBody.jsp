<%@ page contentType="text/html"; charset=UTF-8"%>
<html>
<body>
<h1> Article </h1>
${blogpost.title}
${blogpost.body} <!-- iterate over the list of words, so article body should be a list? ; or I could use this : String upToNCharacters = s.substring(0, Math.min(s.length(), n));

 just do some more research : https://stackoverflow.com/questions/1583940/how-do-i-get-the-first-n-characters-of-a-string-without-checking-the-size-or-goi -->
</body>
</html>