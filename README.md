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
       /U Include upper case characters A-Z
       /L Include lower case characters a-z
       /D Include digits 0-9
       /H Include hexadecimal characters.
       /S Include space character.
       /N Include number each line.
       -v Do not include vowels.
       -c Do not include constants.
</code
</pre>

