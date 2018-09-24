package CommentAnalyzer;

import java.util.ArrayList;

import FileReader.Statement;

public class RemoveComments {

	
	public void removeAllTheCommentFromStatementList(ArrayList<Statement> statementListOfAClass) {
		
		removeSingleLineComment(statementListOfAClass);
		printStatements( statementListOfAClass);
	}

	private void removeSingleLineComment(ArrayList<Statement> statementListOfAClass) {

		int index;
		
		for(int i=0;i<statementListOfAClass.size();i++) {
			
			String line = statementListOfAClass.get(i).getStatement();
			
			if(line.contains("//")) {
				System.out.println(statementListOfAClass.get(i).getStatementLineNumber());
				line = line.replaceFirst("//.*", "");
				
				
				System.out.println(line);
			}
			
			if(line.trim().isEmpty())  statementListOfAClass.remove(statementListOfAClass.get(i));
			
			else statementListOfAClass.get(i).setStatement(line);
		}
		
		
	}
	
	
	public void printStatements(ArrayList<Statement> statementListOfAClass) {
		
		for(Statement statement: statementListOfAClass) System.out.println(statement.getStatementLineNumber()+"  "+statement.getStatement());
		
	}
	
	
}
