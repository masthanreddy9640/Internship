package PasswordGenerator;
import java.util.Random;

public class GenrateRandomPassword {
        String capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smalls = "abcdefghijklmnopqrstuvwxyandz";
        String numbers = "0123456789";
        String symbols = "~`!@#$%^&*()-_+={}[]:|'<.?/;";
    public String randomPassword(int length){

        String combinedString =capitals+smalls+numbers+symbols;
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for(int i = 0; i<length; i++){
            int randomIndex = random.nextInt(combinedString.length());
            password.append(combinedString.charAt(randomIndex));
        }
        return password.toString();
    }
    public int checkPassWordStrength(String password){
       
        boolean isCapsIncluded = checkValidCharAreIncluded(capitals,password);
        boolean isSmallsIncluded = checkValidCharAreIncluded(smalls, password);
        boolean isNumbersIncluded = checkValidCharAreIncluded(numbers, password);
        boolean isSymbolsIncluded = checkValidCharAreIncluded(symbols, password);
        if(isCapsIncluded && isSmallsIncluded&&isNumbersIncluded&&isSymbolsIncluded){
            return 3;
        }
        else if (isCapsIncluded&&isSmallsIncluded&&isNumbersIncluded ||isCapsIncluded&&isSmallsIncluded&&isSymbolsIncluded || isCapsIncluded&&isNumbersIncluded&&isSymbolsIncluded || isSmallsIncluded&&isNumbersIncluded&&isSymbolsIncluded ){
            return 2;
        }
        else if(isCapsIncluded&&isSmallsIncluded ||isCapsIncluded&&isNumbersIncluded || isCapsIncluded&&isSymbolsIncluded ||isSmallsIncluded&&isNumbersIncluded||isSymbolsIncluded&&isNumbersIncluded ||isSmallsIncluded&&isSymbolsIncluded ){
            return 1;
        }
        else if(isCapsIncluded || isSmallsIncluded || isNumbersIncluded ||isSymbolsIncluded ){
            return 0;
        }
        return 0;
    }
    public boolean checkValidCharAreIncluded(String StringToValidate,String password){
        
        boolean isIncluded=false;
        for(int i = 0 ; i <StringToValidate.length(); i++ ){
            for(int j = 0 ; j < password.length() ; j++){
                if(StringToValidate.charAt(i)==password.charAt(j)){
                    isIncluded=true;
                    break;
                }
            }
        }
        return isIncluded;
    }
    public String  checkPasswordStrengthAlongWithLengh(String password){
        String[] strenghtCheckArray = {"Very Weak","Weak","Medium","Strong","Very Strong"};
        int passWordStrength = checkPassWordStrength(password);
        if ( password.length()<=16 && password.length()>=14 && passWordStrength==3){
            passWordStrength++;
        }
        else if (password.length()>=8 && password.length()<=13 && passWordStrength<=2){
            passWordStrength++;
        }
        return strenghtCheckArray[passWordStrength];
    }
    public static void main(String [] args){
        Random random = new Random();
        int length = random.nextInt(20);
        GenrateRandomPassword genrateRandomPassword = new GenrateRandomPassword();
        String password = genrateRandomPassword.randomPassword(length);
        if(password.length()<8 || password.length()>16){
            System.out.println("Password should not be less than 8 or greater than 16 letters");
            System.out.println(password);
        }
        else{
        String passwordStrength = genrateRandomPassword.checkPasswordStrengthAlongWithLengh(password);
        System.out.println("Generated password : "+password);
        System.out.println("Password length : "+password.length());
        System.out.print("Password Strength : "+passwordStrength);
    }

    }

    
}

