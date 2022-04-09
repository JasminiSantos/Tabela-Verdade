import java.util.Scanner;
public class TabelaVerdade {
    //-----------------------------------------------------------------------------------
    // char printBit (boolean p): Imprime V ou F, de acordo com valor booleano de entrada
    //-----------------------------------------------------------------------------------
    public char printBit(boolean p){
        if(p)
            return 'V';
        else
            return 'F';
    }
    //-----------------------------------------------------------------------------------
    // void printFormula (String formulaCorreta) : Imprime uma f�rmula l�gica CORRETA, entre ( )
    //-----------------------------------------------------------------------------------

    public void printFormula (String formulaCorreta){
        System.out.println(" ("+ formulaCorreta + ") ");
    }
    //-----------------------------------------------------------------------------------
    // void tabelaUmLiteral(String formulaCorreta): Imprime tabela verdade
    // de uma f�rmula CORRETA com 1 literal / Vari�vel.
    //-----------------------------------------------------------------------------------
    public void tabelaUmLiteral(String formulaCorreta){
        int i;
        boolean p, resp;

        System.out.println("+---+---+");
        System.out.println("| p | x |");
        System.out.println("+---+---+");

        for(i = 1; i >=0; i--){
            switch(i){
                case 1:
                    p = true;
                    break;
                default:
                    p = false;
                    break;
            }
            // condicional tern�rio: x = (express�o booleana) ? c�digo para Verdade : c�digo para Falso;
            resp = (formulaCorreta.charAt(0) == '~')? !p : p;
            System.out.print("| " + printBit(p) + " | ");
            System.out.println(printBit(resp) + " |");
        }
        System.out.println("+---+---+");
    }
    //-----------------------------------------------------------------------------------
    // void tabelaDoisLiterais(String formulaCorreta): Imprime tabela verdade
    // de uma f�rmula CORRETA com 2 literais / Vari�veis.
    //-----------------------------------------------------------------------------------
    public void tabelaDoisLiterais(String formulaCorreta){
        int i;
        boolean p, q, resp = true;

        System.out.println("+---+---+---+");
        System.out.println("| p | q | x |");
        System.out.println("+---+---+---+");

        for(i = 3; i >= 0; i--){
            switch(i){
                case 3:
                    p = true; q = true;
                    break;
                case 2:
                    p = true; q = false;
                    break;
                case 1:
                    p = false; q = true;
                    break;
                default:
                    p = false; q = false;
                    break;
            }
            if(formulaCorreta.length() == 3)
                resp = formulaCorreta.charAt(1) == '^'? p && q : p || q;
            else if(formulaCorreta.length() == 4){
                if(formulaCorreta.charAt(0) == '~')
                    resp = formulaCorreta.charAt(2) == '^'? (!p && q) : (!p || q);
                else if(formulaCorreta.charAt(2) == '~')
                    resp = formulaCorreta.charAt(1) == '^'? (p && !q) : (p || !q);
            }
            else if(formulaCorreta.length() == 5){
                if(formulaCorreta.charAt(0) == '~')
                    resp = formulaCorreta.charAt(2) == '^'? (!p && !q) : (!p || !q);
            }
            System.out.print("| " + printBit(p) + " | "+ printBit(q)+ " |");
            System.out.println(" " + printBit(resp) + " |");
        }
        System.out.println("+---+---+---+");
    }
    //-----------------------------------------------------------------------------------
    // void tabelaTresLiterais(String formulaCorreta): Imprime tabela verdade
    // de uma f�rmula CORRETA com 2 literais / Vari�veis.
    //-----------------------------------------------------------------------------------
    public void tabelaTresLiterais(String formulaCorreta){
        int i;
        boolean p, q, r, resp = true;

        System.out.println("+---+---+---+---+");
        System.out.println("| p | q | r | x |");	
        System.out.println("+---+---+---+---+");

        for(i = 7; i >= 0; i--){
            switch (i){
                case 7:
                    p = true; q = true; r = true;
                    break;
                case 6:
                    p = true; q = true; r = false;
                    break;
                case 5:
                    p = true; q = false; r = true;
                    break;
                case 4:
                    p = true; q = false; r = false;
                    break;
                case 3:
                    p = false; q = true; r = true;
                    break;
                case 2:
                    p = false; q = true; r = false;
                    break;
                case 1:
                    p = false; q = false; r = true;
                    break;
                default:
                    p = false; q = false; r = false;
                    break;
            }
            if(formulaCorreta.length() == 5) {
            	if((formulaCorreta.charAt(1) == '^') && (formulaCorreta.charAt(3) == '^')) {
            		resp = (p && q && r);
            	}
            	else if((formulaCorreta.charAt(1) == '^') && (formulaCorreta.charAt(3) == 'v')) {
            		resp = (p && q || r);
            	}
            	else if((formulaCorreta.charAt(1) == 'v') && (formulaCorreta.charAt(3) == '^')) {
            		resp = (p || q && r);
            	}
            	else if((formulaCorreta.charAt(1) == 'v') && (formulaCorreta.charAt(3) == 'v')) {
            		resp = (p || q || r);
            	}
            }
            else if((formulaCorreta.length() == 6) &&
                	(formulaCorreta.charAt(0) == '~') &&
                	(formulaCorreta.charAt(1) == 'p') &&
                	(formulaCorreta.charAt(3) == 'q') &&
                	(formulaCorreta.charAt(5) == 'r')){
            	if((formulaCorreta.charAt(2) == '^') && (formulaCorreta.charAt(4) == '^')) {
            		resp = (!p && q && r);
            	}
            	else if((formulaCorreta.charAt(2) == '^') && (formulaCorreta.charAt(4) == 'v')) {
            		resp = (!p && q || r);
            	}
            	else if((formulaCorreta.charAt(2) == 'v') && (formulaCorreta.charAt(4) == '^')) {
            		resp = (!p || q && r);
            	}
            	else if((formulaCorreta.charAt(2) == 'v') && (formulaCorreta.charAt(4) == 'v')) {
            		resp = (!p || q || r);
            	}
            }
            else if((formulaCorreta.length() == 6) &&
            		(formulaCorreta.charAt(0) == 'p') &&
            		(formulaCorreta.charAt(2) == '~') &&
            		(formulaCorreta.charAt(3) == 'q') &&
            		(formulaCorreta.charAt(5) == 'r')) {
            	if((formulaCorreta.charAt(1) == '^') && (formulaCorreta.charAt(4) == '^')) {
            		resp = (p && !q && r);
            	}
            	else if((formulaCorreta.charAt(1) == '^') && (formulaCorreta.charAt(4) == 'v')) {
            		resp = (p && !q || r);
            	}
            	else if((formulaCorreta.charAt(1) == 'v') && (formulaCorreta.charAt(4) == '^')) {
            		resp = (p || !q && r);
            	}
            	else if((formulaCorreta.charAt(1) == 'v') && (formulaCorreta.charAt(4) == 'v')) {
            		resp = (p || !q || r);
            	}

            }
            else if((formulaCorreta.length() == 6) &&
            		(formulaCorreta.charAt(0) == 'p') &&
            		(formulaCorreta.charAt(2) == 'q') &&
            		(formulaCorreta.charAt(4) == '~') &&
            		(formulaCorreta.charAt(5) == 'r')) {
            	if((formulaCorreta.charAt(1) == '^') && (formulaCorreta.charAt(3) == '^')) {
            		resp = (p && q && !r);
            	}
            	else if((formulaCorreta.charAt(1) == '^') && (formulaCorreta.charAt(3) == 'v')) {
            		resp = (p && q || !r);
            	}
            	else if((formulaCorreta.charAt(1) == 'v') && (formulaCorreta.charAt(3) == '^')) {
            		resp = (p || q && !r);
            	}
            	else if((formulaCorreta.charAt(1) == 'v') && (formulaCorreta.charAt(3) == 'v')) {
            		resp = (p || q || !r);
            	}
            }
            else if((formulaCorreta.length() == 7) && 
            		(formulaCorreta.charAt(0) == '~') &&
            		(formulaCorreta.charAt(1) == 'p') &&
            		(formulaCorreta.charAt(3) == '~') &&
            		(formulaCorreta.charAt(4) == 'q') &&
            		(formulaCorreta.charAt(6) == 'r')) {
            	if((formulaCorreta.charAt(2) == '^') && (formulaCorreta.charAt(5) == '^')) {
            		resp = (!p && !q && r);
            	}
            	else if((formulaCorreta.charAt(2) == '^') && (formulaCorreta.charAt(5) == 'v')) {
            		resp = (!p && !q || r);
            	}
            	else if((formulaCorreta.charAt(2) == 'v') && (formulaCorreta.charAt(5) == '^')) {
            		resp = (!p || !q && r);
            	}
            	else if((formulaCorreta.charAt(2) == 'v') && (formulaCorreta.charAt(5) == 'v')) {
            		resp = (!p || !q || r);
            	}
            }
            else if((formulaCorreta.length() == 7) &&
            		(formulaCorreta.charAt(0) == '~') &&
            		(formulaCorreta.charAt(1) == 'p') &&
            		(formulaCorreta.charAt(3) == 'q') &&
            		(formulaCorreta.charAt(5) == '~') &&
            		(formulaCorreta.charAt(6) == 'r')) {
            	if((formulaCorreta.charAt(2) == '^') && (formulaCorreta.charAt(4) == '^')) {
            		resp = (!p && q && !r);
            	}
            	else if((formulaCorreta.charAt(2) == '^') && (formulaCorreta.charAt(4) == 'v')) {
            		resp = (!p && q || !r);
            	}
            	else if((formulaCorreta.charAt(2) == 'v') && (formulaCorreta.charAt(4) == '^')) {
            		resp = (!p || q && !r);
            	}
            	else if((formulaCorreta.charAt(2) == 'v') && (formulaCorreta.charAt(4) == 'v')) {
            		resp = (!p || q || !r);
            	}
            	
            }
            else if((formulaCorreta.length() == 7) &&
            		(formulaCorreta.charAt(0) == 'p') &&
            		(formulaCorreta.charAt(2) == '~') &&
            		(formulaCorreta.charAt(3) == 'q') &&
            		(formulaCorreta.charAt(5) == '~') &&
            		(formulaCorreta.charAt(6) == 'r')) {
            	if((formulaCorreta.charAt(1) == '^') && (formulaCorreta.charAt(4) == '^')) {
            		resp = (p && !q && !r);
            	}
            	else if((formulaCorreta.charAt(1) == '^') && (formulaCorreta.charAt(4) == 'v')) {
            		resp = (p && !q || !r);
            	}
            	else if((formulaCorreta.charAt(1) == 'v') && (formulaCorreta.charAt(4) == '^')) {
            		resp = (p || !q && !r);
            	}
            	else if((formulaCorreta.charAt(1) == 'v') && (formulaCorreta.charAt(4) == 'v')) {
            		resp = (p || !q || !r);
            	}
            }
            else if((formulaCorreta.length() == 8) &&
            		(formulaCorreta.charAt(0) == '~') &&
            		(formulaCorreta.charAt(1) == 'p') &&
            		(formulaCorreta.charAt(3) == '~') &&
            		(formulaCorreta.charAt(4) == 'q') &&
            		(formulaCorreta.charAt(6) == '~') &&
            		(formulaCorreta.charAt(7) == 'r')) {
            	if((formulaCorreta.charAt(2) == '^') && (formulaCorreta.charAt(5) == '^')) {
            		resp = (!p && !q && !r);
            	}
            	else if((formulaCorreta.charAt(2) == '^') && (formulaCorreta.charAt(5) == 'v')) {
            		resp = (!p && !q || !r);
            	}
            	else if((formulaCorreta.charAt(2) == 'v') && (formulaCorreta.charAt(5) == '^')) {
            		resp = (!p || !q && !r);
            	}
            	else if((formulaCorreta.charAt(2) == 'v') && (formulaCorreta.charAt(5) == 'v')) {
            		resp = (!p || !q || !r);
            	}

            }
            System.out.print("| "+ printBit(p) + " | " + printBit(q) + " | " + printBit(r));
            System.out.println(" | " + printBit(resp)+ " |");
        }
        System.out.println("+---+---+---+---+");
    }
    //-----------------------------------------------------------------------------------
    // boolean acharFormulaCom1Variavel(String formula): Confere se f�rmula com
    // 1 vari�vel est� CORRETA; se sim, imprime tabela verdade.
    //-----------------------------------------------------------------------------------
    private boolean acharFormulaCom1Variavel(String formula){
        if((formula.charAt(0) == '~' && formula.charAt(1) == 'p') ||  // F�rmula = ~p
            formula.charAt(0) == 'p' && formula.length() == 1){
            tabelaUmLiteral(formula);
            return true;
        }else{
            System.out.println("Tabela n�o gerada, pois a f�rmula est� incorreta!");
            return false;
        }
    }
    //-----------------------------------------------------------------------------------
    // boolean acharFormulaCom2Variaveis(String formula): Confere se f�rmula com
    // 2 vari�veis est� CORRETA; se sim, imprime tabela verdade.
    //-----------------------------------------------------------------------------------
    private boolean acharFormulaCom2Variaveis(String formula){
        boolean formOk = false;
        if((formula.length() == 3) && //3 caracteres
            (formula.charAt(0) == 'p') &&
            (formula.charAt(2) == 'q')){
                if((formula.charAt(1) == '^')||         //F�rmula = p^q
                    (formula.charAt(1) == 'v'))        //F�rmula = pvq
                    formOk = true;
                else
                    formOk = false;
        }else if((formula.length() == 4) && //4 caracteres
                 (formula.charAt(0) == '~') &&
                 (formula.charAt(1) == 'p') &&
                 (formula.charAt(3) == 'q')) {
                    if ((formula.charAt(2) == '^') ||    //F�rmula = ~p^q
                            (formula.charAt(2) == 'v'))     //F�rmula = ~pvq
                        formOk = true;
                    else
                        formOk = false;
                }
        else if ((formula.length() == 4) && //4 caracteres
                        (formula.charAt(0) == 'p') &&
                        (formula.charAt(2) == '~') &&
                        (formula.charAt(3) == 'q')) {
                    if ((formula.charAt(1) == '^') ||    //F�rmula = p^~q
                            (formula.charAt(1) == 'v'))     //F�rmula = pv~q
                        formOk = true;
                    else
                        formOk = false;
                }
        else if((formula.length() == 5) && 
        		(formula.charAt(0) == '~') &&
        		(formula.charAt(1) == 'p') &&
        		(formula.charAt(3) == '~') &&
        		(formula.charAt(4) == 'q')){
        		if((formula.charAt(2) == '^') || // F�rmula = ~p^~q
        			(formula.charAt(2) == 'v')) // F�rmula = ~pv~q
        			formOk = true;
        		else
        			formOk = false;
        }
        
        if(formOk) {
        	tabelaDoisLiterais(formula);	
        }
        else {
            System.out.println("Tabela n�o gerada, pois a f�rmula est� incorreta!");
    	}
        return formOk;
    }

