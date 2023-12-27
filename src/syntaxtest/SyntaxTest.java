
package syntaxtest;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;


 class SyntaxAnalyzer {
    private List<String> tokens;
    private int TokenIndex;
    
//SyntaxAnalyzer==> constructor take alist of token (input)
    public SyntaxAnalyzer(List<String> tokens) {
        this.tokens = tokens;
        this.TokenIndex = 0;
    }
    
    
//هيمشي علي ال 
//tokens
    public void parse() {
        while (TokenIndex < tokens.size()) {
            atom();
        }
   System.out.println("Syntax Analysis Successful: Input is syntactically correct!");
    }
//check 
    private void atom() {
       
        if (matchIdentifier() || matchLiteral() || matchNumbers()|| matchOperator()) {
            System.out.println("Atom: " + tokens.get(TokenIndex - 1));
        }else {
           
            System.out.println("Syntax Error: Unexpected token '" + tokens.get(TokenIndex) + "'");
            TokenIndex++; 
        }
    }

    private boolean matchIdentifier() {
        String token = tokens.get(TokenIndex);
        if (token.matches("[a-zA-Z][_a-zA-Z0-9]*")) {
            TokenIndex++;
            return true;
        }
        return false;
    }

      private boolean matchNumbers() {
        String token = tokens.get(TokenIndex);
        if (token.matches("[0-9]*")) {
            TokenIndex++;
            return true;
        }
        return false;
    }
      
       private boolean matchOperator() {
        String token = tokens.get(TokenIndex);
        if (token.matches("\\+|\\-|\\*|\\/|\\%|\\=|\\>|\\<|\\!")) {
            TokenIndex++;
            return true;
        }
        return false;
    }
    private boolean matchLiteral() {
        String token = tokens.get(TokenIndex);
        if (token.matches("\"[^\"]*\"")) {
           TokenIndex++;
            return true;
        }
        return false;
    }
    
    
}

public class SyntaxTest {
    
    public static void main(String[] args) {
       

        List<String> tokens ;

        tokens = Arrays.asList("add","y","1","x");
        
        SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer(tokens);
        syntaxAnalyzer.parse();
    
        
        
    }
  

}
    

