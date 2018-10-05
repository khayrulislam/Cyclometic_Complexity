package CodingConventionAnalyzer;

import java.util.ArrayList;

import FileReader.Statement;

public class CodeConventionFinalize {

	
	ArrayList<Statement> statementListOfAClass = new ArrayList<>();

	public CodeConventionFinalize(ArrayList<Statement> statementListOfAClass) {

		this.statementListOfAClass = statementListOfAClass;
		
	}
	
	public void finalizeTheConvention() {
		
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
	
	
}
