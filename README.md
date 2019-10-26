# Random-Password-Generator

pwsgen is a program that enables you to create secure passwords or lists of passwords. All that is required is a length and the count to be created, You also have nine optional options that can be used to style the output of the passwords.

<h2>Usage</h2>

<h3>Running from the command line in Windows</h3>

<code>
  JAVA pwsgen.pwsgen 12 4 /u /l /d
</code>

<h4>More Examples</h4>
Save 20 passwords to a output file.
</br>
<code>JAVA pwsgen.pwsgen 12 20 /u /l /d /n -v > passwords.txt</code>
<p></p>
Save 20 passwords to the clipboard.
</br>
<code>JAVA pwsgen.pwsgen 12 20 /u /l /d /n -v | Clip


<h4>Create a strong password with optional options</h4>

<pre>
<code>
    <b>Options::</b>
Optional flags - general
 /L Lowercase letters [a..z]
 /U Uppercase letters [A..Z]
 /D Digits [0..9]
 /S Include special chars.
 /H Output password in hexadecimal.
 /N Include line numbers.
 /b64 Encode each password as a Base64 string.

Other - flags
 -v Remove all vowels from password.
 -v Remove all constants from password.
</code
</pre>

