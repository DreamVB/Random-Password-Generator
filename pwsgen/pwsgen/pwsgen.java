package pwsgen;
import java.util.*; 

public class pwsgen {

    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = LOWER.toUpperCase();
    private static final String DIGITS = "0123456789";
    private static final String HEX = "ABCDEF" + DIGITS;
    private static final String SPECIAL = "!@#$%&*()_+-=[]?\"";
	public static String pws_mask = "";
	
	public static String b64Encode(String src) {
		return Base64.getEncoder().encodeToString(src.getBytes());
	}
	
	public static String padLeftZeros(String inputString, int length) {
	    if (inputString.length() >= length) {
	        return inputString;
	    }
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < length - inputString.length()) {
	        sb.append('0');
	    }
	    sb.append(inputString);
	    return sb.toString();
	}
	
	public static boolean isvowel(char ch) {
		boolean isv = false;
		switch(Character.toUpperCase(ch)) {
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
				isv = true;
				break;
		}
		return isv;
	}
	
	public static String getpws(int length) {
		int x = 0;
		String pws = "";
		while(x < length) {
			//Get random number of length of
			Random rnd = new Random();
			//Pick out random number
			int r = rnd.nextInt(pws_mask.length()-0) + 0;
			//Build random password.
			pws += pws_mask.charAt(r);
			//INC x
			x++;
		}
		return pws;
	}
	
	public static void main(String[] args) {
		String flag = "";
		String tmp_pmask = "";
		String ret_pws = "";
		
		boolean encode_pws = false;
		boolean remove_vowels = false;
		boolean remove_consts = false;
		boolean include_linesno = false;
		
		if(args.length == 1) {

			if(args[0].equals("/?")) {
				System.out.println("Usage: pwsgen password-length Password-count ");
				System.out.println("");
				System.out.println("  Example: pwsgen 8 10");
				System.out.println("  Above example will create 10 passwords with a length of 8");
				System.out.println("");
				System.out.println("Optional flags - general");
				System.out.println(" /L Lowercase letters [a..z]");
				System.out.println(" /U Uppercase letters [A..Z]");
				System.out.println(" /D Digits [0..9]");
				System.out.println(" /S Include special chars.");
				System.out.println(" /H Output password in hexadecimal.");
				System.out.println(" /N Include line numbers.");
				System.out.println(" /b64 Encode each password as a Base64 string.");
				System.out.println("");
				System.out.println("Other - flags");
				System.out.println(" -v Remove all vowels from password.");
				System.out.println(" -v Remove all constants from password.");
				return;
			}
		}
		
		if(args.length < 2) {
			System.out.println("Syntax Error.");
			System.out.println("See /? help for more details.");
		}
		else {

			int x = 2;
			int count = 0;
			//Get password length
			int pws_len = Integer.parseInt(args[0]);
			//Get the number of passwords to create
			int pws_count = Integer.parseInt(args[1]);
			
			//Process optional flags
			while(x < args.length) {
				flag = args[x].toLowerCase();
				//Include lowercase chars
				if(flag.equals("/l")) {
					pws_mask += LOWER;
				}
				//Include uppercase chars
				if(flag.equals("/u")) {
					pws_mask += UPPER;
				}
				//Include digits
				if(flag.equals("/d")) {
					pws_mask += DIGITS;
				}
				//Include special chars
				if(flag.equals("/s")) {
					pws_mask += SPECIAL;
				}
				if(flag.equals("/h")) {
					pws_mask += HEX;
				}
				
				if(flag.equals("/n")) {
					include_linesno = true;
				}
				if(flag.equals("/b64")) {
					encode_pws = true;
				}
				if(flag.equals("-v")) {
					remove_vowels = true;
				}
				if(flag.equals("-c")) {
					remove_consts = true;
				}
				x++;
			}
			//Check if any password options have been inlcuded
			if(pws_mask.length() == 0) {
				//Append defaults.
				pws_mask = UPPER + LOWER;
			}
			
			//Check if removing vowels
			if(remove_vowels) {
				x = 0;
				while(x < pws_mask.length()) {
					if(!isvowel(pws_mask.charAt(x))) {
						tmp_pmask += pws_mask.charAt(x);
					}
					x++;
				}
				pws_mask = tmp_pmask;
			}
			
			//Check if removing consts
			if(remove_consts) {
				x = 0;
				while(x < pws_mask.length()) {
					if(isvowel(pws_mask.charAt(x))) {
						tmp_pmask += pws_mask.charAt(x);
					}
					x++;
				}
				pws_mask = tmp_pmask;
			}
			
			//Generate the passwords
			while(count < pws_count) {
				//Get random password.
				ret_pws = getpws(pws_len);
				//Check if we are encoding the password as base64 string.
				if(encode_pws) {
					ret_pws = b64Encode(ret_pws);
				}
				
				if(include_linesno) {
					String lnNum = padLeftZeros(Integer.toString(count + 1),Integer.toString(pws_count).length());
					//Print password with line number
					System.out.println(lnNum + " " + ret_pws);
				}else {
					//Print password.
					System.out.println(ret_pws);
				}
				//INC counter.
				count++;
			}
			tmp_pmask = "";
			pws_mask = "";
			ret_pws = "";
		}
	}

}