    //-----------------------------------------------------------------------------------
    // boolean acharFormulaCom3Variaveis(String formula): Confere se f�rmula com
    // 3 vari�veis est� CORRETA; se sim, imprime tabela verdade.
    //-----------------------------------------------------------------------------------
    private boolean acharFormulaCom3Variaveis(String formula){
        boolean formOk = false;
        if((formula.length() == 5) && //5 caracteres
        	(formula.charAt(0) == 'p') && 
        	(formula.charAt(2) == 'q') &&
        	(formula.charAt(4) == 'r')) {
	            if(((formula.charAt(1) == '^')||	//F�rmula = p^q^r
	              (formula.charAt(1) == 'v')) &&	//F�rmula = pvqvr
	              ((formula.charAt(3) == '^') || 
	              (formula.charAt(3) == 'v')))
	            	formOk = true;
	            else
	            	formOk = false;
        	
        }
        else if((formula.length() == 6) &&
        	(formula.charAt(0) == '~') &&
        	(formula.charAt(1) == 'p') &&
        	(formula.charAt(3) == 'q') &&
        	(formula.charAt(5) == 'r')){
	        	if(((formula.charAt(2) == '^') || 	//F�rmula = ~p^q^r
	        		(formula.charAt(2) == 'v')) &&	//F�rmula = ~pvqvr
	        		((formula.charAt(4) == '^') || 	
	        		(formula.charAt(4) == 'v')))
	        		formOk = true;
	        	else
	        		formOk = false;
        }
        else if((formula.length() == 6) &&
        		(formula.charAt(0) == 'p') && 
        		(formula.charAt(2) == '~') && 
        		(formula.charAt(3) == 'q') &&
        		(formula.charAt(5) == 'r')) {
        	if(((formula.charAt(1) == '^') || 		//F�rmula = p^~q^r
        		(formula.charAt(1) == 'v')) && 		//F�rmula = pv~qvr
        		(formula.charAt(4) == '^') ||
        		(formula.charAt(4) == 'v'))
        		formOk = true;
        	else
        		formOk = false;
        }
        else if((formula.length() == 6) &&
        		(formula.charAt(0) == 'p') &&
        		(formula.charAt(2) == 'q') &&
        		(formula.charAt(4) == '~') &&
        		(formula.charAt(5) == 'r')) {
        	if(((formula.charAt(1) == '^') ||		//F�rmula = p^q^~r
        		(formula.charAt(1) == 'v')) &&		//F�rmula = pvqv~r
        		((formula.charAt(3) == '^') ||
        		(formula.charAt(3) == 'v')))
        		formOk = true;
        	else
        		formOk = false;	
        }
        else if((formula.length() == 7) && 
        		(formula.charAt(0) == '~') &&
        		(formula.charAt(1) == 'p') &&
        		(formula.charAt(3) == '~') &&
        		(formula.charAt(4) == 'q') &&
        		(formula.charAt(6) == 'r')) {
        	if(((formula.charAt(2) == '^') ||	 //F�rmula = ~p^~q^r
        		(formula.charAt(2) == 'v')) &&	//F�rmula = ~pv~qvr
        		((formula.charAt(5) == '^') || 
        		(formula.charAt(5) == 'v')))
        		formOk = true;
        	else
        		formOk = false;   		
        }
        else if((formula.length() == 7) &&
        		(formula.charAt(0) == '~') &&
        		(formula.charAt(1) == 'p') &&
        		(formula.charAt(3) == 'q') &&
        		(formula.charAt(5) == '~') &&
        		(formula.charAt(6) == 'r')) {
        	if(((formula.charAt(2) == '^') ||	//F�rmula = ~p^q^~r 
        		(formula.charAt(2) == 'v')) &&	//F�rmula = ~pvqv~r
        		((formula.charAt(4) == '^') ||
        		(formula.charAt(4) == 'v')))
        		formOk = true;
        	else
        		formOk = false;
        }
        else if((formula.length() == 7) &&
        		(formula.charAt(0) == 'p') &&
        		(formula.charAt(2) == '~') &&
        		(formula.charAt(3) == 'q') &&
        		(formula.charAt(5) == '~') &&
        		(formula.charAt(6) == 'r')) {
        	if(((formula.charAt(1) == '^') || 	//F�rmula = p^~q^~r 
        		(formula.charAt(1) == 'v')) &&	//F�rmula = pv~qv~r
        		((formula.charAt(4) == '^') ||
        		(formula.charAt(4) == 'v')))
        		formOk = true;
        	else
        		formOk = false;
        }
        else if((formula.length() == 8) &&
        		(formula.charAt(0) == '~') &&
        		(formula.charAt(1) == 'p') &&
        		(formula.charAt(3) == '~') &&
        		(formula.charAt(4) == 'q') &&
        		(formula.charAt(6) == '~') &&
        		(formula.charAt(7) == 'r')) {
        	if(((formula.charAt(2) == '^') ||	//F�rmula = ~p^~q^~r
        		(formula.charAt(2) == 'v')) &&	//F�rmula = ~pv~qv~r
        		((formula.charAt(5) == '^') ||
        		(formula.charAt(5) == 'v')))
        		formOk = true;
        	else
        		formOk = false;
        }
        if(formOk) {
        	tabelaTresLiterais(formula);
        }
        else {
            System.out.println("Tabela n�o gerada, pois a f�rmula est� incorreta!");
    	}
        return formOk;
    }
    //-----------------------------------------------------------------------------------
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);
        String formula;
        boolean tabOk = false;

        TabelaVerdade tb = new TabelaVerdade();

        System.out.print("Entre com a f�rmula: ");
        formula = leitor.nextLine();
        formula = formula.toLowerCase();

        switch (formula.length()){
            case 1:
            case 2:
                tabOk = tb.acharFormulaCom1Variavel(formula);
                break;
            case 3:
            case 4:
                tabOk = tb.acharFormulaCom2Variaveis(formula);
                break;
            case 5:
            	if(formula.charAt(0) == '~')
                    tabOk = tb.acharFormulaCom2Variaveis(formula);
                else
                    tabOk = tb.acharFormulaCom3Variaveis(formula);
            	break;
            case 6:
            	tabOk = tb.acharFormulaCom3Variaveis(formula);
            	break;
            case 7:
            	tabOk = tb.acharFormulaCom3Variaveis(formula);
            	break;
            case 8:
            	tabOk = tb.acharFormulaCom3Variaveis(formula);
            	break;
            default:
                tabOk = false;
                leitor.close();
        }
    }
}
