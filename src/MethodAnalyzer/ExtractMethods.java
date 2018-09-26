package MethodAnalyzer;

import java.util.ArrayList;

import FileReader.Statement;

public class ExtractMethods {

	ArrayList<Statement> statementListOfAClass = new ArrayList<>();

	public ExtractMethods(ArrayList<Statement> statementListOfAClass) {

		this.statementListOfAClass = statementListOfAClass;
		
	}
	
	public void splitMethodsFromClass() {
		
		mergeStatements();
		
	}
	
	private boolean isStatementEnd(Statement statement) {
		
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

	
	
	
}
