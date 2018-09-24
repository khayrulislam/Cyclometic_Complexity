package FileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadClassFromProject {

	
	public ArrayList<Statement> readStatementsFromAClass(String classPath) throws IOException {
		
		ArrayList<Statement> statementListOfAClass = new ArrayList<>();

		int statementLineNumber=1;
		String statement;
		
		FileReader fr = new FileReader(classPath);
		
		BufferedReader br = new BufferedReader(fr);
		
		while( (statement = br.readLine() ) !=null) {
			
			if(!statement.trim().isEmpty()) statementListOfAClass.add(new Statement(statement, statementLineNumber++ ));
			//System.out.println(statement+"   "+statement.length());
		}
		
		br.close();
		
		return statementListOfAClass;
	}
	/*	
	public void printStatements() {
		
		for(Statement statement: statementListOfAClass) System.out.println(statement.getStatement()+"   "+statement.getStatement().length());
		
	}*/
	
	
}
