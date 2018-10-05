package FileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadClassFromProject {

	
	public ArrayList<Statement> readStatementsFromAClass(String classPath) throws IOException {
		
		ArrayList<Statement> statementListOfAClass = new ArrayList<>();

		int statementLineNumber=1;
		String statement;
		
		FileReader fr = new FileReader(classPath);
		
		BufferedReader br = new BufferedReader(fr);
		
		while( (statement = br.readLine() ) !=null) {
			
			if(!statement.trim().isEmpty() && !isExtrnalStatement(statement) ) statementListOfAClass.add(new Statement(statement.trim(), statementLineNumber ));
			
			statementLineNumber++;

		}
		
		br.close();
		
		return statementListOfAClass;
	}
	
	
	private boolean isExtrnalStatement(String statement) {
				
		if( statement.contains("package") && statement.indexOf("package") == 0 ) return true;
		
		if( statement.contains("import") && statement.indexOf("import") == 0 ) return true;
			
		return false;
		
	}
	
	
}
