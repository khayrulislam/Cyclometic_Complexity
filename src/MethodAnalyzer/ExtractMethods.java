package MethodAnalyzer;

import java.util.ArrayList;

import FileReader.Statement;

public class ExtractMethods {

	ArrayList<Statement> statementListOfAClass = new ArrayList<>();

	public ExtractMethods(ArrayList<Statement> statementListOfAClass) {

		this.statementListOfAClass = statementListOfAClass;
		
	}
	
	public void splitMethodsFromClass() {
		
		//mergeStatements();
		//finalizeBracketInStatement();
		
		
	}
	
	
	public void finalizeBracketInStatement(){
		
		int startIndex;
		
		for(int i=0;i<statementListOfAClass.size();i++) {
			
			if(isContainBracket(statementListOfAClass.get(i), "}")  && statementListOfAClass.get(i).getStatement().length()>1) {
				
				startIndex = statementListOfAClass.get(i).getStatement().indexOf('}');
				
				spliteBracketFromStatement(i,startIndex);
	
			}
			
			if(isContainBracket(statementListOfAClass.get(i), "{")  && statementListOfAClass.get(i).getStatement().length()>1) {
				
				startIndex = statementListOfAClass.get(i).getStatement().indexOf('{');
				
				spliteBracketFromStatement(i,startIndex);
			}
			
		}
		
	}
	

	private void spliteBracketFromStatement(int i, int startIndex) {
		
		if(startIndex==0)startIndex++;
		
		Statement newStatement = new Statement(statementListOfAClass.get(i).getStatement().substring(startIndex, statementListOfAClass.get(i).getStatement().length()).trim(), statementListOfAClass.get(i).getStatementLineNumber());
		
		statementListOfAClass.get(i).setStatement(statementListOfAClass.get(i).getStatement().substring(0, startIndex).trim());
		
		statementListOfAClass.add(i+1, newStatement);
		
	}

	private boolean isContainBracket(Statement statement, String bracket) {
		
		return statement.getStatement().contains(bracket);
	}
	
	
	
	
	
	
	
	
	
	
	/*private boolean isStatementEnd(Statement statement) {
		
		char lastChar;
		
		lastChar = statement.getStatement().charAt(statement.getStatement().length()-1);
		
		if(lastChar==';' || lastChar=='}' || lastChar=='{' ||  lastChar==')') return true;
		
		return false;
	}
	

	private void mergeStatements() {
		
		for(int i=0;i<statementListOfAClass.size();i++) {
			
			if(! isStatementEnd(statementListOfAClass.get(i)) ) {
				
				statementListOfAClass.get(i).setStatement(statementListOfAClass.get(i).getStatement()+" "+statementListOfAClass.get(i+1).getStatement());
				
				statementListOfAClass.remove(i+1);
				
				i--;
			}
			
		}
		
		
	}

	
*/	
	
}
